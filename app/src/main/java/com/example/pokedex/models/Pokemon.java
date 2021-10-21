package com.example.pokedex.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon
{
    @SerializedName("name")
    String name;

    @SerializedName("id")
    int id;

    @SerializedName("types")
    List<Types> tipos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Types> getTipos() {
        return tipos;
    }

    public void setTipos(List<Types> tipos) {
        this.tipos = tipos;
    }

    public String getImage()
    {
        return  "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+id+".png";
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
