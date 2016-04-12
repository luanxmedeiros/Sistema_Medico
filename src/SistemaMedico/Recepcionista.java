package SistemaMedico;

import java.util.Objects;

public class Recepcionista extends Pessoa{
    private int id_recepcionista;
    private String login;
    private String senha;
    private String horario;
    private int id_pessoa;

    public Recepcionista(){
    }
    
    public Recepcionista(int id_recepcionista, String login, String senha, String horario, int id_pessoa) {
        this.login = login;
        this.senha = senha;
        this.horario = horario;
        this.id_pessoa = id_pessoa;
    }

    public int getId_recepcionista() {
        return id_recepcionista;
    }

    public void setId_recepcionista(int id_recepcionista) {
        this.id_recepcionista = id_recepcionista;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
        hash = 53 * hash + this.id_recepcionista;
        hash = 53 * hash + Objects.hashCode(this.login);
        hash = 53 * hash + Objects.hashCode(this.senha);
        hash = 53 * hash + Objects.hashCode(this.horario);
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
        final Recepcionista other = (Recepcionista) obj;
        if (this.id_recepcionista != other.id_recepcionista) {
            return false;
        }
        if (this.id_pessoa != other.id_pessoa) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }
}