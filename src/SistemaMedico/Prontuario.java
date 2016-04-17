package SistemaMedico;

import java.util.Objects;

public class Prontuario {
    private int id_prontuario;
    private String sexo;
    private int idade;
    private String exame_fisico;
    private int id_pessoa;

    public Prontuario() {
    }

    public Prontuario(String sexo, int idade, String exame_fisico, int id_pessoa) {        
        this.sexo = sexo;
        this.idade = idade;
        this.exame_fisico = exame_fisico;
        this.id_pessoa = id_pessoa;
    }

    public int getId_prontuario() {
        return id_prontuario;
    }

    public void setId_prontuario(int id_prontuario) {
        this.id_prontuario = id_prontuario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getExame_fisico() {
        return exame_fisico;
    }

    public void setExame_fisico(String exame_fisico) {
        this.exame_fisico = exame_fisico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id_prontuario;
        hash = 31 * hash + Objects.hashCode(this.sexo);
        hash = 31 * hash + this.idade;
        hash = 31 * hash + Objects.hashCode(this.exame_fisico);
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
        final Prontuario other = (Prontuario) obj;
        if (this.id_prontuario != other.id_prontuario) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.exame_fisico, other.exame_fisico)) {
            return false;
        }
        return true;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    
}
