#Caso de estudio Elastic Search - Grupo 5

create database if not exists fabrica;
use fabrica;


drop table if exists DETALLE_COMPRAS;
drop table if exists ORDEN_COMPRAS;
drop table if exists PRODUCTOS;
drop table if exists TIPO_PRODUCTOS;
drop table if exists HISTORICO_MAQUINAS;
drop table if exists HABILIDADES_TRABAJADOR;
drop table if exists MAQUINAS;
drop table if exists CLIENTES;
drop table if exists TRABAJADORES;
drop table if exists HABILIDADES;
drop table if exists MATERIALES;


/*==============================================================*/
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES
(
    ID_CLIENTE			int        	    	not null AUTO_INCREMENT,
    NOMBRE               VARCHAR(100)        not null,
    DIRECCION            VARCHAR(100)        not null,
    TELEFONO				VARCHAR(15)			not null,
    NOMBRE_CONTACTO		VARCHAR(100)		not null,
    constraint PK_CLIENTES primary key (ID_CLIENTE)
);
/*==============================================================*/
/* Table: MATERIALES                                   */
/*==============================================================*/
create table MATERIALES
(
    ID_MATERIAL     int             not null AUTO_INCREMENT,
    NOMBRE          varchar(50)     not null,
    constraint PK_MATERIALES primary key (ID_MATERIAL)
);


/*==============================================================*/
/* Table: MAQUINAS                                              */
/*==============================================================*/
create table MAQUINAS
(
    NUMERO_SERIE    int         not null AUTO_INCREMENT,
    MARCA           varchar(50) not null,
    MODELO          varchar(50) not null,
    FECHA_COMPRA    date        not null ,
    constraint PK_MAQUINAS primary key (NUMERO_SERIE)
);

/*==============================================================*/
/* Table: TIPO_PRODUCTOS                                   */
/*==============================================================*/
create table TIPO_PRODUCTOS
(
    ID_TIPO         int             not null AUTO_INCREMENT,
    TIPO            varchar(50)     not null,
    ID_MATERIAL     int             not null,
    ID_MAQUINA      int             not null ,
    constraint PK_TIPO_PRODUCTOS primary key (ID_TIPO)
);

alter table TIPO_PRODUCTOS
    add constraint FK_TP_MAT foreign key (ID_MATERIAL)
        references MATERIALES(ID_MATERIAL);

alter table TIPO_PRODUCTOS
    add constraint FK_TP_MAQ foreign key (ID_MAQUINA)
        references MAQUINAS(NUMERO_SERIE);

/*==============================================================*/
/* Table: ORDEN_COMPRAS                                              */
/*==============================================================*/
create table ORDEN_COMPRAS
(
    ID_ORDEN				int        	not null AUTO_INCREMENT,
    FECHA_COMPRA         date        not null,
    ENTREGA_ESTIMADA     date        not null,
    ENTREGA_REAL			date        not null,
    ID_CLIENTE			int 		not null,
    constraint PK_ORDEN primary key (ID_ORDEN)
);

alter table ORDEN_COMPRAS
    add constraint FK_ORDEN_CLIENTE foreign key (ID_CLIENTE)
        references CLIENTES (ID_CLIENTE);

/*==============================================================*/
/* Table: PRODUCTOS                                   */
/*==============================================================*/
create table PRODUCTOS
(
    ID_PRODUCTO     int             not null AUTO_INCREMENT,
    NOMBRE          varchar(50)     not null,
    DESCRIPCION     varchar(100)    not null,
    PRECIO_UNITARIO double          not null,
    ID_TIPO         int             not null ,
    constraint PK_PRODUCTOS primary key (ID_PRODUCTO)
);

alter table PRODUCTOS
    add constraint FK_PR_TP foreign key (ID_TIPO)
        references TIPO_PRODUCTOS(ID_TIPO);



/*==============================================================*/
/* Table: DETALLE_COMPRAS                                              */
/*==============================================================*/
create table DETALLE_COMPRAS
(
    ID_PRODUCTO			int        			not null AUTO_INCREMENT,
    ID_ORDEN         	int        		not null,
    CANTIDAD				int					not null,
    PRECIO_UNITARIO		double(10,2)		not null,
    constraint PK_DETALLE primary key (ID_PRODUCTO, ID_ORDEN)
);

alter table DETALLE_COMPRAS
    add constraint FK_DETALLE_ORDEN foreign key (ID_ORDEN)
        references ORDEN_COMPRAS (ID_ORDEN);

alter table DETALLE_COMPRAS
    add constraint FK_DETALLE_PRODUCTO foreign key (ID_PRODUCTO)
        references PRODUCTOS (ID_PRODUCTO);

/*==============================================================*/
/* Tabla: TRABAJADORES                                          */
/*==============================================================*/
create table TRABAJADORES
(
    ID_TRABAJADOR        int              not null AUTO_INCREMENT,
    NOMBRE               VARCHAR(50)        not null,
    APELLIDO             VARCHAR(50)        not null,
    FECHA_NACIMIENTO 	DATE			   not null,
    DIRECCION 			VARCHAR(70)        not null,
    constraint PK_TRABAJADORES primary key (ID_TRABAJADOR)
);
/*==============================================================*/
/* Tabla: HABILIDADES                                           */
/*==============================================================*/
create table HABILIDADES
(
    ID_HABILIDAD         int              not null AUTO_INCREMENT,
    NOMBRE              VARCHAR(50)         not null,
    DESCRIPCION         VARCHAR(200)         not null,
    constraint PK_HABILIDADES primary key (ID_HABILIDAD)
);
/*==============================================================*/
/* Tabla: HABILIDADES_TRABAJADOR                                */
/*==============================================================*/
create table HABILIDADES_TRABAJADOR
(
    ID_HABILIDAD         int              not null,
    ID_TRABAJADOR        int              not null,
    constraint PK_HABILIDADES_TRABAJADOR primary key (ID_HABILIDAD,ID_TRABAJADOR)
);

alter table HABILIDADES_TRABAJADOR
    add constraint FK_HT_TRABAJADOR foreign key (ID_TRABAJADOR)
        references TRABAJADORES (ID_TRABAJADOR);

alter table HABILIDADES_TRABAJADOR
    add constraint FK_HT_HABILIDADES foreign key (ID_HABILIDAD)
        references HABILIDADES (ID_HABILIDAD);

/*==============================================================*/
/* Table: HISTORICO_MAQUINAS                                    */
/*==============================================================*/
create table HISTORICO_MAQUINAS
(
    ID_TRABAJADOR   int     not null,
    ID_MAQUINA      int     not null,
    FECHA           date    not null,
    constraint PK_HISTORICO_MAQUINAS primary key (ID_TRABAJADOR,ID_MAQUINA,FECHA)
);

alter table HISTORICO_MAQUINAS
    add constraint FK_HM_M foreign key (ID_MAQUINA)
        references MAQUINAS(NUMERO_SERIE);

alter table HISTORICO_MAQUINAS
    add constraint FK_HM_T foreign key (ID_TRABAJADOR)
        references TRABAJADORES(ID_TRABAJADOR);
