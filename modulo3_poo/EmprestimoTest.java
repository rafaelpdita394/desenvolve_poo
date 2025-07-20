package modulo3;

import modulo2.*;
import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    Date dataRetirada;
    Date dataDevolucao;
    Livro livro;
    Usuario usuario;

    @BeforeEach
    void setUp() {
        dataRetirada = new Date();
        dataDevolucao = new Date();
        livro = new Livro("Java Basics", new Autor("Alan Turing", "Inglês"), "Tecnologia", true);
        usuario = new Usuario("Gabriel", 21);
    }

    @Test
    void deveCriarEmprestimoComLivroDisponivel() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 5);
        Emprestimo e = new Emprestimo(livro, usuario, dataRetirada, c.getTime());
        assertEquals(livro, e.getLivro());
        assertEquals(usuario, e.getUsuario());
        assertFalse(livro.isDisponivel());
        assertNull(e.getDataDevolucao());
    }

    @Test
    void naoDevePermitirEmprestimoSeLivroIndisponivel() {
        livro.marcarEmprestado();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 5);
        assertThrows(IllegalStateException.class,
                () -> new Emprestimo(livro, usuario, dataRetirada, c.getTime()));
    }

    @Test
    void registrarDevolucaoDeveAtualizarStatus() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 5);
        Emprestimo e = new Emprestimo(livro, usuario, dataRetirada, c.getTime());
        e.registrarDevolucao(dataDevolucao);
        assertEquals(dataDevolucao, e.getDataDevolucao());
        assertTrue(livro.isDisponivel());
    }

    @Test
    void naoDevePermitirRegistrarDevolucaoDuasVezes() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 5);
        Emprestimo e = new Emprestimo(livro, usuario, dataRetirada, c.getTime());
        e.registrarDevolucao(dataDevolucao);
        assertThrows(IllegalStateException.class, () -> e.registrarDevolucao(new Date()));
    }

    @Test
    void deveDetectarAtraso() {
        Date retirada = new Date(System.currentTimeMillis() - 10L * 24 * 3600_000);
        Date prevista = new Date(System.currentTimeMillis() - 3L * 24 * 3600_000);
        Livro l2 = new Livro("Outro", new Autor("Autor X", "Brasileiro"), "Tecnologia", true);
        Emprestimo e = new Emprestimo(l2, usuario, retirada, prevista);
        assertTrue(e.estaAtrasado(new Date()));
    }

    @Test
    void emprestimoNaoAtrasadoAntesDaDataPrevista() {
        Date retirada = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 4);
        Livro l2 = new Livro("SemAtraso", new Autor("Autor Y", "Brasileiro"), "Tecnologia", true);
        Emprestimo e = new Emprestimo(l2, usuario, retirada, c.getTime());
        assertFalse(e.estaAtrasado(new Date()));
    }
}
