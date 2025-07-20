package modulo3;

import modulo2.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    Autor autor;

    @BeforeEach
    void init() {
        autor = new Autor("Alan Turing", "Inglês");
        new Livro("Computacao Teorica", autor, "academico");
        new Livro("Criptografia", autor, "seguranca");
        new Livro("Maquinas", autor, "academico");
    }

    @Test
    void deveRetornarNacionalidade() {
        assertEquals("Inglês", autor.getNacionalidade());
    }

    @Test
    void deveListarObrasPublicadas() {
        assertEquals(3, autor.getObrasPublicadas().size());
    }

    @Test
    void deveFiltrarObrasPorGenero() {
        List<Livro> academicos = autor.getObrasPublicadasPorGenero("academico");
        assertEquals(2, academicos.size());
    }

    @Test
    void naoDeveDuplicarObra() {
        Livro repetido = autor.getObrasPublicadas().get(0);
        autor.adicionarObra(repetido);
        assertEquals(3, autor.getObrasPublicadas().size());
    }
}
