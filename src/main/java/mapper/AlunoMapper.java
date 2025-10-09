package mapper;

import dto.aluno.CriarAlunoRequisicaoDto;
import dto.aluno.CriarAlunoRespostaDto;
import model.Aluno;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
public class AlunoMapper {

    public  Aluno paraEntidade(CriarAlunoRequisicaoDto requisicaoDto){
        return  new Aluno(requisicaoDto.nome(),
                requisicaoDto.email(),
                requisicaoDto.matricula(),
                requisicaoDto.dataNascimento());
    }


    public CriarAlunoRespostaDto paraRespostaDto(Aluno aluno){
        return new CriarAlunoRespostaDto(aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getDataNascimento());
    }


    public Aluno paraUpdate(CriarAlunoRequisicaoDto requisicaoDto, Aluno aluno){
        if(!requisicaoDto.nome().equals(aluno.getNome()) && requisicaoDto.nome() != null){
            aluno.setNome(requisicaoDto.nome());
        }

        if(!requisicaoDto.email().equals(aluno.getEmail()) && requisicaoDto.email() != null){
            aluno.setEmail(requisicaoDto.email());
        }

        if(requisicaoDto.matricula().equals(aluno.getMatricula()) && requisicaoDto.matricula() != null){
            aluno.setMatricula(requisicaoDto.matricula());
        }

        if(requisicaoDto.dataNascimento() != aluno.getDataNascimento() && requisicaoDto.dataNascimento() != null){
            aluno.setData_nascimento(requisicaoDto.dataNascimento());
        }
        return aluno;
    }
}
