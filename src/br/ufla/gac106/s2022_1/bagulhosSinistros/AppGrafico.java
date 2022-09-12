package br.ufla.gac106.s2022_1.bagulhosSinistros;

import br.ufla.gac106.s2022_1.baseJogo.Tela;

/**
 * Classe AppGrafico
 * 
 * Essa é uma classe da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe é responsável por rodar o jogo através da Tela.
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

public class AppGrafico {
    public static void main(String[] args) throws Exception {
        // Jogo exibido pela tela
        Tela tela = new Tela("Bagulhos Sinistros");

        Jogo jogo = new Jogo(tela);
        jogo.jogar();
    }
}
