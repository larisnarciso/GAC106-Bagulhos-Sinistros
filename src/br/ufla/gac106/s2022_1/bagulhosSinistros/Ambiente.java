package br.ufla.gac106.s2022_1.bagulhosSinistros;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Item;

/**
 * Classe Ambiente
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como tras, frente, direita, esquerda,
 * escada, portal e corredor. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
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

import java.util.ArrayList;
import java.util.HashMap;

public class Ambiente {
    // descrição do ambiente
    private String descricao;
    // itens do ambiente
    private ArrayList<Item> itens;
    // ambientes visinhos de acordo com a direção
    private HashMap<String, Ambiente> saidas;

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas.
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * 
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String descricao) {
        this.descricao = descricao;
        itens = new ArrayList<>();
        saidas = new HashMap<String, Ambiente>();
    }

    /**
     * Define as saídas do ambiente.
     * Cada direção ou leva a um outro ambiente ou é null
     * (indicando que não tem nenhuma saída para lá).
     * 
     * @param direcao  A direção definida.
     * @param ambiente o ambiente definida.
     */
    public void ajustarSaida(String direcao, Ambiente ambiente){
        saidas.put(direcao, ambiente);
    }

    /**
     * @return A descrição do ambiente.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return A descrição completa do ambiente.
     */
    public String getDescricaoLonga() {
        String textoDescricao = "";

        textoDescricao += "Você está " + descricao + "\n"; // ambiente atual
        textoDescricao += listarItens(); // itens no ambiente

        return textoDescricao;
    }

    /**
     * Adiciona um item no ambiente.
     * 
     * @param item O item a ser adicionado.
     */
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    /**
     * @return true se há um item no ambiente.
     */
    private boolean temItem() {
        for (Item item : itens) {
            if (item != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param nome O nome do item.
     * @return se tem o item procurado.
     */
    public boolean procurarItem(String nome) {
        for (Item item : itens) {
            if (temItem() && item.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return A lista de itens no ambiente.
     */
    private String listarItens() {
        String listaItens = "";

        if (temItem()) {
            listaItens += "\nItens encontrado!\n";
            for (Item item : itens) {
                listaItens += "\n- " + item.getNome() + " - " + item.getDescricao();
            }
        } else {
            listaItens += "\nNão há nada aqui";
        }

        return listaItens;
    }

    /**
     * Muda o item para null e retorno o item.
     * 
     * @return O objeto item coletado.
     */
    public Item coletarItem(String nome) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getNome().equals(nome) && itens.get(i).getEhColetavel()) {
                Item meuItem = itens.get(i);
                itens.remove(i);
                return meuItem;
            }
        }
        return null;
    }

    /**
     * @param direcao A direção definida.
     * @return O ambiente atual.
     */
    public Ambiente getAmbiente(String direcao) {
        return saidas.get(direcao);
    }

    /**
     * @return As saídas possíveis.
     */
    public String getSaidas() {
        String textoSaidas = "";
        for (String direcao : saidas.keySet()) {
            textoSaidas += direcao + " ";
        }
        return textoSaidas;
    }
}