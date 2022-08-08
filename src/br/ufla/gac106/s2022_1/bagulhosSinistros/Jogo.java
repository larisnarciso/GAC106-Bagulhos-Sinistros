package br.ufla.gac106.s2022_1.bagulhosSinistros;
import br.ufla.gac106.s2022_1.bagulhosSinistros.item.Item;
import br.ufla.gac106.s2022_1.bagulhosSinistros.item.ItemColetavel;
import br.ufla.gac106.s2022_1.bagulhosSinistros.item.ItemNaoColetavel;

/**
 * Essa é a classe principal da aplicacao "World of Zull".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método
 * "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os
 * ambientes,
 * cria o analisador e começa o jogo. Ela também avalia e executa os comandos
 * que
 * o analisador retorna.
 * 
 * @author Michael Kölling and David J. Barnes (traduzido e adaptado por Julio
 *         César Alves)
 */

public class Jogo {
    // dados do jogador
    private Jogador jogador;
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {
        criarAmbientes();
        analisador = new Analisador();
        jogador = new Jogador("Jim Hopper");
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente centro, delegacia, escritorioDelegacia, escola, ferroVelho, casaMike, poraoCasaMike, trailerJim, floresta, casaByers, casteloByers, florestaFundo, laboratorio, salaLaboratorio, laboratorioMI, florestaMI, casteloMI;

        // cria os itens dos ambientes
        Item chaveEscritorio = new ItemColetavel("chave", "chave do escritório", "chave");
        Item balasArma = new ItemColetavel("balas", "um par de balas de revolver", "bala");
        Item desenhoWill = new ItemNaoColetavel("desenho", "desenho infantil aparentemente feito por uma criança");
        Item alicate = new ItemColetavel("alicate", "alicate grande e enferrujado", "alicate");
        Item lanterna = new ItemColetavel("lanterna", "lanterna tática potente", "chave");
        Item revolver = new ItemColetavel("revolver", "revolver modelo 66 com capacidade para 10 balas", "revolver");
        Item balasArma2 = new ItemColetavel("balas", "um par de balas de revolver", "bala");
        Item bicicleta = new ItemNaoColetavel("bicicleta", "uma bicicleta vermelha caida");
        Item pisca = new ItemNaoColetavel("pisca-pisca", "luzes pisca-pisca de Natal pendurados na parede com um alfabeto");

        // cria os ambientes
        centro = new Ambiente("no centro da cidade de Hawkins");
        centro.adicionarItem(chaveEscritorio);
        centro.adicionarItem(desenhoWill);
        delegacia = new Ambiente("na delegacia de Polícia de Hawkins");
        delegacia.adicionarItem(chaveEscritorio);
        escritorioDelegacia = new Ambiente ("no seu escritório na delegacia");
        escritorioDelegacia.adicionarItem(balasArma);
        escola = new Ambiente ("na Escola de Hawkins");
        escola.adicionarItem(desenhoWill);
        ferroVelho = new Ambiente ("no ferro velho ao redor da cidade");
        ferroVelho.adicionarItem(alicate);
        casaMike = new Ambiente ("na casa da família Wheeler");
        poraoCasaMike = new Ambiente ("no porão da casa da família Wheeler");
        poraoCasaMike.adicionarItem(lanterna);
        trailerJim = new Ambiente ("no seu trailer");
        trailerJim.adicionarItem(revolver);
        trailerJim.adicionarItem(balasArma);
        floresta = new Ambiente ("na Floresta Sombria");
        floresta.adicionarItem(bicicleta);
        casaByers = new Ambiente ("na casa da família Byers");
        casaByers.adicionarItem(pisca);
        casteloByers = new Ambiente ("no Castelo Byers, uma cabana do Will Byers");
        florestaFundo = new Ambiente ("no fundo da Floresta Sombria");
        laboratorio = new Ambiente ("no Laboratório Nacional de Hawkins");
        salaLaboratorio = new Ambiente ("na sala do Laboratório");
        laboratorioMI = new Ambiente ("no Laboratório do Mundo Invertido");
        florestaMI = new Ambiente ("na Floresta Sombria do Mundo Invertido");
        casteloMI = new Ambiente ("no Castelo Byers do Mundo Invertido");

        // inicializa as saidas dos ambientes
        centro.ajustarSaida("esquerda", ferroVelho);
        centro.ajustarSaida("frente", escola);
        centro.ajustarSaida("tras", delegacia);

        delegacia.ajustarSaida("corredor", escritorioDelegacia);
        delegacia.ajustarSaida("tras", casaMike);

        escritorioDelegacia.ajustarSaida("corredor", delegacia);

        escola.ajustarSaida("tras", centro);

        ferroVelho.ajustarSaida("direita", centro);
        ferroVelho.ajustarSaida("esquerda", trailerJim);

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
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo a Bagulhos Sinistros!");
        System.out.println("Este é um jogo de RPG investigativo sobrenatural.");
        System.out.println();
        System.out.println("Após o sumiço de um menino de 12 anos, o delegado Jim Hopper inicia uma investigação para encontra-lo na cidade de Hawkins. Ele irá desvendar misterios, com criaturas monstruosas e dimensões paralelas.");
        System.out.println();
        System.out.println("\nSeu objetivo é achar o Will Byers!");
        System.out.println("\nDigite 'ajuda' se voce precisar de ajuda.");
        System.out.println();

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
        }

        return querSair;
    }

    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de palavras de comando
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

        // Tenta sair do ambiente atual
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
     * É indicada a localização atual e as possíveis saídas.
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
     * Exibe a descrição longa do ambiente atual e, se o jogador possuir
     * itens, eles também são exibidos.
     */
    private void observar() {
        if (jogador.getItens() != "") {
            System.out.println("Itens no carro: " + jogador.getItens());
        }
        System.out.println(ambienteAtual.getDescricaoLonga());
    }

    /**
     * "Pegar" foi digitado.
     * Verifica se tem uma segunda palavra indicando qual item coletar
     * e tenta coletar o item, removendo do ambiente e adicionando no jogador.
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
        boolean encontrouItem = ambienteAtual.procuraItem(item);

        // Tenta coletar o item
        if (encontrouItem) {
            Item itemEncontrado = ambienteAtual.coletarItem(item);

            if (itemEncontrado != null) {
                jogador.adicionarItem(itemEncontrado);
    
                System.out.println("Você coletou o item " + item);
            } else {
                System.out.println("Nao eh possivel coletar esse item");
            }
        } else {
            System.out.println("Não há esse item no ambiente");
        }
    }
}
