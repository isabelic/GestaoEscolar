package model;

import java.time.LocalDateTime;

public class RespostaAula extends Aula{
    private String nomeTurma;

    public RespostaAula(int id, String nomeTurma, LocalDateTime dataHora, String assunto) {
        super(id, assunto, dataHora);
        this.nomeTurma = nomeTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
}
