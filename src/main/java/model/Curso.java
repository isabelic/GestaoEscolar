package model;

public class Curso {

    int id;
    String nome;
    String codigo;

    public Curso(int id, String nome, String codigo) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
    }

    public Curso( String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
