package com.example.RentVideoAdvanced.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDto {
    
    Long id;
    String title;
    String director; 
    String genre; 
    Boolean availabilityStatus;
}
