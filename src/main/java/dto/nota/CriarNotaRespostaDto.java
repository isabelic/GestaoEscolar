package dto.nota;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CriarNotaRespostaDto(
        int id,
        int alunoNome,
        int alunoAssunto,
        double valor

) {
}
