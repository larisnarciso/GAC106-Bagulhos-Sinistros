package br.ufla.gac106.s2022_1.bagulhosSinistros;

import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Classe ManipularArquivo
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Manipular arquivo é responsável por fazer escrita e leitura em um arquivo de
 * texto.
 * 
 * Nesse arquivo são armazenados os dados ao fim do jogo, com o resultado, o
 * nome do jogador, a quantidade de movimentos e a data e hora do jogo
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

public class ManipularArquivo {
    /**
     * @return a data atual.
     */
    private String getDataAtual() {
        DateFormat FormatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return FormatoData.format(date);
    }

    /**
     * Salva os dados em arquivo de texto
     * 
     * @param nome          O nome do Jogador.
     * @param qtdMovimentos A quantidade de movimentos.
     * @param venceu        Se jogador venceu o jogo.
     */
    public void salvarDados(String nome, int qtdMovimentos, boolean venceu) {
        String resultado;
        if (venceu == true) {
            resultado = "Ganhou!";
        } else {
            resultado = "Perdeu";
        }
        try {
            FileWriter arq = new FileWriter("dadosJogador.txt");
            arq.write("\nResultado: " + resultado);
            arq.write("\nNome do Jogador: " + nome);
            arq.write("\nQuantidade de movimentos: " + qtdMovimentos);
            arq.write("\nÚltimo jogo: " + getDataAtual());
            arq.close();
        } catch (Exception e) {
            System.out.println("Falha durante o salvamento! impossível salvar");
        }
    }

    /**
     * Carrega os resultados anteriores
     */
    public void carregarResultados() {
        try {
            BufferedReader arq = new BufferedReader(new FileReader("dadosJogador.txt"));
            String linha = arq.readLine();
            String resultado = "";
            while (linha != null) {
                resultado += linha + "\n";
                linha = arq.readLine();
            }
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Impossível carregar dados salvos anteriormente");
        }
    }
}
