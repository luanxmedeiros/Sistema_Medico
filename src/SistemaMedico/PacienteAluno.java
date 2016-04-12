package SistemaMedico;

import java.util.Objects;

public class PacienteAluno extends Pessoa{
    private int matricula_aluno;
    private String turma;
    private String curso;
    private String turno;
    private int id_pessoa;
    
    public PacienteAluno(){
    }
    
    public PacienteAluno(int matricula_aluno, String turma, String curso, String turno, int id_pessoa){
        this.matricula_aluno = matricula_aluno;
        this.turma = turma;
        this.curso = curso;
        this.turno = turno;
        this.id_pessoa = id_pessoa;
    }

    public int getMatricula_aluno() {
        return matricula_aluno;
    }

    public void setMatricula_aluno(int matricula_aluno) {
        this.matricula_aluno = matricula_aluno;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.matricula_aluno;
        hash = 43 * hash + Objects.hashCode(this.turma);
        hash = 43 * hash + Objects.hashCode(this.curso);
        hash = 43 * hash + Objects.hashCode(this.turno);
        hash = 43 * hash + this.id_pessoa;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PacienteAluno other = (PacienteAluno) obj;
        if (this.matricula_aluno != other.matricula_aluno) {
            return false;
        }
        if (this.id_pessoa != other.id_pessoa) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }
}
