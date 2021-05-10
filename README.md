
 ### SISTEMA DE KOMANDA ELETRÔNICA ###  
 
**Sistema de Komanda Eletrônica,fará a gestão de bares, restaurantes e lanchonetes auxiliando em pedidos
e gerenciamento de contas a pagar de clientes.**
 
*****

 **Integrantes** :trophy:
* Danilo Liparini Moraes RA:201924410096 :rocket:
* Luciano Luiz Romero RA:201924410106 :rocket:
* Mateus Botelho Ribeiro RA:201924410271 :rocket:
******
<h2 align="center"> Projeto Interdisciplinar - IF</h2> 

## **Artefatos :** <h3>
 
● [Documento de Requisitos](https://github.com/Projeto-Interdisicplinar-ifsuldeminas/komanda-eletronica/blob/develop/Artefatos/Documento_de_Requisitos_-_Komanda_Eletr%C3%B4nica_Final.pdf)

● [Diagrama de Caso de uso](https://github.com/Projeto-Interdisicplinar-ifsuldeminas/komanda-eletronica/blob/develop/Artefatos/Diagrama_de_Casos_de_Uso_Final.pdf)

● [Diagrama de classe](https://github.com/Projeto-Interdisicplinar-ifsuldeminas/komanda-eletronica/blob/develop/Artefatos/Diagrama%20de%20Classes_Final.pdf)

● [Modelo Entidade Relacionamento](https://github.com/Projeto-Interdisicplinar-ifsuldeminas/komanda-eletronica/blob/develop/Artefatos/MER_Final.pdf)

****** 
## **Escopo do projeto:** <h3>

● O sistema tem como objetivo auxiliar na gestão e controle de bares, restaurantes e
lanchonetes..

****** 
## Tech: 
● [Script Criação banco de dados](https://github.com/Projeto-Interdisicplinar-ifsuldeminas/komanda-eletronica/blob/develop/ScriptBancodeDados/bancodedados.sql)

### Construído com 

* [Maven](https://maven.apache.org/)

<h3> Rodar, buildar e/ou testar o projeto:</h3>

```
Necessario ter o Java versão 11, instalado. 
Necessario ter o MySQL instalado. 
Rodar o script SQL para criação do banco de dados do sistema.
Realizar a configuração do banco de dados, informando o nome de usuario e senha. 
Executar a aplicação via IDE ou jar.  
```
## Dependência necessárias para o projeto:

* [org.apache.commons]
* [mysql]
* [com.jgoodies]
* [com.miglayout]





****** 
## **Requisitos Funcionais** <h3>
● RF. 1: Cadastro de Funcionário
Descrição: Somente o gerente pode cadastrar um funcionário no sistema.
Entrada: Nome, função, setor, nível de acesso, senha.
Processo: O cadastro será incluído no Banco de Dados.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.
  
● RF. 2: Modificação de Cadastro de Funcionário
Descrição: Somente o gerente pode modificar o cadastro de um funcionário no
sistema.
Entrada: Campo desejado e o novo dado
Processo: Atualização do Banco de Dados.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

● RF. 3: Exclusão de Cadastro de Funcionário
Descrição: Somente o gerente pode excluir o cadastro de um funcionário no
sistema.
Entrada: Nome de usuário
Processo: O sistema verifica se o usuário é cadastrado e se for, o usuário é
excluído.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

● RF. 4: Cadastro de Produto (Pratos do cardápio)
Descrição: Somente o gerente pode cadastrar um produto no sistema.
Entrada: Nome, Descrição, Informações Nutricionais, tamanho (individual, 2
pessoas, 4 pessoas), valor.
Processo: O cadastro será incluído no Banco de Dados.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

● RF. 5: Modificação de Cadastro de Produtos
Descrição: Somente o gerente pode modificar o cadastro de um produto no
sistema.
Entrada: Campo desejado e o novo dado
Processo: Atualização do Banco de Dados.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

● RF. 6: Exclusão de Cadastro de Produto
Descrição: Somente o gerente pode excluir o cadastro de um produto no sistema.
Entrada: Nome do prato
Processo: O sistema verifica se o produto é cadastrado e se for, o produto é
excluído.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

● RF. 7: Cadastro de Mesas
Descrição: Somente o gerente pode cadastrar um produto no sistema.
Entrada: Nome, Descrição.
Processo: O cadastro será incluído no Banco de Dados.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

● RF. 8: Modificação do Cadastro de Mesas
Descrição: Somente o gerente pode modificar um produto no sistema.
Entrada: Campo desejado e o novo dado
Processo: Atualização do Banco de Dados.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

● RF. 9: Exclusão de Cadastro de Mesas
Descrição: Somente o gerente pode excluir o cadastro de uma mesa no sistema.
Entrada: Nome do prato
Processo: O sistema verifica se a mesa é cadastrada e se for, a mesa é excluída.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

● RF. 10: Cadastro de Pedido
Descrição: Qualquer funcionário pode cadastrar um pedido no sistema.
Entrada: Mesa, Produto, Quantidade, Observação.
Processo: O cadastro será incluído no Banco de Dados.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

● RF. 11: Modificação de um Pedido
Descrição: Qualquer funcionário pode modificar um produto no sistema.
Entrada: Campo desejado e o novo dado
Processo: Atualização do Banco de Dados desde que o pedido não tenha sido
fechado e enviado à cozinha para preparação.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

● RF. 12: Exclusão de Pedido
Descrição: Somente o gerente pode excluir o cadastro de um pedido no sistema.
Entrada: Pedido.
Processo: O sistema verifica se o pedido é cadastrado e se for, o pedido é
excluído, desde que não tenha sido enviado à cozinha para preparação.
Saída: Mensagem de confirmação bem sucedido do cadastro caso tenha sido
efetuado com sucesso, senão, mensagem de erro.

******

<h2 align="center" > DESAFIO FINAL - ENTREGAS ADICIONAIS </h2>

<p align="justify"> A equipe utilizou a ferramenta Trello(trello.com) para auxiliar no Scrum permitindo uma melhor organização.
Após a análise dos requisitos, foram listadas todas as atividades necessárias definindo assim nosso Product Backlog. Para o desenvolvimento das atividades, dividimos em dois Sprints(ciclos) com prazos definidos (cada um equivalente a uma semana) com as tarefas que cada membro da equipe deveria realizar. As atividades para cada Sprint foram definidas através de um Sprint Planning. Durante cada dia era disseminado os conhecimentos identificando os impedimentos e priorizando o trabalho do dia que se inicia.
A equipe foi definida através de maior proximidade e afinidade entre os membros do projeto.
A dificuldade encontrada foi a falta de experiência no trabalho em equipe no ambiente tecnológico.
O projeto nos mostrou a importância do trabalho em equipe onde os diferentes conhecimentos e experiências sendo compartilhados se complementam afim de atingir o objeto em comum.</p>






