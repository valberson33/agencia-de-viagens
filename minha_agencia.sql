-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Clientes (
CPF CHAR(11),
id_Cliente VARCHAR(20) PRIMARY KEY,
Endereco VARCHAR(30),
Nome VARCHAR(40),
id_compra VARCHAR(10),
id_login VARCHAR(10)
)

CREATE TABLE Promocao (
id_promoçoes VARCHAR(10) PRIMARY KEY,
ida_volta VARCHAR(30),
so_ida VARCHAR(30)
)

CREATE TABLE Login_Agencia (
id_login VARCHAR(10) PRIMARY KEY,
comum VARCHAR(50),
administrativo VARCHAR(50)
)

CREATE TABLE Destino (
id_Destino VARCHAR(10) PRIMARY KEY,
Estado VARCHAR(30),
Cidades VARCHAR(30)
)

CREATE TABLE Compra (
cartao CHAR(20),
boleto CHAR(40),
id_compra VARCHAR(10) PRIMARY KEY,
avista VARCHAR(20),
id_Destino VARCHAR(10),
FOREIGN KEY(id_Destino) REFERENCES Destino (id_Destino)
)

CREATE TABLE tem (
id_promoçoes VARCHAR(10),
id_Destino VARCHAR(10),
FOREIGN KEY(id_promoçoes) REFERENCES Promocao (id_promoçoes),
FOREIGN KEY(id_Destino) REFERENCES Destino (id_Destino)
)

ALTER TABLE Clientes ADD FOREIGN KEY(id_compra) REFERENCES Compra (id_compra)
ALTER TABLE Clientes ADD FOREIGN KEY(id_login) REFERENCES Login_Agencia (id_login)
