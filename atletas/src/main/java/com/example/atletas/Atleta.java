package com.example.atletas;

import java.io.Serializable;

/**
 * Created by clebr on 27/09/2016.
 */

public class Atleta implements Serializable{

    public String nome;
    public String medalha;
    public String modalidade;
    public String idade;
    public String pais;

    public Atleta(String nome, String medalha, String modalidade, String idade, String pais) {
        this.nome = nome;
        this.medalha = medalha;
        this.idade = idade;
        this.modalidade = modalidade;
        this.pais = pais;

    }
}
