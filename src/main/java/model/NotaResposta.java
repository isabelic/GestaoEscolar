package model;

public class NotaResposta extends Nota{

    private String alunoNome;
    private String aulaAssunto;


    public NotaResposta(int id, double valor, String alunoNome, String assuntoAula){
        super(id,valor);
        this.alunoNome = alunoNome;
        this.aulaAssunto = assuntoAula;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setNomeAluno(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getAulaAssunto() {
        return aulaAssunto;
    }

    public void setAula(String aulaAssunto) {
        this.aulaAssunto = aulaAssunto;
    }
}
