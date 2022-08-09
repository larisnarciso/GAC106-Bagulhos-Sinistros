package br.ufla.gac106.s2022_1.personagem;

public class NPC extends Personagem{
    private String mensagem;

    public NPC(String nome){
        super(nome, "Humano");
        this.mensagem = "Dummy";
    }

    public String getMensagem(){
        return mensagem;
    }
}
