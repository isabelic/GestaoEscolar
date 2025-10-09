package dto.nota;

import jakarta.validation.constraints.*;

public record CriarNotaRequisicaoDto(
        @NotNull(message = "O id do aluno é obrigatório!")
        @Positive(message = "O id deve ser maior que zero!")
        int aluno_id,
        @NotBlank(message = "O id da aula é obrigatório!")
        @Positive(message = "O id deve ser maior que zero!")
        int aula_id,
        @NotBlank(message = "A nota é obrigatório!!")
       @PositiveOrZero(message = "A nota não pode ser menor que 0!")
        @Max(value = 10, message = "A nota não pode ser maior que 10!")
        double valor
) {
}
