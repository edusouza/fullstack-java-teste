DROP TABLE IF EXISTS empresa;
DROP TABLE IF EXISTS empresa_anexo;
DROP TABLE IF EXISTS nota_fiscal;

CREATE TABLE empresa(
	id integer,
	razao_social varchar(255),
	cnpj varchar(14),
	email varchar(255),
);

CREATE TABLE empresa_anexo(
	id_empresa integer,
	anexo integer
);

CREATE TABLE nota_fiscal(
	id integer,
	numero integer,
	data_emissao date,
	descricao text,
	valor float,
	anexo integer
);