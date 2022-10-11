package org.pratyush.service;

import lombok.extern.slf4j.Slf4j;
import org.pratyush.constant.Role;
import org.pratyush.model.entity.RoleEntity;
import org.pratyush.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(final Role role) {
        if(role != null) {
            final RoleEntity roleEntity = new RoleEntity();
            roleEntity.setName(role.name());
            roleRepository.save(roleEntity);
            log.debug("Role {} added.", role.name());
        }
    }

    public String getRole(final Role role) {
        if(role != null) {
            final RoleEntity roleEntity = roleRepository.findByName(role.name());
            if(roleEntity != null) {
                return roleEntity.getName();
            }
            log.debug("Role {} not found.", role.name());
        }
        return null;
    }
}
