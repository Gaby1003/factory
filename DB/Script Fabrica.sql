#Caso de estudio Elastic Search - Grupo 5

create database if not exists fabrica;
use fabrica;

drop table if exists DETALLE_COMPRAS;
drop table if exists ORDEN_COMPRAS;
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

