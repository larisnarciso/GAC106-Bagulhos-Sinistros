package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Jogadores;

/**
 * Classe Hopper (Herda de Jogador)
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe representa o jogador do jogo. Nela é
 * possivel exibir, guardar, largar e usar itens do seu coldre.
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

public class Hopper extends Jogador{
    /**
     * Cria o jogador com o nome passado.
     * Inicialmente ele não possui itens no coldre.
     * "nome" é algo como "Jim Hopper".
     * 
     * @param nome O nome do jogador.
     */
    public Hopper() {
        super("Jim Hopper", "delegado da cidade de Hawkins", "coldre");
    }
}