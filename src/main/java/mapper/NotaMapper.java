package mapper;

import dto.nota.CriarNotaRequisicaoDto;
import model.Nota;
import model.NotaResposta;

public class NotaMapper {

    public Nota paraEntidade (CriarNotaRequisicaoDto requisicaoDto){
        return new Nota(requisicaoDto.aluno_id(), requisicaoDto.aula_id(), requisicaoDto.valor());

    }

    public NotaResposta paraRespostaDto(NotaResposta nota){
        return new NotaResposta(nota.getId(), nota.getValor(), nota.getAlunoNome(), nota.getAulaAssunto());
    }


    public Nota paraUpdate(Nota nota, CriarNotaRequisicaoDto requisicaoDto){
        if(requisicaoDto.aluno_id() != nota.getAluno_id()){
            nota.setAluno_id(requisicaoDto.aluno_id());
        }


        if(requisicaoDto.aula_id() !=  nota.getAula_id()){
            nota.setAula_id(requisicaoDto.aula_id());
        }

        if(requisicaoDto.valor() != nota.getValor()){
            nota.setValor((requisicaoDto.valor()));
        }

        return nota;
    }

}
