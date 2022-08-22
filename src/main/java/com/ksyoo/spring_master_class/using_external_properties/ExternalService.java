package com.ksyoo.spring_master_class.using_external_properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExternalService {
    @Value("${external.service.url}")
    private String url;

    public String getServiceUrl() {
        return url;
    }
}
