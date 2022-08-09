package br.ufla.gac106.s2022_1.bagulhosSinistros;

import java.util.Scanner;

/**
 * Classe Analisador
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Esse analisador lê a entrada do usuario e tenta interpretá-la como um comando
 * "Adventure".
 * Cada vez que é chamado, ele lê uma linha do terminal e tenta interpretar a
 * linha como um comando de duas palavras. Ele retorna o comando como um objeto
 * da classe Comando.
 *
 * O analisador tem um conjunto de palavras de comando conhecidas. Ele compara a
 * entrada do usuário com os comandos conhecidos, e se a entrada não é um dos
 * comandos conhecidos, ele retorna um objeto comando que é marcado como um
 * comando desconhecido.
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

public class Analisador {
    // guarda todas as palavras de comando validas
    private PalavrasComando palavrasDeComando;
    // origem da entrada de comandos
    private Scanner entrada;

    /**
     * Cria um analisador para ler do terminal.
     */
    public Analisador() {
        palavrasDeComando = new PalavrasComando();
        entrada = new Scanner(System.in);
    }

    /**
     * @return O próximo comando do usuario
     */
    public Comando pegarComando() {
        // guardará uma linha inteira
        String linha;
        // guardará até duas palavras usadas no comando
        String palavra1 = null;
        String palavra2 = null;

        // imprime o prompt
        System.out.print("> ");

        // obtém uma linha de comando do usuário
        linha = entrada.nextLine();

        // quebra o comando do usuário em várias palavras, usando espaços em branco como
        // separadores.
        // Exemplo: se ele digitar "ir norte", o comando vai gerar um vetor com as duas
        // palavras ["ir", "norte"].
        String[] palavras = linha.trim().split("\\s+");

        // guarda a primeira e a segunda palavras digitadas pelo usuário, se houverem.
        if (palavras.length >= 1) {
            palavra1 = palavras[0];
        }
        if (palavras.length >= 2) {
            palavra2 = palavras[1];
        }

        // Agora verifica se esta palavra é conhecida. Se for, cria um comando com ela.
        // Se não, cria um comando "null" (para comando desconhecido)
        if (palavrasDeComando.ehComando(palavra1)) {
            return new Comando(palavra1, palavra2);
        } else {
            return new Comando(null, palavra2);
        }
    }

    /**
     * @return A lista de comandos possíveis
     */
    public String getComandos() {
        return PalavrasComando.getComandos();
    }
}
