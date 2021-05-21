package part2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    //1 - CONSULTA
    public List<Aluno> list(){
        List<Aluno> alunos = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "SELECT * from ALUNO";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String estado = rs.getString("estado");

                alunos.add( new Aluno(
                        id,
                        nome,
                        idade,
                        estado
                        ));
            }

        }catch (SQLException e){
            System.out.println("Lista de alunos falhou");
        }
        return alunos;
    }

    //CONSULTA COM FILTRO
    public Aluno getById(int idAluno){
        Aluno aluno = new Aluno();

        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "SELECT * from ALUNO where id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,idAluno);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String estado = rs.getString("estado");
                return new Aluno(id, nome, idade, estado);
            }

        }catch (SQLException e){
            System.out.println("Lista de alunos falhou");
        }
        return aluno;
    }

    //2 - INSERÇÃO
    public void create(Aluno aluno){
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "INSERT INTO ALUNO(NOME, IDADE, ESTADO) VALUES(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());

            int rowsAffected = stmt.executeUpdate();
            System.out.println("INSERÇÃO REALIZADA. LINHAS ADICIONADAS: " + rowsAffected);



        }  catch (SQLException e){
            e.printStackTrace();
        }
    }


    //3 - DELETAR
    public void delete(int id){
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "DELETE FROM ALUNO WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("INSERÇÃO REALIZADA. LINHAS DELETADAS: " + rowsAffected);

        }  catch (SQLException e){
            e.printStackTrace();
        }
    }

    //4 - ATUALIZAR
    public void update(Aluno aluno){
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "UPDATE ALUNO  SET NOME = ?, IDADE = ?, ESTADO = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());
            stmt.setInt(4, aluno.getId());

            int rowsAffected = stmt.executeUpdate();
            System.out.println("UPDATE REALIZADO. LINHAS AFETADAS: " + rowsAffected);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
