-- DROP DATABASE SISTEMAMUTUAL;
-- DROP TABLE SOCIO;

CREATE DATABASE SISTEMAMUTUAL;

-- USE SISTEMAMUTUAL;

CREATE TABLE SOCIO (
    NUMERO_SOCIO INT PRIMARY KEY,                    
    APELLIDO_NOMBRE VARCHAR(50),
	DOMICILIO VARCHAR(50),
	LOCALIDAD VARCHAR(30),
	CODIGO_POSTAL INT(4),
	TIPO_DOCUMENTO VARCHAR(4),
	NRO_DOCUMENTO INT(11),
	FECHA_NACIMIENTO DATE,
	ESTADO_CIVIL VARCHAR(1),
	PROFESION VARCHAR(50),
	CATEGORIA VARCHAR(1),
	FECHA_INGRESO DATE,
	MONTO_MAXIMO DECIMAL(12, 2),
	FECHA_EGRESO DATE,
	FECHA_NACIMIENTO_2 DATE,
	FECHA_INGRESO_2 DATE,
	FECHA_EGRESO_2 DATE,
	CUIT VARCHAR(13),
	RESPONSABLE VARCHAR(1),
	TELEFONO VARCHAR(20),
	EMAIL VARCHAR(50),
	NACIONALIDAD VARCHAR(20),
	CENSO DATE,
	TRABAJO VARCHAR(30),
	APELLIDO_PADRE VARCHAR(20),
	NOMBRE_PADRE VARCHAR(20),
	VIVE_PADRE VARCHAR(1),
	APELLIDO_MADRE VARCHAR(20),
	NOMBRE_MADRE VARCHAR(20),
	VIVE_MADRE VARCHAR(1),
	APELLIDO_BENEFICIARIO VARCHAR(20),
	NOMBRE_BENEFICIARIO VARCHAR(20),
	CARENCIA VARCHAR(10),
	APELLIDO_CASADO VARCHAR(20),
	TIPPER VARCHAR(1),
	CONJUNTA VARCHAR(1),
	LEGAJO VARCHAR(1),
	COMPLETO VARCHAR(1),
	OPERADOR VARCHAR(10),
	FECHA_VENCIMIENTO DATE,
	DOMICILIO_CONTRAC VARCHAR(25),
	LISTADO VARCHAR(1),
	GARANTIAS VARCHAR(1),
	CONSTANCIA_INSC VARCHAR(1),
	DDJJ_IIBB VARCHAR(1),
	DDJJ_GANANCIAS VARCHAR(1),
	DDJJ_BIENES_PERS VARCHAR(1),
	PAGO_MONOTRIBUTO VARCHAR(1),
	PAGO_IVA VARCHAR(1),
	PAGO_IIBB VARCHAR(1),
	RECIBO_SUELDO VARCHAR(1),
	FOTOCOPIA_DNI VARCHAR(1),
	FOTOCOPIA_IMPUESTO VARCHAR(1),
	LICI_FONDO VARCHAR(1),
	PEP VARCHAR(30),
	PERFIL DECIMAL(12, 2),
	RIESGO VARCHAR(5),
	MODALIDAD VARCHAR(15),
	TERROR VARCHAR(25),
	SEXO VARCHAR(1),
	OBLIGADO VARCHAR(1),
	VTOOBL DATE,
	VTOPEP DATE,
	VTOTER DATE,
	PROVINCIA VARCHAR(20),
	BENEFICIARIO_FINAL VARCHAR(30),
	EMAIL_1 VARCHAR(50),
	DIGITAL VARCHAR(1),
	MANDAR VARCHAR(1),
	ACRED VARCHAR(1),
	APODE VARCHAR(1),
	PODER VARCHAR(20),
	APODE_SOC_1 INT,
	APODE_SOC_2 INT,
	APODE_SOC_3 INT,
	PAIS VARCHAR(20),
	LOCALIDAD_CONTR VARCHAR(30),
	PROVINCIA_CONTR VARCHAR(20),
	PAIS_CONTR VARCHAR(20),
	CELULAR VARCHAR(20),
	LUGAR VARCHAR(20),
	VENCIMIENTO_RUPP DATE,
	DOM_GT1 VARCHAR(20),
	TIPO_GT1 VARCHAR(20),
	M1 VARCHAR(3),
	MONTO_GT1 DECIMAL(15, 2),
	VENCIMIENTO_GT1 DATE,
	DOM_GT2 VARCHAR(20),
	TIPO_GT2 VARCHAR(20),
	M2 VARCHAR(3),
	MONTO_GT2 DECIMAL(15, 2),
	VENCIMIENTO_GT2 DATE,
	DOM_GT3 VARCHAR(20),
	TIPO_GT3 VARCHAR(20),
	M3 VARCHAR(3),
	MONTO_GT3 DECIMAL(15, 2),
	VENCIMIENTO_GT3 DATE,
	ACTI_1 VARCHAR(30),
	ACTI_2 VARCHAR(30),
	PROPO VARCHAR(2),
	CANAL VARCHAR(15),
	FECHA_VENCIMIENTO_TOPE DATE
);

CREATE TABLE ROLES (
    ID INT PRIMARY KEY,                    
    NOMBRE VARCHAR(50)
);
	
CREATE TABLE USUARIOS (
    ID INT PRIMARY KEY,                    
    NOMBRE_USUARIO VARCHAR(50),
	PASSWORD VARCHAR(255),
	ROL_ID INT
);

CREATE TABLE FERIADOS (
	ID_FERIADO BIGINT AUTO_INCREMENT PRIMARY KEY,
    FECHA DATE
);

CREATE TABLE SALDOS (
	ID_SALDO BIGINT AUTO_INCREMENT PRIMARY KEY,
	TIPO VARCHAR(4),
    FECHA DATE,
	SALDO DECIMAL(11, 2)
);

CREATE TABLE MOV_CAJA_AHORRO_COMUN (
	ID_MOV_CAJA_AH_COMUN BIGINT AUTO_INCREMENT PRIMARY KEY,
	NUMERO_SOCIO INT,
	ORDEN INT(8),
	FECHA DATE,
	CODIGO INT(1),
	MONTO DECIMAL(11, 2),
	ANULADO VARCHAR(4),
	FECHA_ACRE DATE,
	CONCEPTO VARCHAR(30)
);

CREATE TABLE CUOTAS (
	ID_CUOTA BIGINT AUTO_INCREMENT PRIMARY KEY,
	NUMERO_SOCIO INT,
	MES INT(2),
	ANO INT(4),
	MONTO DECIMAL(11, 2)
);

CREATE TABLE COBROS (
	ID_COBRO BIGINT AUTO_INCREMENT PRIMARY KEY,
	NUMERO_SOCIO INT,
    MES INT(2),
	ANO INT(4),
	FECHA DATE,
	MONTO DECIMAL(11, 2),
	CONDONA VARCHAR(1)
);






