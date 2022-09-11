package br.ufla.gac106.s2022_1.bagulhosSinistros.Ambientes;

import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Item;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Itens.Pista;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.NPC;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Monstros.Demogorgon;
import br.ufla.gac106.s2022_1.bagulhosSinistros.Personagens.Monstros.Monstro;
import br.ufla.gac106.s2022_1.baseJogo.EntidadeGrafica;

/**
 * Classe Ambiente
 * 
 * Essa é uma parte da aplicacao "Bagulhos Sinistros".
 * "Bagulhos Sinistros" é um jogo de RPG investigação sobrenatural, baseado em
 * texto.
 * 
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como tras, frente, direita, esquerda,
 * escada, portal e corredor. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
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

import java.util.ArrayList;

public class Ambiente extends EntidadeGrafica {
    // nome do ambiente
    private String nome;
    // descrição do ambiente
    private String descricao;
    // itens do ambiente
    private ArrayList<Item> itens;
    // monstros do ambiente
    private ArrayList<Monstro> monstros;
    // NPCs do ambiente
    private ArrayList<NPC> npcs;
    // ambientes visinhos de acordo com a direção
    private ArrayList<Saida> saidas;

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas.
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * 
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String nome, String descricao, String caminhoImagem) {
        super(caminhoImagem);
        this.descricao = descricao;

        itens = new ArrayList<>();
        monstros = new ArrayList<>();
        npcs = new ArrayList<>();
        saidas = new ArrayList<>();
    }

    /**
     * Método da classe EntidadeGrafica
     * 
     * @return O nome do ambiente.
     */
     @Override
     public String getNome() {
        return nome;
     };

    /**
     * Define as saídas do ambiente.
     * Cada direção ou leva a um outro ambiente ou é null
     * (indicando que não tem nenhuma saída para lá).
     * 
     * @param direcao  A direção definida.
     * @param ambiente o ambiente definida.
     */
    public void ajustarSaida(String direcao, Ambiente ambiente, Item item) {
        Saida saida = new Saida(direcao, ambiente, item);
        saidas.add(saida);
    }

    /*
     * Sobrecarga do método ajustar saídas quando não há saidas bloqueadas
     */
    public void ajustarSaida(String direcao, Ambiente ambiente) {
        Saida saida = new Saida(direcao, ambiente);
        saidas.add(saida);
    }

    /**
     * @return A descrição do ambiente.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return A descrição completa do ambiente.
     */
    public String getDescricaoLonga() {
        String textoDescricao = "";

        textoDescricao += "Você está " + descricao; // ambiente atual
        textoDescricao += listarNpcs(); // npcs no ambiente
        textoDescricao += listarItens(); // itens no ambiente
        textoDescricao += listarMonstros(); // monstros no ambiente

        return textoDescricao;
    }

    /**
     * Adiciona um item no ambiente.
     * 
     * @param item O item a ser adicionado.
     */
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    /**
     * @return true se há um item no ambiente.
     */
    private boolean temItem() {
        if (itens.size() > 0)
            return true;
        else
            return false;
    }

    /**
     * @param nome O nome do item.
     * @return se tem o item procurado.
     */
    public boolean procurarItem(String nome) {
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return A lista de itens no ambiente.
     */
    private String listarItens() {
        String listaItens = "";

        if (temItem()) {
            listaItens += "\n\nItem encontrado!";

            for (Item item : itens) {
                listaItens += "\n- " + item.getNome() + ": " + item.getDescricao();
            }
        }

        return listaItens;
    }

    /**
     * Muda o item para null e retorno o item.
     * 
     * @return O objeto item coletado.
     */
    public Item coletarItem(String nome) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getNome().equals(nome) && itens.get(i).getEhColetavel()) {
                Item meuItem = itens.get(i);
                itens.remove(i);
                return meuItem;
            }
        }
        return null;
    }

    /**
     * Adiciona um demogorgon no ambiente.
     * 
     * @param demogorgon O demogorgon a ser adicionado.
     */
    public void adicionarDemogorgon(Demogorgon demogorgon) {
        monstros.add(demogorgon);
    }

    /**
     * @return true se há um monstro no ambiente.
     */
    private boolean temMonstro() {
        if (monstros.size() > 0)
            return true;
        else
            return false;
    }

    /**
     * @return A lista de monstros no ambiente.
     */
    private String listarMonstros() {
        String listaMonstros = "";

        if (temMonstro()) {
            listaMonstros += "\nMonstro encontrado!";

            for (Monstro monstro : monstros) {
                listaMonstros += "\n- " + monstro.getNome() + ": " + monstro.getDescricao();
            }
        }

        return listaMonstros;
    }

    /**
     * Metodo onde o Monstro eh atacado e morto.
     */
    public String atacarMonstro(String nomeMonstro){

        if(temMonstro()){
            for(Monstro monstro : monstros){
                if(monstro.getNome().equals(nomeMonstro)){
                    monstro.defender();
                    int vidaAtual = monstro.getVida();
                    if(vidaAtual > 0){
                        return "Monstro Atacado \nVida Restante: " + vidaAtual; 
                    }else{
                        monstros.remove(monstro);
                        return monstro.getNome() + " foi morto";
                    }
        
                }
            }
        }
        return "Monstro nao encontrado";
    }

    /**
     * Adiciona um NPC no ambiente.
     * 
     * @param demogorgon O demogorgon a ser adicionado.
     */
    public void adicionarNpc(NPC npc) {
        npcs.add(npc);
    }

    /**
     * @return true se há um NPC no ambiente.
     */
    private boolean temNpc() {
        if (npcs.size() > 0)
            return true;
        else
            return false;
    }

    /**
     * @return A lista de NPCs no ambiente.
     */
    private String listarNpcs() {
        String listaNpcs = "";

        if (temNpc()) {
            listaNpcs += "\n";

            for (NPC npc : npcs) {
                listaNpcs += "\n" + npc.getNome() + " está aqui!";
            }
        }

        return listaNpcs;
    }

    /**
     * Coleta a informação do NPC.
     * 
     * @return A mensagem do NPC.
     */
    public String interagirComNpc(String nome) {
        String interacao = "";

        // busca o npc para interagir, se encontra, retorna a mensagem
        if (npcs.size() > 0) {
            for (NPC npc : npcs) {
                if (npc.getNome().equals(nome)) {
                    interacao += npc.dizerMensagem();
                }
            }
        } else {
            throw new RuntimeException("Parece que você está sozinho aqui");
        }

        return interacao;
    }

    /**
     * @param direcao A direção definida.
     * @return O ambiente atual.
     */
    public Ambiente getAmbiente(String direcao) {
        for (Saida saida : saidas) {
            if (saida.getDirecao().equals(direcao)) {
                return saida.getAmbiente();
            }
        }
        throw new RuntimeException("Tente outra saída!");
    }

    public Boolean saidaBloqueada(String direcao) {
        for (Saida saida : saidas) {
            if (saida.getDirecao().equals(direcao)) {
                return saida.getBloqueado();
            }
        }
        return false;
    }

    public boolean usarItem(String item) {
        for (Saida saida : saidas) {
            return saida.desbloquearSaida(item);
        }
        throw new RuntimeException("Esse item não foi útil...");
    }

    /**
     * @return As saídas possíveis.
     */
    public String getSaidas() {
        String textoSaidas = "";
        for (Saida saida : saidas) {
            textoSaidas += saida.getDirecao() + " ";
        }
        return textoSaidas;
    }

        /**
     * Coleta a descricao da pista.
     * 
     * @return true se existe pista no item nao coletavel.
     */
    public String getPistaDescricao(String nomeItem) {

        for (Item item:itens){
            if(!item.getEhColetavel() && item.getNome().equals(nomeItem)){
                return ((Pista)item).getPistaDescricao();
            }
        }
        return null;
    }

}