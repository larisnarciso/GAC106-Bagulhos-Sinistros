package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Monstros;

/**
 * Classe Demogorgon (Herda de Monstro)
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe representa o Demogorgon, um monstro do jogo. Ele pode atacar ou
 * se defender de outro personagem.
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

public class Demogorgon extends Monstro {
    public Demogorgon(String descricao) {
        super("Demogorgon", "Monstro", descricao, 6);
    }

    @Override
    public void atacar() {
        int vida = super.getVida() + 1;
        super.setVida(vida);
    };

    @Override
    public void defender() {
        int vida = super.getVida() - 2;
        super.setVida(vida);
    };
}
