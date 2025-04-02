CREATE DATABASE IF NOT EXISTS taller;
USE taller;

CREATE TABLE Cliente (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    telefono int NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE Empleado (
    idEmpleado INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    telefono int NOT NULL
);


CREATE TABLE Vehiculo (
    matricula VARCHAR(20) PRIMARY KEY,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    ano int NOT NULL,
    dni VARCHAR(9) NOT NULL,
    FOREIGN KEY (dni) REFERENCES Cliente(dni)
);

CREATE TABLE Cita (
    idCita INT PRIMARY KEY AUTO_INCREMENT,
    cliente VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    descripcion VARCHAR(200) NOT NULL
);

CREATE TABLE Servicio (
    idServicio INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

CREATE TABLE Pieza (
    idPieza INT PRIMARY KEY AUTO_INCREMENT,
    referencia VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    cantidad INT NOT NULL
);


CREATE TABLE Taller (
    idRelacion INT PRIMARY KEY AUTO_INCREMENT,
    idEmpleado INT,
    dniCliente VARCHAR(9),
    matriculaVehiculo VARCHAR(20),
    idCita INT,
    idServicio INT,
    idPieza INT,
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(idEmpleado),
    FOREIGN KEY (dniCliente) REFERENCES Cliente(dni),
    FOREIGN KEY (matriculaVehiculo) REFERENCES Vehiculo(matricula),
    FOREIGN KEY (idCita) REFERENCES Cita(idCita),
    FOREIGN KEY (idServicio) REFERENCES Servicio(idServicio),
    FOREIGN KEY (idPieza) REFERENCES Pieza(idPieza)
);