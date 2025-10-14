package mapper;

import dto.turma.CriarTurmaRequisicaoDto;
import dto.turma.CriarTurmaRespostaDto;
import model.Turma;
import model.TurmaResposta;

import java.util.List;

public class TurmaMapper {

    public Turma paraEntidade(CriarTurmaRequisicaoDto requisicaoDto){
        return new Turma(requisicaoDto.nome(), requisicaoDto.curso_id(), requisicaoDto.professor_id());
    }

    public CriarTurmaRespostaDto paraRespostaDto(TurmaResposta turma, List<String> alunos){
       return new CriarTurmaRespostaDto(turma.getId(), turma.getNome(), turma.getNomeCurso(), turma.getNomeProfessor(), alunos);

    }



    public Turma paraUpdate(CriarTurmaRequisicaoDto requisicaoDto, Turma turma){
        if(!requisicaoDto.nome().equals(turma.getNome()) && turma.getNome().isEmpty()){
            turma.setNome(requisicaoDto.nome());
        }
         if (requisicaoDto.curso_id() != turma.getCurso_id()){
             turma.setCurso_id(requisicaoDto.curso_id());
         }
         if(requisicaoDto.professor_id() != turma.getProfessor_id()){
             turma.setProfessor_id(requisicaoDto.professor_id());
         }
        return turma;
    }

}
