package com.restaurantreviews.controlador;
import com.restaurantreviews.modelo.Review;
import com.restaurantreviews.servicio.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private com.restaurantreviews.servicio.ReviewService reviewService;

    @PostMapping
    public String createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }


}
