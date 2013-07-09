package br.com.ufpb.LojaDeRoupas.POO;

import static org.junit.Assert.*;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class LojaTeste {
	private Cliente cliente;
	private Loja loja;
	private Funcionario funcionario;
	private Produto produto;

	@Before
	public void iniciar() {
		cliente = criarClientePadrao();
		produto = criarProdutoPadrao();
		funcionario = criarFuncionarioPadrao();
		loja = new Loja();
		loja.addClientes(cliente);
		loja.addFuncionarios(funcionario);
	}
	
	/* Teste de
	 * Funciários
	 */
	
	@Test
	public void testAddFuncionarios() {
		Assert.assertTrue(loja.getFuncionarios().contains(funcionario));
	}

	@Test
	public void testRemoveFuncionario() {
		loja.removerFuncionarios(funcionario);
		Assert.assertFalse(loja.getFuncionarios().contains(funcionario));
	}

	@Test
	public void testVerificarFuncinario() {
		Assert.assertTrue(loja.verificarFuncinario("Rodrigo"));
		Assert.assertFalse(loja.verificarFuncinario("Surama"));
	}

	@Test
	public void testPesquisarFuncionarioPorMatricula() {
		Assert.assertEquals(loja.pesquisarFuncionarioPorMatricula(funcionario.getMatricula()),
				funcionario.getNome());
		Assert.assertEquals(loja.pesquisarFuncionarioPorMatricula("00010"),null);
	}

	@Test
	public void testPesquisarSalario() {

		Assert.assertEquals(loja.pesquisarSalario(funcionario.getNome()),funcionario.getSalario());
		Assert.assertEquals(loja.pesquisarSalario("Surama"), 0.0);
	}

	@Test
	public void testInformarMatricula() {
		Assert.assertEquals(loja.informarMatricula(funcionario.getNome()),funcionario.getMatricula());
		Assert.assertEquals(loja.informarMatricula("Surama"), null);
	}

	/* Testes de
	 * Derente
	 */
	
	@Test
	public void testCalculaSalarioGerente() {
		Gerente gerente = new Gerente();
		gerente.setSalario(3000.00);
		gerente.setSalarioExtra(700.00);
		Assert.assertEquals(gerente.calcularSalario(), 3700.00);
	}

	/* Teste de
	 * Produto
	 */
	
	@Test
	public void testInicializarQuantidadeDeProdutosZerada() {
		Assert.assertEquals(loja.getQuantidadeTotalProdutos(), 0);
	}

	@Test
	public void testAdicionaProduto() {
		loja.adicionaProduto(produto);
		Assert.assertEquals(produto, loja.getProdutos().get(0));
	}

	@Test
	public void testRemoverProduto() {
		loja.removerClientes(cliente);
		Assert.assertFalse(loja.getProdutos().contains(produto));
	}

	@Test
	public void testVerificarDuplicacao() {
		loja.adicionaProduto(produto);
		loja.adicionaProduto(produto);
		Assert.assertEquals(loja.getProdutos().size(), 2);
		loja.verificarDuplicacao();
		Assert.assertEquals(loja.getProdutos().size(), 1);
	}

	@Test
	public void testPesquisarPorTipo() {
		ArrayList<Produto> produtosExtra = produtosExtra();
		for (Produto produto : produtosExtra) {
			loja.adicionaProduto(produto);
		}
		ArrayList<Produto> produtosPesquisados = loja.pesquisarPorTipo("Camisa");
		Assert.assertTrue(produtosPesquisados.contains(produtosExtra.get(0)));
		Assert.assertTrue(produtosPesquisados.contains(produtosExtra.get(1)));
		Assert.assertTrue(produtosPesquisados.contains(produtosExtra.get(2)));
		Assert.assertFalse(produtosPesquisados.contains(produtosExtra.get(3)));
	}

	@Test
	public void testPesquisarPorTipoEMarca() {
		ArrayList<Produto> produtosExtra = produtosExtra();
		for (Produto produto : produtosExtra) {
			loja.adicionaProduto(produto);
		}
		ArrayList<Produto> produtosPesquisados = loja.pesquisarPorTipoEMarca("Camisa", "Hering");
		Assert.assertTrue(produtosPesquisados.contains(produtosExtra.get(0)));
		Assert.assertTrue(produtosPesquisados.contains(produtosExtra.get(2)));
		Assert.assertFalse(produtosPesquisados.contains(produtosExtra.get(1)));
		Assert.assertFalse(produtosPesquisados.contains(produtosExtra.get(3)));
	}

	@Test
	public void testPesquisarPorMarca() {
		ArrayList<Produto> produtosExtra = produtosExtra();
		for (Produto produto : produtosExtra) {
			loja.adicionaProduto(produto);
		}
		ArrayList<Produto> produtosPesquisados = loja.pesquisarPorMarca("Hering");
		Assert.assertTrue(produtosPesquisados.contains(produtosExtra.get(0)));
		Assert.assertTrue(produtosPesquisados.contains(produtosExtra.get(2)));
		Assert.assertTrue(produtosPesquisados.contains(produtosExtra.get(3)));
		Assert.assertFalse(produtosPesquisados.contains(produtosExtra.get(1)));
	}

	@Test
	public void testPesquisarPorTamanho() {
		ArrayList<Produto> produtosExtra = produtosExtra();
		for (Produto produto : produtosExtra) {
			loja.adicionaProduto(produto);
		}
		ArrayList<Produto> produtosPesquisados = loja.pesquisarPorTamanho("P");
		Assert.assertTrue(produtosPesquisados.contains(produtosExtra.get(2)));
		Assert.assertTrue(produtosPesquisados.contains(produtosExtra.get(3)));
		Assert.assertFalse(produtosPesquisados.contains(produtosExtra.get(0)));
		Assert.assertFalse(produtosPesquisados.contains(produtosExtra.get(1)));
	}

	/* Teste de
	 * Cliente
	 */
	@Test
	public void testPesquisarCpfPorNome() {
		Assert.assertEquals(cliente.getCpf(),loja.pesquisarCpfPorNome(cliente.getNome()));
		Assert.assertEquals(null, loja.pesquisarCpfPorNome("Surama"));
	}

	@Test
	public void testPesquisarNomePorCpf() {
		Assert.assertEquals(cliente.getNome(),loja.pesquisarNomePorCpf(cliente.getCpf()));
		Assert.assertEquals(null, loja.pesquisarNomePorCpf("094.553.231.12"));
	}

	@Test
	public void testvalidarCliente() {
		Assert.assertTrue(loja.validarCliente("Rodrigo"));
		Assert.assertFalse(loja.validarCliente("Surama"));
	}

	@Test
	public void testAddCliente() {
		Assert.assertEquals(loja.getClientes().get(0), cliente);
	}

	@Test
	public void testRemoverCliente() {
		loja.removerClientes(cliente);
		Assert.assertFalse(loja.getClientes().contains(cliente));
	}

	/* Teste de
	 * Assalariado
	 */
	
	@Test
	public void testCalcularSaladioDeAssalariado() {
		Assalariado assalariado = new Assalariado();
		assalariado.setComissao(300.00);
		assalariado.setSalario(2000.00);
		Assert.assertEquals(assalariado.calcularSalario(), 2300.00);
	}

	/* Métodos
	 * Necessários
	 */
	
	private Produto criarProdutoPadrao() {
		Produto produto = new Produto();
		produto.setNome("Camisa");
		produto.setPreco(1000.00);
		produto.setMarca("Hering");
		produto.setQuantidadeProduto(50);
		produto.setTamanho("P");
		produto.setTipo("Camisa");
		produto.setCodigoDeBarra("0000000001");
		return produto;
	}

	private Cliente criarClientePadrao() {
		Cliente clientePadrao = new Cliente();
		clientePadrao.setNome("Rodrigo");
		clientePadrao.setCpf("093.555.678.32");
		clientePadrao.setEndereco("R. do Rio, 435, Centro, Rio Tinto");
		return clientePadrao;
	}

	private Funcionario criarFuncionarioPadrao() {
		Funcionario funcionario = new Gerente();
		funcionario.setNome("Rodrigo");
		funcionario.setCpf("098.543.456.76");
		funcionario.setEndereco("R. Aurora, 324, Centro, Santa Rita");
		funcionario.setMatricula("0009");
		funcionario.setSalario(700.00);
		return funcionario;
	}

	private ArrayList<Produto> produtosExtra() {
		String[] nomes = { "Camisa Regata", "Camisa Polo", "Camisa Social","Calça Jeans" };
		double[] precos = { 102.50, 92.50, 213.40, 165.00 };
		String[] marcas = { "Hering", "Lacost", "Hering", "Hering" };
		String[] tamanhos = { "M", "M", "P", "P" };
		String[] tipos = { "Camisa", "Camisa", "Camisa", "Calça" };
		ArrayList<Produto> produtos = new ArrayList<>();
		int quantidadeDeProdutos = 4;
		for (int i = 0; i < quantidadeDeProdutos; i++) {
			Produto produto = new Produto();
			produto.setNome(nomes[i]);
			produto.setPreco(precos[i]);
			produto.setMarca(marcas[i]);
			produto.setQuantidadeProduto(50);
			produto.setTamanho(tamanhos[i]);
			produto.setTipo(tipos[i]);
			produto.setCodigoDeBarra("000000000" + i);
			produtos.add(produto);
		}
		return produtos;
	}
}