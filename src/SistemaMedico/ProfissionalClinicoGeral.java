package SistemaMedico;

import java.util.Objects;

public class ProfissionalClinicoGeral {
    private double salario;
    private String horario;
    private String crm;
    private int id_pessoa;

    public ProfissionalClinicoGeral() {
    }

    public ProfissionalClinicoGeral(double salario, String horario, String crm, int id_pessoa) {
        this.salario = salario;
        this.horario = horario;
        this.crm = crm;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
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
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.horario);
        hash = 53 * hash + Objects.hashCode(this.crm);
        hash = 53 * hash + this.id_pessoa;
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
        final ProfissionalClinicoGeral other = (ProfissionalClinicoGeral) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.crm, other.crm)) {
            return false;
        }
        return true;
    }
}
