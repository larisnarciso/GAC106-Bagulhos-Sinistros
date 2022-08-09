package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens;

import java.util.ArrayList;
import br.ufla.gac106.s2022_1.bagulhosSinistros.item.Item;

/**
 * Classe principal - Representa o personagem Hooper, personagem principal do jogo
 */

public class Principal extends Personagem{
    //Coldre armazena os itens no coldre do Hooper, máximo de 3 tipos de itens
    private ArrayList<Item> coldre;
    private static int maximoTipoItens = 3;

    // Construtor da classe Principal
    public Principal(String nome){
        super(nome, "Principal");
        this.coldre = new ArrayList<Item>();;
    }

    /** 
     * Conta o tipo de itens
     * @param item o item a ser adicionado 
     */
    public int contarTipoItens(Item itemEncontrado){
        int qtdTipos = 0;
        for (Item item : coldre){
            if (!item.getNome().equals(itemEncontrado.getNome())){
                qtdTipos++;
            }
        }
        System.out.println(qtdTipos);
        return qtdTipos;
    }
    
    /** 
     * Insere itens no coldre
     * @param item recebe um tipo item para ser armazenado
     */
    public boolean armazenarItem(Item item){
        int qtdTipos = contarTipoItens(item);
        
        if(qtdTipos + 1 <= maximoTipoItens){
            coldre.add(item);
            return true;
        }
        return false;
    }

    /**
     * Retorna se há itens no ambiente.
     * @return true se há um item no ambiente.
     */

    public boolean temItem(){
        for (Item item : coldre){
            if (item != null){
                return true;
            }
        }
        return false;
    }

    /**
     * @param nome O nome do item;
     * @return se tem o item procurado.
     */

    public boolean procurarItem(String nome){
        for (Item item : coldre){
            boolean itemEncontrado = temItem() && item.getNome().equals(nome);

            if (itemEncontrado){
                return true;
            }
        }
        return false;
    }

    /** 
     * Remove um item do jogador principal e o deixa no ambiente
     * @param nome recebe o nome do item que vai ser largado
     * @return o item a ser deixado no ambiente
     */
    public Item largarItem(String nome) {
        for (int i = 0; i < coldre.size(); i++) {
            boolean itemEncontrado = coldre.get(i).getNome().equals(nome);

            if (itemEncontrado) {
                Item meuItem = coldre.get(i);
                coldre.remove(i);
                return meuItem;
            }
        }
        return null;
    }

        /** 
     * Usa um item do jogador principal
     * @param nome recebe o nome do item que vai ser usado
     * @return acao do item
     */
    public String usarItem(String nome) {
        String acaoItem = "";

        for (Item item : coldre) {
            boolean itemEncontrado = temItem() && item.getNome().equals(nome);

            if (itemEncontrado) {
                acaoItem += item.getAcao();
            }
        }
        return acaoItem;
    }

    /** 
     * Retorna uma lista com todos os itens armazenados
     * @return lista dos itens armazenados
     */
    public String getItensArmazenados() {
        String listagemItens = "";
        if (temItem()){
            listagemItens += "Itens no coldre (" + coldre.size() + "/3): ";
            
            for (Item item : coldre) {
                listagemItens += item.getNome() + " ";
            }
        }
        return listagemItens;
    }
}