package br.ufla.gac106.s2022_1.bagulhosSinistros;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes.Ambiente;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes.Cenarios;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Coletavel;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Pista;
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
    // Responsável pela missão do jogo
    private Missao missao;
    // Analisador de comandos do jogo
    private Analisador analisador;
    // Cria todos os ambientes, adiciona os itens e liga as saidas deles
    private Cenarios cenarios;
    // Responsável por armazenar informações do Jogador
    private ManipularArquivo arq;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo(InterfaceUsuario iu) {
        this.iu = iu;

        analisador = new Analisador(iu);
        jogador = new Hopper();
        missao = new Missao();
        cenarios = new Cenarios();
        arq = new ManipularArquivo();
        iniciar();
    }

    /**
     * Inicia o jogo criando os cenários e atribuindo o ambiente atual ao jogador
     */
    public void iniciar() {
        Ambiente ambiente = cenarios.criarCenarios();
        jogador.setAmbienteAtual(ambiente);
        iu.ambienteAtualMudou(ambiente);
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
        arq.salvarDados(jogador.getNome(), jogador.getQuantidadeMovimentos(), false);
        iu.exibirMensagem("Obrigado por jogar. Até mais!");
        arq.carregarResultados();
    }

    /**
     * Imprime a mensagem de abertura o usuário.
     */
    private void imprimirBoasVindas() {
        iu.exibirMensagem("Bem-vindo a Bagulhos Sinistros!");
        iu.continuarMensagem("Este é um jogo de RPG investigativo sobrenatural.");
        iu.continuarMensagem(
                "\nApós o sumiço de um menino de 12 anos, o delegado Jim Hopper inicia uma investigação para encontra-lo na cidade de Hawkins.");
        iu.continuarMensagem("Ele irá desvendar misterios, com criaturas monstruosas e dimensões paralelas.");
        iu.continuarMensagem("\nSeu objetivo é achar o Will Byers!");
        iu.continuarMensagem("\nDigite 'ajuda' se voce precisar de ajuda.");

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
            iu.continuarMensagem("Eu não entendi o que voce disse...");
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
        } else if (palavraDeComando.equals("conversar")) {
            conversar(comando);
        }else if (palavraDeComando.equals("analisar")){
            analisar(comando);
        }else if (palavraDeComando.equals("atacar")){
            atacar(comando);
        }

        return querSair;
    }

    /**
     * Exibe informações de ajuda.
     * Imprime o objetivo do jogo e os possíveis comandos.
     */
    private void imprimirAjuda() {
        iu.exibirMensagem("Voce está em Hawkins e seu objetivo é encontrar Will Byers");
        iu.continuarMensagem("Suas palavras de comando sao:");
        iu.continuarMensagem("  " + analisador.getComandos());
    }

    /**
     * Exibe informações do ambiente atual.
     * Imprime a localização atual e as possíveis saídas.
     */
    public void exibirAmbienteAtual() {
        iu.continuarMensagem("\nVoce possui " + jogador.getQuantidadeMovimentos() + " movimentos");
        iu.continuarMensagem("\nVoce esta " + jogador.getAmbienteAtual().getDescricao());
        iu.continuarMensagem("Saidas: " + jogador.getAmbienteAtual().getSaidas());
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
            iu.continuarMensagem("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;

        try {
            proximoAmbiente = jogador.getAmbienteAtual().getAmbiente(direcao);

            Boolean saidaBloqueada = jogador.getAmbienteAtual().saidaBloqueada(direcao);

            if (saidaBloqueada) {
                iu.continuarMensagem("Saída bloqueada!");
            } else {
                jogador.setAmbienteAtual(proximoAmbiente);
                iu.ambienteAtualMudou(proximoAmbiente);
                exibirAmbienteAtual();
            }
        } catch (Exception e) {
            iu.continuarMensagem(e.getMessage());
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
            iu.continuarMensagem("Sair o que?");
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
        iu.exibirMensagem(jogador.getAmbienteAtual().getDescricaoLonga() + '\n');

        String itensObjeto = jogador.listarItensObjeto();
        if (itensObjeto != "") {
            iu.continuarMensagem(itensObjeto);
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
            iu.continuarMensagem("Pegar o que?");
            return;
        }

        // jogador recebe nome do item para pegar
        String item = comando.getSegundaPalavra();

       Coletavel encontrouItem = jogador.getAmbienteAtual().procurarItem(item);

        // ambiente tenta encontrar o item
        if (encontrouItem != null) {
           Coletavel itemEncontrado = jogador.getAmbienteAtual().coletarItem(item);

            // jogador tenta coletar o item se encontrado
            if (itemEncontrado != null) {
                boolean pegouItem = jogador.adicionarItem(itemEncontrado);

                // verifica se atingiu o máximo de tipos de itens coletados
                if (pegouItem) {
                    iu.continuarMensagem("Você coletou o item " + item);
                    iu.jogadorPegouItem(itemEncontrado);
                } else {
                    jogador.getAmbienteAtual().adicionarColetavel(itemEncontrado);
                    iu.continuarMensagem("Limite máximo de tipos de itens atingido!");
                }
            } else {
                iu.continuarMensagem("Este item não é coletavel");
            }
        } else {
            iu.continuarMensagem("Não há esse item no ambiente");
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
            iu.continuarMensagem("Usar o que?");
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
                iu.continuarMensagem("Voce usa o item " + item + " e " + acao);
            } catch (Exception e) {
                iu.continuarMensagem(e.getMessage());
            }
        } else {
            iu.continuarMensagem("Voce não possui esse item");
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
            iu.continuarMensagem("Largar o que?");
            return;
        }

        // jogador recebe nome do item para largar
        String item = comando.getSegundaPalavra();

        boolean encontrouItem = jogador.procurarItem(item);

        // tenta largar o item do jogador
        if (encontrouItem) {
            Coletavel itemEncontrado = jogador.removerItem(item);

            // tenta adicionar item no ambiente
            if (itemEncontrado != null) {
                jogador.getAmbienteAtual().adicionarColetavel(itemEncontrado);

                iu.continuarMensagem("Voce largou o item " + item + " " + jogador.getAmbienteAtual().getDescricao());
                iu.jogadorDescartouItem(itemEncontrado);
            }
        } else {
            iu.continuarMensagem("Voce não possui esse item");
        }
    }

    /**
     * "Interagir" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual NPC quer conversar.
     * 
     * @param comando O comando digitado.
     */
    private void conversar(Comando comando) {
        // se não há segunda palavra, não sabemos com quem conversar...
        if (!comando.temSegundaPalavra()) {
            iu.continuarMensagem("Interagir com quem?");
            return;
        }

        // jogador recebe nome do item para conversar
        String npc = comando.getSegundaPalavra();

        try {
            String mensagem = jogador.getAmbienteAtual().conversarComNpc(npc);
            iu.continuarMensagem(mensagem);
        } catch (Exception e) {
            iu.continuarMensagem(e.getMessage());
        }
    }

    /**
     * "Analisar" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual item analisar.
     * 
     * @param comando O comando digitado.
     */

    private void analisar(Comando comando) {
        // se não há segunda palavra, não sabemos o que analisar...
        if (!comando.temSegundaPalavra()) {
            iu.continuarMensagem("");
            return;
        }

        // tenta encontrar o item
        String item = comando.getSegundaPalavra();
        Pista encontrouItem = jogador.getAmbienteAtual().procurarPista(item);
        
        
        // tenta analisar o item se encontrado
        if (encontrouItem != null) {
            String pistaDesc = encontrouItem.getAnalise();
            iu.continuarMensagem(pistaDesc);
            
            missao.addPista(encontrouItem);
            iu.continuarMensagem(missao.verificarPistas());
        } else {
            iu.continuarMensagem("O ambiente não possui esse item");
        }
    }

    /**
     * "Atacar" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual monstro atacar.
     * 
     * @param comando O comando digitado.
     */

    private void atacar(Comando comando) {
        // se não há segunda palavra, não sabemos o que atacar...
        if (!comando.temSegundaPalavra()) {
            iu.continuarMensagem("");
            return;
        }

        // tenta encontrar o monstro
        String nomeMonstro = comando.getSegundaPalavra();
        iu.continuarMensagem(jogador.getAmbienteAtual().atacarMonstro(nomeMonstro));
    }

}