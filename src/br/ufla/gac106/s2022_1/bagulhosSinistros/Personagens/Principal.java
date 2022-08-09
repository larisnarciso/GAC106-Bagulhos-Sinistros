package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens;

import java.util.HashMap;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Item;

/**
 * Classe principal - Representa o personagem Hooper, personagem principal do
 * jogo
 */

public class Principal extends Personagem {
    // Coldre armazena os itens do personagem principal
    private HashMap<Item, Integer> coldre;
    // Variavel que armazena o máximo de tipo de itens
    private static int maximoTipoItens = 3;

    /*
     * Cria o personagem principal do jogo.
     */
    public Principal(String nome) {
        super(nome, "Principal");
        this.coldre = new HashMap<Item, Integer>();
        ;
    }

    /**
     * Retorna se há itens no ambiente.
     * 
     * @return true se há um item no ambiente.
     */
    public boolean temItem() {
        for (Item item : coldre.keySet()) {
            if (item != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona itens no coldre se o item ja existe, incrementa na quantidade,
     * se não, adiciona o item no hashmap a quantidade de itens não pode exceder o máximo
     * 
     * @param novoItem recebe um item para ser armazenado
     * @return true se foi adicionado com sucesso
     */
    public boolean adicionarItem(Item novoItem) {
        int qtdItens = 1;
        boolean jaExiste = procurarItem(novoItem.getNome());

        if (jaExiste)
            qtdItens = coldre.get(novoItem) + 1;
        else if (coldre.size() + 1 > maximoTipoItens)
            return false; // se quantidade for excedida

        coldre.put(novoItem, qtdItens);
        return true;
    }

    /**
     * @param nome O nome do item;
     * @return se tem o item procurado.
     */
    public boolean procurarItem(String nome) {
        for (Item item : coldre.keySet()) {
            boolean itemEncontrado = temItem() && item.getNome().equals(nome);

            if (itemEncontrado) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove um item do jogador
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
     * Usa um item do jogador
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
                listagemItens += "\n- " + coldre.get(item) + " " + item.getDescricao();
            }
        }
        return listagemItens;
    }
}