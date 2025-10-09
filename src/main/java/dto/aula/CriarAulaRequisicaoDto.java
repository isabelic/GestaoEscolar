package dto.aula;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record CriarAulaRequisicaoDto (

        @NotNull(message = "O id da turma é obrigatório!")
        @Positive(message = "O id precisa ser maior que zero!")
       int turmaId,


       @NotBlank (message = "Data e hora são obrigatórios!")
       LocalDateTime dataHora,

       @NotBlank(message = "O assunto é obrigatório!")
       String assunto

        ){




}
