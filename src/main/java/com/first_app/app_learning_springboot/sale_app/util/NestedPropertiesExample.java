package com.first_app.app_learning_springboot.sale_app.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "nested-properties") // Chỉ lấy các config có tiền tố là "common_url"
public class NestedPropertiesExample {
    private List<String> demoList;
    private Map<String, String> demoMap;

    public List<String> getDemoList() {
        return demoList;
    }

    public void setDemoList(List<String> demoList) {
        this.demoList = demoList;
    }

    public Map<String, String> getDemoMap() {
        return demoMap;
    }

    public void setDemoMap(Map<String, String> demoMap) {
        this.demoMap = demoMap;
    }
}
