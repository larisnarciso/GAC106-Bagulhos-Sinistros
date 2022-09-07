package br.ufla.gac106.s2022_1.bagulhosSinistros;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes.Ambiente;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes.Cenarios;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Item;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Jogadores.Hopper;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Jogadores.Jogador;
import br.ufla.gac106.s2022_1.baseJogo.InterfaceUsuario;

/**
 * Classe Jogo
 * 
 * Essa é a classe principal da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * O jogador principal (Jim Hopper) pode caminhar pela cidade de Hawkins com
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
    // Interface do usuário (tela ou terminal)
    private InterfaceUsuario iu;
    // Jogador: Jim Hopper
    private Jogador jogador;
    // Analisador de comandos do jogo
    private Analisador analisador;
    // Cria todos os ambientes, adiciona os itens e liga as saidas deles
    private Cenarios cenarios;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo(InterfaceUsuario iu) {
        this.iu = iu;

        analisador = new Analisador();
        jogador = new Hopper();
        cenarios = new Cenarios();

        iniciar();
    }

    /**
     * Inicia o jogo criando os cenários e atribuindo o ambiente atual ao jogador
     */
    public void iniciar() {
        Ambiente ambiente = cenarios.criarCenarios();
        jogador.setAmbienteAtual(ambiente);
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
        } else if (palavraDeComando.equals("interagir")) {
            interagir(comando);
        }else if (palavraDeComando.equals("analisar")){
            analisar(comando); 
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
     * Exibe informações do ambiente atual.
     * Imprime a localização atual e as possíveis saídas.
     */
    public void exibirAmbienteAtual() {
        System.out.println("\nVoce possui " + jogador.getQuantidadeMovimentos() + " movimentos");
        System.out.println("\nVoce esta " + jogador.getAmbienteAtual().getDescricao());
        System.out.println("Saidas: " + jogador.getAmbienteAtual().getSaidas());
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

        // tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;
        proximoAmbiente = jogador.getAmbienteAtual().getAmbiente(direcao);

        Boolean saidaBloqueada = jogador.getAmbienteAtual().saidaBloqueada(direcao);

        if (saidaBloqueada) {
            System.out.println("Saída bloqueada!");
        } else {
            jogador.setAmbienteAtual(proximoAmbiente);
            exibirAmbienteAtual();
        }
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
     * jogador observa o ambiente atual.
     */
    private void observar() {
        System.out.println(jogador.getAmbienteAtual().getDescricao());
        System.out.println();

        String itensObjeto = jogador.listarItensObjeto();
        if (itensObjeto != "") {
            System.out.println(itensObjeto);
        }
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

        // jogador recebe nome do item para pegar
        String item = comando.getSegundaPalavra();

        boolean encontrouItem = jogador.getAmbienteAtual().procurarItem(item);

        // ambiente tenta encontrar o item
        if (encontrouItem) {
            Item itemEncontrado = jogador.getAmbienteAtual().coletarItem(item);

            // jogador tenta coletar o item se encontrado
            if (itemEncontrado != null) {
                boolean pegouItem = jogador.adicionarItem(itemEncontrado);

                // verifica se atingiu o máximo de tipos de itens coletados
                if (pegouItem) {
                    System.out.println("Você coletou o item " + item);
                } else {
                    jogador.getAmbienteAtual().adicionarItem(itemEncontrado);
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

        // jogador recebe nome do item para usar
        String item = comando.getSegundaPalavra();

        boolean encontrouItem = jogador.procurarItem(item);

        // tenta usar o item se encontrado
        if (encontrouItem) {
            try {
                jogador.getAmbienteAtual().usarItem(item);

                String acao = jogador.usarItem(item);
                System.out.println("Voce usa o item " + item + " e " + acao);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Voce nao possui esse item");
        }
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

        // jogador recebe nome do item para largar
        String item = comando.getSegundaPalavra();

        boolean encontrouItem = jogador.procurarItem(item);

        // tenta largar o item do jogador
        if (encontrouItem) {
            Item itemEncontrado = jogador.removerItem(item);

            // tenta adicionar item no ambiente
            if (itemEncontrado != null) {
                jogador.getAmbienteAtual().adicionarItem(itemEncontrado);

                System.out.println("Voce largou o item " + item + " " + jogador.getAmbienteAtual().getDescricao());
            }
        } else {
            System.out.println("Voce nao possui esse item");
        }
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

        // jogador recebe nome do item para interagir
        String npc = comando.getSegundaPalavra();
        
        try {
            String mensagem = jogador.getAmbienteAtual().interagirComNpc(npc);
            System.out.println(mensagem);
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
    }
    private void analisar(Comando comando) {
        // se não há segunda palavra, não sabemos o que analisar...
        if (!comando.temSegundaPalavra()) {
            System.out.println("");
            return;
        }

        // tenta encontrar o item
        String item = comando.getSegundaPalavra();
        String pistaDesc = jogador.getAmbienteAtual().getPistaDescricao(item);

        // tenta usar o item se encontrado
        if (pistaDesc != null) {
            System.out.println("Voce analisa o item " + item + " e encontra uma pista: " + pistaDesc);
        } else {
            System.out.println("O ambiente nao possui esse item");
        }
    }
    
}