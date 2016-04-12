package SistemaMedico;

import java.util.Objects;

public class Emergencia {
    private int id_emergencia;
    private String data;

    public Emergencia() {
    }

    public Emergencia(int id_emergencia, String data) {
        this.id_emergencia = id_emergencia;
        this.data = data;
    }

    public int getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(int id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_emergencia;
        hash = 97 * hash + Objects.hashCode(this.data);
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
        final Emergencia other = (Emergencia) obj;
        if (this.id_emergencia != other.id_emergencia) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    
}
