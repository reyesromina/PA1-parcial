package model;

import exception.ExceptionMayorEdad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class TestPiloto {
    @Test
    public void TestPiloto(){
        Piloto piloto=Piloto.crearPiloto(UUID.randomUUID(),"Franco Colapinto", LocalDate.of(2000,2,12),"1234");

        Assertions.assertNotNull(piloto);
    }

    public void TestPiloto_toString(){
        UUID licencia=UUID.randomUUID();
        Piloto piloto=Piloto.crearPiloto(licencia,"Franco Colapinto", LocalDate.of(2000,2,12),"1234");

        String StringEsperado="Nombre del piloto: Franco Colapinto, licencia: ,edad: ,DNI:";
    }
    @Test
    public void MayorEdad(){

        Piloto piloto=Piloto.crearPiloto(UUID.randomUUID(),"Franco Colapinto", LocalDate.of(2000,2,12),"1234");

        Assertions.assertEquals(25,piloto.getEdad(LocalDate.of(2000,2,12)));

    }
    @Test
    public void NoMayorEdad_Exception(){

        Assertions.assertThrows(ExceptionMayorEdad.class,()->{Piloto piloto=Piloto.crearPiloto(UUID.randomUUID(),"Franco Colapinto", LocalDate.of(2020,2,12),"1234");});
    }
}
