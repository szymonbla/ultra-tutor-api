package com.ultra_tutor.ultra_tutor_api.mappings;

import com.ultra_tutor.ultra_tutor_api.model.Capture;
import com.ultra_tutor.ultra_tutor_api.model.dto.CaptureDTO;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class CaptureToCaptureDTOConverter implements Converter<Capture, CaptureDTO> {
    @Override
    public CaptureDTO convert(MappingContext<Capture, CaptureDTO> mappingContext) {
        CaptureDTO captureDTO = new CaptureDTO();
        captureDTO.setId(mappingContext.getSource().getId());
        captureDTO.setPageTitle(mappingContext.getSource().getPageTitle());
        captureDTO.setFaviconUrl(mappingContext.getSource().getFaviconUrl());
        captureDTO.setSelectedText(mappingContext.getSource().getSelectedText());
        captureDTO.setSourceUrl(mappingContext.getSource().getSourceUrl());
        captureDTO.setSurroundingParagraph(mappingContext.getSource().getSurroundingParagraph());
        return captureDTO;
    }
}
