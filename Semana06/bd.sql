CREATE DATABASE sistema_tareas;
USE sistema_tareas;
CREATE TABLE estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
    clave VARCHAR(100) NOT NULL
);

-- Tabla de tareas
CREATE TABLE tareas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_estudiante VARCHAR(50) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha_entrega VARCHAR(20),
    estado VARCHAR(20),
    FOREIGN KEY (nombre_estudiante) REFERENCES estudiantes(nombre_usuario)
);
