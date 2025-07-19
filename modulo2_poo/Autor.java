package modulo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Autor extends Pessoa {
    private String nacionalidade;
    private List<Livro> obrasPublicadas = new ArrayList<>();

    public Autor(String nome, String nacionalidade) {
        super(nome);
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    void adicionarObra(Livro livro) {
        if (!obrasPublicadas.contains(livro)) {
            obrasPublicadas.add(livro);
        }
    }

    public List<Livro> getObrasPublicadas() {
        return Collections.unmodifiableList(obrasPublicadas);
    }

    public List<Livro> getObrasPublicadasPorGenero(String genero) {
        return obrasPublicadas.stream()
                .filter(l -> l.getGenero().equalsIgnoreCase(genero))
                .toList();
    }
}
