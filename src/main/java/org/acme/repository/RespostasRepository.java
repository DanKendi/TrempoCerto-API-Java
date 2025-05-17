package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.RespostasEntity;

@ApplicationScoped
public class RespostasRepository implements PanacheRepositoryBase<RespostasEntity, Integer> {
}
