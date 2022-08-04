package br.ufla.gac106.s2022_1.bagulhosSinistros;

import java.util.ArrayList;

public class Jogador {
    private String nome;
    private ArrayList<Item> carro;

    public Jogador(String nome) {
        this.nome = nome;
        this.carro = new ArrayList<Item>();
    }

    /**
     * @return O nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Adiciona um item para o jogador
     * 
     * @param item O item a ser adicionado.
     */
    public void adicionarItem(Item item) {
        carro.add(item);
    }

    /**
     * Remove um itens para o jogador
     * 
     * @param nome O nome do item a ser removido.
     * @return true se foi removido corretamente.
     */
    public boolean removerItem(String nome) {
        for (int i = 0; i < carro.size(); i++) {
            if (carro.get(i).getNome().equals(nome)) {
                carro.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * @return uma string com todos os itens coletados.
     */
    public String getItens() {
        String listagemItens = "";
        for (Item item : carro) {
            listagemItens += item.getNome() + " ";
        }
        return listagemItens;
    }

}
