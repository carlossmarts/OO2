-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb`;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Inspector`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Inspector` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Inspector` (
  `idInspector` INT NOT NULL AUTO_INCREMENT,
    `cuil` varchar(20) NOT NULL,
  PRIMARY KEY (`idInspector`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `cuil_cuit` varchar (80) NULL,
  `inactivo` tinyint(1) null,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Zona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Zona` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Zona` (
  `idZona` INT NOT NULL AUTO_INCREMENT,
`nombre` varchar(20),
  PRIMARY KEY (`idZona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medidor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Medidor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Medidor` (
  `idMedidor` INT NOT NULL AUTO_INCREMENT,
  `nroSerie` INT NOT NULL,
  `cliente` INT NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `zona` INT NOT NULL,
  `esBaja` TINYINT(1) NULL,
  `tension` varchar(10) null,
  PRIMARY KEY (`idMedidor`),
  INDEX `fk_Medidor_Cliente2_idx` (`cliente` ASC),
  INDEX `fk_Medidor_Zona1_idx` (`zona` ASC),
  CONSTRAINT `fk_Medidor_Cliente2`
    FOREIGN KEY (`cliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medidor_Zona1`
    FOREIGN KEY (`zona`)
    REFERENCES `mydb`.`Zona` (`idZona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Lectura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Lectura` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Lectura` (
  `idLectura` INT NOT NULL AUTO_INCREMENT,
  `medidor` INT NOT NULL,
  `fecha` DATE NULL,
  `hora` TIME NULL,
  `inactiva` tinyint(1) null,
  `inspector` INT NOT NULL,
  PRIMARY KEY (`idLectura`),
  INDEX `fk_Lectura_Inspector1_idx` (`inspector` ASC),
  INDEX `fk_Lectura_Medidor1_idx` (`medidor` ASC),
  CONSTRAINT `fk_Lectura_Inspector1`
    FOREIGN KEY (`inspector`)
    REFERENCES `mydb`.`Inspector` (`idInspector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lectura_Medidor1`
    FOREIGN KEY (`medidor`)
    REFERENCES `mydb`.`Medidor` (`idMedidor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LecturaBajaDemanda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LecturaBajaDemanda` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LecturaBajaDemanda` (
  `idLectura` INT NOT NULL,
  `consumo` INT NOT NULL,
  INDEX `fk_Baja_Lectura1_idx` (`idLectura` ASC),
  PRIMARY KEY (`idLectura`),
  CONSTRAINT `fk_Baja_Lectura1`
    FOREIGN KEY (`idLectura`)
    REFERENCES `mydb`.`Lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LecturaAltaDemanda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LecturaAltaDemanda` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LecturaAltaDemanda` (
  `idLectura` INT NOT NULL,
  `consumoPico` INT NOT NULL,
  `consumoValle` INT NULL,
  `consumoResto` INT NULL,
  INDEX `fk_Alta_Lectura1_idx` (`idLectura` ASC),
  PRIMARY KEY (`idLectura`),
  CONSTRAINT `fk_Alta_Lectura1`
    FOREIGN KEY (`idLectura`)
    REFERENCES `mydb`.`Lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Zona_has_Inspector`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Zona_has_Inspector` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Zona_has_Inspector` (
  `idZona` INT NOT NULL,
  `idInspector` INT NOT NULL,
  PRIMARY KEY (`idZona`, `idInspector`),
  INDEX `fk_Zona_has_Inspector_Inspector1_idx` (`idInspector` ASC),
  INDEX `fk_Zona_has_Inspector_Zona1_idx` (`idZona` ASC),
  CONSTRAINT `fk_Zona_has_Inspector_Zona1`
    FOREIGN KEY (`idZona`)
    REFERENCES `mydb`.`Zona` (`idZona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Zona_has_Inspector_Inspector1`
    FOREIGN KEY (`idInspector`)
    REFERENCES `mydb`.`Inspector` (`idInspector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Contacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Contacto` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Contacto` (
    `idContacto` INT,
    `direccion` VARCHAR(45) NOT NULL,
    `telefono` VARCHAR(45) NULL,
    `email` VARCHAR(45) NULL,
    INDEX `fk_Contacto_Cliente1_idx` (`idContacto` ASC),
    PRIMARY KEY (`idContacto`),
    CONSTRAINT `fk_Contacto_Cliente1` FOREIGN KEY (`idContacto`)
        REFERENCES `mydb`.`Cliente` (`idCliente`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=INNODB;


-- -----------------------------------------------------
-- Table `mydb`.`ItemFactura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ItemFactura` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ItemFactura` (
  `idItemFactura` INT NOT NULL AUTO_INCREMENT,
  `detalle` VARCHAR(45) NULL,
  `precioUnitario` DOUBLE NULL,
  `cantidad` INT NULL,
  `unidad` VARCHAR(45) NULL,
  `idFactura` int,
  PRIMARY KEY (`idItemFactura`),
  FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tarifa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Tarifa` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Tarifa` (
  `idTarifa` INT NOT NULL AUTO_INCREMENT,
  `codigo` varchar (25) not null,
  PRIMARY KEY (`idTarifa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Factura` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `nroMedidor` INT not NULL,
  `direccion` VARCHAR(45) not NULL,
  `fecha` DATE not NULL,
  `totalPagar` DOUBLE not NULL,
  `idCliente` int not NULL,
  `observaciones` VARCHAR(100) not NULL,
  PRIMARY KEY (`idFactura`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TarifaIndustrial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TarifaIndustrial` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TarifaIndustrial` (
  `idTarifa` INT NOT NULL,
  `cargoFijo` double NOT NULL,
  `cargoVariablePico` double NULL,
  `cargoVariableValle` double NULL,
  `cargoVariableResto` double NULL,
  `consumoMayor` TINYINT(1) NULL,
  `limiteConsumo` int null,
  `tension` varchar (50) NULL,
  INDEX `fk_TarifaIndustrial_Tarifa1_idx` (`idTarifa` ASC),
  PRIMARY KEY (`idTarifa`),
  CONSTRAINT `fk_TarifaIndustrial_Tarifa1`
    FOREIGN KEY (`idTarifa`)
    REFERENCES `mydb`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TarifaResidencial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TarifaResidencial` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TarifaResidencial` (
  `idTarifa` INT NOT NULL,
  `montoMinimo` double NULL,
  `cargoVariable` double NULL,
  `limiteInferiorConsumo` int null,
  `limiteSuperiorConsumo` int null,
  PRIMARY KEY (`idTarifa`),
  INDEX `fk_TarifaResidencial_Tarifa1_idx` (`idTarifa` ASC),
  CONSTRAINT `fk_TarifaResidencial_Tarifa1`
    FOREIGN KEY (`idTarifa`)
    REFERENCES `mydb`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

select * from factura;
select * from lectura;
select * from TarifaIndustrial;
select * from itemFactura;
select * from cliente;
select * from cliente c inner join contacto co on c.idCliente = co.idContacto;
select * from contacto;
select * from inspector;
select * from zona;
select * from medidor;
select * from zona_has_inspector;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
