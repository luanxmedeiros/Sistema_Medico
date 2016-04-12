package SistemaMedico;

import java.util.Objects;

public class ProfissionalDentista {
    private double salario;
    private String horario;
    private String cro;
    private int id_pessoa;

    public ProfissionalDentista() {
    }

    public ProfissionalDentista(double salario, String horario, String cro, int id_pessoa) {
        this.salario = salario;
        this.horario = horario;
        this.cro = cro;
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

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
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
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.horario);
        hash = 83 * hash + Objects.hashCode(this.cro);
        hash = 83 * hash + this.id_pessoa;
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
        final ProfissionalDentista other = (ProfissionalDentista) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (this.id_pessoa != other.id_pessoa) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.cro, other.cro)) {
            return false;
        }
        return true;
    }
}
