package SistemaMedico;

import java.util.Objects;

public class Agendamento {
    private int id_agendamento;
    private String hora_da_consulta;
    private String data;

    public Agendamento() {
    }

    public Agendamento(int id_agendamento, String hora_da_consulta, String data) {
        this.id_agendamento = id_agendamento;
        this.hora_da_consulta = hora_da_consulta;
        this.data = data;
    }

    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public String getHora_da_consulta() {
        return hora_da_consulta;
    }

    public void setHora_da_consulta(String hora_da_consulta) {
        this.hora_da_consulta = hora_da_consulta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_agendamento;
        hash = 53 * hash + Objects.hashCode(this.hora_da_consulta);
        hash = 53 * hash + Objects.hashCode(this.data);
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
        final Agendamento other = (Agendamento) obj;
        if (this.id_agendamento != other.id_agendamento) {
            return false;
        }
        if (!Objects.equals(this.hora_da_consulta, other.hora_da_consulta)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    
}
