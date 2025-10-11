package mapper;

import dto.curso.CriarCursoRequisicaoDto;
import dto.curso.CriarCursoRespostaDto;
import jakarta.validation.Valid;
import model.Curso;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
public class CursoMapper {

    public Curso paraEntidade (CriarCursoRequisicaoDto requisicaoDto){
        return new Curso(requisicaoDto.nome(),requisicaoDto.codigo());
    }


    public CriarCursoRespostaDto paraRespostaDto(Curso curso, List<String> professores){
      return new CriarCursoRespostaDto((curso.getId()),
              curso.getNome(), curso.getCodigo(),professores);
    }



    public Curso paraUpdate(CriarCursoRequisicaoDto requisicaoDto, Curso curso){
        if(!requisicaoDto.nome().equals(curso.getNome()) && requisicaoDto.nome() != null){
            curso.setNome(requisicaoDto.nome());
        }

        if(!requisicaoDto.codigo().equals(curso.getCodigo()) && requisicaoDto.codigo() != null){
             curso.setCodigo((requisicaoDto.codigo()));
        }
        return curso;
    }

}
