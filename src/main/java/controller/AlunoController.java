package controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import dto.aluno.CriarAlunoRequisicaoDto;
import dto.aluno.CriarAlunoRespostaDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AlunoService;

import java.util.List;

@RestController
 @RequestMapping("/aluno")

public class AlunoController {

     /*@PostMapping
     public ResponseEntity<String> testarValidacao(@Valid @ResponseBody CriarAlunoRequisicaoDto requisicaoDto){
         return  ResponseEntity.status(HttpStatus.OK).body("Ola mundo");
     }*/

  private AlunoService service;

     public AlunoController(AlunoService service){
      this.service = service;
     }


     @GetMapping
     public ResponseEntity<List<CriarAlunoRespostaDto>> listarAlunos(){
      try{
       return ResponseEntity.status(HttpStatus.OK).body(service.listarAlunos());
      } catch (Exception e){
       e.printStackTrace();
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
     }

 @GetMapping("/{id}")
 public ResponseEntity<CriarAlunoRespostaDto> buscarAlunoPorId(
         @PathVariable int id
 ){
  try{
   return ResponseEntity.status(HttpStatus.OK).body(service.buscarAlunoPorID(id));
  }catch (Exception e){
   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
           .build();
  }
 }

@PostMapping
 public ResponseEntity<CriarAlunoRespostaDto> criar(@Valid @RequestBody CriarAlunoRequisicaoDto requisicaoDto){
  try {
   return ResponseEntity.status(HttpStatus.CREATED).body(service.criarAluno(requisicaoDto));
  }catch (Exception e){
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}


@PutMapping("/{id}")
 public ResponseEntity<CriarAlunoRespostaDto> atualizar (@PathVariable int id, @Valid @RequestBody CriarAlunoRequisicaoDto requisicaoDto){
      try{
       return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id,requisicaoDto));

      }catch (Exception e){
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
}


@DeleteMapping("/{id}")
 public ResponseEntity<Void> excluir (@PathVariable int id){
      try{
       service.excluir(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      } catch (Exception e){
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
}

}
