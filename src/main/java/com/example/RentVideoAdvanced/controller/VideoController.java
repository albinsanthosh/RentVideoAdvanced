package com.example.RentVideoAdvanced.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RentVideoAdvanced.exchanges.VideoDto;
import com.example.RentVideoAdvanced.service.VideoService;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;
    
    // Add Video REST API
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/video")
    public ResponseEntity<VideoDto> addVideo(@RequestBody VideoDto videoDto) {
        VideoDto savedVideo = videoService.createVideo(videoDto);
        return ResponseEntity.ok(savedVideo);
    }

    // Get Video by Id REST API
    @GetMapping("/video/{id}")
    public ResponseEntity<VideoDto> getVideoById(@PathVariable Long id) {
        VideoDto savedVideo = videoService.getVideoById(id);
        return ResponseEntity.ok(savedVideo);
    }

    // Get All Videos REST API
    @GetMapping("/video")
    public ResponseEntity<List<VideoDto>> getAllVideo() {
        List<VideoDto> savedVideo = videoService.getAllVideos();
        return ResponseEntity.ok(savedVideo);
    }

    // Update Video by Id REST API
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/video/{id}")
    public ResponseEntity<VideoDto> updateVideoById(@RequestBody VideoDto videoDto, @PathVariable Long id) {
        VideoDto savedVideo = videoService.updateVideoById(videoDto, id);
        return ResponseEntity.ok(savedVideo);
    }

    // Delete Video by Id REST API
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/video/{id}")
    public ResponseEntity<String> deleteVideoById(@PathVariable Long id) {
        videoService.deleteVideoById(id);
        return ResponseEntity.ok("Video deleted with id: " + id);
    }
}
