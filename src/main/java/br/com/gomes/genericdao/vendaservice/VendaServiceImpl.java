package br.com.gomes.genericdao.vendaservice;

import br.com.gomes.genericdao.model.Venda;
import br.com.gomes.genericdao.vendadao.VendaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaDAO vendaDAO;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Venda lancarVenda(Venda venda) {
        return (Venda) vendaDAO.persist(venda);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venda> buscaPorCliente(String cliente) {
        List<Venda> byCliente = vendaDAO.findByCliente(cliente);

        org.hibernate.engine.spi.PersistenceContext persistenceContext = getHibernatePersistenceContext();

        for (Venda venda : byCliente) {
            log.info("Contem cliente {}", entityManager.contains(venda));
            EntityEntry entityEntry = persistenceContext.getEntry(venda);
            log.info("Is null loadedStage {}", Objects.isNull(entityEntry.getLoadedState()));
        }
        return byCliente;
    }

    @Override
    @Transactional
    public Venda buscaPorId(UUID id) {
        Venda venda = (Venda) vendaDAO.findById(id);

        org.hibernate.engine.spi.PersistenceContext persistenceContext = getHibernatePersistenceContext();
        EntityEntry entityEntry = persistenceContext.getEntry(venda);
        log.info("Is not null loadedStage {}", Objects.isNull(entityEntry.getLoadedState()));

        return venda;
    }

    private org.hibernate.engine.spi.PersistenceContext getHibernatePersistenceContext() {
        SharedSessionContractImplementor session = entityManager.unwrap(
                SharedSessionContractImplementor.class
        );
        return session.getPersistenceContext();
    }
}
