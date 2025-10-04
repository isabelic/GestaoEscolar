package repository;

import Conexao.Conexao;
import model.Aluno;

import java.net.ConnectException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class alunoDAO {

        public Aluno inserirAluno (Aluno aluno) throws SQLException{
             String sql = "INSERT INTO aluno(nome,email,matricula,data_nascimento) VALUES(?,?,?,?)";



             try(Connection conn = Conexao.conectar();
                 PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

                 st.setString(1,aluno.getNome());
                 st.setString(2, aluno.getEmail());
                 st.setString(3,aluno.getMatricula());
                 st.setDate(4,aluno.getData_nascimento());
                 st.executeUpdate();


                 ResultSet rt =  st.getGeneratedKeys();

                 if(rt.next()){
                     aluno.setId(rt.getInt(1));
                 }

             }

             return aluno;
        }


        public List<Aluno> listarTodosAlunos() throws  SQLException{
            List<Aluno> alunos = new ArrayList<>();

            String sql = "SELECT id,nome,email,matricula,data_nascimento FROM aluno";

            try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){

                ResultSet rt = st.executeQuery();

                while(rt.next()){
                    int id = rt.getInt("id");
                    String nome = rt.getString("nome");
                    String email = rt.getString("email");
                    String matricula = rt.getString("matricula");
                    Date data_nascimento = rt.getDate("data_nascimento");


                    var aluno = new Aluno(id,nome,email,matricula,data_nascimento);
                    alunos.add(aluno);
                }
            }

            return alunos;

        }


        public Aluno  buscarAlunoPorId(int id) throws SQLException{
            String sql= "SELECT id,nome,email,matricula FROM aluno WHERE id = ?";



            try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){

                st.setInt(1,id);
                ResultSet rt = st.executeQuery();

                if(rt.next()){
                     int  newID = rt.getInt("id");
                    String nome = rt.getString("nome");
                    String  email = rt.getString("email");
                    String matricula = rt.getString("matricula");

                }
            }

            return null;
        }

        public boolean alunoExistePorId (int id) throws  SQLException{
            String sql = "SELECT id FROM aluno WHERE id = ?";

            try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){

                st.setInt(1,id);

                ResultSet rt = st.executeQuery();

                if(rt.next()){
                    return  true;
                }
            }
            return  false;

        }



        public void atualizarAlunos(Aluno aluno) throws  SQLException{
            String sql = "UPDATE aluno SET nome =? , email = ?,  matricula =? ,  data_nascimento = ? WHERE id = ? ";


            try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){

                st.setString(1, aluno.getNome());
                st.setString(2, aluno.getEmail());
                st.setString(3, aluno.getMatricula());
                st.setDate(4,aluno.getData_nascimento());
                st.setInt(5, aluno.getId());
                st.executeUpdate();
            }
        }


        public void deletarAluno (int id) throws SQLException{
            String sql = "DELETE FROM aluno WHERE id = ?";

            try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){

                st.setInt(1,id);
                st.executeUpdate();


            }
        }

        public boolean alunonaoExiste(int id)throws  SQLException {
            String sql = "SELECT nome FROM aluno WHERE id = ?";

            try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){
                st.setInt(1,id);

                ResultSet rt = st.executeQuery();


                if(rt.next()){
                    return true;
                }
            }

            return  false;
        }

}
