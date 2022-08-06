package br.ufla.gac106.s2022_1.bagulhosSinistros.item;

public class Item {
    private String nome;
    private String descricao;

    public Item(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * @return O nome do item.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @return A descrição do item.
     */
    public String getDescricao() {
        return descricao;
    }
}
