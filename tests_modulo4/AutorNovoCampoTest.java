package modulo3;

import modulo2.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutorNovoCampoTest {

    @Test
    void autorPadraoDeveSerTradicional() {
        Autor a = new Autor("Maria", "Brasileira"); // usa construtor padrão
        assertEquals(TipoAutor.TRADICIONAL, a.getTipo());
        assertFalse(a.isAutorUsuario());
    }

    @Test
    void autorUsuarioDeveSerMarcadoCorretamente() {
        Autor a = new Autor("Joao", "Brasileiro", TipoAutor.USUARIO);
        assertTrue(a.isAutorUsuario());
    }

    @Test
    void alterarTipoDeveFuncionar() {
        Autor a = new Autor("Lia", "Portuguesa");
        a.setTipo(TipoAutor.USUARIO);
        assertEquals(TipoAutor.USUARIO, a.getTipo());
        assertTrue(a.isAutorUsuario());
    }
}
