package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens;

/*
 * Classe personagem
 * Super classe que contém caracteristicas comuns a personagens do jogo
 */

public class Personagem {
    private String nome;
    private String tipo;

    // Construtor da classe Personagem
    public Personagem(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    // @return nome do personagem
    public String getNome() {
        return nome;
    }

    // @return tipo do personagem
    public String getTipo() {
        return tipo;
    }

}