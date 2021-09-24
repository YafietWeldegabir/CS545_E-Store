package waa.finalproject.service.review;

import waa.finalproject.domain.Review;

import java.util.List;


public interface ReviewService {

    List<Review> getAllReviews();

    Review getReviewById(long id);

    Review approveReview(long id);
}
