package br.com.ufpb.LojaDeRoupas.POO;

import java.util.ArrayList;

public class ControleProduto {
    
    private ArrayList<Produto> produtos;
    private static int quantidadeTotalProdutos = 0;
    
    public int getQuantidadeTotalProdutos() {
		return quantidadeTotalProdutos;
	}

	ControleProduto(){
        produtos = new ArrayList<Produto>();
    }
    
    public void adicionaProduto(Produto p){
        produtos.add(p);
        quantidadeTotalProdutos++;
    }
    
    public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void removerProduto(Produto p){
       produtos.remove(p);
    }
    
    private int posicaoProduto(Produto p1){
        for(int i = 0; i < produtos.size(); i++){
            if (produtos.get(i).getNome().equalsIgnoreCase(p1.getNome())){
                return i;
            }
        }
        return -1;
    }
    
    private int somarQuantidadeProdutos(Produto p1, Produto p2){
    	return p1.getQuantidadeProduto() + p2.getQuantidadeProduto();
    }
    
    private void mesclarProduto(Produto p1, Produto p2){
        produtos.get(posicaoProduto(p1)).setQuantidadeProduto(somarQuantidadeProdutos(p1, p2));
        removerProduto(p2);
    }
    
    public void verificarDuplicacao(){
        for(int i = 0; i < produtos.size(); i++){
            for (int i2 = 0; i2 < produtos.size(); i2++){
                if (produtos.get(i).getNome().equalsIgnoreCase(produtos.get(i2).getNome()) && i != i2){
                    if(produtos.get(i).equals(produtos.get(i2))){
                        mesclarProduto(produtos.get(i), produtos.get(i2));
                    }
                }
            }
        }
    }
    
    public ArrayList<Produto> pesquisarPorTipoEMarca(String tipo, String marca){
        ArrayList<Produto> produtosTipoMarca = new ArrayList<>();
        for(Produto tm : produtos){
            if(tm.getTipo().equalsIgnoreCase(tipo) && tm.getMarca().equalsIgnoreCase(marca)){
                produtosTipoMarca.add(tm);
            }
        }
        return produtosTipoMarca;
    }
    
    public ArrayList<Produto> pesquisarPorTipo(String tipo){
        ArrayList<Produto> produtosTipo = new ArrayList<Produto>();
        for(Produto t : produtos){
            if(t.getTipo().equalsIgnoreCase(tipo)){
                produtosTipo.add(t);
            }
        }
        return produtosTipo;
    }
    
    public ArrayList<Produto> pesquisarPorMarca(String marca){
        ArrayList<Produto> produtosMarca = new ArrayList<Produto>();
        for(Produto m : produtos){
            if(m.getMarca().equalsIgnoreCase(marca)){
                produtosMarca.add(m);
            }
        }
        return produtosMarca;
    }
    
    public ArrayList<Produto> pesquisarPorTamanho(String tamanho){
        ArrayList<Produto> produtosTamanho = new ArrayList<Produto>();
        for(Produto ta: produtos){
            if(ta.getTamanho().equalsIgnoreCase(tamanho)){
                produtosTamanho.add(ta);
            }
        }
        return produtosTamanho;
    }
    
    public String exibirInformacoesProduto(Produto p){
        int Id = produtos.indexOf(p);
        String informacoes = "\n------------Produto------------\n";
		informacoes += "Nome: "+ produtos.get(Id).getNome()+"\n";
		informacoes += "Preço: "+ String.valueOf(this.produtos.get(Id).getPreco())+"\n";
		informacoes += "Quantidade: "+ String.valueOf(this.produtos.get(Id).getQuantidadeProduto())+"\n";
		informacoes += "Tamanho: "+ produtos.get(Id).getTamanho() + "\n";
		informacoes += "Tipo: "+ produtos.get(Id).getTipo() + "\n";
		return informacoes;
	}
}
