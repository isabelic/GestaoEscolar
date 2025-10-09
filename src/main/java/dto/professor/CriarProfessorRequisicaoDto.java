package dto.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarProfessorRequisicaoDto(

        @NotBlank (message = "O nome é obrigatório!")
        String nome,

        @Email(message = "Email inválido!")
        @NotBlank(message = "O email é obrigatório")
        String email,


        @NotBlank(message = "A disciplina é obrigatória")
        String disciplina
) {
}
