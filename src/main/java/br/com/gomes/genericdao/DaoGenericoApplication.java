package br.com.gomes.genericdao;

import br.com.gomes.genericdao.model.Venda;
import br.com.gomes.genericdao.vendaservice.VendaService;
import br.com.gomes.genericdao.vendaservice.VendaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@SpringBootApplication
public class DaoGenericoApplication implements CommandLineRunner {
	@Autowired
	private VendaService vendaService;

	public static void main(String[] args) {
		SpringApplication.run(DaoGenericoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Venda newVenda = new Venda();
		newVenda.setCliente("Guilherme");
		newVenda.setValorTotal(new BigDecimal(1000));

		vendaService.lancarVenda(newVenda);
		log.info("ID newVenda {}", newVenda.getId());

		List<Venda> vendas = vendaService.buscaPorCliente("Guilherme");
		log.info("Qtd row {}", vendas.size());

		Venda venda = vendaService.buscaPorId(newVenda.getId());
		log.info("Name is {}", venda.getCliente());
	}
}
