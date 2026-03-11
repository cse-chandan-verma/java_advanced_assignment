package com.springrest.api.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.springrest.api.demo.dto.InspectionDTO;
import com.springrest.api.demo.exception.InspectionNotFoundException;
import com.springrest.api.demo.exception.InvalidFileException;
import com.springrest.api.demo.mapper.InspectionMapper;
import com.springrest.api.demo.model.Inspection;
import com.springrest.api.demo.repository.InspectionRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InspectionService {

    @Autowired
    private InspectionRepository inspectionRepository;

    @Autowired
    private InspectionMapper inspectionMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

   
    public InspectionDTO createInspection(
            String siteName, String inspectorName,
            LocalDate inspectionDate, String remarks,
            MultipartFile sitePhoto, MultipartFile safetyReport) {

        validatePhoto(sitePhoto);
        validateReport(safetyReport);

        Inspection inspection = new Inspection();
        inspection.setSiteName(siteName);
        inspection.setInspectorName(inspectorName);
        inspection.setInspectionDate(inspectionDate);
        inspection.setRemarks(remarks);
        Inspection saved = inspectionRepository.save(inspection);

        Path folderPath = Paths.get(uploadDir, String.valueOf(saved.getId()));
        try {
            Files.createDirectories(folderPath);

            String photoName = sitePhoto.getOriginalFilename();
            Files.copy(sitePhoto.getInputStream(),
                       folderPath.resolve(photoName),
                       StandardCopyOption.REPLACE_EXISTING);

            String reportName = safetyReport.getOriginalFilename();
            Files.copy(safetyReport.getInputStream(),
                       folderPath.resolve(reportName),
                       StandardCopyOption.REPLACE_EXISTING);

            saved.setPhotoFileName(photoName);
            saved.setReportFileName(reportName);
            inspectionRepository.save(saved);

        } catch (IOException e) {
            throw new RuntimeException("Failed to store files: " + e.getMessage());
        }

        return inspectionMapper.toDto(saved);
    }
    
    public List<InspectionDTO> getAll(){
    		return inspectionRepository.findAll().stream().map(inspectionMapper::toDto).collect(Collectors.toList()); 
    }

    public InspectionDTO getInspectionById(Long id) {
        Inspection inspection = inspectionRepository.findById(id)
            .orElseThrow(() -> new InspectionNotFoundException(
                "Inspection not found with id: " + id));
        return inspectionMapper.toDto(inspection);
    }


    public Resource downloadPhoto(Long id) {
        Inspection inspection = inspectionRepository.findById(id)
            .orElseThrow(() -> new InspectionNotFoundException(
                "Inspection not found with id: " + id));

        Path filePath = Paths.get(uploadDir, String.valueOf(id))
                             .resolve(inspection.getPhotoFileName());
        return loadFileAsResource(filePath);
    }

    public Resource downloadReport(Long id) {
        Inspection inspection = inspectionRepository.findById(id)
            .orElseThrow(() -> new InspectionNotFoundException(
                "Inspection not found with id: " + id));

        Path filePath = Paths.get(uploadDir, String.valueOf(id))
                             .resolve(inspection.getReportFileName());
        return loadFileAsResource(filePath);
    }

    private Resource loadFileAsResource(Path filePath) {
        try {
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException(
                    "File not found: " + filePath.getFileName());
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid file path: " + e.getMessage());
        }
    }


    private void validatePhoto(MultipartFile file) {
        String type = file.getContentType();
        if (type == null ||
            (!type.equals("image/jpeg") && !type.equals("image/png"))) {
            throw new InvalidFileException(
                "Site photo must be JPG or PNG. Received: " + type);
        }
    }

    
    private void validateReport(MultipartFile file) {
        String type = file.getContentType();
        if (type == null || !type.equals("application/pdf")) {
            throw new InvalidFileException(
                "Safety report must be PDF. Received: " + type);
        }
    }
}