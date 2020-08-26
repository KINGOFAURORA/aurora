package com.aurora.service.impl;

import com.aurora.service.TemplateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {

    public String getValue() {
        return "value";
    }
}
