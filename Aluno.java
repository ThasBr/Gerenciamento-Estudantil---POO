import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private String matricula;
    private List<Curso> cursos;

    // Construtor
    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
        this.cursos = new ArrayList<>();
    }

    // Getters e Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    // Métodos para manipulação de dados
    public void cadastrarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void removerCurso(Curso curso) {
        cursos.remove(curso);
    }

    public void editarCurso(Curso cursoAntigo, Curso cursoNovo) {
        int index = cursos.indexOf(cursoAntigo);
        if (index != -1) {
            cursos.set(index, cursoNovo);
        }
    }

    @Override
    public void exibirDados() {
        System.out.println("Estudante: " + getNome() + ", Idade: " + getIdade() + ", Matrícula: " + matricula);
    }
}
