public class Item {
    private String nome;
    private int peso;
    private String descricao;

    public Item(String nome, int peso, String descricao) {
        this.nome = nome;
        this.peso = peso;
        this.descricao = descricao;
    }

    /**
     * @return O nome do item.
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return O peso do item.
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @return A descrição do item.
     */
    public String getDescricao() {
        return descricao;
    }
}
