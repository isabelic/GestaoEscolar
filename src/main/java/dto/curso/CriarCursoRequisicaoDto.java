package dto.curso;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Normalized;

import java.util.List;

public record CriarCursoRequisicaoDto(


        @NotBlank(message = "O nome é obrigatório!")
        String nome,

        @NotBlank(message = "O código do curso é obrigatório!")
        String codigo,
        List<String> listaProfessoresIds
) {
}
