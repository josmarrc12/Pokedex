package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.example.pokedex.controleers.PokemonController;
import com.example.pokedex.databinding.ActivityMainBinding;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.models.Type;
import com.example.pokedex.models.Types;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private PokemonController pokemonController;
    private ActivityMainBinding binding;
    private TimerTask task;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponents();
        setContentView(binding.getRoot());
        pokemonController.getPokemon(this);
    }

    private void initComponents()
    {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        pokemonController = new PokemonController();

        task = new TimerTask() {
            @Override
            public void run() {
                pokemonController.getPokemon(MainActivity.this);
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(task,30000,30000);

        final Button cambiarPokemon = binding.cambiarPokemon;
        cambiarPokemon.setOnClickListener(
                new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          pokemonController.getPokemon(MainActivity.this);
                          //Log.e("Nombre","Boton respondiendo");
                      }
                  });


    }

    public  void resultPokemon(Pokemon pokemon)
    {
        binding.pokemonNombre.setText(pokemon.getName().substring(0,1).toUpperCase(Locale.ROOT)+pokemon.getName().substring(1,pokemon.getName().length()));

        Log.e("Nombre",pokemon.getName());
        Glide.with(this).load(Uri.parse(pokemon.getImage()))
                .into(binding.pokemonImagen);

        String tipo = "Type: ";
        for (Types p: pokemon.getTipos())
        {
            tipo += p.getTipo().getName()+"/";
        }

        binding.pokemonTipo.setText(tipo.substring(0,tipo.length()-1));
    }
}