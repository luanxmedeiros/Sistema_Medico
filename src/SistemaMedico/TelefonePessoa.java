package SistemaMedico;

import java.util.Objects;

public class TelefonePessoa {
    private int id_fone;
    private String telefone;
    private int id_pessoa;
    
    public TelefonePessoa(){
    }
    
    public TelefonePessoa(int id_fone, String telefone, int id_pessoa){
        this.id_fone = id_fone;
        this.telefone = telefone;
        this.id_pessoa = id_pessoa;
    }

    public int getId_fone() {
        return id_fone;
    }

    public void setId_fone(int id_fone) {
        this.id_fone = id_fone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        hash = 37 * hash + this.id_fone;
        hash = 37 * hash + Objects.hashCode(this.telefone);
        hash = 37 * hash + this.id_pessoa;
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
        final TelefonePessoa other = (TelefonePessoa) obj;
        if (this.id_fone != other.id_fone) {
            return false;
        }
        if (this.id_pessoa != other.id_pessoa) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        return true;
    }

}
