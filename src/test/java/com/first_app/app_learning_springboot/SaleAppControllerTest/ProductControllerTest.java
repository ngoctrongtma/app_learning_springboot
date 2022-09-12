package com.first_app.app_learning_springboot.SaleAppControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.first_app.app_learning_springboot.sale_app.model.Location;
import com.first_app.app_learning_springboot.sale_app.model.Product;
import com.first_app.app_learning_springboot.sale_app.service.implement.LocationService;
import com.first_app.app_learning_springboot.sale_app.service.implement.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.xmlunit.util.Linqy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    /**
     * Đối tượng MockMvc do Spring cung cấp
     * Có tác dụng giả lập request, thay thế việc khởi động Server
     */
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testFindAllProduct() throws Exception {

        // Tạo ra một List<Location> 10 phần tử
        List<Product> allProduct= IntStream.range(0, 10)
                .mapToObj(i -> new Product(i, 10 + i , "Class-" + i, "Inventory-" + i))
                .collect(Collectors.toList());
        // giả lập todoService trả về List mong muốn
        given(productService.getAllProduct()).willReturn(allProduct);

        mvc.perform(get("/api/v1/product").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)))
                .andExpect(jsonPath("$[0].id", is(0)))
                .andExpect(jsonPath("$[0].productClass", is("Class-0")))
                .andExpect(jsonPath("$[0].inventory", is("Inventory-0")));
    }

    @Test
    public void testGetProductById() throws Exception {
        // Tạo ra một List<Location> 10 phần tử
        List<Product> allProduct= IntStream.range(0, 10)
                .mapToObj(i -> new Product(i, 10 + i , "Class-" + i, "Inventory-" + i))
                .collect(Collectors.toList());

        // giả lập todoService trả về List mong muốn
        given(productService.getProductById(1)).willReturn(new Product(1, 10 + 1 , "Class-1", "Inventory-1"));

        mvc.perform(get("/api/v1/product/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    //      .andExpect(jsonPath("$", hasSize(1)));
    }
//
    @Test
    public void createProduct() throws Exception {
        String uri = "/api/v1/product";
        Product product = new Product();
        product.setId(1);
        product.setItem(1);
        product.setInventory("Inventory-1");
        product.setProductClass("Class-1");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Product is created successfully");
    }

    @Test
    public void testUpdateProduct() throws Exception {
        String uri = "/api/v1/product/1";
        Product product = new Product();
        product.setInventory("Inventory-3");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Product is updated successsfully");
    }
//
    @Test
    public void testDeleteProduct() throws Exception {
        String uri = "/api/v1/location/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Product is deleted successsfully");
    }
}
