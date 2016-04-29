DROP DATABASE ConstruFacil;
CREATE DATABASE ConstruFacil;

USE ConstruFacil;

INSERT INTO `Pessoa` (`id`,`Complemento`,`bairro`,`celular`,`cep`,`cidade`,`cpf`,`dataNascimento`,`email`,`logadouro`,`nome`,`nomeRecado`,`numero`,`senha`,`sobrenome`,`telRecado`,`telefone`,`uf`) VALUES (2,'CASA A ','PARQUE DAS FLORES','87687678678','98098980','MAUA','11111111111','1965-09-13','MARIA@MARIA.COM','RUA EGITO','MARIA','MARCOS','49','202cb962ac59075b964b07152d234b70','NUNES','8798787987','7687678678','AC');
INSERT INTO `Pessoa` (`id`,`Complemento`,`bairro`,`celular`,`cep`,`cidade`,`cpf`,`dataNascimento`,`email`,`logadouro`,`nome`,`nomeRecado`,`numero`,`senha`,`sobrenome`,`telRecado`,`telefone`,`uf`) VALUES (17,'ZAIRA','MAUA','68768767868','87987987','SANTO ANDRE','22222222222','2010-02-19','PAULO@PAULO.COM','RUA SEM SAIDA','PAULO','MARCOS','88','202cb962ac59075b964b07152d234b70','RODRIGUES','7687687676','7687687676','AM');
INSERT INTO `Pessoa` (`id`,`Complemento`,`bairro`,`celular`,`cep`,`cidade`,`cpf`,`dataNascimento`,`email`,`logadouro`,`nome`,`nomeRecado`,`numero`,`senha`,`sobrenome`,`telRecado`,`telefone`,`uf`) VALUES (18,'ZAIRA','MAUA','68768767868','87987987','SANTO ANDRE','33333333333','2010-02-19','MARCOS@MARCOS.COM','RUA SEM SAIDA','MARCOS','MARCOS','88','202cb962ac59075b964b07152d234b70','CRISTINO','7687687676','7687687676','AM');


INSERT INTO `Administrador` (`ativo`,`nivel`,`pessoa_id`) VALUES ('1',1,2);
INSERT INTO `Profissional` (`ativo`,`pessoa_id`) VALUES ('1',18);
INSERT INTO `Profissional` (`ativo`,`pessoa_id`) VALUES ('1',17);

INSERT INTO `Categoria` (`id`,`area`,`descricao`) VALUES (3,'CC','CATEGORIA 1');
INSERT INTO `Categoria` (`id`,`area`,`descricao`) VALUES (4,'PI','CATEGORIA 2');
INSERT INTO `Categoria` (`id`,`area`,`descricao`) VALUES (5,'EL','CATEGORIA 3');
INSERT INTO `Categoria` (`id`,`area`,`descricao`) VALUES (6,'HI','CATEGORIA 4');

INSERT INTO `Profissao` (`id`,`area`,`nome`) VALUES (10,0,'PROFISSAO 1');
INSERT INTO `Profissao` (`id`,`area`,`nome`) VALUES (11,1,'PROFISSAO 2');
INSERT INTO `Profissao` (`id`,`area`,`nome`) VALUES (12,2,'PROFISSAO 3');
INSERT INTO `Profissao` (`id`,`area`,`nome`) VALUES (13,3,'PROFISSAO 4');
INSERT INTO `Profissao` (`id`,`area`,`nome`) VALUES (14,4,'PROFISSAO 5');

INSERT INTO `Servico` (`id`,`dataPrecoMedio`,`dataPrecoSinap`,`descricao`,`precoMedio`,`precoSinap`,`categoria_id`) VALUES (7,NULL,'2010-10-09','SERVIÇO 1',NULL,10.00,3);
INSERT INTO `Servico` (`id`,`dataPrecoMedio`,`dataPrecoSinap`,`descricao`,`precoMedio`,`precoSinap`,`categoria_id`) VALUES (8,NULL,'2012-10-09','SERVIÇO 2',NULL,10.00,4);
INSERT INTO `Servico` (`id`,`dataPrecoMedio`,`dataPrecoSinap`,`descricao`,`precoMedio`,`precoSinap`,`categoria_id`) VALUES (9,NULL,'2011-10-09','SERVIÇO 3',NULL,100.00,5);
