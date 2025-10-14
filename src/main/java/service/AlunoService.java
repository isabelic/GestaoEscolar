package service;

import dto.aluno.CriarAlunoRequisicaoDto;
import dto.aluno.CriarAlunoRespostaDto;
import mapper.AlunoMapper;
import model.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import repository.AlunoDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AlunoService {
    private AlunoDAO repository;
    private AlunoMapper mapper;


    public AlunoService(AlunoDAO repository, AlunoMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CriarAlunoRespostaDto> listarAlunos()throws SQLException{
        return repository.listarTodosAlunos()
                .stream()
                .map(mapper::paraRespostaDto)
                .toList();
    }


   public CriarAlunoRespostaDto buscarAlunoPorID(int id) throws  SQLException{
        Aluno aluno = repository.buscarAlunoPorId(id);

        if(aluno == null){
            throw new RuntimeException("Aluno não existe!");
        }

        return mapper.paraRespostaDto(aluno);
   }


   public CriarAlunoRespostaDto criarAluno(CriarAlunoRequisicaoDto requisicaoDto) throws SQLException{
        return mapper.paraRespostaDto(repository.inserirAluno(mapper.paraEntidade(requisicaoDto)));
   }

   public CriarAlunoRespostaDto atualizar(int id, CriarAlunoRequisicaoDto requisicaoDto) throws SQLException{
        Aluno aluno = repository.buscarAlunoPorId(id);

        if(aluno == null) {
            throw new RuntimeException("Aluno não existe!");
        }

        Aluno newAluno = mapper.paraUpdate(requisicaoDto, aluno);
        repository.atualizarAlunos(id,newAluno);
        return mapper.paraRespostaDto(newAluno);
   }


   public void excluir(int id)throws SQLException{
        Aluno aluno = repository.buscarAlunoPorId(id);

        if(aluno == null){
            throw new RuntimeException("Aluno não existe!");
        }
        repository.deletarAluno(id);
   }
}
