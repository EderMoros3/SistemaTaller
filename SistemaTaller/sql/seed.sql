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
    FOREIGN KEY (dni) REFERENCES Cliente(dni) ON DELETE CASCADE
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
    nombre VARCHAR(100) NOT NULL,
    referencia VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    cantidad INT NOT NULL,
    descripcion VARCHAR(200) NOT NULL
);

CREATE TABLE Proveedor (
    idProveedor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    telefono int NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE Pedido (
    idPedido INT PRIMARY KEY AUTO_INCREMENT,
    fechaPedido DATE NOT NULL,
    fechaEntrega DATE NOT NULL,
    estado VARCHAR(50) NOT NULL,
    precioTotal DECIMAL(10,2) NOT NULL,
    idProveedor INT NOT NULL,
    idPieza INT NOT NULL,
    FOREIGN KEY (idPieza) REFERENCES Pieza(idPieza) ON DELETE CASCADE,
    FOREIGN KEY (idProveedor) REFERENCES Proveedor(idProveedor) ON DELETE CASCADE
);

CREATE TABLE Proveedor (
    idProveedor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    telefono INT NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE Taller (
    idRelacion INT PRIMARY KEY AUTO_INCREMENT,
    idEmpleado INT,
    dniCliente VARCHAR(9),
    matriculaVehiculo VARCHAR(20),
    idCita INT,
    idServicio INT,
    idPieza INT,
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(idEmpleado) ON DELETE CASCADE,
    FOREIGN KEY (dniCliente) REFERENCES Cliente(dni) ON DELETE CASCADE,
    FOREIGN KEY (matriculaVehiculo) REFERENCES Vehiculo(matricula) ON DELETE CASCADE,
    FOREIGN KEY (idCita) REFERENCES Cita(idCita) ON DELETE CASCADE,
    FOREIGN KEY (idServicio) REFERENCES Servicio(idServicio) ON DELETE CASCADE,
    FOREIGN KEY (idPieza) REFERENCES Pieza(idPieza) ON DELETE CASCADE
);

-- Modificacion de la tabla taller para aagregar idPedido
-- esto se eliminara cuando actualices tu base de datos
ALTER TABLE Taller
ADD COLUMN idPedido INT,
ADD FOREIGN KEY (idPedido) REFERENCES Pedido(idPedido) ON DELETE CASCADE;
