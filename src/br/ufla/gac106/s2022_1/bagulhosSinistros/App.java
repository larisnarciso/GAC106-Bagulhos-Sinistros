package br.ufla.gac106.s2022_1.bagulhosSinistros;

/**
 * Classe App
 * 
 * Essa é uma classe da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe é responsável por rodar o jogo através do Terminal.
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

public class App {
    public static void main(String[] args) throws Exception {
        // Jogo exibido pelo terminal
        Terminal terminal = new Terminal();

        Jogo jogo = new Jogo(terminal);
        jogo.jogar();
    }
}