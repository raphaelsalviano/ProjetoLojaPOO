package br.com.ufpb.LojaDeRoupas.POO;

public class Produto {
    
    private String nome;
    private String marca;
    private String codigoDeBarra;
    private String tipo;
    private String tamanho;
    private double preco;
    private int quantidadeProduto;
    
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCodigoDeBarra() {
		return codigoDeBarra;
	}
	public void setCodigoDeBarra(String codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTamanho(){
	    return tamanho;
	}
	public void setTamanho(String tamanho){
	    this.tamanho = tamanho;
	   }
		public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

}
