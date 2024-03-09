package br.com.gomes.genericdao.vendadao;

import br.com.gomes.genericdao.generic.GenericDAOImpl;
import br.com.gomes.genericdao.model.Venda;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VendaDAOImpl extends GenericDAOImpl<Venda, UUID> implements VendaDAO {

    protected VendaDAOImpl() {
        super(Venda.class);
    }

    @Override
    public List<Venda> findByCliente(String cliente) {
        return getEntityManager()
                .createQuery(
                        """
                                select v from Venda v where v.cliente = :cliente
                                """, Venda.class)
                .setParameter("cliente", cliente)
                .getResultList();
    }

    @Override
    public Venda persist(Venda venda) {
        return super.persist(venda);
    }
}
