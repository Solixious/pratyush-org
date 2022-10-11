package org.pratyush;

import org.pratyush.constant.Role;
import org.pratyush.service.RoleService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final RoleService roleService;

    public InitialDataLoader(final RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for(Role role : Role.values()) {
            createRoleIfNotFound(role);
        }
    }

    @Transactional
    public String createRoleIfNotFound(final Role role) {
        final String roleName = roleService.getRole(role);
        if (roleName == null) {
            roleService.addRole(role);
        }
        return roleName;
    }
}
