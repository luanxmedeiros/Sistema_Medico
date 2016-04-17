package SistemaMedico;

import java.util.Objects;

public class Agendamento {
    private int id_prontuario;    
    private String data_hora;
    private String para;

    public Agendamento() {
    }

    public Agendamento(int id_prontuario, String data_hora, String para) {
        this.id_prontuario = id_prontuario;        
        this.data_hora = data_hora;
        this.para = para;
    }

    public int getId_agendamento() {
        return id_prontuario;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_prontuario = id_agendamento;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }    

    public int getId_prontuario() {
        return id_prontuario;
    }

    public void setId_prontuario(int id_prontuario) {
        this.id_prontuario = id_prontuario;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }
}
