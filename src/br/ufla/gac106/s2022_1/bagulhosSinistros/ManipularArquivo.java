package br.ufla.gac106.s2022_1.bagulhosSinistros;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ManipularArquivo {

    private String getDataAtual() {
        DateFormat FormatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return FormatoData.format(date);
    }



    public void salvarDados(String nome, int qtdMovimentos, boolean venceu) {
        String resultado;
        if(venceu == true){
            resultado = "Ganhou!";
        }
        else{
            resultado = "Perdeu";
        }
        try {
            FileWriter arq = new FileWriter("dadosJogador.txt");
            arq.write("\nResultado: " + resultado);
            arq.write("\nNome do Jogador: " + nome);
            arq.write("\nQuantidade de movimentos: " + qtdMovimentos);
            arq.write("\nÚltimo jogo: " + getDataAtual());
            arq.close();
        }catch (Exception e) {
            System.out.println("Falha durante o salvamento! impossível salvar");
        }
    }


    public void carregarResultados(){
        try {
            BufferedReader arq = new BufferedReader(new FileReader("dadosJogador.txt"));
            String linha = arq.readLine();
            String resultado = "";
            while (linha != null) {
                resultado+= linha + "\n";
                linha = arq.readLine();
            }
            System.out.println(resultado);
        }
        catch (Exception e) {
            System.out.println("Impossível carregar dados salvos anteriormente");
        }
    }
}
