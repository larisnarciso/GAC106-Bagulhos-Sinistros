package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Monstros;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Personagem;

/**
 * Classe Monstro (Herda de Personagem)
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe contém caracteristicas comuns aos monstros do jogo. Representa
 * os monstros, como o Demogorgon.
 * 
 * @author Ana Beatriz Rodrigues Torres,
 *         Ingrid de Falchi,
 *         Larissa Narciso Oliveira e
 *         Samuel Luiz Freitas Ferreira
 * 
 *         Baseado no jogo "World of Zuul", um RPG por textos pelo terminal.
 * @author Michael Kölling and David J. Barnes (traduzido e adaptado por Julio
 *         César Alves)
 */

public abstract class Monstro extends Personagem {
    private String descricao;
    private int vida;
    
    public Monstro(String nome, String tipo, String descricao, int vida) {
        super(nome, "Monstro");
        this.descricao = descricao;
        this.vida = vida;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public abstract void atacar();

    public abstract void defender();
}
