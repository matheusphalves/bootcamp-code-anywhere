package part2;

public class QueriesExecution {

    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();

        System.out.println(alunoDAO.list());
        System.out.println(alunoDAO.getById(2));
        //alunoDAO.create(new Aluno("Joel", 50, "SC"));
        //alunoDAO.delete(4);
        Aluno alunoNovo = alunoDAO.getById(1);
        alunoNovo.setNome("Jéssica");
        alunoNovo.setIdade(25);
        alunoNovo.setEstado("MT");
        alunoDAO.update(alunoNovo);
    }
}
