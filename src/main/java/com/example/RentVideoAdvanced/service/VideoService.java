package com.example.RentVideoAdvanced.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.RentVideoAdvanced.entity.User;
import com.example.RentVideoAdvanced.entity.Video;
import com.example.RentVideoAdvanced.exception.DuplicateRentalVideoException;
import com.example.RentVideoAdvanced.exception.RentalLimitExceededException;
import com.example.RentVideoAdvanced.exception.ResourceNotFoundException;
import com.example.RentVideoAdvanced.exchanges.VideoDto;
import com.example.RentVideoAdvanced.mapper.VideoMapper;
import com.example.RentVideoAdvanced.repository.VideoRepository;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    UserService userService;

    public VideoDto createVideo(VideoDto videoDto) {

        Video video = VideoMapper.mapToVideo(videoDto);
        Video savedVideo = videoRepository.save(video);
        return VideoMapper.mapToVideoDto(savedVideo);
    }

    public VideoDto getVideoById(Long id) {

        Video video = videoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video does not exits with id: " + id));

        return VideoMapper.mapToVideoDto(video);
    }

    public List<VideoDto> getAllVideos() {

        List<Video> videos = videoRepository.findAll();
        return videos.stream().map((video) -> VideoMapper.mapToVideoDto(video)).collect(Collectors.toList());
    }

    public VideoDto updateVideoById(VideoDto videoDto, Long id) {

        Video video = videoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video does not exits with id: " + id));

        video.setTitle(videoDto.getTitle());
        video.setDirector(videoDto.getDirector());
        video.setGenre(videoDto.getGenre());
        video.setAvailabilityStatus(videoDto.getAvailabilityStatus());
        Video savedVideo = videoRepository.save(video);

        return VideoMapper.mapToVideoDto(savedVideo);
    }

    public void deleteVideoById(Long id) {

        Video video = videoRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video does not exits with id: " + id));

        videoRepository.delete(video);
    }

    public void rentVideo(Long videoId) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = (User) userService.loadUserByUsername(userName);

        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found"));

        // Limit to 2 rentals
        if (user.getRentedVideos().size() >= 2) {
            throw new RentalLimitExceededException("User already has 2 active rentals.");
        }

        // Prevent duplicate rentals
        if (user.getRentedVideos().contains(video)) {
            throw new DuplicateRentalVideoException("User has already rented this video.");
        }

        // Add the video
        user.getRentedVideos().add(video);
        video.getRentedByUsers().add(user); // if bidirectional

        userService.save(user);
    }

    public void returnVideo(Long id) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = (User) userService.loadUserByUsername(userName);

        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found"));

        if (!user.getRentedVideos().contains(video)) {
            throw new ResourceNotFoundException("User has not rented this video with id: " + id);
        }

        user.getRentedVideos().remove(video);
        video.getRentedByUsers().remove(user); // if bidirectional

        userService.save(user);
    }
}
