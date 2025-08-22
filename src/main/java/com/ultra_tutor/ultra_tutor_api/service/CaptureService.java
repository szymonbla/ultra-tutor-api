package com.ultra_tutor.ultra_tutor_api.service;

import com.ultra_tutor.ultra_tutor_api.model.Capture;
import com.ultra_tutor.ultra_tutor_api.model.command.CreateCaptureCommand;
import com.ultra_tutor.ultra_tutor_api.model.dto.CaptureDTO;
import com.ultra_tutor.ultra_tutor_api.repository.CaptureRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaptureService {
    private final CaptureRepository captureRepository;
    private final ModelMapper modelMapper;

    public CaptureDTO createCapture(CreateCaptureCommand createCaptureCommand) {
        Capture capture = new Capture();
        capture.setFaviconUrl(createCaptureCommand.getFaviconUrl());
        capture.setSelectedText(createCaptureCommand.getSelectedText());
        capture.setSourceUrl(createCaptureCommand.getSourceUrl());
        capture.setPageTitle(createCaptureCommand.getPageTitle());
        capture.setSurroundingParagraph(createCaptureCommand.getSurroundingParagraph());
        captureRepository.save(capture);
        return modelMapper.map(capture, CaptureDTO.class);
    }

    public Page<CaptureDTO> findAllCaptures(Pageable pageable) {
        Page<Capture> captures = captureRepository.findAll(pageable);
        return captures.map((capture -> modelMapper.map(capture, CaptureDTO.class)));
    }
}
