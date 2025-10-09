package dto.curso;

import java.util.List;

public record CriarCursoRespostaDto(
        int id,
        String nome,
        String codigo,
        List<String> listaProfessores
) {
}
