package br.com.gomes.genericdao.vendadao;

import br.com.gomes.genericdao.generic.GenericDAO;
import br.com.gomes.genericdao.model.Venda;

import java.util.List;
import java.util.UUID;

public interface VendaDAO extends GenericDAO<Venda, UUID> {

    List<Venda> findByCliente(String cliente);
}
