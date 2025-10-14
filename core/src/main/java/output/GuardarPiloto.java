package output;

import java.util.UUID;

public interface GuardarPiloto {
    Boolean existePiloto(String DNI);
    UUID registroExitoso();
}
