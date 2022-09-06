package br.ufla.gac106.s2022_1.bagulhosSinistros;

import br.ufla.gac106.s2022_1.baseJogo.Tela;

public class AppGrafico {
    public static void main(String[] args) throws Exception {
        // Jogo exibido pela tela
        Tela tela = new Tela("Bagulhos Sinistros");

        Jogo jogo = new Jogo(tela);
        jogo.jogar();
    }
}
