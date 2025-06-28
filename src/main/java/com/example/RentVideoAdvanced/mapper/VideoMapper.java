package com.example.RentVideoAdvanced.mapper;

import com.example.RentVideoAdvanced.entity.Video;
import com.example.RentVideoAdvanced.exchanges.VideoDto;

public class VideoMapper {
    
    public static Video mapToVideo(VideoDto videoDto) {
        if (videoDto == null){
            return null;
        }

        Video video = new Video();
        video.setTitle(videoDto.getTitle());
        video.setDirector(videoDto.getDirector());
        video.setGenre(videoDto.getGenre());
        video.setAvailabilityStatus(videoDto.getAvailabilityStatus());
        
        return video;
    }

    public static VideoDto mapToVideoDto(Video video) {
        if (video == null){
            return null;
        }

        VideoDto videoDto = new VideoDto(
            video.getId(),
            video.getTitle(),
            video.getDirector(),
            video.getGenre(),
            video.getAvailabilityStatus()
        );

        return videoDto;
    }
}
