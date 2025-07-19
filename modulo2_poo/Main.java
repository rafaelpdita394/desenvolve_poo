package modulo2;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Autor autor = new Autor("Jessica Felix", "Brasileira");
        Usuario usuario = new Usuario("Lucas Rafael", 25);
        Livro livro = new Livro("Java for Beginners", autor, "Tecnologia");

        if (!livro.isDisponivel()) {
            System.out.println("O livro não está disponível");
        } else {
            livro.marcarEmprestado();
            System.out.println("O livro não está disponível");
            livro.marcarDisponivel();
        }

        Date agora = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(agora);
        c.add(Calendar.DAY_OF_MONTH, 7);
        Date dataPrevista = c.getTime();

        Emprestimo emprestimo = new Emprestimo(livro, usuario, agora, dataPrevista, agora);

        System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
        System.out.println();
        System.out.println("Autor: " + emprestimo.getLivro().getAutorPrincipal().getNome());
        System.out.println();
        System.out.println("Genero: " + emprestimo.getLivro().getGenero());
        System.out.println();
        System.out.println("Usuario: " + emprestimo.getUsuario().getNome());
        System.out.println();
        System.out.println("Idade: " + emprestimo.getUsuario().getIdade());
        System.out.println();
        System.out.println("Data de Retirada: " + emprestimo.getDataRetirada());
        System.out.println();
        System.out.println("Data de Devolucao: " + emprestimo.getDataDevolucao());
    }
}
