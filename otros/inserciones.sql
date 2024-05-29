-- Inserción para la tabla EMPLEADOS
INSERT INTO EMPLEADOS (identificacion, nombre, apellidos, cargo) 
VALUES (1, 'Juan', 'Pérez', 'Analista');

-- Inserción para la tabla EVALUACIONES
INSERT INTO EVALUACIONES (id_evaluacion, identificacion, descripcion) 
VALUES (1, 1, 'Evaluación de desempeño 2024');

-- Inserción para la tabla VAC_LIC
INSERT INTO VAC_LIC (id_vl, identificacion, tipo, fecha_inicio, fecha_fin) 
VALUES (1, 1, 'Vacaciones', TO_DATE('2024-06-01', 'YYYY-MM-DD'), TO_DATE('2024-06-15', 'YYYY-MM-DD'));

-- Inserción para la tabla TURNOS
INSERT INTO TURNOS (id_turno, hora_entrada, hora_salida, pago, identificacion) 
VALUES (1, TO_TIMESTAMP('2024-05-22 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-05-22 16:00:00', 'YYYY-MM-DD HH24:MI:SS'), 200, 1);

-- Inserción para la tabla PAGOS
INSERT INTO PAGOS (id_pago, identificacion, salario, mes) 
VALUES (1, 1, 3000, 5);

-- Inserción para la tabla PERFIL_EMPLEADOS
INSERT INTO PERFIL_EMPLEADOS (id_perfil, identificacion, ultima_evaluacion, descripcion) 
VALUES (1, 1, 'Evaluación positiva', 'Empleado con excelentes habilidades de análisis y trabajo en equipo.');

commit;