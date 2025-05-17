package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.PerguntasEntity;

@ApplicationScoped
public class PerguntasRepository implements PanacheRepositoryBase<PerguntasEntity, Integer> {

}
