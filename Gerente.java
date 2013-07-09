package br.com.ufpb.LojaDeRoupas.POO;

public class Gerente extends Funcionario {
    
    private double salarioExtra;
    
    public void setSalarioExtra (double salarioExtra){
        this.salarioExtra = salarioExtra;
    }
    
    public double getsalarioExtra() {
        return salarioExtra;
    }
    
    public double calcularSalario(){
        return getSalario() + salarioExtra;
    }
}
