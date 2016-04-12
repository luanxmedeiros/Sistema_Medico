package SistemaMedico;

import java.util.Objects;

public class PacienteProfessor extends Pessoa{
    private int matricula_professor;
    private String turno;
    private String data_contrato;
    private String disciplina;
    private int id_pessoa;

    public PacienteProfessor(){
    }
    
    public PacienteProfessor(int matricula_professor, String turno, String data_contrato, String disciplina, int id_pessoa){
        this.matricula_professor = matricula_professor;
        this.turno = turno;
        this.data_contrato = data_contrato;
        this.disciplina = disciplina;
        this.id_pessoa = id_pessoa;
    }

    public int getMatricula_professor() {
        return matricula_professor;
    }

    public void setMatricula_professor(int matricula_professor) {
        this.matricula_professor = matricula_professor;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getData_contrato() {
        return data_contrato;
    }

    public void setData_contrato(String data_contrato) {
        this.data_contrato = data_contrato;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.matricula_professor;
        hash = 79 * hash + Objects.hashCode(this.turno);
        hash = 79 * hash + Objects.hashCode(this.data_contrato);
        hash = 79 * hash + Objects.hashCode(this.disciplina);
        hash = 79 * hash + this.id_pessoa;
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
        final PacienteProfessor other = (PacienteProfessor) obj;
        if (this.matricula_professor != other.matricula_professor) {
            return false;
        }
        if (this.id_pessoa != other.id_pessoa) {
            return false;
        }
        if (!Objects.equals(this.turno, other.turno)) {
            return false;
        }
        if (!Objects.equals(this.data_contrato, other.data_contrato)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        return true;
    }
}
