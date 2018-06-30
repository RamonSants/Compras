package br.ufms.compras;

import br.ufms.compras.entity.*;
import br.ufms.compras.entity.enumeration.EstadoPagamentoEnum;
import br.ufms.compras.entity.enumeration.TipoClienteEnum;
import br.ufms.compras.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ComprasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ComprasApplication.class, args);
	}

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia");
        Cidade c2 = new Cidade(null, "São Paulo");
        Cidade c3 = new Cidade(null, "Campinas");

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        c1.setEstado(est1);
        c2.setEstado(est2);
        c3.setEstado(est2);

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoClienteEnum.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

        Endereco e1 = new Endereco(null, "Rua das Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "300", "Sala 800", "Centro", "38220834", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.save(cli1);
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/08/2017 10:32"), e1, cli1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), e2, cli1);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamentoEnum.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamentoEnum.PENDENTE, ped2,
                sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.0);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p1.getItens().addAll(Arrays.asList(ip3));
        p1.getItens().addAll(Arrays.asList(ip2));

    }
}
