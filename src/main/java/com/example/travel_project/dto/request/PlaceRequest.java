package com.example.travel_project.dto.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceRequest {

    @NotBlank(message = "Place name must not be blank")
    @Size(max = 150, message = "Place name must not exceed 150 characters")
    private String name;

    @NotBlank(message = "Country must not be blank")
    @Size(max = 100, message = "Country must not exceed 100 characters")
    private String country;

    @NotBlank(message = "City must not be blank")
    @Size(max = 100, message = "City must not exceed 100 characters")
    private String city;

    @Size(max = 1000, message = "Place description must not exceed 1000 characters")
    private String description;

    @Size(max = 2048, message = "Place image URL must not exceed 2048 characters")
    private String imageUrl;

    @DecimalMin(value = "-90", message = "Latitude must be at least -90")
    @DecimalMax(value = "90", message = "Latitude must be at most 90")
    @Digits(integer = 3, fraction = 7, message = "Latitude must have at most 3 integer digits and 7 decimal places")
    private BigDecimal latitude;

    @DecimalMin(value = "-180", message = "Longitude must be at least -180")
    @DecimalMax(value = "180", message = "Longitude must be at most 180")
    @Digits(integer = 3, fraction = 7, message = "Longitude must have at most 3 integer digits and 7 decimal places")
    private BigDecimal longitude;

    @Size(max = 100, message = "Timezone must not exceed 100 characters")
    private String timezone;


    private Set<@NotNull(message = "Category id must not be null") @Positive(message = "Category id must be positive") Long> categoryIds;
}
