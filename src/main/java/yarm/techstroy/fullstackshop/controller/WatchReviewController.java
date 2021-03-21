package yarm.techstroy.fullstackshop.controller;

import org.springframework.web.bind.annotation.*;
import yarm.techstroy.fullstackshop.model.WatchItem;
import yarm.techstroy.fullstackshop.model.WatchReviews;
import yarm.techstroy.fullstackshop.request.RequestBodyAddReview;
import yarm.techstroy.fullstackshop.service.WatchReviewsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/watch-reviews/")
public class WatchReviewController {

    private final WatchReviewsService watchReviewsService;

    public WatchReviewController(WatchReviewsService watchReviewsService) {
        this.watchReviewsService = watchReviewsService;
    }

    @GetMapping(value = "get")
    public List<WatchReviews> getAllReviews() {
        return watchReviewsService.getAllReviews();
    }

    @GetMapping(value = "get", params = {"reviewId"})
    public Optional<WatchReviews> getReviewById(@RequestParam Long reviewId) {
        return watchReviewsService.getAllReviews(reviewId);
    }

    @GetMapping(value = "get", params = {"itemId"})
    public List<WatchReviews> getReviewsByWatchId(@RequestParam Long itemId) {
        return watchReviewsService.getReviewsByItemId(itemId);
    }

    @PostMapping("add")
    public Optional<WatchItem> addReview(@RequestBody RequestBodyAddReview requestBody) {
        return watchReviewsService.addNewReview(requestBody);
    }

    @DeleteMapping("delete")
    public String deleteReviews() {
        watchReviewsService.delete();
        return "ok";
    }

    @DeleteMapping(value = "delete", params = {"reviewId"})
    public String deleteReviewById(@RequestParam Long reviewId) {
        watchReviewsService.delete(reviewId);
        return "ok";
    }
}
