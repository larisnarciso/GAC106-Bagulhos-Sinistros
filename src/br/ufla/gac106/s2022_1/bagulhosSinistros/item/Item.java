package br.ufla.gac106.s2022_1.bagulhosSinistros.item;

public class Item {
    private String nome;
    private String descricao;
    private String acao;
    private boolean ehColetavel;

    public Item(String nome, String descricao, String acao, boolean ehColetavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.acao = acao;
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
     * @return A acao do item.
     */
    public String getAcao() {
        return acao;
    }
    
    /**
     * @return se item é coletavel.
     */
    public boolean getEhColetavel() {
        return ehColetavel;
    }
}
