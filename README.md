<div align=center>

![Bagulhos Sinistros](./img/logo/bagulhos_sinistros.png)

</div>

<p align=center>
  <a href="#entregafinal" style="font-weight: 600; color: #A60D1A">Entrega Final</a> • 
  <a href="#trabalho" style="font-weight: 600; color: #A60D1A">Trabalho</a> • 
  <a href="#sobre" style="font-weight: 600; color: #A60D1A">Sobre o Jogo</a> • 
  <a href="#mapa" style="font-weight: 600; color: #A60D1A">Mapa</a> • 
  <a href="#jogabilidade" style="font-weight: 600; color: #A60D1A">Jogabilidade</a> • 
  <a href="#tecnologias" style="font-weight: 600; color: #A60D1A">Tecnologias</a> • 
  <a href="#autores" style="font-weight: 600; color: #A60D1A">Autores</a> • 
  <a href="#licenca" style="font-weight: 600; color: #A60D1A">Licença</a> 
</p>
<br>

<h1 id="entregafinal" style="font-weight: 600; color: #A60D1A">
☑ Entrega Final
</h1>

**Nomes completos** dos integrantes do grupo que realmente fizeram o trabalho:

- Ana Beatriz Rodrigues Torres
- Ingrid de Falchi
- Larissa Narciso Oliveira
- Samuel Luiz Freitas Ferreira

### Tabela de Requisitos

|  Id |  Descrição                                              | Respostas    | 
|-----|---------------------------------------------------------|--------------|
| 3.1 | Número de ambientes                                     | (17) |
| 3.2 | Número de direções                                      | (7) |
| 3.3 | Trata itens e há itens que jogador não consegue pegar?  | (**sim**/não)    |
| 3.4 | Tem máximo de itens que jogador não consegue carregar?  | (**sim**/não)    |
| 3.5 | Jogador consegue usar itens?                            | (**sim**/não)    |
| 3.6 | Jogador consegue largar itens?                          | (**sim**/não)    |
| 3.7 | Jogo tem personagens (além do jogador)?                 | (**sim**/não)    |
| 3.8 | As duas funcionalidades adicionais implementadas foram: | (Limite de tempo: 70 movimentos) (Ambientes com mais saídas bloqueadas: 3 saídas (Sala Delegacia - Laboratório - Mundo Invertido))  |
| 3.9 | As duas palavras de comando adicionais são:             | (**Analisar** pistas nos ambientes)(**Atacar Inimigo**))  |
| 3.10| Os três passos (resumidos) de missão são:               | (A missão é uma investigação para encontrar o Will, deverá ser encontrado 3 pistas, sendo elas: **1- o desenho que está na escola, 2- a bicicleta que esta na floresta, e o 3- pisca-pisca que está na casa dos Byers.** Após realizar a analise de todas as pistas, o jogador ganhará a laterna, onde ao usar ela na sala do Laboratorio, irá liberar o acesso ao Mundo Invertido, no castelo Byers do Mundo Invertido ele irá encontrar o Will.)  |
| 3.11| Jogo funciona no terminal e na interface gráfica        | (**sim**/não)    |
| 4.1 | Atende passos obrigatórios do Exercício World of Zuul   | (**sim**/não)    |
| 4.5 | Só há interação com usuário nas classes Terminal e Tela | (**sim**/não)    |
| 4.7 | Código usa polimorfismo de método                       | (sim/**não** (apenas em coisas simples, como mudar Descrição))    |
| 4.8 | A alteração de funcionalidade na interface gráfica foi: | (texto de resposta)    |
| 4.9 | Jogo usa arquivos para:                                 | (Exibir resultado, nome, quantidade de movimentos e data do jogo)    |
| 4.10| Código possui tratamento de exceção                     | (**sim**/não)    |
| 4.11| Padrão de projeto implementado:                         | (Singleton em Missão)    |
| 4.12| Diagrama de classes UML atualizado está na pasta doc?   | (**sim**/não)    |



<h1 id="trabalho" style="font-weight: 600; color: #A60D1A">
📚 Trabalho
</h1>

Trabalho Prático da disciplina de Prática de Programação Orientada a Objetos da Universidade Federal de Lavras (UFLA), lecionada pelo professor Julio Cesar Alves.

Baseado no jogo World of Zuul, um RPG por textos pelo terminal.

Para o gerenciamento do projeto, fluxo de trabalho e monitoramento de tarefas, foi utilizado a ferramenta Trello. Planejamos o trabalho como um todo, elaborando um bom Design de Classes e dividindo as tarefas entre os membros do grupo.

**Jogabilidade**

Do ponto de vista do jogador, ele poderá andar em 7 direções nos 17 ambientes. Além disso, ele terá uma missão para concluir o jogo, que consiste em analisar e coletar itens para encontrar Will. Caso o jogador ultrapasse 70 movimentos, o jogo irá finalizar.

Mais detalhes em <a href="#sobre">Sobre o Jogo</a> e <a href="#jogabilidade">Jogabilidade</a>.

**Conceitos**

Para a construção do trabalho foram utilizados os conceitos estudados de Orientação a Objetos:
- Relacionamentos de composição, agregação e associação: entre as classes Ambiente, Item e Personagem.
- Herança: Coletavel e Pista herdam de Item e Principal, NPC e Monstro herdam de Personagem.
- Polimorfismo:
  - Variável Polimórfica: itens na classe Ambiente que recebem tanto Item Coletavel quanto Item Pista.
  - Polimorfismo de Método: sobrescrição do método getDescricao() da classe Item pela classe Pista, adicionando uma informação que é um item especial. 
- Salvamento/carregamento de dados: será em um arquivo de texto, armazenando os dados: 
  - Se ele ganhou ou perdeu;
  - Quantidade de movimentos; 
  - Data que jogou.

<h1 id="sobre" style="font-weight: 600; color: #A60D1A" > 🕹️ Sobre o Jogo </h1>

### História:

Após o sumiço de Will Byers, um menino de 12 anos, o delegado Jim Hopper inicia uma investigação para encontrá-lo na cidade de Hawkins. Ele irá desvendar mistérios, com criaturas monstruosas e dimensões paralelas.

### Objetivo:

Encontrar Will Byers no Mundo Invertido.

### Jogador Principal:

Jim Hopper.

### Personagem Secundários (NPC):

Joyce Byers, Will Byers, Eleven, Dustin , Nancy.

### Missão:

Na investigação, deverá ser analisado alguns itens para descobrir onde está o Will.

1. O desenho irá ser uma pista de onde o Will está
2. A bicicleta irá mostrar que o Will estava perto do Laboratório
3. O pisca-pisca na casa da Joyce irá indicar que ele está no Mundo Invertido

Com a análise dessas 3 pistas, o jogador ganhará um item adicional (Lanterna), que irá liberar o acesso ao Mundo Invertido.

Alguns itens que ajudará no Mundo Invertido:

1. Arma
2. Balas
3. Lanterna

No Mundo invertido, o jogador irá encontrar o Demogorgon, ele poderá derrota-lo, andando para frente ele irá chegar ao Castelo Byers do Mundo Invertido, e lá irá encontar o Will.

### Game Over:

70 movimentos.

### Armazenamento:

Coldre do Jim Hopper.

### Limite do armazenamento:

3 tipos de itens. (Extra: Lanterna)

### Gênero:

RPG Investigação Sobrenatural.

<br>
<h1 id="mapa" style="font-weight: 600; color: #A60D1A">
🗺️ Mapa
</h1>

<br>
<div align=center>

![Mapa](./img/documento/mapa.png "Mapa de Hawkins")

</div>

<br>
<h1 id="jogabilidade" style="font-weight: 600; color: #A60D1A">
🖥️ Jogabilidade
</h1>

<table style="width:100%">
  <tr>
    <th>Ambiente</th>
    <th>Itens</th>
    <th>Ação</th>
    <th>Personagens</th>
    <th>Direções</th>
  </tr>
  <tr>
    <td>Centro</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>
      Esquerda: Ferro Velho <br>
      Frente: Escola <br>
      Trás: Delegacia
    </td>
  </tr>
  <tr>
    <td>Delegacia</td>
    <td>Chave</td>
    <td>Usar chave</td>
    <td>-</td>
    <td>
      Corredor: Escritório <br>
      Trás: Casa Mike <br>
      Frente: Centro
    </td>
  </tr>
  <tr>
    <td>Escritório</td>
    <td>Balas</td>
    <td>
      Usar chave <br>
      Pegar balas
    </td>
    <td>-</td>
    <td>Corredor: Delegacia</td>
  </tr>
  <tr>
    <td>Escola</td>
    <td>Desenho</td>
    <td>Analisar desenho</td>
    <td>Adolescentes</td>
    <td>Trás: Centro</td>
  </tr>
  <tr>
    <td>Ferro Velho</td>
    <td>Alicate</td>
    <td>Pegar alicate</td>
    <td>Crianças</td>
    <td>
      Direita: Centro <br>
      Esquerda: Trailer Jim 
    </td>
  </tr>
  <tr>
    <td>Casa Mike</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>
      Escada: Porão <br>
      Frente: Delegacia
    </td>
  </tr>
   <tr>
    <td>Porão</td>
    <td>-</td>
    <td>-</td>
    <td>Eleven</td>
    <td>Escada: Casa Mike</td>
  </tr>
   <tr>
    <td>Trailer Jim</td>
    <td>
      Revolver <br>
      Balas
    </td>
    <td>
      Pegar revolver <br>
      Pegar balas  
    </td>
    <td>-</td>
    <td>
      Direta: Ferro Velho <br>
      Esquerda: Floresta Sombria <br>
      Frente: Casa Byers  
    </td>
  </tr>
   <tr>
    <td>Floresta Sombria</td>
    <td>Bicicleta</td>
    <td>Analisar bicicleta</td>
    <td>-</td>
    <td>
      Direta: Trailer Jim <br>
      Frente: Castelo Byers  
    </td>
  </tr>
  <tr>
    <td>Casa Byers</td>
    <td>Pisca-Pisca</td>
    <td>Analisar Pisca-Pisca</td>
    <td>Joyce</td>
    <td>
      Trás: Trailer Jim <br>
      Esquerda: Castelo Byers  
    </td>
  </tr>
  <tr>
    <td>Castelo Byers</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>
      Trás: Floresta Sombria <br>
      Direita: Casa Byers <br>
      Frente: Floresta Sombria Fundo 
    </td>
  </tr>
  <tr>
    <td>Floresta Sombria (Fundo)</td>
    <td>-</td>
    <td>Usar alicate</td>
    <td>-</td>
    <td>
      Trás: Castelo Byers <br>
      Frente: Laboratório 
    </td>
  </tr>
  <tr>
    <td>Laboratório</td>
    <td>-</td>
    <td>-</td>
    <td>-</td>
    <td>
      Escada: Sala <br>
      Tras: Floresta
    </td>
  </tr>
  <tr>
    <td>Sala</td>
    <td>-</td>
    <td>Usar lanterna</td>
    <td>-</td>
    <td>
      Escada: Laboratório <br>
      Portal: Laboratório - Mundo Invertido  
    </td>
  </tr>
  <tr>
    <td>Laboratório - Mundo Invertido</td>
    <td>-</td>
    <td></td>
    <td>-</td>
    <td>
      Portal: Sala <br> 
      Frente: Floresta Sombria - Mundo Invertido 
    </td>
  </tr>
  <tr>
    <td>Floresta Sombria - Mundo Invertido</td>
    <td>-</td>
    <td></td>
    <td>Demogorgon</td>
    <td>
      Trás: Laboratório - Mundo Invertido  <br> 
      Frente: Castelo Byers - Mundo Invertido 
    </td>
  </tr>
  <tr>
    <td>Castelo Byers - Mundo Invertido</td>
    <td>-</td>
    <td></td>
    <td>Will Byers</td>
    <td>Trás: Laboratório - Mundo Invertido</td>
  </tr>
</table>

### Direções:

- Direita
- Esquerda
- Frente
- Trás
- Portal
- Corredor
- Escada

### Itens:

#### Coletáveis:

- Chave
- Arma
- Bala
- Lanterna
- Alicate

#### Não coletáveis (Pistas):

- Desenho
- Bicicleta Will
- Pisca-Pisca


### Funcionalidades:

- Limite de tempo ao jogo.
- Ambientes com mais saídas bloqueadas.
- Extra: Inimigos e forma de derrota-lo.

### Palavras de Comando:

- Ir
- Ajuda
- Sair
- Observar
- Pegar
- Largar
- Usar
- Analisar
- Atacar Inimigo

#### Ações:

- Pegar
  - Itens coletáveis
- Largar
  - Itens coletáveis
- Usar
  - Alicate
  - Chave
  - Lanterna
- Analisar
  - Desenho
  - Bicicleta
  - Pisca-Pisca
- Atacar Inimigo
  - Revolver + Bala

---

<h1 id="tecnologias" style="font-weight: 600; color: #A60D1A">
🛠️ Tecnologias
</h1>

<table border-collapse=collapse>
  <tr>
    <td><img alt="Java" height="30" widht="40" src="https://raw.githubusercontent.com/vorillaz/devicons/ba75593fdf8d66496676a90cbf127d721f73e961/!SVG/java.svg" /></td>
    <td><a href="https://docs.oracle.com/en/java/" target="_blank">Java 11</a></td>
  </tr>
  <tr>
    <td><img alt="VSCode" height="30" widht="40" src="https://cdn.icon-icons.com/icons2/2107/PNG/512/file_type_vscode_icon_130084.png" /></td>
    <td><a href="https://code.visualstudio.com/" target="_blank">VSCode</a></td>
  </tr>
  <tr>
    <td><img alt="Trello" height="30" widht="40" src="https://seeklogo.com/images/T/trello-logo-CE7B690E34-seeklogo.com.png" /></td>
    <td><a href="https://trello.com/" target="_blank">Trello</a></td>
  </tr>
</table>

<h1 id="autores" style="font-weight: 600; color: #A60D1A">
👥 Autores
</h1>

<table style="width: 100%;">
  <tr>
    <td style="padding: 16px;">
      <img width="100%" height="100%" style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/71350840?v=4">
    </td>
    <td style="padding: 16px;">
      <img width="100%" height="100%" style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/109180449?v=4">
    </td>
    <td style="padding: 16px;">
      <img width="100%" height="100%" style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/97248900?v=4">
    </td>
    <td style="padding: 16px;">
      <img width="100%" height="100%" style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/109627613?v=4">
    </td>
  </tr>
  <tr>
    <td style="text-align: center;">Ana Torres</td>
    <td style="text-align: center;">Ingrid Falchi</td>
    <td style="text-align: center;">Larissa Narciso</td>
    <td style="text-align: center;">Samuel Ferreira</td>
  </tr>
</table>

<h1 id="licenca" style="font-weight: 600; color: #A60D1A">
📜 Licença
</h1>

O projeto publicado em 2022 sobre a licença MIT.

[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8155518&assignment_repo_type=AssignmentRepo)
