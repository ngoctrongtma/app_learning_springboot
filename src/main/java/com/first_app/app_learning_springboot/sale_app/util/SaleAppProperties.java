package com.first_app.app_learning_springboot.sale_app.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
// @PropertySource("classpath:loda.yml") // Đánh dấu để lấy config từ trong file loda.yml
// Nếu không có annotation này(@PropertySource), Spring sẽ sử dụng file mặc định (classpath:application.yml trong thư mục resources)
@ConfigurationProperties(prefix = "common-url") // Chỉ lấy các config có tiền tố là "common_url"
public class SaleAppProperties {
    private  String locationUrl;
    private  String productUrl;
    private  String saleUrl;
    private  String timeUrl;

    public String getLocationUrl() {
        return locationUrl;
    }

    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getSaleUrl() {
        return saleUrl;
    }

    public void setSaleUrl(String saleUrl) {
        this.saleUrl = saleUrl;
    }

    public String getTimeUrl() {
        return timeUrl;
    }

    public void setTimeUrl(String timeUrl) {
        this.timeUrl = timeUrl;
    }

}
