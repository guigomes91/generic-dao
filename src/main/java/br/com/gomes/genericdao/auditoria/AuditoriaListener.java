package br.com.gomes.genericdao.auditoria;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;
import java.util.Objects;

public class AuditoriaListener {

    @PrePersist
    public void aoCriar(Auditavel auditavel) {
        Auditoria auditoria = auditavel.getAuditoria();
        if (Objects.isNull(auditoria)) {
            auditoria = new Auditoria();
            auditavel.setAuditoria(auditoria);
        }

        auditoria.setCreatedBy("User most be logged");
        auditoria.setCreatedOn(LocalDateTime.now());
    }

    @PreUpdate
    public void aoAtualizar(Auditavel auditavel) {
        Auditoria auditoria = auditavel.getAuditoria();
        if (Objects.isNull(auditoria)) {
            auditoria = new Auditoria();
            auditavel.setAuditoria(auditoria);
        }

        auditoria.setUpdatedBy("User most be logged");
        auditoria.setUpdatedOn(LocalDateTime.now());
    }
}
