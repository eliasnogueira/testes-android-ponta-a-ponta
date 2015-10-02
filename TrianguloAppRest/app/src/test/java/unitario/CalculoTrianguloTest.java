package unitario;


import com.eliasnogueira.trianguloapp.models.CalculaTriangulo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculoTrianguloTest {

    @Test
    public void testCalculaTrianguloEquilatero() {
        assertEquals("O triângulo é Equilátero", CalculaTriangulo.calculaTipoTriangulo("3", "3", "3"));
    }

    @Test
    public void testeCalculaTrianguloIsosceles() {
        assertEquals("O triângulo é Isósceles", CalculaTriangulo.calculaTipoTriangulo("3", "6", "6"));
    }

}