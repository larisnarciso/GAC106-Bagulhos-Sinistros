package br.ufla.gac106.s2022_1.bagulhosSinistros;

public class App {
    public static void main(String[] args) throws Exception {
        // Jogo exibido pelo terminal
        Terminal terminal = new Terminal("Bagulhos Sinistros");

        Jogo jogo = new Jogo(terminal);
        jogo.jogar();
    }
}