package br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Jogadores;

import java.util.HashMap;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes.Ambiente;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Item;
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
  private int quantidadeMovimentos = 70;
  // Objeto em que se guardados os itens do jogador
  private HashMap<Item, Integer> objeto;
  // Nome do objeto onde os itens serão guardados
  private String nomeObjeto;
  // Variavel que armazena o máximo de tipo de itens
  private static int maximoTipoItens = 3;

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

    this.objeto = new HashMap<Item, Integer>();
  }

  /**
   * Retorna se há itens no objeto do jogador.
   * 
   * @return true se há um item no objeto.
   */
  private boolean temItem() {
    if (objeto.size() > 0)
      return true;
    else
      return false;
  }

  /**
   * @param nome O nome do item;
   * @return se tem o item procurado.
   */
  public boolean procurarItem(String nome) {
    for (Item item : objeto.keySet()) {
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
  private String listarItensObjeto() {
    String listagemItens = "";
    if (temItem()) {
      listagemItens += "Itens no " + nomeObjeto + " (" + objeto.size() + "/3): ";

      for (Item item : objeto.keySet()) {
        listagemItens += "\n+ " + objeto.get(item) + " " + item.getDescricao();
      }
    }
    return listagemItens;
  }

  public void setAmbienteAtual(Ambiente ambiente) {
    System.out.println("jogador");
    ambienteAtual = ambiente;
  }

  private String getDescricaoAmbienteAtual() {
    return ambienteAtual.getDescricaoLonga();
  }

  /**
   * "Observar" foi digitado.
   * Exibe a descrição longa do ambiente atual e, se o jogador
   * possuir
   * itens, eles também são exibidos.
   */
  public void observar() {
    System.out.println(getDescricaoAmbienteAtual());
    System.out.println();

    String itensObjeto = listarItensObjeto();
    if (itensObjeto != "") {
      System.out.println(itensObjeto);
    }
  }

  /**
   * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente,
   * caso contrário imprime mensagem de erro.
   * 
   * @param direcao A direção a seguir.
   */
  public void irParaAmbiente(String direcao) {
    // tenta sair do ambiente atual
    Ambiente proximoAmbiente = null;
    proximoAmbiente = ambienteAtual.getAmbiente(direcao);

    if (proximoAmbiente == null) {
      System.out.println("Nao ha passagem!");
    } else {
      ambienteAtual = proximoAmbiente;
      exibirAmbienteAtual();
    }
  }

  /**
   * Exibe informações do ambiente atual.
   * Imprime a localização atual e as possíveis saídas.
   */
  public void exibirAmbienteAtual() {
    System.out.println("\nVoce possui " + quantidadeMovimentos + " movimentos");
    System.out.println("\nVoce esta " + ambienteAtual.getDescricao());
    System.out.println("Saidas: " + ambienteAtual.getSaidas());
  }

  /**
   * "Pegar" foi digitado. Pega o item indicado.
   * 
   * @param item O item a ser pego.
   */
  public void pegar(String item) {
    boolean encontrouItem = ambienteAtual.procurarItem(item);

    // ambiente tenta encontrar o item
    if (encontrouItem) {
      Item itemEncontrado = ambienteAtual.coletarItem(item);

      // jogador tenta coletar o item se encontrado
      if (itemEncontrado != null) {
        boolean pegouItem = adicionarItem(itemEncontrado);

        // verifica se atingiu o máximo de tipos de itens coletados
        if (pegouItem) {
          System.out.println("Você coletou o item " + item);
        } else {
          ambienteAtual.adicionarItem(itemEncontrado);
          System.out.println("Limite máximo de tipos de itens atingido!");
        }
      } else {
        System.out.println("Este item não é coletavel");
      }
    } else {
      System.out.println("Não há esse item no ambiente");
    }
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
  private boolean adicionarItem(Item itemEncontrado) {
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

  /**
   * "Usar" foi digitado. Usa o item indicado.
   * 
   * @param item O item a ser usado.
   */
  public void usar(String item) {
    boolean encontrouItem = procurarItem(item);

    // tenta usar o item se encontrado
    if (encontrouItem) {
      String acao = usarItem(item);
      System.out.println("Voce usa o item " + item + " e " + acao);
    } else {
      System.out.println("Voce nao possui esse item");
    }
  }

  /**
   * Usa um item do jogador
   * 
   * @param nome O nome do item a ser usado.
   * @return a acao do item.
   */
  private String usarItem(String nome) {
    String acaoItem = "";

    for (Item item : objeto.keySet()) {
      boolean itemEncontrado = item.getNome().equals(nome);

      if (itemEncontrado) {
        acaoItem += item.getAcao();
      }
    }

    return acaoItem;
  }

  /**
   * "Largar" foi digitado.
   * Tenta largar o item, removendo do jogador e devolvendo no ambiente
   * 
   * @param item O item a ser largado.
   */
  public void largar(String item) {
    boolean encontrouItem = procurarItem(item);

    // tenta largar o item do jogador
    if (encontrouItem) {
      Item itemEncontrado = removerItem(item);

      // tenta adicionar item no ambiente
      if (itemEncontrado != null) {
        ambienteAtual.adicionarItem(itemEncontrado);

        System.out.println("Voce largou o item " + item + " " + ambienteAtual.getDescricao());
      }
    } else {
      System.out.println("Voce nao possui esse item");
    }
  }

  /**
   * Remove um item do objeto do jogador
   * 
   * @param nome O nome do item a ser removido.
   * @return o item a ser deixado no ambiente.
   */
  private Item removerItem(String nome) {
    for (Item item : objeto.keySet()) {
      if (item.getNome().equals(nome)) {
        Item meuItem = item;
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

  /**
   * "Interagir" foi digitado.
   * Verifica se tem uma segunda palavra indicando qual NPC quer interagir
   * e tenta interagir com ele.
   * 
   * @param comando O comando digitado.
   */
  public void interagir(String npc) {
    try {
      String mensagem = ambienteAtual.interagirComNpc(npc);
      System.out.println(mensagem);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}