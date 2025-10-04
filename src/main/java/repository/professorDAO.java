package repository;

import Conexao.Conexao;
import model.Professor;
import org.springframework.boot.context.event.SpringApplicationEvent;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class professorDAO {

    public Professor inserirProf(Professor prof) throws SQLException{
        String sql = "INSERT INTO professor(nome,email,disciplina) VALUES(?,?,?)";


        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            st.setString(1, prof.getNome());
            st.setString(2, prof.getEmail());
            st.setString(3, prof.getDisciplina());
            st.executeUpdate();


            ResultSet rt = st.getGeneratedKeys();


            if(rt.next()){
                prof.setId(rt.getInt(1));
            }
        }

        return prof;

    }


    public List<Professor> listarTodosProfessores(int id) throws  SQLException{
        List<Professor> profes = new ArrayList<>();
        String sql = "SELECT id, nome,email,disciplina FROM professor";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            ResultSet rt = st.executeQuery();

            while(rt.next()){
                int idP = rt.getInt("id");
                String nomeP = rt.getString("nome");
                String emailP = rt.getString("email");
                String disciplinaP = rt.getString("disciplina");

                var prof = new Professor(idP,nomeP,emailP,disciplinaP);
                profes.add(prof);

            }
        }
            return profes;
    }


    public Professor buscarProfessorPorId (int id) throws  SQLException{

        String sql = "SELECT id,nome,email,disciplina FROM professor WHERE id = ?";


        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            ResultSet rt = st.executeQuery();

             if(rt.next()){
                int newID = rt.getInt("id");
                String nomeP = rt.getString("nome");
                String emailP =rt.getString("email");
                String disciplinaP = rt.getString("disciplina");
            }
         }
             return null;
    }


    public boolean professorExistePorId(int id)  throws SQLException{

        String sql = "SELECT id FROM professor WHERE id = ? ";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){


            st.setInt(1,id);

            ResultSet rt = st.executeQuery();

            if(rt.next()){
                return true;
            }
        }

        return false;

    }

    public void atualizarProfessor (Professor prof) throws  SQLException{
        String sql = "UPDATE professor SET nome = ? , email = ? , disciplina = ? WHERE id = ?  ";

        try (Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setString(1,prof.getNome());
            st.setString(2,prof.getEmail());
            st.setString(3,prof.getDisciplina());
            st.executeUpdate();
        }
    }


    public void deletarProfessor(int id) throws SQLException {
        String sql = "DELETE FROM professor WHERE id = ? ";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            st.executeUpdate();
        }
    }


    public boolean professorNaoExiste(int id) throws  SQLException{
        String sql = "SELECT nome FROM professor WHERE id = ? ";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            st.executeUpdate();


            ResultSet rt = st.executeQuery();

            if(rt.next()){
                return true;
            }
        }

        return  false;
    }


}