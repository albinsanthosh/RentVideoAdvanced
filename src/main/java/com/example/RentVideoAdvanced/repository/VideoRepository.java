package com.example.RentVideoAdvanced.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RentVideoAdvanced.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{
    
}
