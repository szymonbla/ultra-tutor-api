package com.ultra_tutor.ultra_tutor_api.controller;

import com.ultra_tutor.ultra_tutor_api.model.command.CreateCaptureCommand;
import com.ultra_tutor.ultra_tutor_api.model.dto.CaptureDTO;
import com.ultra_tutor.ultra_tutor_api.service.CaptureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/captures")
@RequiredArgsConstructor
public class CaptureController {
    private final CaptureService captureService;

    @PostMapping
    public ResponseEntity<CaptureDTO> saveCapture(@RequestBody @Valid CreateCaptureCommand createCaptureCommand) {
        return new ResponseEntity<>(captureService.createCapture(createCaptureCommand), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<CaptureDTO>> getAllCaptures(@PageableDefault(size = 20) Pageable pageable) {
        return new ResponseEntity<>(captureService.findAllCaptures(pageable), HttpStatus.OK);
    }
}
