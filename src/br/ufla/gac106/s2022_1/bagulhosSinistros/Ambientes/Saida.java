package br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Item;

/**
 * Classe Saida
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe é responsável por criar uma saida, contendo a direção, o ambiente
 * que se encontra nessa direção, se a passagem está bloqueada ou não e o item
 * que desbloqueia a passagem;
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

public class Saida {
  // Direção da saída
  private String direcao;
  // Ambiente a ser direcionado
  private Ambiente ambiente;
  // Se saída está bloqueada
  private Boolean bloqueado;
  // Item para desbloquear a saída
  private Item item;

  /**
   * Cria uma saída com os parâmetros passados.
   * "direcao" é algo como "escada".
   * "ambiente" é algo como "centro.
   * "bloqueado" é algo como "true".
   * "item" é algo como "chave".
   * 
   * @param direcao   A direção da saída.
   * @param ambiente  O ambiente a ser direcionado.
   * @param bloqueado se saída está bloqueada.
   * @param item      O item para desbloquear a saída.
   */
  public Saida(String direcao, Ambiente ambiente, Boolean bloqueado, Item item) {
    this.direcao = direcao;
    this.ambiente = ambiente;
    this.bloqueado = bloqueado;
    this.item = item;
  }

  /**
   * @return A direção do ambiente.
   */
  public String getDirecao() {
    return direcao;
  }

  /**
   * @return O ambiente a ser direcionado.
   */
  public Ambiente getAmbiente() {
    return ambiente;
  }

  /**
   * @return se saída está bloqueada.
   */
  public Boolean getBloqueado() {
    return bloqueado;
  }

  /**
   * Desbloquear a saída.
   */
  private void desbloquear() {
    bloqueado = true;
  }

  /**
   * Tenta desbloquear a saída com o item passado.
   * 
   * @param item O item para desbloquear a saída
   * @return se conseguiu desbloquear ou não.
   */
  public String desbloquear(String item) {
    if (item.equals(this.item.getNome())) {
      desbloquear();
      return "Passagem desbloqueada!";
    } else {
      throw new RuntimeException("Esse item não foi útil");
    }
  }

}
