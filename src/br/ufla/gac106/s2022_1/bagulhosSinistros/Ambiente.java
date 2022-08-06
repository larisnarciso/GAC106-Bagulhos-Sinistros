package br.ufla.gac106.s2022_1.bagulhosSinistros;
import br.ufla.gac106.s2022_1.bagulhosSinistros.item.Item;
/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul, leste 
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */

import java.util.HashMap;

public class Ambiente {
    // descrição do ambiente
    private String descricao;
    // itens do ambiente
    private Item item;
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
        saidas = new HashMap<String, Ambiente>();
    }

    /**
     * Cria ambiente com um Item.
     * 
     * @param descricao A descrição do ambiente.
     * @param item      O item no ambiente.
     */
    public Ambiente(String descricao, Item item) {
        this(descricao);
        this.item = item;
    }

    /**
     * Define as saídas do ambiente.
     * Cada direção ou leva a um outro ambiente ou é null
     * (indicando que não tem nenhuma saída para lá).
     * 
     * @param direcao  A direção definida.
     * @param ambiente o ambiente definida.
     */
    public void ajustarSaida(String direcao, Ambiente ambiente) {
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
        String textoDescricao = "Você está " + descricao;

        if (temItem() == true) {
            textoDescricao += "\nItem encontrado! \nNome: " + item.getNome() + "\nDescricao: " + item.getDescricao();
        } else {
            textoDescricao += "\nNão há nada aqui";
        }

        return textoDescricao;
    }

    /**
     * @return true se há um item no ambiente.
     */
    public boolean temItem() {
        if (item != null) {
            return true;
        }
        return false;
    }

    /**
     * @return O nome do item coletado.
     */
    public String getItem() {
        if (temItem()) {
            return item.getNome();
        }
        return null;
    }

    /**
     * Muda o item para null e retorno o item.
     * 
     * @return O objeto item coletado.
     */
    public Item coletarItem() {
        Item meuItem = item;
        item = null;
        return meuItem;
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
