package repository;

import Conexao.Conexao;
import model.Curso;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.validation.method.ParameterErrors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {


    public Curso inserirCurso(Curso curso) throws SQLException{
        String sql = "INSERT INTO curso(nome,codigo) VALUES(?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            st.setString(1, curso.getNome());
            st.setString(2, curso.getCodigo());
            st.executeUpdate();


            ResultSet rt = st.getGeneratedKeys();

            if(rt.next()){
                curso.setId(rt.getInt(1));
            }

        }
            return curso;
    }



    public List<Curso> listarTodosCursos (Curso curso) throws  SQLException{
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT id,nome,codigo FROM curso";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            ResultSet rt = st.executeQuery();
            while(rt.next()){
                int idCurso = rt.getInt("id");
                String nome = rt.getString("nome");
                String codigo = rt.getString("codigo");


                var newCurso = new Curso(idCurso,nome,codigo);
                cursos.add(newCurso);
            }

        }
        return cursos;
    }

    public Curso buscarCursoPoID (int id) throws SQLException {
        String sql = "SELECT id,nome,codigo FROM curso WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            ResultSet rt = st.executeQuery();

            if(rt.next()){
                int newID = rt.getInt("id");
                String nome = rt.getString("nome");
                String codigo = rt.getString("codigo");


            }
        }

        return null;
    }



    public boolean cursoExistePorID(int id) throws SQLException{
        String sql = "SELECT id FROM curso WHERE id = ?";

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


    public void atualizarCurso(Curso curso) throws  SQLException{
        String sql = "UPDATE curso SET nome = ? , codigo = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setString(1,curso.getNome());
            st.setString(2,curso.getCodigo());
            st.executeUpdate();

        }


    }


    public void deletarCurso(int id)throws SQLException{


        String sql="DELETE FROM curso WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            st.executeUpdate();

        }
    }



    public boolean cursoNaoExiste(int id) throws  SQLException{

        String sql = "SELECT nome FROM curso WHERE id = ? ";


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
}
