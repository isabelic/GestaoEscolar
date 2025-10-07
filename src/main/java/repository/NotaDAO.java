package repository;

import Conexao.Conexao;
import model.Nota;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotaDAO {

    public Nota inserirNota (Nota nota) throws SQLException{

        String sql = "INSERT INTO nota(aluno_id,aula_id,valor) VALUES(?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            st.setInt(1,nota.getAluno_id());
            st.setInt(2,nota.getAula_id());
            st.setDouble(3,nota.getValor());

            ResultSet rt = st.getGeneratedKeys();

            if(rt.next()){
                nota.setId(rt.getInt(1));
            }
        }
        return nota;
    }




    public List<Nota> buscarTodasNotas() throws SQLException{
        List<Nota> notas = new ArrayList<>();

        String sql = "SELECT id, aluno_id,aula_id,valor FROM aula";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            ResultSet rt = st.executeQuery();

            while(rt.next()){
                int newID = rt.getInt("id");
                int alunoID = rt.getInt("aluno_id");
                int aulaID = rt.getInt("aula_id");
                double valor = rt.getDouble("valor");


                var newNota = new Nota(newID,alunoID,aulaID,valor);
                notas.add(newNota);
            }
        }

        return notas;


    }


    public Nota buscarNotaPorID(int id) throws SQLException{
        String sql = "SELECT aluno_id, aula_id, valor FROM nota WHERE id = ?";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            ResultSet rt = st.executeQuery();

            if(rt.next()){
                int newID = rt.getInt("id");
                int alunoID = rt.getInt("aluno_id");
                int aulaID = rt.getInt("aula_id");
                double valor = rt.getDouble("valor");


            }
        }
    return null;

    }

    public boolean notaNaoExistePorID (int id) throws SQLException{
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


    public void atualizarNota (Nota nota) throws  SQLException{

        String sql = "UPDATE nota SET aluno_id = ? , aula_id = ?, valor = ? WHERE id = ?";
        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(2,nota.getAula_id());
            st.setInt(1,nota.getAluno_id());
            st.setDouble(3,nota.getValor());
            st.setInt(4,nota.getId());

        }
    }

    public void deletarNota (int id) throws SQLException{
        String sql = "DELETE FROM curso WHERE id = ? ";

        try(Connection conn = Conexao.conectar();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);

            st.executeUpdate();
        }
    }

    public boolean notaNaoExiste(int id) throws  SQLException{
        String sql = "SELECT aluno_id, aula_id FROM nota WHERE id = ? ";

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
