package src;

public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor("João Silva", true);
        Artigo artigo = new Artigo("Entendendo Compiladores", autor, "tecnologia", true);

        System.out.println(autor);
        System.out.println(artigo);
    }
}
