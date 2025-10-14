package dto.nota;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CriarNotaRespostaDto(
        int id,
        String  alunoNome,
        String  alunoAssunto,
        double valor

) {
}
