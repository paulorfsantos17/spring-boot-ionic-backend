package com.paulo.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.paulo.cursomc.domain.Categoria;
import com.paulo.cursomc.domain.Cidade;
import com.paulo.cursomc.domain.Cliente;
import com.paulo.cursomc.domain.Endereco;
import com.paulo.cursomc.domain.Estado;
import com.paulo.cursomc.domain.ItemPedido;
import com.paulo.cursomc.domain.Pagamento;
import com.paulo.cursomc.domain.PagamentoComBoleto;
import com.paulo.cursomc.domain.PagamentoComCartao;
import com.paulo.cursomc.domain.Pedido;
import com.paulo.cursomc.domain.Produto;
import com.paulo.cursomc.domain.enums.EstadoPagamento;
import com.paulo.cursomc.domain.enums.TipoCliente;
import com.paulo.cursomc.repositories.CategoriaRepositories;
import com.paulo.cursomc.repositories.CidadeRepositories;
import com.paulo.cursomc.repositories.ClienteRepositories;
import com.paulo.cursomc.repositories.EnderecoRepositories;
import com.paulo.cursomc.repositories.EstadoRepositories;
import com.paulo.cursomc.repositories.ItemPedidoRepositories;
import com.paulo.cursomc.repositories.PagamentoRepositories;
import com.paulo.cursomc.repositories.PedidoRepositories;
import com.paulo.cursomc.repositories.ProdutoRepositories;


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private ProdutoRepositories produtoRepositories;
	
	@Autowired
	private CategoriaRepositories categoriaRepositories;
	
	@Autowired
	private CidadeRepositories cidadeRepositories;
	
	@Autowired
	private EstadoRepositories estadoRepositories; 
	
	@Autowired
	private ClienteRepositories clienteRepositories;
	
	@Autowired
	private EnderecoRepositories enderecoRepositories;
	
	@Autowired
	private PedidoRepositories pedidoRepositories;
	
	@Autowired
	private PagamentoRepositories pagamentoRepostories;
	
	
	@Autowired
	private ItemPedidoRepositories  itemPedidoRepositories;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria (null, "informatica");
		Categoria cat2 = new Categoria (null, "Escritorio");
		
		Produto p1 = new Produto (null,"Computador", 2000.00);
		Produto p2 = new Produto (null,"Computador", 2000.00);
		Produto p3 = new Produto (null,"Computador", 2000.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList( p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		
		categoriaRepositories.saveAll(Arrays.asList(cat1, cat2));
		produtoRepositories.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado (null , "Minas Gerais");
		Estado est2 = new Estado (null , "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepositories.saveAll(Arrays.asList(est1, est2));
		cidadeRepositories.saveAll(Arrays.asList(c1,c2,c3));

		
		
		Cliente cli1 = new Cliente (null ,"Maria Silva", "maria@gmail.com", "36978945622",TipoCliente.PESSOAFISICA );
		
		cli1.getTelefones().addAll(Arrays.asList("25877889", "78459654"));
		
		Endereco e1 = new Endereco(null , "Rua Flores", "300", "Apto 303" , "Jardim", "38220834", c2, cli1);
		Endereco e2 = new Endereco(null , "Avenida Matos", "105", "Sala 105" , "Centro", "3258844", c1, cli1);

		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepositories.saveAll(Arrays.asList(cli1));
		enderecoRepositories.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1, e1 );
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"),cli1, e2 );
		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO , ped1,6);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PEDENTE , ped2,sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		  
		pedidoRepositories.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepostories.saveAll(Arrays.asList(pgto1, pgto2));
		
		ItemPedido ip1 = new ItemPedido(p1, ped1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(p3, ped1, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(p2, ped2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		
		p1.getItens().addAll(Arrays.asList(ip1));
//		p2.getItens().addAll(Arrays.asList(ip3));	
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepositories.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	}
	
}
