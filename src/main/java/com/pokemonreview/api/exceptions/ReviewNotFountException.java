package com.pokemonreview.api.exceptions;

public class ReviewNotFountException extends RuntimeException{
    public static final  long serialVersionUID = 1;

    public ReviewNotFountException(String message){
        super(message);
    }
}
