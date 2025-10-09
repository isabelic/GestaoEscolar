package dto.turma;

import java.util.List;

public record CriarTurmaRespostaDto(
        int id,
        String nome,
        String nomeCurso,
        String nomeProfessor,
        List<String> listaAlunos
) {
}
