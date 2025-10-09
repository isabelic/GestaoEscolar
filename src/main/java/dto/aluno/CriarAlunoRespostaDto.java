package dto.aluno;

import java.time.LocalDate;

public record CriarAlunoRespostaDto(
        int id,
        String nome,
        String email,

        String Matricula,
        LocalDate dataNascimento
) {

}
