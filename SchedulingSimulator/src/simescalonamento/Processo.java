/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simescalonamento;

/**
 *
 * @author tadeu
 */
public class Processo {
    private int tempoRestante;
    private int tempoNecessario;
    private int tempoEspera;
    private String nome;
    private int turnaround = 0;
    
    public Processo(int tempoNecessario, String nome) {
        this.tempoNecessario = tempoNecessario;
        this.tempoRestante = tempoNecessario;
        this.nome = nome;
        this.tempoEspera = 0;
    }
    /**
     * Extrai [ nome - tempoRestante - tempo de espera ]
     * @return Texto contendo [ nome - tempoRestante - tempo de espera ]
     */
    @Override
    public String toString(){
        return "NOME: "+ nome + " - RESTANDO: " + Integer.toString(tempoRestante) + " - TURNAROUND: "+turnaround+" - ESPERA: " + 
                Integer.toString(tempoEspera)+"\n";
    }
            
    public int getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(int tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public void decTempoRestante(){
        this.tempoRestante--;
    }
   
    public void decTempoRestanteRR(){
        this.tempoRestante --;        
    }

    public void decTempoRestanteRR2(){
        
        this.tempoRestante = 0;
    }    
    public int getTempoNecessario() {
        return tempoNecessario;
    }

    public void setTempoNecessario(int tempoNecessario) {
        this.tempoNecessario = tempoNecessario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoConsumido(){
        return this.tempoNecessario - this.tempoRestante;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }
    
    public void incTempoEspera() {
        this.tempoEspera++;
    }

    public void incTempoEsperaRR() {
        this.tempoEspera++;
    }

    public void incTempoEsperaRR2(int i) {
        this.tempoEspera += i;
    }     
    /**
     * Retorna tempo total do processo desde o inicio até o fim de sua execução.
     * caso o processo ainda não tenha terminado retorna 0
     * @return 0 caso o processo ainda não terminou ou 
     * tempoDeEspera + tempoConsumido pelo processo se o processo terminou
     */
    public int getTempoTurnaround(){
        //se o processo ainda nao acabou
        if (tempoRestante != 0) return 0;
        return tempoEspera + getTempoConsumido();
    }
    
    public void incTurnaround(int i)
    {
        turnaround = i;
    }
    
    public void incTurnaroundRR2(int i)
    {
        turnaround += i;
    }    
        public void incTurnaroundRR()
    {
        turnaround++;
    }
    
}
