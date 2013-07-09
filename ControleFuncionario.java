package br.com.ufpb.LojaDeRoupas.POO;

import java.util.ArrayList;

public class ControleFuncionario {
    private ArrayList<Funcionario> funcionarios;
    
    ControleFuncionario(){
    	funcionarios = new ArrayList<Funcionario>();
    }
    
    public void addFuncionarios(Funcionario f){
        funcionarios.add(f);
    }
    
    public void removerFuncionarios(Funcionario f){
        funcionarios.remove(f);
    }
    
    public ArrayList<Funcionario> getFuncionarios(){
        return funcionarios;
    }
    
    public boolean verificarFuncinario(String nome){
        for(int i = 0; i<funcionarios.size(); i++){
            if(nome.equalsIgnoreCase(funcionarios.get(i).getNome())){
                return true;
            }
        }
        return false;
    }
    
    public String pesquisarFuncionarioPorMatricula(String matricula){
        for(Funcionario m : funcionarios){
            if(matricula.equals(m.getMatricula())){
                return m.getNome();
            }
        }
        return null;
    }
    
    public double pesquisarSalario(String nome){
        for(Funcionario n: funcionarios){
            if(nome.equalsIgnoreCase(n.getNome())){
                return n.getSalario();
            }
        }
        return 0;
    }
    
    public String informarMatricula(String nome){
        for(Funcionario n : funcionarios){
            if(nome.equalsIgnoreCase(n.getNome())){
                return n.getMatricula();
            }
        }
        return null;
    }
}
