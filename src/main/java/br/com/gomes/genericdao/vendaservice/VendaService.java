package br.com.gomes.genericdao.vendaservice;

import br.com.gomes.genericdao.model.Venda;

import java.util.List;
import java.util.UUID;

public interface VendaService {

    Venda lancarVenda(Venda venda);
    List<Venda> buscaPorCliente(String cliente);
    Venda buscaPorId(UUID id);
}
