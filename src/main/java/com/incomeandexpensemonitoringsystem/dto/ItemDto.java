package com.incomeandexpensemonitoringsystem.dto;

import java.io.Serializable;
import lombok.*;
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ItemDto implements Serializable {
    private Long id;
    private String name;
    private Double amount;
    private Long categoryId;
    private String categoryName;
    private Boolean categoryStatus;
}
