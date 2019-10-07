package com.github.evgeniymelnikov.gps.service.controller;

import com.github.evgeniymelnikov.gps.service.dto.GpsPositionInfo;
import com.github.evgeniymelnikov.gps.service.model.GpsPosition;
import com.github.evgeniymelnikov.gps.service.repository.GpsPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
@RequestMapping("/gps-tracker")
@RequiredArgsConstructor
public class GpsPositionController {

    private final GpsPositionRepository gpsPositionRepository;

    @PostMapping
    public void add(@RequestBody GpsPositionInfo gpsPositionInfo) {
        if (gpsPositionInfo == null || gpsPositionInfo.getExtId() == null || gpsPositionInfo.getLocation() == null) {
            return;
        }
        gpsPositionRepository.save(GpsPositionInfo.map(gpsPositionInfo)).subscribe();
    }

    @GetMapping("/{extId}")
    public Flux<GpsPosition> getByExtId(@PathVariable UUID extId) {
        return null;
    }
}