package com.restaurantreviews.modelo;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Data
public class Review {
    private Long id;

    @NotBlank(message = "Restaurant name is mandatory")
    private String restaurantName;

    @NotBlank(message = "Reviewer name is mandatory")
    private String reviewerName;

    @NotBlank(message = "Comment is mandatory")
    private String comment;

    @Min(1)
    @Max(5)
    private int rating; // Del 1 al 5
}
