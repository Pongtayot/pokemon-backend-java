package com.pokemonreview.api.services;

import com.pokemonreview.api.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(int pokemonId, ReviewDto reviewDto);
    List<ReviewDto> getReviewByPokemonId(int pokemonId);
    ReviewDto getReviewById(int reviewId, int pokemonId);

    ReviewDto updateReview(ReviewDto reviewDto, int reviewId, int pokemonId);

    void deleteReview(int reviewId, int pokemonId);
}
