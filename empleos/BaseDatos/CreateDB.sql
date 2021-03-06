

CREATE SEQUENCE CATEGORIAS_SEQ START WITH 1 INCREMENT BY 1;
CREATE TABLE CATEGORIAS
(
    CATEGORIA_ID NUMERIC   NOT NULL DEFAULT nextval('CATEGORIAS_SEQ')
	,NOMBRE           VARCHAR(255)  NOT NULL 
	,DESCRIPCION      VARCHAR(1024) NOT NULL 
);
ALTER TABLE CATEGORIAS ADD CONSTRAINT CATEGORIAS_UNK UNIQUE (NOMBRE);
ALTER TABLE CATEGORIAS ADD CONSTRAINT CATEGORIAS_ID_UNK UNIQUE (CATEGORIA_ID);


CREATE SEQUENCE PERFILES_SEQ START WITH 1 INCREMENT BY 1;
CREATE TABLE PERFILES
(
    PERFIL_ID NUMERIC   NOT NULL DEFAULT nextval('PERFILES_SEQ')
	,NOMBRE           VARCHAR(255)  NOT NULL 
	,DESCRIPCION      VARCHAR(1024) NOT NULL 
);
ALTER TABLE PERFILES ADD CONSTRAINT PERFILES_UNK UNIQUE (NOMBRE);
ALTER TABLE PERFILES ADD CONSTRAINT PERFILES_ID_UNK UNIQUE (PERFIL_ID);


CREATE SEQUENCE VACANTES_SEQ START WITH 1 INCREMENT BY 1;

DROP TABLE VACANTES
CREATE TABLE VACANTES
(
    VACANTES_ID NUMERIC   NOT NULL DEFAULT nextval('VACANTES_SEQ')
	,NOMBRE           VARCHAR(255)  NOT NULL 
	,DESCRIPCION      VARCHAR(1024) NOT NULL
	,FECHA_PUBLICACION DATE NOT NULL
	,SALARIO     NUMERIC NOT NULL
	,ESTADO         VARCHAR(15)  NOT NULL 
    ,DESTACADO   VARCHAR(2)
    ,IMAGEN        VARCHAR(1024) NOT NULL
    ,DETALLE        VARCHAR(2048) NOT NULL
    ,CATEGORIA  NUMERIC
	,FOREIGN KEY (CATEGORIA) REFERENCES CATEGORIAS(CATEGORIA_ID)
);
ALTER TABLE VACANTES ADD CONSTRAINT VACANTES_ID_UNK UNIQUE (VACANTES_ID);





CREATE SEQUENCE USUARIOS_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE USUARIOS
(
    USUARIO_ID NUMERIC   NOT NULL DEFAULT nextval('USUARIOS_SEQ')
	,NOMBRE           VARCHAR(255)  NOT NULL 
	,EMAIL           VARCHAR(255)  NOT NULL
	,USUARIO           VARCHAR(100)  NOT NULL
	,PASSWORD           VARCHAR(100)  NOT NULL
	,ESTADO         VARCHAR(15)  NOT NULL 
	,FECHA_REGISTRO DATE NOT NULL
);
ALTER TABLE USUARIOS ADD CONSTRAINT USUARIOS_UNK UNIQUE (USUARIO_ID);
ALTER TABLE USUARIOS ADD CONSTRAINT USUARIOS_USER_UNK UNIQUE (USUARIO);
ALTER TABLE USUARIOS ADD CONSTRAINT USUARIOS_EMAIL_UNK UNIQUE (EMAIL);


CREATE TABLE USUARIO_PERFIL
(
    USUARIO_ID NUMERIC   NOT NULL 
   ,PERFIL_ID NUMERIC   NOT NULL 
   ,FOREIGN KEY (USUARIO_ID) REFERENCES USUARIOS(USUARIO_ID)
   ,FOREIGN KEY (PERFIL_ID) REFERENCES  PERFILES(PERFIL_ID)
);
ALTER TABLE USUARIO_PERFIL ADD CONSTRAINT USUARIO_PERFIL_UNK UNIQUE (USUARIO_ID,PERFIL_ID);



CREATE SEQUENCE SOLICITUDES_SEQ START WITH 1 INCREMENT BY 1;


CREATE TABLE SOLICITUDES
(
    SOLICITUD_ID NUMERIC   NOT NULL DEFAULT nextval('SOLICITUDES_SEQ')
    ,FECHA DATE NOT NULL
	,ARCHIVO           VARCHAR(255)  NOT NULL 
	,COMENTARIOS           VARCHAR(2048)  NOT NULL
    ,USUARIO_ID NUMERIC   NOT NULL 
    ,VACANTE_ID NUMERIC   NOT NULL 
    ,FOREIGN KEY (USUARIO_ID) REFERENCES USUARIOS(USUARIO_ID)
    ,FOREIGN KEY (VACANTE_ID) REFERENCES  VACANTES(VACANTES_ID)
);
ALTER TABLE SOLICITUDES ADD CONSTRAINT SOLICITUD_USER_UNK UNIQUE (USUARIO_ID,VACANTE_ID);
ALTER TABLE SOLICITUDES ADD CONSTRAINT SOLICITUD_ID_EMAIL_UNK UNIQUE (SOLICITUD_ID);