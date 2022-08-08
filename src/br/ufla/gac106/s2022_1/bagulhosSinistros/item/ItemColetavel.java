package br.ufla.gac106.s2022_1.bagulhosSinistros.item;

public class ItemColetavel extends Item {
    private String tipo;
    
    public ItemColetavel(String nome, String descricao, String tipo) {
        super(nome, descricao, true);
        this.tipo = tipo;
    }  

    public String getTipo() {
        return tipo;
    }
}
