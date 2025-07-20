package modulo3;

import modulo2.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    Autor autor;
    Livro livro1;
    Livro livro2;

    @BeforeEach
    void setUp() {
        autor = new Autor("Jess", "Brasileira");
        livro1 = new Livro("Java Basico", autor, "tecnologia", true);
        livro2 = new Livro("Java Avançado", autor, "tecnologia", false);
    }

    @Test
    void deveRetornarTituloCorreto() {
        assertEquals("Java Basico", livro1.getTitulo());
    }

    @Test
    void deveIndicarDisponibilidade() {
        assertTrue(livro1.isDisponivel());
        assertFalse(livro2.isDisponivel());
    }

    @Test
    void marcarEmprestadoDeveMudarDisponibilidade() {
        livro1.marcarEmprestado();
        assertFalse(livro1.isDisponivel());
    }

    @Test
    void marcarEmprestadoEmLivroIndisponivelDeveLancarExcecao() {
        assertThrows(IllegalStateException.class, () -> livro2.marcarEmprestado());
    }

    @Test
    void marcarDisponivelDeveLiberarLivro() {
        livro2.marcarDisponivel();
        assertTrue(livro2.isDisponivel());
    }

    @Test
    void validarDisponibilidade() {
        assertTrue(livro1.validarDisponibilidade());
        assertFalse(livro2.validarDisponibilidade());
    }

    @Test
    void autorDeveTerLivroAssociadoAutomaticamente() {
        assertTrue(autor.getObrasPublicadas().contains(livro1));
        assertTrue(autor.getObrasPublicadas().contains(livro2));
    }
}
