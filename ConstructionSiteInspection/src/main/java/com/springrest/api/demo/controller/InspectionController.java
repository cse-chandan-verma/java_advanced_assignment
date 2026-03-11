package com.springrest.api.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.springrest.api.demo.dto.InspectionDTO;
import com.springrest.api.demo.service.InspectionService;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/inspections")
public class InspectionController {
	
    @Autowired
    private InspectionService inspectionService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<InspectionDTO> createInspection(
            @RequestParam("siteName") String siteName,
            @RequestParam("inspectorName") String inspectorName,
            @RequestParam("inspectionDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inspectionDate,
            @RequestParam(value = "remarks", required = false) String remarks,
            @RequestParam("sitePhoto") MultipartFile sitePhoto,
            @RequestParam("safetyReport") MultipartFile safetyReport) throws IOException {

        InspectionDTO dto = inspectionService.createInspection(
                siteName, inspectorName, inspectionDate, remarks, sitePhoto, safetyReport);

        return new ResponseEntity<>(dto, HttpStatus.CREATED); 
    }

    @GetMapping
    public ResponseEntity<List<InspectionDTO>> getAllEntity(){
    		return ResponseEntity.ok(inspectionService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<InspectionDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(inspectionService.getInspectionById(id));
    }
    @GetMapping("/{id}/photo")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable Long id) throws IOException {
        Resource resource = inspectionService.downloadPhoto(id);

        String contentType = Files.probeContentType(resource.getFile().toPath());
        if (contentType == null) contentType = "application/octet-stream";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/{id}/report")
    public ResponseEntity<Resource> downloadReport(@PathVariable Long id) throws IOException {
        Resource resource = inspectionService.downloadReport(id);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}