package com.example.RentVideoAdvanced.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    
    String email;
    String password;
    String firstName; 
    String lastName;
    String role; 
}
