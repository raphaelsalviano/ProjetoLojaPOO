package br.com.ufpb.LojaDeRoupas.POO;

import java.util.ArrayList;

public class Loja {
	
	ControleProduto p = new ControleProduto();
	ControleCliente c = new ControleCliente();
	ControleFuncionario f = new ControleFuncionario();

	public void adicionaProduto(Produto p){
		this.p.adicionaProduto(p);
	}
	public void removerProduto(Produto p){
		this.p.removerProduto(p);
	}
	public ArrayList<Produto> pesquisarPorTipoEMarca(String tipo, String marca){
		return p.pesquisarPorTipoEMarca(tipo, marca);
	}
	public ArrayList<Produto> pesquisarPorTipo(String tipo){
		return p.pesquisarPorTipo(tipo);
	}
	public ArrayList<Produto> pesquisarPorMarca(String marca){
		return p.pesquisarPorMarca(marca);
	}
	public ArrayList<Produto> pesquisarPorTamanho(String tamanho){
		return p.pesquisarPorTamanho(tamanho);
	}
	 public void verificarDuplicacao(){
		 this.p.verificarDuplicacao();
	 }
	 public ArrayList<Produto> getProdutos(){
		 return p.getProdutos();
	 }
	 public int getQuantidadeTotalProdutos() {
		 return p.getQuantidadeTotalProdutos();
	 }
	 public void addClientes(Cliente c){
	        this.c.addClientes(c);
	 }
	 public void removerClientes(Cliente c){
		 this.c.removerClientes(c);
	 }
	 public String pesquisarCpfPorNome(String nome){
		 return c.pesquisarCpfPorNome(nome);
	 }
	 public String pesquisarNomePorCpf(String cpf){
		 return c.pesquisarNomePorCpf(cpf);
	 }
	 public boolean validarCliente(String nome){
		 return c.validarCliente(nome);
	 }
	 public ArrayList<Cliente> getClientes(){
		 return c.getClientes();
	 }
	 
	 public void addFuncionarios(Funcionario f){
		 this.f.addFuncionarios(f);
	 }
	 public void removerFuncionarios(Funcionario f){
		 this.f.removerFuncionarios(f);
	 }
	 public String pesquisarFuncionarioPorMatricula(String matricula){
		 return f.pesquisarFuncionarioPorMatricula(matricula);
	 }
	 public boolean verificarFuncinario(String nome){
		 return f.verificarFuncinario(nome);
	 }
	 public double pesquisarSalario(String nome){
		 return f.pesquisarSalario(nome);
	 }
	 public String informarMatricula(String nome){
		 return f.informarMatricula(nome);
	 }
	 public ArrayList<Funcionario> getFuncionarios(){
		 return f.getFuncionarios();
	 }
	 
}
