package usecase;

import input.RegistrarPilotoInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.GuardarPiloto;

@ExtendWith(MockitoExtension.class)
public class TestUseCase {

    @Mock
    GuardarPiloto guardarPiloto;

    @Test
    public void TestRegistarPiloto_Success(){

        RegistrarPilotoInput useCase= new RegistrarPilotoUseCase(guardarPiloto);
    }
}
