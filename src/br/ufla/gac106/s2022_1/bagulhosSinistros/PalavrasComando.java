package br.ufla.gac106.s2022_1.bagulhosSinistros;

/**
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Essa classe guarda uma enumeração de todos os comandos conhecidos do
 * jogo. Ela é usada no reconhecimento de comandos como eles são digitados.
 *
 * @author Michael Kölling and David J. Barnes (traduzido e adaptado por Julio
 *         César Alves)
 */

public class PalavrasComando {
    // um vetor constante que guarda todas as palavras de comandos válidas
    private static final String[] comandosValidos = {
            "ir", "sair", "ajuda", "observar", "pegar"
    };

    /**
     * @return A lista de comandos possíveis
     */
    public static String getComandos() {
        String comandos = "";
        for (String comando : comandosValidos) {
            comandos += comando + " ";
        }
        return comandos;
    }

    /**
     * Verifica se uma dada String é uma palavra de comando válida.
     * 
     * @param umaString A string de comando.
     * @return true se a string dada é um comando valido, false se não é.
     */
    public boolean ehComando(String umaString) {
        for (int i = 0; i < comandosValidos.length; i++) {
            if (comandosValidos[i].equals(umaString))
                return true;
        }
        // se chegamos aqui, a string não foi encontrada nos comandos.
        return false;
    }
}