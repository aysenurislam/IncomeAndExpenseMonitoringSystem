package com.incomeandexpensemonitoringsystem.dto;

import lombok.*;

import java.io.Serializable;

@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public class UserDto implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String nickname;
    private String email;
    private String password;
    private Long roleId;
    private String roleName;
    
}
