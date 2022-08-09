package br.ufla.gac106.s2022_1.personagem;

import java.util.ArrayList;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Item;

public class Principal extends Personagem{
    private ArrayList<Item> coldre;

    Principal(String nome){
        super(nome, "Principal");
        this.coldre = new ArrayList<Item>();;
    }

    public void armazenarItem(Item item){
        coldre.add(item);
    }

    public boolean retirarItem(String nome) {
        for (int i = 0; i < coldre.size(); i++) {
            if (coldre.get(i).getNome().equals(nome)) {
                coldre.remove(i);
                return true;
            }
        }
        return false;
    }

    public String getItensArmazenados() {
        String listagemItens = "";
        for (Item item : coldre) {
            listagemItens += item.getNome() + " ";
        }
        return listagemItens;
    }

}