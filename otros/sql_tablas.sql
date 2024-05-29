create database frutygreen ;
use frutygreen;

drop table empleados;
drop table evaluaciones;
drop table vac_lic;
 drop table pagos;
drop table turnos;
drop table PERFIL_EMPLEADOS;


CREATE TABLE EMPLEADOS (
    identificacion INT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    cargo VARCHAR(255) NOT NULL
);





CREATE TABLE EVALUACIONES (
    id_evaluacion INT PRIMARY KEY,
    identificacion INT NOT NULL,
    descripcion VARCHAR(1500) ,
    FOREIGN KEY (identificacion) REFERENCES EMPLEADOS(identificacion)
);



CREATE TABLE VAC_LIC (
    id_vl INT PRIMARY KEY,
    identificacion INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    FOREIGN KEY (identificacion) REFERENCES EMPLEADOS(identificacion)
    
);


CREATE TABLE TURNOS (
    id_turno INT PRIMARY KEY,
    hora_entrada TIMESTAMP NOT NULL,
    hora_salida TIMESTAMP NOT NULL,
    pago NUMBER NOT NULL,
    identificacion INT NOT NULL,
    FOREIGN KEY (identificacion) REFERENCES EMPLEADOS(identificacion)

);


CREATE TABLE PAGOS (
    id_pago INT PRIMARY KEY,
    identificacion INT NOT NULL,
    salario NUMBER NOT NULL,
    mes int NOT NULL,
    FOREIGN KEY (identificacion) REFERENCES EMPLEADOS(identificacion)
);


CREATE TABLE PERFIL_EMPLEADOS (
    id_perfil INT PRIMARY KEY,
    identificacion INT NOT NULL,
    ultima_evaluacion VARCHAR(1500),
    descripcion VARCHAR(2500),
    FOREIGN KEY (identificacion) REFERENCES EMPLEADOS(identificacion)
);





commit;
select * from empleados;
