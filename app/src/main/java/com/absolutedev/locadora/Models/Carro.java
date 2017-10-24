package com.absolutedev.locadora.Models;

/**
 * Created by Infranet on 24/10/2017.
 */

public class Carro {
    public String modelo;
    public int ano;
    public int fabricante;
    public boolean gasolina;
    public boolean etanol;

    public Carro(String modelo, int ano, int fabricante, boolean gasolina, boolean etanol){
        this.modelo = modelo;
        this.ano = ano;
        this.fabricante = fabricante;
        this.gasolina = gasolina;
        this.etanol = etanol;
    }
}
