package br.ufla.gac106.s2022_1.personagem;

public class Personagem {
    private String nome;
    private String tipo;

    public Personagem(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

}