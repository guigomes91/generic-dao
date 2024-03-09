package br.com.gomes.genericdao;

import br.com.gomes.genericdao.model.Venda;
import br.com.gomes.genericdao.vendaservice.VendaService;
import br.com.gomes.genericdao.vendaservice.VendaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class VendaServiceImplTest {

    @Test

    public void testInserirVenda() {
        VendaServiceImpl service = new VendaServiceImpl();
        Venda newVenda = new Venda();
        newVenda.setCliente("Guilherme");
        newVenda.setValorTotal(new BigDecimal(1000));

        service.lancarVenda(newVenda);
        Assertions.assertNotNull(newVenda.getId());

        List<Venda> vendas = service.buscaPorCliente("Guilherme");
        Assertions.assertEquals(1, vendas.size());

        Venda venda = service.buscaPorId(newVenda.getId());
        Assertions.assertEquals("Guilherme", venda.getCliente());
    }
}
