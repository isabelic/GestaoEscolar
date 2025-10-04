package repository;

import Conexao.Conexao;
import model.Aula;

import java.io.PipedReader;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class aulaDAO {

    public Aula inserirAula(Aula aula) throws SQLException{
        String sql = "INSERT INTO aula(turma_id, data_hora, assunto) VALUES(?,?,?)";


        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){


            st.setInt(1,aula.getTurma_id());
           st.setObject(2,aula.getData_hora());
           st.setString(3, aula.getAssunto());
           st.executeUpdate();


           ResultSet rt = st.getGeneratedKeys();
           if(rt.next()){
               aula.setId(rt.getInt(1));
           }
        }
        return aula;
    }




    public List<Aula> listarTodasAulas(Aula aula) throws SQLException{

        List<Aula> aulas = new ArrayList<>();

        String sql = "SELECT id, turma_id, data_hora, assunto FROM aula";

        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql)){

            ResultSet rt = st.executeQuery();

            while(rt.next()){

                int id = rt.getInt("id");
                int turmaID = rt.getInt("turma_id");
                LocalDateTime dataHora = rt.getObject("data_hora",LocalDateTime.class);
                String assunto = rt.getString("assunto");


                var newAula = new Aula(id,turmaID,dataHora,assunto);
                aulas.add(newAula);

            }
        }
        return aulas;
    }


    public Aula buscarAulaPorId(int id) throws SQLException{
        String sql = "SELECT id,turma_id,data_hora, assunto FROM aula WHERE id = ? ";


        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){
            st.setInt(1,id);

            ResultSet rt = st.executeQuery();



            if(rt.next()){
                int idA = rt.getInt("id");
                int turmaID = rt.getInt("turma_id");
                LocalDateTime dataHora = rt.getObject("data_hora", LocalDateTime.class);
                String assunto = rt.getString("assunto");
            }
        }

        return null;

    }


    public boolean aulaExistePorID(int id) throws  SQLException{
        String sql = "SELECT id, turma_id, data_hora, assunto FROM  aula  WHERE id = ?";

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


    public void atualizarAula(Aula aula) throws SQLException{
        String sql = "UPDATE aula SET turma_id = ?, data_hora = ? , assunto = ?";


        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,aula.getTurma_id());
            st.setObject(2,aula.getData_hora());
            st.setString(3, aula.getAssunto());

            st.executeUpdate();

        }
    }

    public  void deletarAula (int id) throws  SQLException{

        String sql = "DELETE FROM aula WHERE id = ? ";

        try(Connection conn = Conexao.conectar();

        PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            st.executeUpdate();
        }
    }


    public boolean aulaNaoExiste(int id ) throws  SQLException{
        String sql = "SELECT id FROM aula WHERE id = ?";

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
