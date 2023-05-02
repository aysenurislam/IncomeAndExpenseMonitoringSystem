package com.incomeandexpensemonitoringsystem.dto;
import java.io.Serializable;
import lombok.*;
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String name;
    private Boolean status;
}
