CREATE DATABASE sistemadb;

USE sistemadb;

CREATE TABLE usuarios(
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(30) DEFAULT NULL,
  sobrenome varchar(30) DEFAULT NULL,
  username varchar(30) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  password varchar(30) DEFAULT NULL,
  UNIQUE KEY unique_username (username),
  UNIQUE KEY unique_email (email),
  PRIMARY KEY (id)
);


CREATE TABLE tarefas(
  id int NOT NULL AUTO_INCREMENT,
  descricao varchar(50) DEFAULT NULL,
  momento date NOT NULL,
  usuario_id int DEFAULT NULL,
  status enum('pendente','concluido') NOT NULL,
  PRIMARY KEY (id),
  KEY usuario_id (usuario_id),
  CONSTRAINT tarefas_ibfk_1 FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
);