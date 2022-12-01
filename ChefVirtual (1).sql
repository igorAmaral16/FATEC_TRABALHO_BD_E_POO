CREATE DATABASE chefvirtual
GO
USE chefvirtual
GO
CREATE TABLE usuariochef(
cpfChef			  BIGINT							 NOT NULL,
nome			  VARCHAR(45)					 NOT NULL,
sobrenome		  VARCHAR(45)				     NOT NULL,
dataNasc		  VARCHAR(12)					 NOT NULL,
senha			  VARCHAR(12)                    NOT NULL		 DEFAULT('123456'),
email             VARCHAR(45)                    NOT NULL,
certificado		  VARCHAR(45)		             NOT NULL,
PRIMARY KEY(cpfChef)
)
SELECT * from usuariochef
DROP TABLE USUARIOCHEF
GO
CREATE TABLE usuariocomum(
apelido			  VARCHAR(20)					 NOT NULL,
nome			  VARCHAR(45)					 NOT NULL,
sobrenome		  VARCHAR(45)				     NOT NULL,
dataNasc		  VARCHAR(10)					 NOT NULL,		
senha			  VARCHAR(12)                    NOT NULL		 DEFAULT('123456'),
email             VARCHAR(45)                    NOT NULL,
PRIMARY KEY(apelido),
)

drop table usuariocomum

select * from usuariocomum
GO
CREATE TABLE usuariorestaurante(
cnpj			  CHAR(14)CHECK(LEN(cnpj) = 14)					NOT NULL         UNIQUE,
nome			  VARCHAR(45)									NOT NULL,
senha			  VARCHAR(12)									NOT NULL		 DEFAULT('123456'),
email             VARCHAR(45)							        NOT NULL,
PRIMARY KEY(cnpj)
)
GO
CREATE TABLE funcionario (
cpfFunc			  CHAR(11)CHECK(LEN(cpfFunc) = 11)			NOT NULL         UNIQUE,
nome			  VARCHAR(45)								NOT NULL,
sobrenome		  VARCHAR(45)								NOT NULL,
email			  VARCHAR(45)								NOT NULL,
senha			  VARCHAR(12)								NOT NULL,
PRIMARY KEY(cpfFunc),
)
GO
CREATE TABLE ingrediente(
nomeIngrediente		VARCHAR(45)									NOT NULL         UNIQUE,
descricao		    VARCHAR(244)								NOT NULL,
PRIMARY KEY (nomeIngrediente)
)
GO
CREATE TABLE receita_func(
idReceitaFunc			  INT												NOT NULL,
idFunc					  CHAR(11)											NOT NULL,
idRec					  INT												NOT NULL,
PRIMARY KEY(idReceitaFunc),
FOREIGN KEY(idFunc) REFERENCES funcionario (cpfFunc),
FOREIGN KEY(idRec) REFERENCES receita (idReceita)
)
GO
CREATE TABLE receita_chef(
idReceitaChef			  INT												NOT NULL,
idChef					  CHAR(11)											NOT NULL,
idRec					  INT												NOT NULL,
PRIMARY KEY(idReceitaChef),
FOREIGN KEY(idChef) REFERENCES usuariochef (cpfChef),
FOREIGN KEY(idRec) REFERENCES receita (idReceita)
)
DROP TABLE RECEITA_CHEF
GO
CREATE TABLE receita_rest(
idReceitaRest			  INT												NOT NULL,
idRest					  CHAR(14)											NOT NULL,
idRec					  INT												NOT NULL,
PRIMARY KEY(idReceitaRest),
FOREIGN KEY(idRest) REFERENCES usuariorestaurante (cnpj),
FOREIGN KEY(idRec) REFERENCES receita (idReceita)
)
GO
CREATE TABLE receita(
idReceita                 INT												NOT NULL             IDENTITY(1,1),
nomeIngredient			  VARCHAR(45)									    NOT NULL             UNIQUE,
nomeReceita			      VARCHAR(45)									    NOT NULL,            
descricao		          VARCHAR(244)									    NOT NULL,
PRIMARY KEY (idReceita),
FOREIGN KEY(nomeIngredient) REFERENCES ingrediente (nomeIngrediente)
)
GO
CREATE TABLE faqfunc(
idDuvida	    INT														    NOT NULL             IDENTITY(1,1),
nomeDuvida      VARCHAR(45)													NOT NULL,
descricaoDuvida VARCHAR(244)												NOT NULL,
respostaDuvida  VARCHAR(244)												NOT NULL,
PRIMARY KEY (idDuvida)
)
GO
CREATE TABLE faqusuario(
idDuvidaUsuario        INT												NOT NULL             IDENTITY(1,1),
nomeDuvidaUsuario      VARCHAR(45)										NOT NULL,
descricaoDuvidaUsuario VARCHAR(244)										NOT NULL,
respostaDuvida		   VARCHAR(244)										NOT NULL,
PRIMARY KEY (idDuvidaUsuario)
)
GO
select * from receita
