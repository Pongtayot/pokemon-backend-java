package com.pokemonreview.api.services;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.dto.PokemonResponse;
import com.pokemonreview.api.models.Pokemon;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);

    PokemonResponse getAllPokemon(int pageNo, int pageSize);

    PokemonDto getPokemonById(int id);

    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);

    void deletePokemon(int id);

    List<Pokemon>  getPokemonByCriteria(String name);
}
