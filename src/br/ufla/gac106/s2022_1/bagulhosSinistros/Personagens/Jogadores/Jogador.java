package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Jogadores;

import java.util.HashMap;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes.Ambiente;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Coletavel;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Personagem;

/**
 * Classe Jogador (Herda de Personagem)
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe representa o jogador do jogo. Nela é
 * possivel exibir, guardar, largar e usar itens do seu objeto.
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

public class Jogador extends Personagem {
  // Ambiente onde se encontra o jogador
  private Ambiente ambienteAtual;
  // Contagem da quantidade de movimentos do jogador
  private int quantidadeMovimentos = 71;
  // Objeto em que se guardados os itens do jogador
  private HashMap<Coletavel, Integer> objeto;
  // Nome do objeto onde os itens serão guardados
  private String nomeObjeto;
  // Variavel que armazena o máximo de tipo de itens
  private int maximoTipoItens = 3;

  /**
   * Cria o jogador com o nome e descrição.
   * Inicialmente ele não possui itens no objeto.
   * "nome" é algo como "Jim Hopper".
   * 
   * @param nome       O nome do jogador.
   * @param descricao  A descricao do jogador.
   * @param nomeObjeto O nome do objeto onde os itens serão guardados.
   */
  public Jogador(String nome, String descricao, String nomeObjeto) {
    super(nome, "Jogador", descricao);
    this.nomeObjeto = nomeObjeto;

    objeto = new HashMap<Coletavel, Integer>();
  }

  /**
   * @return A quantidade de movimentos restantes.
   */
  public int getQuantidadeMovimentos() {
    return quantidadeMovimentos;
  }

  /**
   * @param ambiente O ambiente atual.
   */
  public void setAmbienteAtual(Ambiente ambiente) {
    ambienteAtual = ambiente;
    quantidadeMovimentos--;
  }

  /**
   * @return O ambiente atual.
   */
  public Ambiente getAmbienteAtual() {
    return ambienteAtual;
  }

  /**
   * @param nome O nome do item;
   * @return se tem o item procurado.
   */
  public boolean procurarItem(String nome) {
    for (Coletavel item : objeto.keySet()) {
      boolean itemEncontrado = item.getNome().equals(nome);

      if (itemEncontrado) {
        return true;
      }
    }

    return false;
  }

  /**
   * Retorna uma lista com todos os itens armazenados e suas respectivas
   * quantidades
   * 
   * @return lista dos itens armazenados
   */
  public String listarItensObjeto() {
    String listagemItens = "";

    if (objeto.size() > 0) {
      listagemItens += "Itens no " + nomeObjeto + " (" + objeto.size() + "/" + maximoTipoItens + "): ";

      for (Coletavel item : objeto.keySet()) {
        listagemItens += "\n+ " + objeto.get(item) + " " + item.getDescricao();
      }
    }

    return listagemItens;
  }

  /**
   * Adiciona itens no objeto se o tipo do item ja existe, incrementa na
   * quantidade,
   * se não, adiciona o item no hashmap a quantidade de itens não pode exceder o
   * máximo
   * 
   * @param itemEncontrado recebe um item para ser guardado
   * @return true se foi adicionado com sucesso
   */
  public boolean adicionarItem(Coletavel itemEncontrado) {
    int qtdItens = 1;
    boolean jaExiste = procurarItem(itemEncontrado.getNome());

    // se já existe o tipo do item é adicionado mais um do mesmo tipo
    if (jaExiste)
      qtdItens = objeto.get(itemEncontrado) + 1;
    // se não existe deve verificar a capacidade máxima de tipos de item
    else if (objeto.size() + 1 > maximoTipoItens)
      return false; // se quantidade de tipos for excedida

    objeto.put(itemEncontrado, qtdItens);
    return true;
  }

  public void aumentarMaximoTipoItens() {
    maximoTipoItens++;
  }

  /**
   * Usa um item do jogador
   * 
   * @param nome O nome do item a ser usado.
   * @return a acao do item.
   */
  public String usarItem(String nome) {
    String acaoItem = "";

    ambienteAtual.usarItem(nome);

    for (Coletavel item : objeto.keySet()) {
      boolean itemEncontrado = item.getNome().equals(nome);

      if (itemEncontrado) {
        acaoItem += item.getAcao();
      }
    }

    return acaoItem;
  }

  /**
   * Remove um item do objeto do jogador
   * 
   * @param nome O nome do item a ser removido.
   * @return o item a ser deixado no ambiente.
   */
  public Coletavel removerItem(String nome) {
    for (Coletavel item : objeto.keySet()) {
      if (item.getNome().equals(nome)) {
        Coletavel meuItem = item;
        // se tem mais de uma quantidade do mesmo item
        if (objeto.get(meuItem) > 1) {
          objeto.put(meuItem, objeto.get(meuItem) - 1);
        } // se tem só uma quantidade do mesmo item
        else {
          objeto.remove(item);
        }

        return meuItem;
      }
    }

    return null;
  }
}