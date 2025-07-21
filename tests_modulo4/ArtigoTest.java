package modulo3;

import modulo2.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArtigoTest {

    @Test
    void deveCriarArtigoPublicado() {
        Autor autor = new Autor("Ana", "Brasileira");
        Artigo artigo = new Artigo("Entendendo Compiladores", autor, "tecnologia", true);
        assertEquals("Entendendo Compiladores", artigo.getTitulo());
        assertEquals(autor, artigo.getAutor());
        assertEquals("tecnologia", artigo.getGenero());
        assertTrue(artigo.isPublicado());
    }

    @Test
    void devePermitirPublicarEDespublicar() {
        Autor autor = new Autor("Carlos", "Chileno");
        Artigo artigo = new Artigo("JIT vs AOT", autor, "tecnologia", false);
        assertFalse(artigo.isPublicado());
        artigo.publicar();
        assertTrue(artigo.isPublicado());
        artigo.despublicar();
        assertFalse(artigo.isPublicado());
    }

    @Test
    void naoDevePermitirTituloVazio() {
        Autor autor = new Autor("Rita", "Argentina");
        assertThrows(IllegalArgumentException.class,
                () -> new Artigo("   ", autor, "tecnologia", true));
    }

    @Test
    void naoDevePermitirAutorNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Artigo("Analise Lexica", null, "tecnologia", true));
    }
}
