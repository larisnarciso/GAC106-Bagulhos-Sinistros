package br.ufla.gac106.s2022_1.bagulhosSinistros;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Coletavel;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Item;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Pista;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Principal;

/**
 * Classe Jogo
 * 
 * Essa é a classe principal da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * O personagem principal (Jim Hopper) pode caminhar pela cidade de Hawkins com
 * o objetivo de encontrar Will Byers.
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método
 * "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os
 * ambientes - com os itens coletaveis e não coletaveis -, cria o analisador e
 * começa o jogo. Ela também avalia e executa os comandos que o analisador
 * retorna.
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

public class Jogo {
    // Personagem principal: Jim Hopper
    private Principal personagemPrincipal;
    // Analisador de comandos do jogo
    private Analisador analisador;
    // Ambiente onde se encontra o personagem principal
    private Ambiente ambienteAtual;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {
        criarAmbientes();
        analisador = new Analisador();
        personagemPrincipal = new Principal("Jim Hopper");
    }

    /**
     * Cria todos os ambientes, adiciona os itens e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente centro, delegacia, escritorioDelegacia, escola, ferroVelho, casaMike, poraoCasaMike, trailerJim,
                floresta, casaByers, casteloByers, florestaFundo, laboratorio, salaLaboratorio, laboratorioMI,
                florestaMI, casteloMI;

        // itens coletaveis dos ambientes
        Item chaveEscritorio, balaRevolver, alicate, lanterna, revolver;

        chaveEscritorio = new Coletavel("chave", "chave do escritório", "abre a porta");
        balaRevolver = new Coletavel("bala", "bala de revolver", "coloca na arma");
        alicate = new Coletavel("alicate", "alicate grande e enferrujado", "abre a grade");
        lanterna = new Coletavel("lanterna", "lanterna tática potente", "ilumina o Mundo Invertido");
        revolver = new Coletavel("revolver", "revolver modelo 66 em bom estado", "atira no inimigo");

        // pistas (item não coletaveis dos ambientes)
        Item desenhoWill, bicicleta, pisca;

        bicicleta = new Pista("bicicleta", "uma bicicleta vermelha caida");
        pisca = new Pista("pisca-pisca", "luzes pisca-pisca de Natal pendurados na parede");
        desenhoWill = new Pista("desenho", "desenho infantil aparentemente feito por uma criança");

        // cria os ambientes
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

        // adiciona os itens nos ambientes
        delegacia.adicionarItem(chaveEscritorio);
        escritorioDelegacia.adicionarItem(balaRevolver);
        escola.adicionarItem(desenhoWill);
        ferroVelho.adicionarItem(alicate);
        poraoCasaMike.adicionarItem(lanterna);
        trailerJim.adicionarItem(revolver);
        trailerJim.adicionarItem(balaRevolver);
        floresta.adicionarItem(bicicleta);
        casaByers.adicionarItem(pisca);

        // inicializa as saidas dos ambientes
        centro.ajustarSaida("esquerda", ferroVelho);
        centro.ajustarSaida("frente", escola);
        centro.ajustarSaida("tras", delegacia);

        delegacia.ajustarSaida("corredor", escritorioDelegacia);
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
        florestaFundo.ajustarSaida("frente", laboratorio);

        laboratorio.ajustarSaida("tras", floresta);
        laboratorio.ajustarSaida("escada", salaLaboratorio);

        salaLaboratorio.ajustarSaida("escada", laboratorio);
        salaLaboratorio.ajustarSaida("portal", laboratorioMI);

        laboratorioMI.ajustarSaida("portal", salaLaboratorio);
        laboratorioMI.ajustarSaida("frente", florestaMI);

        florestaMI.ajustarSaida("tras", laboratorioMI);
        florestaMI.ajustarSaida("frente", casteloMI);

        casteloMI.ajustarSaida("tras", florestaMI);

        ambienteAtual = centro; // o jogo comeca no centro
    }

    /**
     * Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e
        // os executamos até o jogo terminar.

        boolean terminado = false;
        while (!terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura o usuário.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo a Bagulhos Sinistros!");
        System.out.println("Este é um jogo de RPG investigativo sobrenatural.");
        System.out.println(
                "\nApós o sumiço de um menino de 12 anos, o delegado Jim Hopper inicia uma investigação para encontra-lo na cidade de Hawkins.");
        System.out.println("Ele irá desvendar misterios, com criaturas monstruosas e dimensões paralelas.");
        System.out.println("\nSeu objetivo é achar o Will Byers!");
        System.out.println("\nDigite 'ajuda' se voce precisar de ajuda.");

        exibirAmbienteAtual();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * 
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) {
        boolean querSair = false;

        if (comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        } else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        } else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        } else if (palavraDeComando.equals("observar")) {
            observar();
        } else if (palavraDeComando.equals("pegar")) {
            pegar(comando);
        } else if (palavraDeComando.equals("usar")) {
            usar(comando);
        } else if (palavraDeComando.equals("largar")) {
            largar(comando);
        }

        return querSair;
    }

    /**
     * Exibe informações de ajuda.
     * Imprime o objetivo do jogo e os possíveis comandos.
     */
    private void imprimirAjuda() {
        System.out.println("Voce está em Hawkins e seu objetivo é encontrar Will Byers");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println("  " + analisador.getComandos());
    }

    /**
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente,
     * caso contrário imprime mensagem de erro.
     * 
     * @param comando O comando digitado.
     */
    private void irParaAmbiente(Comando comando) {
        // se não há segunda palavra, não sabemos pra onde ir...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

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
    private void exibirAmbienteAtual() {
        System.out.println("\nVoce esta " + ambienteAtual.getDescricao());
        System.out.println("Saidas: " + ambienteAtual.getSaidas());
    }

    /**
     * "Sair" foi digitado.
     * Verifica o resto do comando pra ver se nós queremos
     * realmente sair do jogo.
     * 
     * @param comando O comando digitado.
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        } else {
            return true; // sinaliza que nós realmente queremos sair
        }
    }

    /**
     * "Observar" foi digitado.
     * Exibe a descrição longa do ambiente atual e, se o personagem principal
     * possuir
     * itens, eles também são exibidos.
     */
    private void observar() {
        System.out.println(ambienteAtual.getDescricaoLonga());
        System.out.println();
        String itensColdre = personagemPrincipal.listarItensColdre();
        if (itensColdre != "") {
            System.out.println(itensColdre);
        }
    }

    /**
     * "Pegar" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual item coletar
     * e tenta coletar o item, removendo do ambiente e adicionando no personagem
     * principal.
     * 
     * @param comando O comando digitado.
     */
    private void pegar(Comando comando) {
        // se não há segunda palavra, não sabemos o que coletar...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Pegar o que?");
            return;
        }

        String item = comando.getSegundaPalavra();
        boolean encontrouItem = ambienteAtual.procurarItem(item);

        // ambiente tenta encontrar o item
        if (encontrouItem) {
            Item itemEncontrado = ambienteAtual.coletarItem(item);

            // personagem principal tenta coletar o item se encontrado
            if (itemEncontrado != null) {
                boolean pegouItem = personagemPrincipal.adicionarItemColdre(itemEncontrado);

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
     * "Usar" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual item quer usar
     * e tenta usar o item no ambiente atual.
     * 
     * @param comando O comando digitado.
     */
    private void usar(Comando comando) {
        // se não há segunda palavra, não sabemos o que usar...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Usar o que?");
            return;
        }

        // tenta encontrar o item
        String item = comando.getSegundaPalavra();
        boolean encontrouItem = personagemPrincipal.procurarItemColdre(item);

        // tenta usar o item se encontrado
        if (encontrouItem) {
            String acao = personagemPrincipal.usarItem(item);
            System.out.println("Voce usa o item " + item + " e " + acao);
        } else {
            System.out.println("Voce nao possui esse item");
        }
    }

    /**
     * "Largar" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual item quer descartar
     * e tenta largar o item, removendo do jogador e devolvendo no ambiente
     * 
     * @param comando O comando digitado.
     */
    private void largar(Comando comando) {
        // se não há segunda palavra, não sabemos o que largar...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Largar o que?");
            return;
        }

        // tenta encontrar o item
        String item = comando.getSegundaPalavra();
        boolean encontrouItem = personagemPrincipal.procurarItemColdre(item);

        // tenta largar o item do personagem principal
        if (encontrouItem) {
            Item itemEncontrado = personagemPrincipal.largarItem(item);

            // tenta adicionar item no ambiente
            if (itemEncontrado != null) {
                ambienteAtual.adicionarItem(itemEncontrado);

                System.out.println("Voce largou o item " + item + " " + ambienteAtual.getDescricao());
            } else {
                System.out.println("Nao eh possivel largar esse item");
            }
        } else {
            System.out.println("Voce nao possui esse item");
        }
    }
}