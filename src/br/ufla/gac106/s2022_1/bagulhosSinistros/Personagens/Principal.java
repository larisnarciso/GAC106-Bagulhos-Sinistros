package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens;

import java.util.HashMap;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Item;

/**
 * Classe Principal (Herda de Personagem)
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe representa o personagem principal do jogo. Nela é
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

public class Principal extends Personagem {
    // Coldre armazena os itens do personagem principal
    private HashMap<Item, Integer> coldre;
    // Variavel que armazena o máximo de tipo de itens
    private static int maximoTipoItens = 3;

    /**
     * Cria o personagem principal com o nome passado.
     * Inicialmente ele não possui itens no coldre.
     * "nome" é algo como "Jim Hopper".
     * 
     * @param nome O nome do personagem principal.
     */
    public Principal(String nome) {
        super(nome, "Principal");
        this.coldre = new HashMap<Item, Integer>();
        ;
    }

    /**
     * Retorna se há itens no coldre do personagem principal.
     * 
     * @return true se há um item no coldre.
     */
    private boolean temItem() {
        for (Item item : coldre.keySet()) {
            if (item != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona itens no coldre se o item ja existe, incrementa na quantidade,
     * se não, adiciona o item no hashmap a quantidade de itens não pode exceder o
     * máximo
     * 
     * @param itemEncontrado recebe um item para ser armazenado
     * @return true se foi adicionado com sucesso
     */
    public boolean adicionarItemColdre(Item itemEncontrado) {
        int qtdItens = 1;
        boolean jaExiste = procurarItemColdre(itemEncontrado.getNome());

        if (jaExiste)
            qtdItens = coldre.get(itemEncontrado) + 1;
        else if (coldre.size() + 1 > maximoTipoItens)
            return false; // se quantidade for excedida

        coldre.put(itemEncontrado, qtdItens);
        return true;
    }

    /**
     * @param nome O nome do item;
     * @return se tem o item procurado.
     */
    public boolean procurarItemColdre(String nome) {
        for (Item item : coldre.keySet()) {
            boolean itemEncontrado = temItem() && item.getNome().equals(nome);

            if (itemEncontrado) {
                return true;
            }
        }

        return false;
    }

    /**
     * Remove um item do coldre do personagem principal
     * 
     * @param nome O nome do item a ser removido.
     * @return o item a ser deixado no ambiente.
     */
    public Item largarItem(String nome) {
        for (Item item : coldre.keySet()) {
            if (item.getNome().equals(nome)) {
                Item meuItem = item;
                // se tem mais de uma quantidade do mesmo item
                if (coldre.get(meuItem) > 1) {
                    coldre.put(meuItem, coldre.get(meuItem) - 1);
                } // se tem só uma quantidade do mesmo item
                else {
                    coldre.remove(item);
                }
                return meuItem;
            }
        }
        return null;

    }

    /**
     * Usa um item do personagem principal
     * 
     * @param nome O nome do item a ser usado.
     * @return a acao do item.
     */
    public String usarItem(String nome) {
        String acaoItem = "";

        for (Item item : coldre.keySet()) {
            boolean itemEncontrado = temItem() && item.getNome().equals(nome);

            if (itemEncontrado) {
                acaoItem += item.getAcao();
            }
        }

        return acaoItem;
    }

    /**
     * Retorna uma lista com todos os itens armazenados e suas respectivas
     * quantidades
     * 
     * @return lista dos itens armazenados
     */
    public String listarItensColdre() {
        String listagemItens = "";
        if (temItem()) {
            listagemItens += "Itens no coldre (" + coldre.size() + "/3): ";

            for (Item item : coldre.keySet()) {
                listagemItens += "\n+ " + coldre.get(item) + " " + item.getDescricao();
            }
        }
        return listagemItens;
    }
}