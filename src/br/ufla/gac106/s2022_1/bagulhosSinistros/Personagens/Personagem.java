package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens;

/**
 * Classe Personagem
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe contém caracteristicas comuns a personagens do jogo. Representa
 * os personagens do jogo, como o Principal, os NPCs e os monstros (Demogorgom).
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

public class Personagem {
    private String nome;
    private String tipo;
    private String descricao;

    /**
     * Cria o personagem o nome e o tipo.
     * Inicialmente ele não possui itens no coldre.
     * "nome" é algo como "Jim Hopper".
     * "nome" é algo como "principal".
     * 
     * @param nome O nome do personagem.
     * @param tipo O tipo do personagem.
     */
    public Personagem(String nome, String tipo, String descricao) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    /**
     * @return O nome do personagem.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return O tipo do personagem.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return A descricao do personagem.
     */
    public String getDescricao() {
        return descricao;
    }
}