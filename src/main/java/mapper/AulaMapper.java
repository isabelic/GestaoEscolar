package mapper;

import dto.aula.CriarAulaRequisicaoDto;
import dto.aula.CriarAulaRespostaDto;
import model.Aula;
import model.RespostaAula;
import org.springframework.stereotype.Component;

@Component
public class AulaMapper  {

        public Aula paraEntidade(CriarAulaRequisicaoDto requisicaoDto){
        return  new Aula(requisicaoDto.turmaId(),requisicaoDto.dataHora(),requisicaoDto.assunto());
        }

        public CriarAulaRespostaDto paraRespostaDto(RespostaAula aula){
            return new CriarAulaRespostaDto(aula.getId(),
                    aula.getNomeTurma(),
                    aula.getData_hora(),
                    aula.getAssunto());
        }


        public Aula paraUpdate(CriarAulaRequisicaoDto requisicaoDto, Aula aula){
        if(requisicaoDto.turmaId() != aula.getTurma_id() && requisicaoDto.turmaId() != 0){
                aula.setId(requisicaoDto.turmaId());
        }

        if(requisicaoDto.dataHora() != aula.getData_hora() && requisicaoDto.dataHora() != null){
            aula.setData_hora(requisicaoDto.dataHora());
        }

        if(requisicaoDto.assunto() != aula.getAssunto() && requisicaoDto.assunto() != null){
            aula.setAssunto(requisicaoDto.assunto());
        }
        return aula;

        }
}
