# 💊 InventarioFarmaciaProyecto

Este proyecto implementa un sistema de inventario para una farmacia, desarrollado en **Java** con **Swing** para la interfaz gráfica y conexión a **MySQL** para la persistencia de datos. Forma parte del curso de Programación I y aplica principios de **POO**, manejo de estructuras de datos y operaciones CRUD.

## 📌 Objetivo General

Desarrollar un sistema de inventario para una farmacia que permita registrar, consultar, actualizar, vender y eliminar productos, con una interfaz gráfica amigable y conexión a base de datos.

## 🧩 Estructura del Proyecto

- `ProductoDTO`: Objeto que representa un producto.
- `InventarioFarmacia`: Clase lógica para manejar las operaciones con productos.
- `ProductoDAO`: Clase que realiza la conexión a MySQL y operaciones CRUD.
- `MenuPrincipal`: Menú inicial con acceso a todas las funciones.
- Formularios Swing: Registrar, Consultar, Buscar, Vender, Actualizar, Eliminar productos.

## 🖥️ Tecnologías Utilizadas

- Java 11  
- Maven  
- Swing  
- MySQL  
- JDBC (MySQL Connector)

## 🛠️ Requisitos Previos

- Java JDK 11 instalado
- NetBeans o IDE compatible con Maven
- MySQL Server activo
- Usuario `root` configurado (o modificar credenciales en `ProductoDAO`)
- Crear la base de datos con el siguiente script:

```sql
CREATE DATABASE farmacia;
USE farmacia;

CREATE TABLE productos (
    codigo_barras VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    precio_unitario DOUBLE,
    cantidad_stock INT
);
```

## 📦 Funcionalidades Implementadas

✅ Registrar productos  
✅ Consultar inventario completo  
✅ Buscar producto por código de barras  
✅ Vender productos  
✅ Actualizar precio  
✅ Eliminar productos  
✅ Interfaz gráfica con menús
