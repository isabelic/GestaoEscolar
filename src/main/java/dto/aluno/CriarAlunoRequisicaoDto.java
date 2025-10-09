package dto.aluno;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CriarAlunoRequisicaoDto(
        @NotBlank(message = "nome inváido!")
        String nome,

        @Email(message = "Email inválido")
                @NotBlank(message = "O email é obrigatório")
        String email,

        @NotBlank(message = "A matricula  é obrigatória!")
        String matricula,

        @NotBlank(message = "A data é obrigatória!")
        @Past(message = "A data é inválida!")
        LocalDate dataNascimento



) {
}
