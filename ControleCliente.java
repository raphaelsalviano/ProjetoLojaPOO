package br.com.ufpb.LojaDeRoupas.POO;

import java.util.ArrayList;

public class ControleCliente {
    
    private ArrayList<Cliente> clientes;
    
    ControleCliente(){
    	clientes = new ArrayList<Cliente>();
    }
    
    public void addClientes(Cliente c){
        clientes.add(c);
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    
    public void removerClientes(Cliente c){
        clientes.remove(c);
    }
    
    public boolean validarCliente(String nome){
        for(Cliente c: clientes){
            if(nome.equalsIgnoreCase(c.getNome())){
                return true;
            }
        }
        return false;
    }
    
    public String pesquisarCpfPorNome(String nome){
        for(Cliente c : clientes){
            if(nome.equalsIgnoreCase(c.getNome())){
                return c.getCpf();
            }
        }
        return null;
    }
    
    public String pesquisarNomePorCpf(String cpf){
        for(Cliente c : clientes){
            if(cpf.equals(c.getCpf())){
                return c.getNome();
            } 
        }
        return null;
    }
}
