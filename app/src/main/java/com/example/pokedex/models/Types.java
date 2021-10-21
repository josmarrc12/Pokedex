package com.example.pokedex.models;

import com.google.gson.annotations.SerializedName;

public class Types {

    @SerializedName("type")
    private Type tipo;

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }
}
