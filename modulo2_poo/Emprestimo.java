package modulo2;

import java.util.Date;

public class Emprestimo {
    private Date dataRetirada;
    private Date dataPrevistaDevolucao;
    private Date dataDevolucao;
    private Livro livro;
    private Usuario usuario;

    public Emprestimo(Livro livro, Usuario usuario, Date dataRetirada,
                      Date dataPrevistaDevolucao) {
        if (livro == null || usuario == null) {
            throw new IllegalArgumentException("Livro e Usuário obrigatórios.");
        }
        if (!livro.validarDisponibilidade()) {
            throw new IllegalStateException("O livro não está disponível para empréstimo.");
        }
        this.livro = livro;
        this.usuario = usuario;
        this.dataRetirada = dataRetirada;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        livro.marcarEmprestado();
        usuario.adicionarEmprestimo(this);
    }

    public Emprestimo(Livro livro, Usuario usuario, Date dataRetirada,
                      Date dataPrevistaDevolucao, Date dataDevolucao) {
        this(livro, usuario, dataRetirada, dataPrevistaDevolucao);
        registrarDevolucao(dataDevolucao);
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public Date getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void registrarDevolucao(Date data) {
        if (dataDevolucao != null) {
            throw new IllegalStateException("Devolução já registrada.");
        }
        this.dataDevolucao = data;
        livro.marcarDisponivel();
    }

    public boolean estaAtrasado(Date hoje) {
        return dataDevolucao == null &&
               dataPrevistaDevolucao != null &&
               dataPrevistaDevolucao.before(hoje);
    }
}
