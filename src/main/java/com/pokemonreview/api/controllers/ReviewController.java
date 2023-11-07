package com.pokemonreview.api.controllers;

import com.pokemonreview.api.dto.ReviewDto;
import com.pokemonreview.api.models.Review;
import com.pokemonreview.api.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/pokemon/{pokemonId}/review")
    public ResponseEntity<ReviewDto> createReview(@PathVariable(value = "pokemonId") int pokemonId, @RequestBody ReviewDto reviewDto){
        return new ResponseEntity<>(reviewService.createReview(pokemonId, reviewDto), HttpStatus.CREATED);
    }

    @GetMapping("/pokemon/{pokemonId}/reviews")
    public ResponseEntity<List<ReviewDto>> getReviewByPokemonId(@PathVariable(value = "pokemonId") int pokemonId) {
        return new ResponseEntity<>(reviewService.getReviewByPokemonId(pokemonId),HttpStatus.OK);
    }

    @GetMapping("/pokemon/{pokemonId}/reviews/{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable(value = "id")int reviewId, @PathVariable(value = "pokemonId") int pokemonId) {
        ReviewDto reviewDto = reviewService.getReviewById(reviewId, pokemonId);
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @PutMapping("/pokemon/{pokemonId}/reviews/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable(value = "id")int reviewId, @PathVariable(value = "pokemonId") int pokemonId, @RequestBody ReviewDto reviewDto) {
        ReviewDto updateReview = reviewService.updateReview(reviewDto, reviewId, pokemonId);
        return new ResponseEntity<>(updateReview, HttpStatus.OK);
    }

    @DeleteMapping("/pokemon/{pokemonId}/reviews/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable(value = "id")int reviewId, @PathVariable(value = "pokemonId") int pokemonId){
        reviewService.deleteReview(reviewId, pokemonId);
        return new ResponseEntity<>("Review delete successfully", HttpStatus.OK);
    }
}
