package SistemaMedico;

import java.util.Objects;

public class ProfissionalNutricionista {
    private double salario;
    private String horario;
    private String crn;
    private int id_pessoa;

    public ProfissionalNutricionista() {
    }

    public ProfissionalNutricionista(double salario, String horario, String crn, int id_pessoa) {
        this.salario = salario;
        this.horario = horario;
        this.crn = crn;
        this.id_pessoa = id_pessoa;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.horario);
        hash = 67 * hash + Objects.hashCode(this.crn);
        hash = 67 * hash + this.id_pessoa;
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
        final ProfissionalNutricionista other = (ProfissionalNutricionista) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (this.id_pessoa != other.id_pessoa) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.crn, other.crn)) {
            return false;
        }
        return true;
    }
}
