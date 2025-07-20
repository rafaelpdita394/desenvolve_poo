package modulo3;

import modulo2.*;
import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    Usuario usuario;
    Autor autor;
    Livro livro;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Gabriel", 21);
        autor = new Autor("Jess", "Brasileira");
        livro = new Livro("Java Basico", autor, "tecnologia", true);
    }

    @Test
    void deveRegistrarEmprestimoNoHistorico() {
        Date agora = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 7);
        Emprestimo e = new Emprestimo(livro, usuario, agora, c.getTime());
        assertEquals(1, usuario.getHistoricoEmprestimos().size());
        assertTrue(usuario.getHistoricoEmprestimos().contains(e));
    }

    @Test
    void deveDetectarEmprestimoVencido() {
        Date retirada = new Date(System.currentTimeMillis() - 10L * 24 * 3600_000);
        Date prevista = new Date(System.currentTimeMillis() - 5L * 24 * 3600_000);
        Emprestimo e = new Emprestimo(new Livro("Outro", autor, "tecnologia", true),
                usuario, retirada, prevista);
        assertTrue(usuario.possuiEmprestimoVencido(new Date()));
        assertTrue(e.estaAtrasado(new Date()));
    }

    @Test
    void naoDeveAcusarVencidoSeDentroDoPrazo() {
        Date retirada = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 3);
        new Emprestimo(new Livro("DentroPrazo", autor, "tecnologia", true),
                usuario, retirada, c.getTime());
        assertFalse(usuario.possuiEmprestimoVencido(new Date()));
    }
}
