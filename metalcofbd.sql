CREATE DATABASE metalcofbd;
USE metalcofbd;

CREATE TABLE clientes (
    id_cliente INT NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    direccion VARCHAR(30) NOT NULL,
    ciudad VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    telefono VARCHAR(11) NOT NULL,
    PRIMARY KEY(id_cliente)
);

CREATE TABLE ventas (
    id_venta INT NOT NULL,
    producto VARCHAR(20) NOT NULL,
    cliente INT NOT NULL,
    empleado INT NOT NULL,
    valor INT NOT NULL,
    PRIMARY KEY(id_venta),
    CONSTRAINT ventas_clientes_fk1 FOREIGN KEY (cliente) REFERENCES clientes (id_cliente),
    CONSTRAINT ventas_empleado_fk1 FOREIGN KEY (empleado) REFERENCES empleado (id_empleado)
);

CREATE TABLE productos_estufas (
    id_producto INT NOT NULL,
    nombre_estufa VARCHAR(20) NOT NULL,
    precio_costo VARCHAR(20) NOT NULL,
    precio_venta VARCHAR(30) NOT NULL,
    accesorios VARCHAR(20) NOT NULL,
    obsequio VARCHAR(30) NOT NULL,
    PRIMARY KEY(id_producto)
);

CREATE TABLE ventas_productos_estufas (
    id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    PRIMARY KEY(id_venta, id_producto),
    CONSTRAINT ventas_productos_estufas_fk1 FOREIGN KEY (id_venta) REFERENCES ventas (id_venta),
    CONSTRAINT ventas_productos_estufas_fk2 FOREIGN KEY (id_producto) REFERENCES productos_estufas (id_producto)
);

CREATE TABLE empleado (
    id_empleado INT NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    direccion VARCHAR(30) NOT NULL,
    telefono VARCHAR(11) NOT NULL,
    id_cargo INT NOT NULL,
    salario INT NOT NULL,
    PRIMARY KEY(id_empleado),
    CONSTRAINT empleado_cargo_fk1 FOREIGN KEY (id_cargo) REFERENCES cargo (id_cargo)
);

CREATE TABLE cargo (
    id_cargo INT NOT NULL,
    descripcion_cargo VARCHAR(20) NOT NULL,
    PRIMARY KEY(id_cargo)
);
