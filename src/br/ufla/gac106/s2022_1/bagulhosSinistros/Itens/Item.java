package br.ufla.gac106.s2022_1.bagulhosSinistros.Itens;

/**
 * Classe Item
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe contém caracteristicas comuns a itens do jogo. Representa
 * os itens que podem ser coletáveis e não coletáveis.
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

public abstract class Item {
    private String nome;
    private String descricao;
    private String acao;
    private boolean ehColetavel;

    /**
     * Cria um item com nome, descricao, acao e se é coletável.
     * Inicialmente ele não possui itens no coldre.
     * "nome" é algo como "chave".
     * "descricao" é algo como "chave do escritório".
     * "acao" é algo como "abre o escritório".
     * "ehColetavel" é true se posso coletar, senão é false.
     * 
     * @param nome        O nome do item.
     * @param descricao   A descricao do item.
     * @param acao        A acao do item.
     * @param ehColetavel Se item é coletável.
     */
    public Item(String nome, String descricao, String acao, boolean ehColetavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.acao = acao;
        this.ehColetavel = ehColetavel;
    }

    /**
     * @return O nome do item.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return A descrição do item.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return A acao do item.
     */
    public String getAcao() {
        return acao;
    }

    /**
     * @return se item é coletavel.
     */
    public boolean getEhColetavel() {
        return ehColetavel;
    }
}