package com.first_app.app_learning_springboot.SaleAppControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.first_app.app_learning_springboot.sale_app.controller.TimeController;
import com.first_app.app_learning_springboot.sale_app.exception.ApiExceptionHandler;
import com.first_app.app_learning_springboot.sale_app.model.Product;
import com.first_app.app_learning_springboot.sale_app.model.Time;
import com.first_app.app_learning_springboot.sale_app.service.TimeServiceInterface;
import com.first_app.app_learning_springboot.sale_app.service.implement.TimeService;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.xmlunit.util.Linqy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

////để có thể sử dụng annotation
//@RunWith(MockitoJUnitRunner.class )
////tự động cấu hình cơ sở kiến trúc Spring MVC
//@WebMvcTest(controllers = TimeController.class)
/*---------------------------------------------------------*/
// Demo Easy Mock

// --------------

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(EasyMockRunner.class)
@SpringBootTest
public class TimeControllerTest {

    /*----------------------------------------------------------------------------------------*/
    // Demo Easy mock
    // @TestSubject annotation is used to identify class which is going to use the mock object
    @TestSubject
    TimeController timeController = new TimeController();

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    TimeService timeService;


    @Test
    public void testGetAllTimeController(){
        // Tạo ra một List<Location> 10 phần tử
        List<Time> allTimes= IntStream.range(0, 10)
                .mapToObj(i -> new Time(i, 10,  i, i))
                .collect(Collectors.toList());

        // add the behavior of calc service to add two numbers
        Object temp = EasyMock.expect(timeService.getAllTime()).andReturn(allTimes);
        //activate the mock
        EasyMock.replay(timeService);
//
        // test the add functionality
        Assert.assertEquals(timeController.getAllTime(), allTimes);
    }

    @Test
    public void testGetTimeById() throws Exception {
        Time time = new Time(1, 12, 4,2022);
        EasyMock.expect(timeService.getTimeById(1)).andReturn(time);

        //activate the mock
        EasyMock.replay(timeService);

        // test the add functionality
        Assert.assertEquals(timeController.getTimeById(1), time);

        EasyMock.verify(timeService);

    }

//    @Test
//    public void testUpdateTime() throws Exception {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String inputJson = objectMapper.writeValueAsString(product);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
////        String content = mvcResult.getResponse().getContentAsString();
////        assertEquals(content, "Product is updated successsfully");
//    }
//






    /*----------------------------------------------------------------------------------------*/

//
//    public MockMvc mockMvc;
//
//    // đối tượng được test
//    @InjectMocks
//    TimeController timeController;
//
//    @Mock
//    TimeService timeServiceMock;
//
//    @Before
//    public void setup() {
//        System.out.println("Before method");
//        mockMvc = MockMvcBuilders.standaloneSetup(timeController)
//                .setControllerAdvice(new ApiExceptionHandler()).build();
//    }
//
//    @Test
//    public void testGetAllTime() throws Exception{
//        Time time1 = new Time(1, 12, 4,2022);
//        Time time2 = new Time(2, 9, 3, 2022);
//
//        List<Time> listTime = new ArrayList<Time>();
//        listTime.add(time1);
//        listTime.add(time2);
//
//        Mockito.when(timeServiceMock.getAllTime()).thenReturn(listTime);
//
//        Assertions.assertEquals(timeServiceMock.getAllTime(), listTime);
//        Assertions.assertEquals(time1, listTime.get(0));
//
//        mockMvc.perform(get("/api/v1/time")).andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id", Matchers.is(1)))
//                .andExpect(jsonPath("$[0].month", Matchers.is(12)))
//                .andExpect(jsonPath("$[0].quarter", Matchers.is(4)));
//
//         Mockito.verify(timeServiceMock,  Mockito.atLeastOnce()).getAllTime();
//    }
//
//    @Test
//    public void testGetTimeById() throws Exception {
//        Time time = new Time(1, 12, 4,2022);
//        Mockito.when(timeServiceMock.getTimeById(1)).thenReturn(time);
//        mockMvc.perform(get("/api/v1/time/1")).andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", Matchers.is(1)));
//    }







}
