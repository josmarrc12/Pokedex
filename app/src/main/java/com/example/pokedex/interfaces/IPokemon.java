package com.example.pokedex.interfaces;

import com.example.pokedex.models.Pokemon;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface IPokemon {

    @Headers({
            "Accept:application/json"
    })
    @GET("pokemon/{id}")
    Observable<Pokemon> getPokemon(@Path(value = "id")int id);
}
