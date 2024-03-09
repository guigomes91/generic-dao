package br.com.gomes.genericdao.model;

import br.com.gomes.genericdao.auditoria.Auditavel;
import br.com.gomes.genericdao.auditoria.Auditoria;
import br.com.gomes.genericdao.auditoria.AuditoriaListener;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@EntityListeners(AuditoriaListener.class)
@Entity
@Table(name = "venda_item")
public class VendaItem implements Auditavel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "venda_id")
    private Venda venda;

    private String produto;

    private Integer quantidade;

    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Embedded
    private Auditoria auditoria;

    @Override
    public Auditoria getAuditoria() {
        return this.auditoria;
    }

    @Override
    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }
}
