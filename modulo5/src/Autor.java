package src;

public class Autor {
    private String nome;
    private boolean usuario; // true = Usuário, false = Autor tradicional

    public Autor(String nome, boolean usuario) {
        this.nome = nome;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public boolean isUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return nome + (usuario ? " (Usuário)" : " (Autor tradicional)");
    }
}
