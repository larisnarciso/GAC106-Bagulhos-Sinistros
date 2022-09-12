package br.ufla.gac106.s2022_1.bagulhosSinistros.Itens;

/**
 * Classe Coletavel (Herda de Item)
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe representa os itens coletáveis.
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

public class Coletavel extends Item {
    /**
     * Cria um item Coletavel com nome, descricao e acao.
     * Como padrão ehColetável é true.
     * 
     * "nome" é algo como "chave".
     * "descricao" é algo como "chave do escritório".
     * "acao" é algo como "abre o escritório".
     * 
     * @param nome      O nome do item.
     * @param descricao A descricao do item.
     * @param acao      A acao do item.
     */
    public Coletavel(String nome, String descricao, String caminhoImagem, String acao) {
        super(nome, descricao, caminhoImagem, acao, true);
    }

    /**
     * @return A analise do item.
     */
    @Override
    public String getAnalise() {
        return super.getDescricao();
    };

    /* 
     * Sobrescrita do método equals para Coletavel
     */
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        // se o objeto passado não é do mesmo tipo, eles não são iguais
        else if (!(objeto instanceof Coletavel)) {
            return false;
        } else {
            Coletavel outro = (Coletavel) objeto; 
            return super.getNome().equals(outro.getNome());
        }
    }
}
