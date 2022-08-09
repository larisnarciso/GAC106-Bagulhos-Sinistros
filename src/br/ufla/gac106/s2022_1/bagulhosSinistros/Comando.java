package br.ufla.gac106.s2022_1.bagulhosSinistros;

/**
 * Classe Comando
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Essa classe guarda informações sobre um comando que foi digitado pelo
 * usuário.
 * Um comando atualmente consiste em duas strings: uma palavra de comando e uma
 * segunda palavra (por exemplo, se o campo for "pegar chave", entao as duas
 * strings obviamente serao "pegar" e "chave").
 * 
 * Isso é usado assim: comandos já estão validados como comandos válidos. Se o
 * usuário entrou um comando inválido (uma palavra que não é conhecida) então a
 * palavra de comando é <null>.
 *
 * Se o comando tem só uma palavra, a segunda palavra é <null>.
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

public class Comando {
    // primeira palavra que representa o comando
    private String palavraDeComando;
    // segunda palavra que representa um complemento do comando
    private String segundaPalavra;

    /**
     * Cria um objeto comando. Primeira e segunda palavra devem ser fornecidas, mas
     * qualquer uma (ou ambas) podem ser null.
     * 
     * @param primeiraPalavra A primeira palavra do comando. Null se o comando não
     *                        foi reconhecido.
     * @param segundaPalavra  A segunda palavra do comando.
     */
    public Comando(String primeiraPalavra, String segundaPalavra) {
        palavraDeComando = primeiraPalavra;
        this.segundaPalavra = segundaPalavra;
    }

    /**
     * Retorna a palavra de comando (a primeira palavra) deste comando.
     * Se o comando não foi entendido, o resultado eh null.
     * 
     * @return A palavra de comando.
     */
    public String getPalavraDeComando() {
        return palavraDeComando;
    }

    /**
     * @return A segunda palavra deste comando. Retorna null se não existe segunda
     *         palavra.
     */
    public String getSegundaPalavra() {
        return segundaPalavra;
    }

    /**
     * @return true se o comando não foi entendido.
     */
    public boolean ehDesconhecido() {
        return (palavraDeComando == null);
    }

    /**
     * @return true se o comando tem uma segunda palavra.
     */
    public boolean temSegundaPalavra() {
        return (segundaPalavra != null);
    }
}
