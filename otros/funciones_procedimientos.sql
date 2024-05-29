//PROCEDIMIENTO QUE ME CALCULA EL PAGO DE UN TURNO Y LO CREA.
create or replace procedure calcularPago(ide turnos.identificacion%type,he turnos.hora_entrada%type, hs turnos.hora_salida%type)
as
salarioTurno number;
horasTurno number;
var_cargo varchar2(200);
var_idTurno int;
begin
select max(id_turno)+1 into var_idTurno from turnos;
horasTurno:=(EXTRACT(HOUR FROM hs-he));
select cargo into var_cargo from empleados where identificacion= ide;
if LOWER(var_cargo)=LOWER('Gerente') then
salarioTurno:= horasTurno*11000;
elsif LOWER(var_cargo)=LOWER('Contadora') or LOWER(var_cargo)=LOWER('Contador') then
salarioTurno:= horasTurno*7000;
elsif LOWER(var_cargo)=LOWER('Bulteador') or LOWER(var_cargo)=LOWER('Bulteadora') then
salarioTurno:= horasTurno*4000;
else  
salarioTurno:= horasTurno*5000;
end if;

insert into turnos values(var_idTurno,he,hs,salarioTurno,ide);
COMMIT;
end;


execute calcularPago(4,TIMESTAMP '2024-06-05 10:00:00', TIMESTAMP '2024-06-05 19:00:00');


//PROCEDIMIENTO QUE CALCULA EL SALARIO MENSUAL DE UN EMPLEADO INCLUYENDO SI TUVO VACACIONES O LICENCIAS
CREATE OR REPLACE PROCEDURE
crearPago(ide pagos.identificacion%type, var_mes INT)
AS
salarioTotal NUMBER;
var_idPago NUMBER;

VAR_COUNT_VAC_LIC INT;
PAGO_VAC_LIC NUMBER;
DIAS_DE_VAC_LIC INT;

BEGIN
salarioTotal:=0;
SELECT sum(t.pago) into salarioTotal from turnos t where t.identificacion = ide and EXTRACT(MONTH FROM t.hora_entrada)= var_mes;
select max(id_pago)+1 into var_idPago from pagos;


SELECT COUNT(*) INTO VAR_COUNT_VAC_LIC FROM VAC_LIC WHERE IDENTIFICACION=IDE and EXTRACT(MONTH FROM FECHA_fin)=var_mes;
CASE 
WHEN VAR_COUNT_VAC_LIC>= 1 THEN
SELECT sum(FECHA_FIN -FECHA_inicio) INTO DIAS_DE_VAC_LIC from vac_lic where identificacion=IDE and  EXTRACT(MONTH FROM FECHA_fin)=var_mes;
PAGO_VAC_LIC:= 8*5000*DIAS_DE_VAC_LIC; 
salarioTotal := salarioTotal + PAGO_VAC_LIC; 
WHEN VAR_COUNT_VAC_LIC= 0 THEN
salarioTotal := salarioTotal;
end case;
insert into pagos values(var_idPago,ide,salarioTotal,var_mes);
commit;

if salarioTotal <=0  then
raise_application_error(-20001,'No se encontró el empleado, puede que no haya realizado ningún turno este mes');
end if;

if salarioTotal is null  then
raise_application_error(-20001,'No se encontró el empleado, puede que no haya realizado ningún turno este mes');
end if;

end;


execute crearPago(100274467778,5);



//PROCEDIMIENTO QUE CUANDO CREO UN EMPLEADO LE GENERA AUTOMATICAMENTE EL PERFIL
create or replace procedure
crearEmpleadoyPerfil
(ide_empleado empleados.identificacion%type,
nombre_empleado empleados.nombre%type,
apellidos_empleado empleados.apellidos%type,
cargo_empleado empleados.cargo%type)
as
var_idPerfil perfil_empleados.id_perfil%type;
begin
select max(id_perfil)+1 into var_idPerfil from perfil_empleados;
insert into empleados values(ide_empleado,nombre_empleado,apellidos_empleado,cargo_empleado);

insert into perfil_empleados (id_perfil,identificacion) values(var_idPerfil,ide_empleado);
commit;
end;

execute crearEmpleadoyPerfil(222222222,'genaro','Rendón M.','Contadora');


//PROCEDIMIENTO CON LA QUE CREO UNA EVALUACION PARA UN EMPLEADO Y ME ACTUALIZA EL PERFIL DEL EMPLEADO
CREATE OR REPLACE PROCEDURE
ACTUALIZAR_EVALUACION_PERFIL (IDE EVALUACIONES.IDENTIFICACION%TYPE, DESCRIP EVALUACIONES.DESCRIPCION%TYPE)
AS
VAR_ID_EVALUACION EVALUACIONES.ID_EVALUACION%TYPE;
BEGIN
SELECT max(id_evaluacion)+1 INTO VAR_ID_EVALUACION FROM EVALUACIONES;
INSERT INTO EVALUACIONES VALUES (VAR_ID_EVALUACION,IDE,DESCRIP);
UPDATE PERFIL_EMPLEADOS SET ULTIMA_EVALUACION= descrip WHERE PERFIL_EMPLEADOS.IDENTIFICACION=IDE;
COMMIT;
END;

EXECUTE ACTUALIZAR_EVALUACION_PERFIL(70000077,'me lo mama');


//procedimiento para actualizar la descripcion de un perfil
create or replace procedure
actualizarPerfil(ide perfil_empleados.identificacion%type, correo varchar, domicilio varchar, telefono Long)
as
begin
update perfil_empleados set DESCRIPCION= 'EMAIL: '||CORREO||
CHR(10)||' DOMICILIO: '||DOMICILIO||
CHR(10)||' TELEFONO: '||TELEFONO 
WHERE IDENTIFICACION=IDE;
commit;
END;



//procedimiento para eliminar un empleado 
create or replace procedure
eliminarempleado(ide empleados.identificacion%type)
as
begin
delete from VAC_LIC where identificacion=ide;
delete from turnos where identificacion=ide;
delete from pagos where identificacion=ide;
delete from perfil_empleados where identificacion=ide;
delete from evaluaciones where identificacion=ide;
delete from empleados where identificacion=ide;
end;

execute eliminarempleado(45466645);



//Procedimiento para registrar un permiso de vacaciones/licencias
create or replace procedure 
CREARVAC_LIC(
IDE VAC_LIC.IDENTIFICACION%TYPE,
TIPO VAC_LIC.TIPO%TYPE,
FI VAC_LIC.FECHA_INICIO%TYPE,
FF VAC_LIC.FECHA_FIN%TYPE
)
AS
VAR_COUNT INT;
BEGIN
SELECT max(id_vl)+1 INTO VAR_COUNT FROM VAC_LIC;
INSERT INTO VAC_LIC VALUES(VAR_COUNT,IDE,TIPO,FI,FF);
COMMIT;
END;




//Trigger que evite la inserción de un pago cuando el mes y la identificación ya existan en un registro previo
CREATE OR REPLACE TRIGGER trg_prevent_duplicate_payments
BEFORE INSERT ON PAGOS
FOR EACH ROW
DECLARE
    v_count INT;
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM PAGOS
    WHERE identificacion = :NEW.identificacion
    AND mes = :NEW.mes;
    
    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Ya existe un pago registrado para este mes y esta identificación.');
    END IF;
END;






rollback;
commit;
select * from turnos;
select * from empleados where identificacion=12387;



select fecha_fin-fecha_inicio from vac_lic where identificacion=100274467778;



SELECT * FROM turnos WHERE EXTRACT(MONTH FROM hora_salida) = EXTRACT(MONTH FROM SYSDATE);
