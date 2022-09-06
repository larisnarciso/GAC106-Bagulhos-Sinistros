package br.ufla.gac106.s2022_1.bagulhosSinistros;

import java.util.*;

import br.ufla.gac106.s2022_1.baseJogo.EntidadeGrafica;
import br.ufla.gac106.s2022_1.baseJogo.InterfaceUsuario;

/* Melhorias possíveis:
 *   - Tratamento para comando sair (término do jogo em geral).
 *   - Criar botões para as direções possíveis? (atalho para comando "ir")
 *   - Tratar itens como botões? (atalho para comando "usar")
 *   - Tratar todos os comandos válidos como botões?
 */

/**
 * Classe que cria e exibe uma janela gráfica para Interface com o Usuário em um jogo do tipo Adventure.
 * 
 * @author Julio César Alves
 */
public class Terminal implements InterfaceUsuario
{
    // origem da entrada de comandos
    private Scanner entrada;
    
    /**
     * Exibe uma nova mensagem para o jogador
     * 
     * @param mensagem Mensagem a ser exibida para o usuário.
     * @param apagarAnteriroes Indica se as mensagens anteriores devem ser apagadas antes de 
     *                         exibir a nova mensagem.
     */
    @Override
    public void exibirMensagem(String mensagem) {
        // exibe a mensagem
        System.out.println(mensagem);
    }
        
    /**
     * Acrescenta informação à uma mensagem anterior
     * 
     * @param mensagem Informação a ser acrecentada na mensagem anterior
     */
    @Override
    public void continuarMensagem(String mensagem)  {
        // exibe a mensagem
        System.out.println(mensagem);
    }
        
    /**
     * Obtém um comando do jogador.
     * 
     * O código abaixo tem o efeito da tela ficar aguardando o jogador digitar um comando 
     * e apertar ENTER ou clicar em enviar.
     */
    @Override
    public String obterComando() {
        // guardará uma linha inteira
        String comando;

        // imprime o prompt
        System.out.print("> ");

        // obtém uma linha de comando do usuário
        comando = entrada.nextLine();
        
        // O método retorna o comando digitado pelo usuário
        return comando;
    }
    
    /**
     * Obtém uma informação do usuário como String. 
     * 
     * Obs.: não deve ser usado para comandos. No caso de comandos use 'obterComando'.
     * 
     * @param instrucao Mensagem de instrução para o usuário (diz qual informação está sendo solicitada)
     */
    @Override
    public String obterInformacao(String instrucao) {
        // exibe a instrução da informação pedida
        System.out.println(instrucao);

        return obterComando();
    }
    
    /**
     * Informa a Interface do Usuário que o jogador mudou de ambiente.
     * 
     * Tem o efeito de mostrar na tela a imagem do novo ambiente atual.
     * 
     * @param ambiente Objeto do novo ambiente atual.
     */
    @Override
    public void ambienteAtualMudou(EntidadeGrafica ambiente) {
        // comandos
    }
    
    /**
     * Informa a Interface do Usuário que o jogador pegou um item (ou similar).
     * 
     * Tem o efeito de mostrar o item na barra lateral do jogo.
     * 
     * @param item Objeto do item que o usuário pegou.
     */
    @Override
    public void jogadorPegouItem(EntidadeGrafica item) {
        // comandos
    }

    /**
     * Informa a Interface do Usuário que o jogador não tem mais um item (ou similar).
     * 
     * Tem o efeito de não mostrar mais o item na barra lateral do jogo.
     * 
     * @param item Objeto do item que o usuário não tem mais.
     */
    @Override
    public void jogadorDescartouItem(EntidadeGrafica item) {
        // comandos
    }
}
