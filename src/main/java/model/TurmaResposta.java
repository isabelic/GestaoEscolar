package model;

public class TurmaResposta extends Turma{

    private  String nomeCurso;
    private String nomeProfessor;

    public TurmaResposta(int id, String nome,String nomeCurso, String nomProfessor){
        super(id,nome);
        this.nomeCurso = nomeCurso;
        this.nomeProfessor = nomProfessor;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
}
