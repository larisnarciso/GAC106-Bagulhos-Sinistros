package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens;

/**
 * Classe NPC (Herda de Personagem)
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe contém caracteristicas comuns aos NPCs (Non Playable Character ou
 * Personagens Não Jogáveis). Representa os personagens secundários do jogo, que
 * podem passar uma mensagem de ajuda para o personagem principal.
 * 
 * @author Ana Beatriz Rodrigues Torres,
 *         Ingrid de Falchi,
 *         Larissa Narciso Oliveira e
 *         Samuel Luiz Freitas Ferreira
 * 
 *         Baseado no jogo "World of Zuul", um RPG por textos pelo terminal.
 * @author Michael Kölling and David J. Barnes (traduzido e adaptado por Julio
 *         César Alves)
 */

public class NPC extends Personagem {
    private String mensagem;

    /**
     * Cria o NPN com seu nome e a mensagem.
     * 
     * @param nome     O nome do NPC.
     * @param mensagem A mensagem no NPC.
     */
    public NPC(String nome, String mensagem) {
        super(nome, "NPC");
        this.mensagem = mensagem;
    }

    /**
     * @return A mensagem do NPC.
     */
    public String dizerMensagem() {
        return mensagem;
    }
}
