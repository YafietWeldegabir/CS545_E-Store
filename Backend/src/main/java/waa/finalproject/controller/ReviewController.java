package waa.finalproject.controller;

import waa.finalproject.domain.Review;
import waa.finalproject.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> loadAllReviews(){
        return reviewService.getAllReviews();
    }

    @PatchMapping("/reviews/{id}/approve")
    public Review approveReview(@PathVariable long id){
        return reviewService.approveReview(id);
    }
}
