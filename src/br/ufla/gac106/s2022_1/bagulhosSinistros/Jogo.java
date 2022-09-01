package br.ufla.gac106.s2022_1.bagulhosSinistros;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes.Ambiente;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes.Cenarios;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Jogadores.Hopper;

/**
 * Classe Jogo
 * 
 * Essa é a classe principal da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * O hopper principal (Jim Hopper) pode caminhar pela cidade de Hawkins com
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
    // Jogador: Jim Hopper
    private Hopper hopper;
    // Analisador de comandos do jogo
    private Analisador analisador;
    // Cria todos os ambientes, adiciona os itens e liga as saidas deles
    private Cenarios cenarios;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {
        analisador = new Analisador();
        hopper = new Hopper();
        cenarios = new Cenarios();

        iniciar();
    }

    /**
     * Inicia o jogo criando os cenários e atribuindo o ambiente atual ao hopper
     */
    public void iniciar() {
        Ambiente ambiente = cenarios.criarCenarios();
        hopper.setAmbienteAtual(ambiente);
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

        hopper.exibirAmbienteAtual();
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
        } else if (palavraDeComando.equals("interagir")) {
            interagir(comando);
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
    public void irParaAmbiente(Comando comando) {
        // se não há segunda palavra, não sabemos pra onde ir...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();
        hopper.irParaAmbiente(direcao);
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
     * hopper observa o ambiente atual.
     */
    private void observar() {
        hopper.observar();
    }

    /**
     * "Pegar" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual item coletar.
     * 
     * @param comando O comando digitado.
     */
    private void pegar(Comando comando) {
        // se não há segunda palavra, não sabemos o que coletar...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Pegar o que?");
            return;
        }

        // hopper recebe nome do item para pegar
        String item = comando.getSegundaPalavra();
        hopper.pegar(item);
    }

    /**
     * "Usar" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual item quer usar.
     * 
     * @param comando O comando digitado.
     */
    private void usar(Comando comando) {
        // se não há segunda palavra, não sabemos o que usar...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Usar o que?");
            return;
        }

        // hopper recebe nome do item para usar
        String item = comando.getSegundaPalavra();
        hopper.usar(item);
    }

    /**
     * "Largar" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual item quer descartar.
     * 
     * @param comando O comando digitado.
     */
    private void largar(Comando comando) {
        // se não há segunda palavra, não sabemos o que largar...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Largar o que?");
            return;
        }

        // hopper recebe nome do item para largar
        String item = comando.getSegundaPalavra();
        hopper.largar(item);
    }

    /**
     * "Interagir" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual NPC quer interagir.
     * 
     * @param comando O comando digitado.
     */
    private void interagir(Comando comando) {
        // se não há segunda palavra, não sabemos com quem interagir...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Interagir com quem?");
            return;
        }

        // hopper recebe nome do item para interagir
        String npc = comando.getSegundaPalavra();
        hopper.interagir(npc);
    }
}