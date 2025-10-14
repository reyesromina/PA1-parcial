package output;

import model.Piloto;

import java.util.UUID;

public interface GuardarPiloto {
    Boolean existePiloto(String DNI);
    Boolean registroExitoso(Piloto piloto);
}
