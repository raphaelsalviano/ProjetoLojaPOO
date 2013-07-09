package br.com.ufpb.LojaDeRoupas.POO;

public class Assalariado extends Funcionario {
    
    private double comissao;
    
    public void setComissao(double comissao){
        this.comissao = comissao;
    }
    
    public double getComissao(){
        return comissao;
    }
    
    public double calcularSalario(){
        return getSalario() + comissao;
    }

}
