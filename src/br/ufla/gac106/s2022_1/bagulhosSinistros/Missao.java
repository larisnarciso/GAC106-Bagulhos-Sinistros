package br.ufla.gac106.s2022_1.bagulhosSinistros;

import java.util.ArrayList;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Pista;

/**
 * Classe Missao
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Uma "Missao" representa o que o jogador deve encontrar para terminar o jogo.
 * Sua saída para o Mundo Invertido será bloqueada até que ele encontre as 3
 * pistas do jogo.
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

public class Missao {
    // as pistas a serem encontradas
    private ArrayList<Pista> pistas;

    /**
     * Cria uma missão e inicializa as pistas.
     */
    public Missao() {
        pistas = new ArrayList<Pista>();
    }

    /**
     * Adiciona uma pista.
     * 
     * @param item A pista a ser adicionada.
     */
    public void addPista(Pista pista) {
        pistas.add(pista);
    }

    /**
     * Verifica se encontrou todas as pistas.
     * 
     * @return se completou a missao.
     */
    public boolean completouMissao() {
        if (pistas.size() == 3) {
            return true;
        }
        return false;
    }

    /**
     * Verifica se completou a missão e retorna a descrição.
     * 
     * @return A descrição da missão.
     */
    public String verificarPistas() {
        if (completouMissao()) {
            return getDescricao();
        }
        return "";
    }

    /**
     * Descrição da pistas e indicação de onde o Will está.
     * 
     * @return A descrição da missão.
     */
    private String getDescricao() {
        String descricao = "";

        descricao += "\nVocê encontrou todas as pistas!";

        descricao += "\n\nO pisca-pisca indica que o Will está no Mundo Invertido...";
        descricao += "\nA bicicleta mostra que ele esteve próximo ao laboratório...";
        descricao += "\nO desenho mostra que o Will está em seu castelo...";

        descricao += "\n\nVá atrás dele em seu castelo no Mundo Invertido... e se prepare!";

        return descricao;
    }
}
