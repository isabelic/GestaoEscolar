package mapper;

import dto.professor.CriarProfessorRequisicaoDto;
import dto.professor.CriarProfessorRespostaDto;
import model.Professor;

import javax.sound.sampled.Port;

public class ProfessorMapper {
    public Professor paraEntidade(CriarProfessorRequisicaoDto requisicaoDto){
        return new Professor(requisicaoDto.nome(),
                requisicaoDto.email(),
                requisicaoDto.disciplina());
    }


    public CriarProfessorRespostaDto paraRespostaDto(Professor professor){
        return new CriarProfessorRespostaDto(professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina());
    }


    public Professor paraUpdate(CriarProfessorRequisicaoDto requisicaoDto, Professor professor){
        if(!requisicaoDto.nome().equals(professor.getNome()) && requisicaoDto.nome() != null){
            professor.setNome((requisicaoDto.nome()));
        }

        if(!requisicaoDto.email().equals(professor.getEmail()) && requisicaoDto.email() != null){
            professor.setEmail(requisicaoDto.email());
        }

        if(!requisicaoDto.disciplina().equals(professor.getDisciplina()) && requisicaoDto.disciplina() != null){
            professor.setDisciplina(requisicaoDto.disciplina());
        }

        return professor;
    }
}
