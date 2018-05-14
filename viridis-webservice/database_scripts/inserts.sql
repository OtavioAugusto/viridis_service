--
-- Data for table equipamento
--
INSERT INTO equipamento (id_equipamento, nome_equipamento, num_serie, descricao)
VALUES (3, 'MISTURADOR DE PÓ TIPO DUPLO CONE EM AÇO INOX 1500L', 'MTR001', 'Misturador e secador duplo cone em aço inox, capacidade total 1.500 litros, capacidade útil 1.200 litros, com camisa em aço carbono. Dimensional: Ø interno 1600 mm x 430 mm altura com cone superior e inferior com 530 mm altura.');

INSERT INTO equipamento (id_equipamento, nome_equipamento, num_serie, descricao)
VALUES (2, 'CENTRÍFUGA DECANTER EM AÇO INOX 3000L', 'CT001', 'Centrífuga Decanter para separação de líquido/sólido, em aço inox, capacidade 3.000/4.000 litros, marca SHARPLES e modelo P 3000.');

INSERT INTO equipamento (id_equipamento, nome_equipamento, num_serie, descricao)
VALUES (1, 'TANQUE MISTURADOR EM AÇO INOX 1600L', 'TNQ001', 'Tanque misturador em aço inox, capacidade de 1.600 litros, com sistema de agitação excêntrico com 02 jogos tipo disco, tampo reto e fundo semi cônico. Dimensional: Ø de 1.100 mm x 1.640 mm de altura.');

--
-- Data for table servico
--
INSERT INTO servico (id_servico, nome_servico)
VALUES (2, 'Manutencao Corretiva');

INSERT INTO servico (id_servico, nome_servico)
VALUES (1, 'Manutencao Preventiva');

--
-- Data for table manutencao
--
INSERT INTO manutencao (id_manutencao, id_equipamento_fk, id_servico_fk, data_manutencao)
VALUES (1, 1, 1, '2018-05-11');

INSERT INTO manutencao (id_manutencao, id_equipamento_fk, id_servico_fk, data_manutencao)
VALUES (2, 2, 2, '2018-05-12');

INSERT INTO manutencao (id_manutencao, id_equipamento_fk, id_servico_fk, data_manutencao)
VALUES (3, 1, 1, '2018-05-29');