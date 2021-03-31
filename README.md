# Tempera Simulada Para o Problema das n-Rainhas

Este é o projeto final da disciplina de Inteligência Artificial 2020.2

[Link para o artigo original](https://siaiap32.univali.br/seer/index.php/acotb/article/view/6357)

O projeto consiste em selecionar um artigo que trabalhe com algum conceito da área e tentar implementá-lo utilizando a mesma linguagem e os mesmos métodos descritos.


## Manual para instalação e execução do programa - Windows

### Pré-requisitos

[Faça o download do Eclipse IDE](https://www.eclipse.org/downloads/). Ao executar o instalador, escolha a opção "Eclipse IDE for Java Developers".

### Executar o Programa

1. Ao executar o programa Eclipse pela primeira vez, clique em “create a Java Project” 
2. Nomeie o projeto para escolher a versão Java. Para a execução do programa foi utilizada a versão 1.8. Após isso, clique em “finish”
3. Ao abrir o novo projeto criado, clique com o botão direito do mouse na pasta “src” e selecione:
   ```
   New > Package
   ```
4. Nomeie-o como "temperaSimulada" e clique em “Finish”
5. Após fazer o download dos arquivos, copie-os para dentro do pacote, no seguinte diretório:
   ```
   C:\Users\seu-usuario\eclipse-workspace\nome-do-projeto\src\temperaSimulada
   ```
6. Atualize o eclipse clicando com o botão direito sobre o pacote e clique em “refresh”
7. Os arquivos deverão ser exibidos após isso. Exiba cada uma das classes e execute-as, tendo a classe “Main” como principal
8. Na linha 7 podem ser definidos os parâmetros a ser executados no programa:
   ```java
    Busca search = new Busca ( x, y , (float) z )
   ```
   Em que:

  * x = Quantidade de rainhas / dimensões do tabuleiro
  * y = Quantidade máxima de interações para cada valor de temperatura
  * z = Taxa de decaimento de temperatura


## Autores

Ana Carolina Silva Abreu - anacarolinaks19@gmail.com

Anderson Alves Bezerra - anderson.alves.bezerra07@aluno.ifce.edu.br

Victor de Moraes Correia - victor.moraes.correia07@aluno.ifce.edu.br