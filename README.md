# SistemaTaller

Sistema de gestión para un taller mecánico desarrollado en Java. Este programa permite gestionar clientes, vehículos, citas, pedidos, piezas, empleados y servicios de manera eficiente.

---

## Características

- **Gestión de Clientes**: Agregar, modificar, eliminar y listar clientes.
- **Gestión de Vehículos**: Agregar, modificar, eliminar y listar vehículos asociados a clientes.
- **Gestión de Citas**: Crear, modificar, eliminar y listar citas para los clientes.
- **Gestión de Pedidos**: Administrar pedidos de piezas y proveedores.
- **Gestión de Empleados**: Agregar, modificar, eliminar y listar empleados del taller.
- **Gestión de Servicios**: Consultar el historial de servicios realizados para los clientes.
- **Gestión de Inventario**: Administrar piezas disponibles en el taller.

---

## Requisitos

- **Java Development Kit (JDK)**: Versión 8 o superior.
- **Base de Datos**: MySQL.
- **Dependencias**:
  - Conector JDBC para MySQL (`mysql-connector-j-<version>.jar`).

---

## Estructura del Proyecto

```plaintext
SistemaTaller/
├── src/                # Código fuente del programa
│   ├── dao/            # Acceso a datos (Data Access Objects)
│   ├── model/          # Modelos de datos
│   ├── view/           # Interfaces de usuario (consola)
│   └── App.java        # Clase principal
├── lib/                # Librerías externas (como el conector JDBC)
├── sql/                # Scripts SQL para la base de datos
├── bin/                # Archivos compilados
├── README.md           # Documentación del proyecto
└── run.bat             # Script para ejecutar el programa en Windows
```

---

## Instalación

### 1. Clonar el repositorio
```bash
git clone <URL_DEL_REPOSITORIO>
cd SistemaTaller
```

### 2. Configurar la base de datos
- Crear una base de datos en MySQL:
  ```sql
  CREATE DATABASE taller;
  ```
- Ejecutar el script SQL ubicado en `sql/seed.sql` para crear las tablas necesarias:
  ```bash
  mysql -u <usuario> -p taller < sql/seed.sql
  ```

### 3. Agregar el conector JDBC
- Descargar el archivo `mysql-connector-j-<version>.jar`.
- Colocarlo en la carpeta `lib/`.

### 4. Compilar el proyecto
```bash
javac -cp lib/mysql-connector-j-<version>.jar -d bin src/**/*.java
```

### 5. Ejecutar el programa
```bash
java -cp bin;lib/mysql-connector-j-<version>.jar App
```

---

## Uso

### Menú Principal
Al iniciar el programa, se mostrará un menú principal con las siguientes opciones:
1. Iniciar sesión como administrador.
2. Iniciar sesión como cliente.
3. Salir.

### Funcionalidades
- **Administrador**:
  - Gestionar empleados, clientes, vehículos, citas, pedidos, piezas y servicios.
- **Cliente**:
  - Modificar datos personales, gestionar citas y consultar el historial de servicios.

---

## Scripts SQL

El archivo `sql/seed.sql` contiene los scripts necesarios para crear las tablas y relaciones en la base de datos. Asegúrate de ejecutarlo antes de usar el programa.

---

## Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE).

---

## Autor

- **EderMoros3** - [GitHub](https://github.com/EderMoros3)
- **cnywu0** - [GitHub](https://github.com/cnywu0)