package repository;

import Conexao.Conexao;
import model.Turma;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {


    public Turma inserirTurma(Turma turma) throws SQLException{
        String sql ="INSERT INTO turma(nome,curso_id,professor_id) VALUES(?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            st.setString(1,turma.getNome());
            st.setInt(2,turma.getCurso_id());
            st.setInt(3,turma.getProfessor_id());
            st.executeUpdate();


            ResultSet rt = st.getGeneratedKeys();

            if(rt.next()){
                turma.setId(rt.getInt(1));
            }
        }

        return turma;
    }


    public List<Turma> listarTodasTurmas(Turma turma) throws SQLException{
        List<Turma> turmas = new ArrayList<>();

        String sql = "SELECT id,nome,curso_id,professor_id FROM turma";


        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            ResultSet rt = st.executeQuery();

            while(rt.next()){
                int id = rt.getInt("id");
                String nome = rt.getString("nome");
                int cursoID = rt.getInt("curso_id");
                int profID = rt.getInt("professor_id");


                var newTurma = new Turma(id,nome,cursoID,profID);
                turmas.add(newTurma);
            }

        }
        return turmas;

    }



    public Turma buscarTurmaPorID (int id) throws SQLException{
        String sql ="SELECT id,nome, curso_id,professor_id FROM turma WHERE id =? ";


        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){
            st.setInt(1,id);

            ResultSet rt = st.executeQuery();

            if(rt.next()){
                int newID = rt.getInt("id");
                String nome = rt.getString("nome");
                int cursoID = rt.getInt("curso_id");
                int professorID = rt.getInt("professor_id");
            }

        }
            return null;
    }




    public  void atualizarTurma(Turma turma) throws SQLException{

        String sql = "UPDATE turma SET nome = ?, curso_id = ?, professor_id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){
             st.setString(1, turma.getNome());
             st.setInt(2,turma.getCurso_id());
             st.setInt(3,turma.getProfessor_id());
             st.setInt(4,turma.getId());
             st.executeUpdate();
        }
    }


    public  void deletar(int id ) throws SQLException{
        String sql = "DELETE FROM turma WHERE id = ? ";


        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            st.executeUpdate();
        }
    }


    public boolean turmaNaoExiste(int id) throws SQLException{
        String sql = "SELECT nome FROM turma WHERE id = ?";

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
}
