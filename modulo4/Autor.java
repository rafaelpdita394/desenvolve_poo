package modulo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Autor extends Pessoa {

    private String nacionalidade;
    private List<Livro> obrasPublicadas = new ArrayList<>();
    private TipoAutor tipo; // NOVO CAMPO

    // Construtor padrão (tradicional)
    public Autor(String nome, String nacionalidade) {
        this(nome, nacionalidade, TipoAutor.TRADICIONAL);
    }

    // Construtor completo permitindo definir tipo
    public Autor(String nome, String nacionalidade, TipoAutor tipo) {
        super(nome);
        this.nacionalidade = nacionalidade;
        this.tipo = tipo;
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

    // NOVOS MÉTODOS
    public TipoAutor getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutor tipo) {
        this.tipo = tipo;
    }

    public boolean isAutorUsuario() {
        return this.tipo == TipoAutor.USUARIO;
    }
}
