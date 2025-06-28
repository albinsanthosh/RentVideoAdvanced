package com.example.RentVideoAdvanced.exchanges.request;

import com.example.RentVideoAdvanced.entity.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    
}