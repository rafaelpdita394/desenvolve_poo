package test;

import org.junit.jupiter.api.Test;
import src.Autor;
import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {
    @Test
    public void testCriacaoAutorUsuario() {
        Autor autor = new Autor("Maria", true);
        assertEquals("Maria", autor.getNome());
        assertTrue(autor.isUsuario());
    }

    @Test
    public void testCriacaoAutorTradicional() {
        Autor autor = new Autor("Carlos", false);
        assertEquals("Carlos", autor.getNome());
        assertFalse(autor.isUsuario());
    }
}
