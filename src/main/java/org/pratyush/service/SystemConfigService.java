package org.pratyush.service;

import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.pratyush.model.entity.SystemConfigEntity;
import org.pratyush.model.response.SystemConfigResponse;
import org.pratyush.repository.SystemConfigRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class SystemConfigService {

    private final SystemConfigRepository systemConfigRepository;
    private final Mapper mapper;

    public SystemConfigService(SystemConfigRepository systemConfigRepository, Mapper mapper) {
        this.systemConfigRepository = systemConfigRepository;
        this.mapper = mapper;
    }

    public List<SystemConfigResponse> getAllSystemConfig() {
        Iterator<SystemConfigEntity> systemConfigEntities = systemConfigRepository.findAll().iterator();
        List<SystemConfigResponse> systemConfigResponseList = new ArrayList<>();
        systemConfigEntities.forEachRemaining(e -> systemConfigResponseList.add(mapper.map(e, SystemConfigResponse.class)));
        return systemConfigResponseList;
    }
}
