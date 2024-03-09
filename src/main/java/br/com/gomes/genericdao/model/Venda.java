package br.com.gomes.genericdao.model;

import br.com.gomes.genericdao.auditoria.Auditavel;
import br.com.gomes.genericdao.auditoria.Auditoria;
import br.com.gomes.genericdao.auditoria.AuditoriaListener;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@EntityListeners(AuditoriaListener.class)
@Entity
@Table(name = "venda")
public class Venda implements Auditavel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String cliente;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "venda")
    private List<VendaItem> vendaItem;

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
