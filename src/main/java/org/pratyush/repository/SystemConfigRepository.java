package org.pratyush.repository;

import org.pratyush.model.entity.SystemConfigEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemConfigRepository extends CrudRepository<SystemConfigEntity, String> {
}
