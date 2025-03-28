INSERT INTO Cliente (dni, nombre, apellido, telefono, direccion, email) VALUES
('12345678A', 'Juan', 'Pérez', 654321987, 'Calle Mayor 10', 'juan.perez@email.com'),
('23456789B', 'María', 'González', 612345678, 'Avenida del Sol 5', 'maria.gonzalez@email.com'),
('34567890C', 'Carlos', 'Fernández', 698765432, 'Calle Luna 23', 'carlos.fernandez@email.com'),
('45678901D', 'Ana', 'Martínez', 677889900, 'Paseo del Prado 12', 'ana.martinez@email.com'),
('56789012E', 'Luis', 'Rodríguez', 699112233, 'Calle Verde 8', 'luis.rodriguez@email.com');

INSERT INTO Empleado (nombre, apellido, telefono) VALUES
('Pedro', 'López', 611223344),
('Elena', 'Sánchez', 622334455),
('Javier', 'García', 633445566),
('Laura', 'Díaz', 644556677),
('Andrés', 'Moreno', 655667788);

INSERT INTO Vehiculo (matricula, marca, modelo, ano, dni) VALUES
('ABC123', 'Toyota', 'Corolla', 2018, '12345678A'),
('XYZ789', 'Honda', 'Civic', 2020, '23456789B'),
('LMN456', 'Ford', 'Focus', 2019, '34567890C'),
('PQR678', 'Volkswagen', 'Golf', 2017, '45678901D'),
('JKL345', 'BMW', 'Serie 3', 2021, '56789012E');

INSERT INTO Cita (cliente, fecha, hora, descripcion) VALUES
('Juan Pérez', '2024-04-01', '09:00:00', 'Cambio de aceite y revisión general'),
('María González', '2024-04-02', '10:30:00', 'Revisión de frenos y alineación'),
('Carlos Fernández', '2024-04-03', '11:00:00', 'Cambio de neumáticos'),
('Ana Martínez', '2024-04-04', '14:00:00', 'Reparación de aire acondicionado'),
('Luis Rodríguez', '2024-04-05', '16:30:00', 'Diagnóstico de motor');

INSERT INTO Servicio (nombre, precio) VALUES
('Cambio de aceite', 50.00),
('Revisión general', 80.00),
('Cambio de neumáticos', 120.00),
('Revisión de frenos', 70.00),
('Alineación', 60.00);

INSERT INTO Pieza (referencia, marca, descripcion, precio, cantidad) VALUES
('FILTRO001', 'Bosch', 'Filtro de aceite', 15.00, 20),
('PASTILLAS002', 'Brembo', 'Juego de pastillas de freno', 45.00, 15),
('BUJIAS003', 'NGK', 'Juego de bujías', 30.00, 25),
('NEUMATICO004', 'Michelin', 'Neumático 205/55R16', 90.00, 10),
('BATERIA005', 'Varta', 'Batería de 70Ah', 120.00, 5);