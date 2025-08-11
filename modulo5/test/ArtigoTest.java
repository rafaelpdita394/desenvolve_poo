package test;

import org.junit.jupiter.api.Test;
import src.Autor;
import src.Artigo;
import static org.junit.jupiter.api.Assertions.*;

public class ArtigoTest {
    @Test
    public void testCriacaoArtigo() {
        Autor autor = new Autor("Ana", true);
        Artigo artigo = new Artigo("Título Teste", autor, "educação", false);

        assertEquals("Título Teste", artigo.getTitulo());
        assertEquals(autor, artigo.getAutor());
        assertEquals("educação", artigo.getGenero());
        assertFalse(artigo.isPublicado());
    }
}
