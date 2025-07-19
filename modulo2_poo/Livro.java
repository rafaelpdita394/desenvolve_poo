package modulo2;

public class Livro {
    private String titulo;
    private Autor autorPrincipal;
    private String genero;
    private boolean disponivel = true;

    public Livro(String titulo, Autor autorPrincipal, String genero) {
        this.titulo = titulo;
        this.autorPrincipal = autorPrincipal;
        this.genero = genero;
        autorPrincipal.adicionarObra(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutorPrincipal() {
        return autorPrincipal;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    void marcarEmprestado() {
        if (!disponivel) {
            throw new IllegalStateException("Livro já está emprestado.");
        }
        this.disponivel = false;
    }

    void marcarDisponivel() {
        this.disponivel = true;
    }

    public boolean validarDisponibilidade() {
        return disponivel;
    }
}
