package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens;

import java.util.ArrayList;
import br.ufla.gac106.s2022_1.bagulhosSinistros.item.Item;

/**
 * Classe principal - Representa o personagem Hooper, personagem principal do jogo
 */

public class Principal extends Personagem{
    //Coldre armazena os itens no coldre do Hooper, máximo de 3 itens
    private ArrayList<Item> coldre;

    // Construtor da classe Principal
    Principal(){
        super("Hooper", "Principal");
        this.coldre = new ArrayList<Item>();;
    }

    // Insere itens no coldre
    /*
     * @param item recebe um tipo item para ser armazenado
     */
    public void armazenarItem(Item item){
        coldre.add(item);
    }

    // Larga um item do inventário
    /*
     * @param nome recebe o nome do item que vai ser largado
     * return verdadeiro ou falso se o item buscado foi deletado
     */

    public boolean largarItem(String nome) {
        for (int i = 0; i < coldre.size(); i++) {
            if (coldre.get(i).getNome().equals(nome)) {
                coldre.remove(i);
                return true;
            }
        }
        return false;
    }

    // Retorna itens armazenados
    /*
     * return lista dos itens armazenados
     */
    public String getItensArmazenados() {
        String listagemItens = "";
        for (Item item : coldre) {
            listagemItens += item.getNome() + " ";
        }
        return listagemItens;
    }

}