/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordememoria;

/**
 *
 * @author Luan Medeiros
 */
public class MelhorPosicao {
    private int base;
    private int limite;
    private int tamanho = 0;

    public MelhorPosicao(int base) {
        this.base = base;
        this.limite = base;        
    }

    public int getTamanho() {
        return tamanho;
    }

    public void incrimentaTamanho() {
        this.tamanho++ ;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getLimite() {
        return limite;
    }

    public void incrimentaLimite() {
        this.limite++;
    }
    
    
    
}
