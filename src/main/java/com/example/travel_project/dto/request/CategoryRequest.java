package com.example.travel_project.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

    @NotBlank(message = "Category name must not be blank")
    @Size(max = 150, message = "Category name must not exceed 150 characters")
    private String name;

    @Size(max = 1000, message = "Category description must not exceed 1000 characters")
    private String description;

    @Size(max = 2048, message = "Category image URL must not exceed 2048 characters")
    private String imageUrl;
}
