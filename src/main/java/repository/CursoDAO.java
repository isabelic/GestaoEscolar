package repository;

import Conexao.Conexao;
import model.Curso;

import java.sql.*;

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

    }
}
