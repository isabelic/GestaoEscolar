package model;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class Aula {

    int id;
    int turma_id;

    LocalDateTime data_hora;

    String assunto;

    public Aula(int id, int turma_id, LocalDateTime data_hora, String assunto) {
        this.id = id;
        this.turma_id = turma_id;
        this.data_hora = data_hora;
        this.assunto = assunto;
    }
    public Aula(int id,String assunto, LocalDateTime data_hora ) {
        this.id = id;
        this.assunto = assunto;
         this.data_hora = data_hora;
    }

    public Aula( int turma_id, LocalDateTime data_hora, String assunto) {
        this.turma_id = turma_id;
        this.data_hora = data_hora;
        this.assunto = assunto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(int turma_id) {
        this.turma_id = turma_id;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;

    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
