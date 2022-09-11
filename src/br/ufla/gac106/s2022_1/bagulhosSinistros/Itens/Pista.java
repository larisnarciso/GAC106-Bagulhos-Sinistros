package br.ufla.gac106.s2022_1.bagulhosSinistros.Itens;

/**
 * Classe Pista (Herda de Item)
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe representa os itens não coletáveis, chamados de pista.
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

public class Pista extends Item {

    private String pistaDescricao;
    /**
     * Cria um item Coletavel com nome e descricao.
     * Como padrão acao é null e ehColetável é false.
     * 
     * "nome" é algo como "desenho".
     * "descricao" é algo como "desenho feito por um garoto".
     * 
     * @param nome      O nome do item.
     * @param descricao A descricao do item.
     */
    public Pista(String nome, String descricao, String caminhoImagem, String pistaDescricao) {
        super(nome, descricao, caminhoImagem, null, false);
        this.pistaDescricao = pistaDescricao;
    }

    /**
     * @return A descrição do item da classe Item e a informação que o item é
     *         especial.
     */
    @Override
    public String getDescricao() {
        return super.getDescricao() + "... este item te chamou atenção...";
    }
    public String getPistaDescricao(){
        return pistaDescricao;
    }
}
