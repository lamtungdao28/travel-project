package com.example.travel_project.dto.request;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripRequest {

    @NotBlank(message = "Trip name must not be blank")
    @Size(max = 150, message = "Trip name must not exceed 150 characters")
    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    @PositiveOrZero(message = "Budget must be zero or positive")
    @Digits(integer = 10, fraction = 2, message = "Budget must have at most 10 integer digits and 2 decimal places")
    private BigDecimal budget;

    @Size(max = 1000, message = "Trip description must not exceed 1000 characters")
    private String description;

    @AssertTrue(message = "End date must be on or after start date")
    public boolean isDateRangeValid() {
        return startDate == null || endDate == null || !endDate.isBefore(startDate);
    }
}
