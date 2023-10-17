#Caso de estudio Elastic Search - Grupo 5

create database if not exists fabrica;
use fabrica;


drop table if exists DETALLE_COMPRAS;
drop table if exists ORDEN_COMPRAS;
drop table if exists HISTORICO_MAQUINAS;
drop table if exists MAQUINAS;
drop table if exists CLIENTES;

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
/* Table: DETALLE_COMPRAS                                              */
/*==============================================================*/
create table DETALLE_COMPRAS
(
    ID_PRODUCTO			int        			not null AUTO_INCREMENT,
    ID_ORDEN         	date        		not null,
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
/* Table: HISTORICO_MAQUINAS                                    */
/*==============================================================*/
create table HISTORICO_MAQUINAS
(
    ID_TRABAJADOR   int     not null,
    ID_MAQUINA      int     not null,
    FECHA           date    not null,
    constraint PK_HISTORICO_MAQUINAS primary key (ID_TRABAJADOR,ID_MAQUINA,FECHA)
)

alter table HISTORICO_MAQUINAS
    add constraint FK_HM_M foreign key (ID_MAQUINA)
        references MAQUINAS(NUMERO_SERIE);

alter table HISTORICO_MAQUINAS
    add constraint FK_HM_T foreign key (ID_TRABAJADOR)
        references TRABAJADORES(ID_TRABAJADOR);

/*==============================================================*/
/* Table: MATERIALES                                   */
/*==============================================================*/
create table MATERIALES
(
    ID_MATERIAL     int             not null AUTO_INCREMENT,
    NOMBRE          varchar(50)     not null,
    constraint PK_MATERIALES primary key (ID_MATERIAL)
)

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
)

alter table TIPO_PRODUCTOS
    add constraint FK_TP_MAT foreign key (ID_MATERIAL)
        references MATERIALES(ID_MATERIAL);

alter table TIPO_PRODUCTOS
    add constraint FK_TP_MAQ foreign key (ID_MAQUINA)
        references MAQUINAS(NUMERO_SERIE);

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
)

alter table PRODUCTOS
    add constraint FK_PR_TP foreign key (ID_TIPO)
        references TIPO_PRODUCTOS(ID_TIPO);


