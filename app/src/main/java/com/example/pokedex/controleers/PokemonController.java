package com.example.pokedex.controleers;

import android.util.Log;

import com.example.pokedex.MainActivity;
import com.example.pokedex.interfaces.IPokemon;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.services.PokeService;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DefaultObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class PokemonController {

    public void getPokemon (MainActivity result)
    {
        int id = (int) ((Math.random() * (800 - 1)) + 1);


        IPokemon iPokemon = PokeService.getAPI().create(IPokemon.class);
        iPokemon.getPokemon(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<Pokemon>() {
                    @Override
                    public void onNext(@NonNull Pokemon pokemon) {
                        result.resultPokemon(pokemon);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("Pokemon",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
