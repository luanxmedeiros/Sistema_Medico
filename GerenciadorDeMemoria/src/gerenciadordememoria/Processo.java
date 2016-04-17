
package gerenciadordememoria;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Luan Medeiros
 */
public class Processo implements Cloneable {
    private String nome;
    private int tamanho = 0;
    private int base = 0;
    private int limite = 0;
    private String local = "";
    private ArrayList<String> espacoMemoria = new ArrayList<>();
    public Processo() 
    {
    
    }        
    
    public Processo(String nome, int tamanho, String local) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.local = local;             
    }

    //Usando clone para faszer o backup do estado do processo.
    @Override
    protected Processo clone()  {
        Processo cloned = null;        
        try {
            cloned = (Processo)super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
        }
        cloned.setEspacoMemoria((ArrayList<String>)cloned.getEspacoMemoria().clone());
        return cloned;
    }
    //Reserva os setores da memória de acordo com o tamanho do processo.
    public void alocaEspacoMemoria() {
        for(int a = 0; a < tamanho; a++)
        {
            espacoMemoria.add(nome);
        }
    }
    //Método para substituir o valor no espaco da memória alocado para o processo
    public void replaceInformacao(String info, int pos) {
        int posMemoria = base;
        for(int x = 0; x < espacoMemoria.size(); x++)
        {    
            if(pos == posMemoria) 
            {
               espacoMemoria.remove(x);
               espacoMemoria.add(x, info);
                break;
            }
            posMemoria++;
        }           
    }            
    //Realoca valores da memória para as novas base e limite.
    public void realocaEspacoMemoria(JTable tabela) {                
        int posMemoria = base;
        for(String info : espacoMemoria)
        {    
            tabela.setValueAt(info, posMemoria, 1);                        
            posMemoria++;
        }        
    }          
   
    //Métodos get
    public String getNome() {
        return nome;
    }
    public int getTamanho() {
        return tamanho;
    }
    public int getBase() {
        return base;
    }
    public int getLimite() {
        return limite;
    }
    public String getLocal() {
        return local;
    }
    public ArrayList<String> getEspacoMemoria() {
        return espacoMemoria;
    }
    
    //Métodos set
    public void setBase(int regisTradorBase) {
        this.base = regisTradorBase;
    }
    public void setLimite(int limite) {
        this.limite = limite;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public void setEspacoMemoria(ArrayList<String> espacoMemoria) {
        this.espacoMemoria = espacoMemoria;
    }    
    
}
