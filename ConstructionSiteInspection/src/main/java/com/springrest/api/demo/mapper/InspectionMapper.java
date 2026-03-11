package com.springrest.api.demo.mapper;

import org.springframework.stereotype.Component;

import com.springrest.api.demo.dto.InspectionDTO;
import com.springrest.api.demo.model.Inspection;

@Component
public class InspectionMapper {
	
	public InspectionDTO toDto(Inspection inspection) {
		return new InspectionDTO(
	            inspection.getId(),
	            inspection.getSiteName(),
	            inspection.getInspectorName(),
	            inspection.getInspectionDate(),
	            inspection.getRemarks(),
	            inspection.getPhotoFileName(),
	            inspection.getReportFileName()
	        );
	}
}