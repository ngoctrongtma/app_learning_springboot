package com.first_app.app_learning_springboot.SaleAppServiceTest;

import com.first_app.app_learning_springboot.sale_app.model.Product;
import com.first_app.app_learning_springboot.sale_app.service.implement.ProductService;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xmlunit.util.Linqy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(EasyMockRunner.class)
public class ProductServiceTest {


    // @Mock annotation is used to create the mock object to be injected
    @Mock
    ProductService productService;


    @Test
    public void testGetAllService(){

        // Tạo ra một List<Location> 10 phần tử
        List<Product> allProduct= IntStream.range(0, 10)
                .mapToObj(i -> new Product(i, 10 + i , "Class-" + i, "Inventory-" + i))
                .collect(Collectors.toList());

        // add the behavior of calc service to add two numbers
        EasyMock.expect(productService.getAllProduct()).andReturn(allProduct);

        //activate the mock
        EasyMock.replay(productService);

        // test the add functionality
        Assert.assertEquals(productService.getAllProduct(), allProduct);
    }
}
