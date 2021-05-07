/* 
Script para criação do banco de dados do Sistema Komada Eletronica 
Versão 0.1

Comando para exclusão caso necessario.
drop database komandaeletronica;
*/

/* Criação da base de dados
######################################## */
create database IF NOT EXISTS komandaeletronica;

/* Selecionando a database para criar as tabelas
######################################## */
use komandaeletronica;

/* Criação da tabela Pessoa
######################################## */
create table pessoa (IdPessoa int NOT NULL AUTO_INCREMENT , 
cpf varchar(11) NOT NULL, 
nome varchar(100) NOT NULL,
endereco varchar(100), 
telefone varchar (20),
email varchar (50), 
IsExcluido bool, 
primary key (IdPessoa));

/* Criação da tabela LoginUsuario
######################################## */
create table LoginUsuario (IdLoginUsuario int NOT NULL AUTO_INCREMENT , 
IdPessoa int, 
senha varchar (20),
isBloqueado bool,
primary key (IdLoginUsuario),
foreign key (IdPessoa) references pessoa (IdPessoa));

/* Criação da tabela Tipo de Funcao
######################################## */
create table TiposDeFuncao (IdFuncao int NOT NULL AUTO_INCREMENT , 
NomeFuncao varchar (100),
primary key (IdFuncao));

/* Criação da tabela Funcionario
######################################## */
create table Funcionario (IdFuncionario int NOT NULL AUTO_INCREMENT , 
IdPessoa int, 
NumeroRegistro int (11) NOT NULL,
IdFuncao int, 
IsGerente bool,
IsExcluido bool,
primary key (IdFuncionario),
foreign key (IdPessoa) references pessoa (IdPessoa),
foreign key (IdFuncao) references TiposDeFuncao (IdFuncao));

/* Criação da tabela Login Funcionario
######################################## */
create table LoginFuncionario (IdLoginFuncionario int NOT NULL AUTO_INCREMENT , 
IdFuncionario int,
senha varchar(20),
NivelDeAcesso int(2),
IsBloqueado bool,
primary key (IdLoginFuncionario),
foreign key (IdFuncionario) references Funcionario (IdFuncionario));

/* Criação da tabela Tipo de Produto
######################################## */
create table TipoDeProduto (Id int NOT NULL AUTO_INCREMENT , 
Nome varchar (20),
primary key (Id));

/* Criação da tabela Produtos do Cardapio
Tabela Cardapio para pratos 
######################################## */
create table ProdutoCardapio (IdProdutoCardapio int NOT NULL AUTO_INCREMENT , 
Nome varchar (50) NOT NULL,
Peso decimal,
Descricao varchar(200),
Valor decimal, 
InformacaoesNutricionais varchar(200),
QuantidadeDePessoasQueServe int(11), 
IsExcluido bool,
primary key (IdProdutoCardapio));

/* Criação da tabela Pedito
######################################## */
create table Pedido (IdPedido int NOT NULL AUTO_INCREMENT , 
primary key (IdPedido));

/* Criação da tabela Produtos Cardapio Pedito
######################################## */
create table ProdutoCardapioPedido (
IdProdutoCardapio int, 
IdPedido int,
primary key (IdProdutoCardapio,IdPedido),
foreign key (IdProdutoCardapio) references ProdutoCardapio (IdProdutoCardapio),
foreign key (IdPedido) references Pedido(IdPedido));

/* Criação da tabela Tipo de Produto Estoque
######################################## */
create table ProdutoEstoque (IdProdutoEstoque int NOT NULL AUTO_INCREMENT, 
Nome varchar (20),
Peso decimal,
Descricao varchar (20),
InformacoesAdicionais varchar (50),
IsExcluido bool,
primary key (IdProdutoEstoque));

/* Criação da tabela Estoque
######################################## */
create table Estoque (IdEstoque int NOT NULL AUTO_INCREMENT , 
IdProdutoEstoque int,
Quantidade int(11),
primary key (IdEstoque),
foreign key (IdProdutoEstoque) references ProdutoEstoque(IdProdutoEstoque));

/* Criação da tabela Mesa
######################################## */
create table Mesa (IdMesa int NOT NULL AUTO_INCREMENT , 
Nome varchar(20) NOT NULL,
primary key (IdMesa));

/* Criação da tabela Mesa Pedito
######################################## */
create table MesaPedido (IdMesaPedido int NOT NULL AUTO_INCREMENT , 
IdMesa int,
ValorTotal decimal,
Data date,
primary key (IdMesaPedido),
foreign key (IdMesa) references Mesa(IdMesa));

/* Criação da tabela Pedito Mesa Pedito
######################################## */
create table PedidoMesaPedido (
IdPedido int,
IdMesaPedido int,
primary key (IdPedido, IdMesaPedido),
foreign key (IdPedido) references Pedido(IdPedido),
foreign key (IdMesaPedido) references MesaPedido (IdMesaPedido));

/* Criação da tabela Cozinha
######################################## */
create table Cozinha (IdPedidoCozinha int NOT NULL AUTO_INCREMENT , 
IdPedido int,
idMesa int,
Status varchar(10) NOT NULL,
primary key (IdPedidoCozinha),
foreign key (IdPedido) references Pedido(IdPedido),
foreign key (IdMesa) references Mesa(IdMesa));

/* Criação da tabela Delivery
######################################## */
create table Delivery (IdDelivery int NOT NULL AUTO_INCREMENT , 
IdPessoa int,
IdCozinha int,
ValorTotal decimal,
Data date,
primary key (IdDelivery),
foreign key (IdPessoa) references pessoa (IdPessoa),
foreign key (IdCozinha) references Cozinha(IdPedidoCozinha));

/* Inserção de Coluna na tabela loginFuncionario
######################################## */
ALTER TABLE `komandaeletronica`.`loginfuncionario` 
ADD COLUMN `primeiroAcesso` TINYINT(1) NULL AFTER `IsBloqueado`;

/* Inserção de Coluna na tabela loginUsuario
######################################## */
ALTER TABLE `komandaeletronica`.`loginusuario` 
ADD COLUMN `primeiroAcesso` TINYINT(1) NULL AFTER `isBloqueado`;

/* Inserção de Coluna na tabela Funcionario
######################################## */
ALTER TABLE `komandaeletronica`.`funcionario` 
ADD COLUMN `NivelDeAcesso` INT(3) NULL AFTER `IsExcluido`;

/* Inserção de Colunas na tabela produtocardapiopedido
######################################## */
ALTER TABLE `komandaeletronica`.`produtocardapiopedido` 
ADD COLUMN `Quantidade` INT(5) NULL AFTER `IdPedido`,
ADD COLUMN `Status` INT(5) NULL AFTER `Quantidade`;