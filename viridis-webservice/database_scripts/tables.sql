CREATE TABLE equipamento (
  id_equipamento SERIAL,
  nome_equipamento VARCHAR(50),
  num_serie VARCHAR(25) NOT NULL,
  descricao VARCHAR(100),
  CONSTRAINT equipamento_num_serie_key UNIQUE(num_serie),
  CONSTRAINT equipamento_pkey PRIMARY KEY(id_equipamento)
) 
WITH (oids = false);

CREATE TABLE servico (
  id_servico SERIAL,
  nome_servico VARCHAR(50) NOT NULL,
  CONSTRAINT table_pkey PRIMARY KEY(id_servico)
) 
WITH (oids = false);

CREATE TABLE manutencao (
  id_manutencao SERIAL,
  id_equipamento_fk INTEGER,
  id_servico_fk INTEGER,
  data_manutencao DATE NOT NULL,
  CONSTRAINT manutencao_pkey PRIMARY KEY(id_manutencao),
  CONSTRAINT manutencao_fk FOREIGN KEY (id_equipamento_fk)
    REFERENCES equipamento(id_equipamento)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
    NOT DEFERRABLE,
  CONSTRAINT manutencao_fk1 FOREIGN KEY (id_servico_fk)
    REFERENCES servico(id_servico)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
    NOT DEFERRABLE
) 
WITH (oids = false);