package usecase;

import exception.ExceptionPilotoPersistencia;
import exception.ExceptionYaExistePiloto;
import input.RegistrarPilotoInput;
import model.Piloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.GuardarPiloto;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestUseCase {

    @Mock
    GuardarPiloto guardarPiloto;

    @Test
    public void TestRegistarPiloto_Success(){

        RegistrarPilotoInput useCase= new RegistrarPilotoUseCase(guardarPiloto);

        when(guardarPiloto.existePiloto("1234")).thenReturn(false);

        when(guardarPiloto.registroExitoso(any(Piloto.class))).thenReturn(true);

        UUID confirmacionUUID=useCase.registrarPiloto("Franco colapinto", LocalDate.of(1999,02,12),"1234");

        Assertions.assertNotNull(confirmacionUUID);

    }
    @Test
    public void TestRegistarPiloto_UnSuccess_YaExistePiloto(){

        RegistrarPilotoInput useCase= new RegistrarPilotoUseCase(guardarPiloto);

        when(guardarPiloto.existePiloto("1234")).thenReturn(true);

        lenient().when(guardarPiloto.registroExitoso(any(Piloto.class))).thenReturn(true);

        Assertions.assertThrows(ExceptionYaExistePiloto.class,()->{ UUID confirmacionUUID=useCase.registrarPiloto("Franco colapinto", LocalDate.of(1999,02,12),"1234");});

    }
    @Test
    public void TestRegistarPiloto_UnSuccess_FallaPersistencia(){

        RegistrarPilotoInput useCase= new RegistrarPilotoUseCase(guardarPiloto);

        when(guardarPiloto.existePiloto("1234")).thenReturn(false);

        when(guardarPiloto.registroExitoso(any(Piloto.class))).thenReturn(false);

        Assertions.assertThrows(ExceptionPilotoPersistencia.class,()->{ UUID confirmacionUUID=useCase.registrarPiloto("Franco colapinto", LocalDate.of(1999,02,12),"1234");});

    }
}
