package dto.turma;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CriarTurmaRequisicaoDto(

        @NotBlank(message = "O nome é obrigátorio!")
        String nome,

        @NotNull(message = "O id do curso é obrigatório!")
        @Positive(message = "O id precisa ser maior que zero!")
        int curso_id,

        @NotNull(message = "O id do professor é obrigatório!")
        @Positive(message = "O id precisa ser maior que zero!")
        int professor_id,

        List<Integer> listaAlunoIds

) {
}
