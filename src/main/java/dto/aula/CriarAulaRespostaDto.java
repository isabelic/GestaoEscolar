package dto.aula;

import java.time.LocalDateTime;

public record CriarAulaRespostaDto (
        int id,
        String nomeTurma,
        LocalDateTime dataHora,

        String assunto

){


}
