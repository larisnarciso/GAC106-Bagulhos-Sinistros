package br.ufla.gac106.s2022_1.bagulhosSinistros.item;

public class Item {
    private String nome;
    private String descricao;
    private boolean ehColetavel;

    public Item(String nome, String descricao, boolean ehColetavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.ehColetavel = ehColetavel;
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
    
    /**
     * @return O tipo do item.
     */
    public boolean getEhColetavel() {
        return ehColetavel;
    }
}
