package org.pratyush.controller;

import org.pratyush.constant.ApiPath;
import org.pratyush.model.response.SystemConfigResponse;
import org.pratyush.service.SystemConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(ApiPath.SYSTEM_CONFIG)
public class SystemConfigController {

    private final SystemConfigService systemConfigService;

    public SystemConfigController(SystemConfigService systemConfigService) {
        this.systemConfigService = systemConfigService;
    }

    @GetMapping
    public ResponseEntity<List<SystemConfigResponse>> getSystemConfigList() {
        return ResponseEntity.ok(systemConfigService.getAllSystemConfig());
    }
}
