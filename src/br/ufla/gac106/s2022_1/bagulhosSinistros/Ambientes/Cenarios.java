package br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Coletavel;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Pista;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.NPC;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Monstros.Demogorgon;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Monstros.Monstro;

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

    centro = new Ambiente("Centro", "no centro da cidade de Hawkins", "img/ambiente/centro.jpg");
    delegacia = new Ambiente("Delegacia", "na delegacia de Polícia de Hawkins", "img/ambiente/delegacia.jpg");
    escritorioDelegacia = new Ambiente("Escritório da Delegacia", "no seu escritório na delegacia", "img/ambiente/escritorio.jpg");
    escola = new Ambiente("Escola", "na Escola de Hawkins", "img/ambiente/escola.jpg");
    ferroVelho = new Ambiente("Ferro Velho", "no ferro velho ao redor da cidade", "img/ambiente/ferrovelho.jpg");
    casaMike = new Ambiente("Casa do Mike", "na casa da família Wheeler", "img/ambiente/casaWheeler.jpg");
    poraoCasaMike = new Ambiente("Porão da Casa do Mike", "no porão da casa da família Wheeler", "img/ambiente/porao.jpg");
    trailerJim = new Ambiente("Trailer do Jim", "no seu trailer", "img/ambiente/trailer.jpg");
    floresta = new Ambiente("Floresta Sombria", "na Floresta Sombria", "img/ambiente/florestaSombria.jpg");
    casaByers = new Ambiente("Casa dos Byers", "na casa da família Byers", "img/ambiente/casaByers.jpg");
    casteloByers = new Ambiente("Castelo Byers", "no Castelo Byers, uma cabana do Will Byers", "img/ambiente/castelo.jpg");
    florestaFundo = new Ambiente("Floresta Sombria Fundo", "no fundo da Floresta Sombria", "img/ambiente/floresta.jpg");
    laboratorio = new Ambiente("Laboratório", "no Laboratório Nacional de Hawkins", "img/ambiente/laboratorio.jpg");
    salaLaboratorio = new Ambiente("Sala Laboratório", "na sala do Laboratório", "img/ambiente/sala.jpg");
    laboratorioMI = new Ambiente("Laboratório do Mundo Invertido", "no Laboratório do Mundo Invertido", "img/ambiente/laboratorioMI.jpg");
    florestaMI = new Ambiente("Floresta do Mundo Invertido", "na Floresta Sombria do Mundo Invertido", "img/ambiente/florestaMI.jpg");
    casteloMI = new Ambiente("Castelo Byers do Mundo Invertido", "no Castelo Byers do Mundo Invertido", "img/ambiente/casteloMI.jpg");


    /*---------- ITENS ----------*/
    // cria os itens
    Coletavel chaveEscritorio, balaRevolver, alicate, lanterna, revolver;

    chaveEscritorio = new Coletavel("chave", "chave do escritório", "img/itens/chave.png", "abre a porta");
    balaRevolver = new Coletavel("bala", "bala de revolver", "img/itens/bala.png", "coloca na arma");
    alicate = new Coletavel("alicate", "alicate grande e enferrujado", "img/itens/alicate.png", "abre a grade");
    lanterna = new Coletavel("lanterna", "lanterna tática potente", "img/itens/lanterna.png", "ilumina o Mundo Invertido");
    revolver = new Coletavel("revolver", "revolver modelo 66 em bom estado", "img/itens/revolver.png", "atira no inimigo");
    
    // adiciona os itens nos ambientes
    delegacia.adicionarColetavel(chaveEscritorio);
    escritorioDelegacia.adicionarColetavel(balaRevolver);
    ferroVelho.adicionarColetavel(alicate);
    trailerJim.adicionarColetavel(revolver);
    trailerJim.adicionarColetavel(balaRevolver);


    /*---------- PISTAS ----------*/
    // cria as pistas
    Pista desenhoWill, bicicleta, pisca;

    bicicleta = new Pista("bicicleta", "uma bicicleta vermelha", "img/itens/bicicleta.png", "Você encontrou uma bicicleta infantil caída próximo ao laboratório");

    pisca = new Pista("pisca-pisca", "luzes pisca-pisca de Natal pendurados na parede", "img/itens/pisca.png", "As luzes piscam nas letra A-Q-U-I" );

    desenhoWill = new Pista("desenho", "desenho de um castelo", "img/itens/desenho.png", "O desenho é feito pelo Will, uma imagem do Castelo Byers");

    // adiciona as pistas nos ambientes
    escola.adicionarPista(desenhoWill);
    floresta.adicionarPista(bicicleta);
    casaByers.adicionarPista(pisca);


    /*---------- MONSTROS ----------*/
    // cria os monstros
    Monstro demogorgon;
    
    demogorgon = new Demogorgon("um demônio associado com o submundo");

    // adiciona monstros no ambiente
    florestaMI.adicionarMonstro(demogorgon);


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
    joyce.adicionarMensagem("Will está tentando comunicar comigo");
    joyce.adicionarMensagem("Ele se mostra através das luzes");

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
