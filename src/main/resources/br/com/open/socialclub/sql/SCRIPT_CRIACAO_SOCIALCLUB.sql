CREATE TABLE estado(
    sigla       VARCHAR(2)   CONSTRAINT estado_sigla_nn NOT NULL,
    nome        VARCHAR(100) CONSTRAINT estado_nome_nn NOT NULL,
    populacao   FLOAT,
    pais        VARCHAR(100) CONSTRAINT estado_pais_nn NOT NULL,
    sigla_pais  VARCHAR(5)   CONSTRAINT estado_sigla_pais_nn NOT NULL,
	
    CONSTRAINT estado_sigla_pk PRIMARY KEY (sigla)
);

CREATE TABLE cidade(
    codigo        SERIAL       CONSTRAINT cidade_codigo_nn NOT NULL,
    nome          VARCHAR(100) CONSTRAINT cidade_nome_nn NOT NULL,
    cep           VARCHAR(20),
    sigla_estado  VARCHAR(2)   CONSTRAINT cidade_sigla_estado_ NOT NULL,
    codigo_ibge   INTEGER,
	
    CONSTRAINT cidade_codigo_pk PRIMARY KEY (codigo),
    CONSTRAINT cidade_sigla_estado_fk FOREIGN KEY (sigla_estado) REFERENCES estado (sigla)
);

CREATE TABLE tipo_socio(
    codigo      SERIAL       CONSTRAINT tipo_socio_nn NOT NULL,
    descricao   VARCHAR(100) CONSTRAINT tipo_socio_nn NOT NULL,

    CONSTRAINT tipo_socio_codigo_pk PRIMARY KEY (codigo)
);

CREATE TABLE categoria_socio(
    codigo      SERIAL       CONSTRAINT categoria_socio_nn NOT NULL,
    descricao   VARCHAR(100) CONSTRAINT categoria_socio_nn NOT NULL,

    CONSTRAINT categoria_socio_codigo_pk PRIMARY KEY (codigo)
);

CREATE TABLE socio(
    codigo                 SERIAL       CONSTRAINT socio_codigo_nn NOT NULL,
    nome                   VARCHAR(100) CONSTRAINT socio_nome_nn NOT NULL,
    apelido                VARCHAR(100),
    data_nascimento        DATE,
    nome_pai               VARCHAR(100),
    nome_mae               VARCHAR(100),
    sexo                   VARCHAR(2),
    rg                     VARCHAR(25),
    orgao                  VARCHAR(25),
    data_emissao           DATE,
    crt                    VARCHAR(25),
    nome_fantasia          VARCHAR(100),
    inscricao_estadual     VARCHAR(100),
    cpf_cnpj               VARCHAR(25),
    logradouro             VARCHAR(100)  CONSTRAINT socio_logradouro_nn NOT NULL,
    numero                 VARCHAR(25)   CONSTRAINT socio_numero_nn NOT NULL,
    complemento            VARCHAR(100)  CONSTRAINT socio_complemento_nn NOT NULL, 
    bairro                 VARCHAR(100)  CONSTRAINT socio_bairro_nn NOT NULL, 
    ponto_referencia       VARCHAR(100)  CONSTRAINT socio_ponto_referencia_nn NOT NULL,
    cep                    VARCHAR(25)   CONSTRAINT socio_cep_nn NOT NULL,
    codigo_tipo_socio      INTEGER       CONSTRAINT socio_codigo_tipo_socio_nn NOT NULL,
    codigo_categoria_socio INTEGER       CONSTRAINT socio_codigo_categoria_socio_nn NOT NULL,
    email                  VARCHAR(100),
    inativo                BOOLEAN,
    cadastrado_por         VARCHAR(100)  CONSTRAINT socio_cadastrado_por_nn NOT NULL,
    data_cadastro          DATE          CONSTRAINT socio_data_cadastro_nn NOT NULL,
    modificado_por         VARCHAR(100)  CONSTRAINT socio_modificado_por_nn NOT NULL,
    data_modificado        DATE          CONSTRAINT socio_data_modificacao_nn NOT NULL,

    CONSTRAINT socio_codigo_pk PRIMARY KEY (codigo),
    CONSTRAINT socio_codigo_tipo_socio_fk FOREIGN KEY (codigo_tipo_socio) REFERENCES tipo_socio (codigo),
    CONSTRAINT socio_codigo_categoria_socio_fk FOREIGN KEY (codigo_categoria_socio) REFERENCES categoria_socio (codigo)
);

CREATE TABLE tipo_telefone(
    codigo      SERIAL       CONSTRAINT tipo_telefone_nn NOT NULL,
    descricao   VARCHAR(100) CONSTRAINT tipo_telefone_nn NOT NULL,

    CONSTRAINT tipo_telefone_codigo_pk PRIMARY KEY (codigo)
);

CREATE TABLE telefone_socio(
    numero               VARCHAR(25)  CONSTRAINT telefone_socio_numero_nn NOT NULL,
    contato              VARCHAR(100) CONSTRAINT telefone_socio_contato_nn NOT NULL,
    codigo_socio         INTEGER CONSTRAINT telefone_socio_codigo_socio_nn NOT NULL,
    codigo_tipo_telefone INTEGER CONSTRAINT telefone_socio_codigo_tipo_socio_nn NOT NULL,
    
    CONSTRAINT telefone_socio_codigo_socio_fk FOREIGN KEY (codigo_socio) REFERENCES socio (codigo),
    CONSTRAINT telefone_socio_codigo_tipo_telefone_fk FOREIGN KEY (codigo_tipo_telefone) REFERENCES tipo_telefone (codigo)
);

CREATE TABLE perfil(
    codigo     SERIAL       CONSTRAINT perfil_codigo_nn NOT NULL,
    descricao  VARCHAR(60)  CONSTRAINT perfil_descricao_nn NOT NULL,
    nivel      INTEGER      CONSTRAINT perfil_nivel_nn NOT NULL,
    role       VARCHAR(25)  CONSTRAINT perfil_role_nn NOT NULL,

    CONSTRAINT perfil_codigo_pk PRIMARY KEY (codigo)
);

CREATE TABLE usuario(
    codigo         SERIAL       CONSTRAINT usuario_codigo_nn NOT NULL,
    login          VARCHAR(60)  CONSTRAINT usuario_login_nn NOT NULL,
    senha          VARCHAR(60)  CONSTRAINT usuario_senha_nn NOT NULL,
    email          VARCHAR(60),

    CONSTRAINT usuario_codigo_pk PRIMARY KEY (codigo)
);

CREATE TABLE permissoes (
    codigo          SERIAL CONSTRAINT permissoes_codigo_nn NOT NULL,
    codigo_usuario  INTEGER CONSTRAINT permissoes_codigo_usuario_nn NOT NULL,
    codigo_perfil   INTEGER CONSTRAINT permissoes_codigo_perfil_nn NOT NULL,

    CONSTRAINT permissoes_codigo_pk PRIMARY KEY (codigo),
    CONSTRAINT permissoes_codigo_perfil_fk FOREIGN KEY (codigo_perfil) REFERENCES perfil (codigo),
    CONSTRAINT permissoes_codigo_usuario_fk FOREIGN KEY (codigo_usuario) REFERENCES usuario (codigo)
);