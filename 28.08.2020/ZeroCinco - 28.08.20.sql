CREATE TABLE `usuario` (
	`id_usuario` INT NOT NULL AUTO_INCREMENT,
	`email` varchar(100) NOT NULL UNIQUE,
	`nome_completo` varchar(70) NOT NULL,
	`senha` varchar(8) NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `postagem` (
	`id_postagem` INT NOT NULL AUTO_INCREMENT UNIQUE,
	`data` DATE NOT NULL,
	`privacidade` BOOLEAN NOT NULL,
	`descricao` TEXT(300) NOT NULL,
	`midia` blob NOT NULL,
	`fk_tema` INT(255) NOT NULL,
	`fk_usuario` INT NOT NULL,
	PRIMARY KEY (`id_postagem`)
);

CREATE TABLE `tema` (
	`id_tema` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(70) NOT NULL UNIQUE,
	`tipo` varchar(100) NOT NULL UNIQUE,
	`disponibilidade` BOOLEAN NOT NULL,
	PRIMARY KEY (`id_tema`)
);

ALTER TABLE `postagem` ADD CONSTRAINT `postagem_fk0` FOREIGN KEY (`fk_tema`) REFERENCES `tema`(`id_tema`);

ALTER TABLE `postagem` ADD CONSTRAINT `postagem_fk1` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario`(`id_usuario`);

