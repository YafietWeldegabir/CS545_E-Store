package waa.finalproject.service.review;

import waa.finalproject.domain.Review;
import waa.finalproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public Review approveReview(long id) {
        Review review = getReviewById(id);
        review.setApproved(true);
        return reviewRepository.save(review);
    }
}
