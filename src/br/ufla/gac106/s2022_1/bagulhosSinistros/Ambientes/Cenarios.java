package br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Coletavel;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Item;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Pista;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.NPC;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Monstros.Demogorgon;

/**
 * Classe Cenarios
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe é responsável por criar todos os ambientes e atribuir a eles suas saídas, os
 * itens coletáveis, as pistas, os npcs e os monstros;
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

public class Cenarios {
  /**
   * Cria todos os ambientes, adiciona os itens e liga as saidas deles
   * 
   * @return ambiente atual
   */
  public Ambiente criarCenarios() {
    /*---------- AMBIENTES ----------*/
    // cria os ambientes
    Ambiente centro, delegacia, escritorioDelegacia, escola, ferroVelho, casaMike, poraoCasaMike, trailerJim, floresta,
        casaByers, casteloByers, florestaFundo, laboratorio, salaLaboratorio, laboratorioMI, florestaMI, casteloMI;

    centro = new Ambiente("no centro da cidade de Hawkins");
    delegacia = new Ambiente("na delegacia de Polícia de Hawkins");
    escritorioDelegacia = new Ambiente("no seu escritório na delegacia");
    escola = new Ambiente("na Escola de Hawkins");
    ferroVelho = new Ambiente("no ferro velho ao redor da cidade");
    casaMike = new Ambiente("na casa da família Wheeler");
    poraoCasaMike = new Ambiente("no porão da casa da família Wheeler");
    trailerJim = new Ambiente("no seu trailer");
    floresta = new Ambiente("na Floresta Sombria");
    casaByers = new Ambiente("na casa da família Byers");
    casteloByers = new Ambiente("no Castelo Byers, uma cabana do Will Byers");
    florestaFundo = new Ambiente("no fundo da Floresta Sombria");
    laboratorio = new Ambiente("no Laboratório Nacional de Hawkins");
    salaLaboratorio = new Ambiente("na sala do Laboratório");
    laboratorioMI = new Ambiente("no Laboratório do Mundo Invertido");
    florestaMI = new Ambiente("na Floresta Sombria do Mundo Invertido");
    casteloMI = new Ambiente("no Castelo Byers do Mundo Invertido");


    /*---------- ITENS ----------*/
    // cria os itens
    Item chaveEscritorio, balaRevolver, alicate, lanterna, revolver;

    chaveEscritorio = new Coletavel("chave", "chave do escritório", "abre a porta");
    balaRevolver = new Coletavel("bala", "bala de revolver", "coloca na arma");
    alicate = new Coletavel("alicate", "alicate grande e enferrujado", "abre a grade");
    lanterna = new Coletavel("lanterna", "lanterna tática potente", "ilumina o Mundo Invertido");
    revolver = new Coletavel("revolver", "revolver modelo 66 em bom estado", "atira no inimigo");
    
    // adiciona os itens nos ambientes
    delegacia.adicionarItem(chaveEscritorio);
    escritorioDelegacia.adicionarItem(balaRevolver);
    ferroVelho.adicionarItem(alicate);
    poraoCasaMike.adicionarItem(lanterna);
    trailerJim.adicionarItem(revolver);
    trailerJim.adicionarItem(balaRevolver);


    /*---------- PISTAS ----------*/
    // cria as pistas
    Item desenhoWill, bicicleta, pisca;

    bicicleta = new Pista("bicicleta", "uma bicicleta vermelha caida", "é a bicicleta do Will");
    pisca = new Pista("pisca-pisca", "luzes pisca-pisca de Natal pendurados na parede", "As Luzes indicam que Will esta no mundo inferior" );
    desenhoWill = new Pista("desenho", "desenho infantil aparentemente feito por uma criança", "É o desenho do Mundo Inferior");

    // adiciona as pistas nos ambientes
    escola.adicionarItem(desenhoWill);
    floresta.adicionarItem(bicicleta);
    casaByers.adicionarItem(pisca);


    /*---------- MONSTROS ----------*/
    // cria os monstros
    Demogorgon demogorgon = new Demogorgon("um demônio associado com o submundo");

    // adiciona monstros no ambiente
    florestaMI.adicionarDemogorgon(demogorgon);


    /*---------- NPCS ----------*/
    // cria os NPCs
    NPC nancy, dustin, eleven, joyce, will;

    nancy = new NPC("Nancy", "a irmã do Mike este é meu amigo Jonathan");
    nancy.adicionarMensagem("Encontramos um monstro na floresta e ele sumiu");
    nancy.adicionarMensagem("Ele era grande e parecia não ter um rosto");

    dustin = new NPC("Dustin", "um amigo do Will e estes são Mike e Lucas");
    dustin.adicionarMensagem("Nós vimos homens armados no laboratório");
    dustin.adicionarMensagem("Mas não conseguimos passar pelas grades");

    eleven = new NPC("Eleven", "uma garota escondida em um forte de travesseiros");
    eleven.adicionarMensagem("Laboratório é perigoso");
    eleven.adicionarMensagem("Lá é muito escuro");

    joyce = new NPC("Joyce", "uma mãe preocupada com o sumiço de meu filho");
    joyce.adicionarMensagem("Meu filho falou que está aqui");
    joyce.adicionarMensagem("Ele me mostrou através das luzes");

    will = new NPC("Will", "o garoto perdido");

    // adiciona NPCs no ambiente
    escola.adicionarNpc(nancy);
    ferroVelho.adicionarNpc(dustin);
    poraoCasaMike.adicionarNpc(eleven);
    casaByers.adicionarNpc(joyce);
    casteloByers.adicionarNpc(will);

    
    /*---------- SAÍDAS ----------*/
    centro.ajustarSaida("esquerda", ferroVelho);
    centro.ajustarSaida("frente", escola);
    centro.ajustarSaida("tras", delegacia);

    delegacia.ajustarSaida("corredor", escritorioDelegacia, chaveEscritorio); // saída bloqueada
    delegacia.ajustarSaida("tras", casaMike);
    delegacia.ajustarSaida("frente", centro);

    escritorioDelegacia.ajustarSaida("corredor", delegacia);

    escola.ajustarSaida("tras", centro);

    ferroVelho.ajustarSaida("direita", centro);
    ferroVelho.ajustarSaida("esquerda", trailerJim);

    casaMike.ajustarSaida("frente", delegacia);
    casaMike.ajustarSaida("escada", poraoCasaMike);

    poraoCasaMike.ajustarSaida("escada", casaMike);

    trailerJim.ajustarSaida("direita", ferroVelho);
    trailerJim.ajustarSaida("esquerda", floresta);
    trailerJim.ajustarSaida("frente", casaByers);

    floresta.ajustarSaida("direita", trailerJim);
    floresta.ajustarSaida("frente", casteloByers);

    casaByers.ajustarSaida("tras", trailerJim);
    casaByers.ajustarSaida("esquerda", casteloByers);

    casteloByers.ajustarSaida("tras", floresta);
    casteloByers.ajustarSaida("direita", casaByers);
    casteloByers.ajustarSaida("frente", florestaFundo);

    florestaFundo.ajustarSaida("tras", casteloByers);
    florestaFundo.ajustarSaida("frente", laboratorio, alicate); // saída bloqueada

    laboratorio.ajustarSaida("tras", floresta);
    laboratorio.ajustarSaida("escada", salaLaboratorio);

    salaLaboratorio.ajustarSaida("escada", laboratorio);
    salaLaboratorio.ajustarSaida("portal", laboratorioMI, lanterna); // saída bloqueada

    laboratorioMI.ajustarSaida("portal", salaLaboratorio);
    laboratorioMI.ajustarSaida("frente", florestaMI);

    florestaMI.ajustarSaida("tras", laboratorioMI);
    florestaMI.ajustarSaida("frente", casteloMI);

    casteloMI.ajustarSaida("tras", florestaMI);

    return centro;
  }

}
