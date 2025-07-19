package modulo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Usuario extends Pessoa {
    private int idade;
    private List<Emprestimo> historicoEmprestimos = new ArrayList<>();

    public Usuario(String nome, int idade) {
        super(nome);
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    void adicionarEmprestimo(Emprestimo e) {
        if (!historicoEmprestimos.contains(e)) {
            historicoEmprestimos.add(e);
        }
    }

    public List<Emprestimo> getHistoricoEmprestimos() {
        return Collections.unmodifiableList(historicoEmprestimos);
    }

    public boolean possuiEmprestimoVencido(Date hoje) {
        return historicoEmprestimos.stream()
                .anyMatch(e -> e.getDataDevolucao() == null &&
                        e.getDataPrevistaDevolucao() != null &&
                        e.getDataPrevistaDevolucao().before(hoje));
    }
}
