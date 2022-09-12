package com.first_app.app_learning_springboot.SaleAppControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.first_app.app_learning_springboot.sale_app.model.Location;
import com.first_app.app_learning_springboot.sale_app.service.implement.LocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@WebMvcTest(LocationController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LocationControllerTest {
    /**
     * Đối tượng MockMvc do Spring cung cấp
     * Có tác dụng giả lập request, thay thế việc khởi động Server
     */
    @Autowired
    private MockMvc mvc;

    @MockBean
    private LocationService locationService;

    @Test
    public void testFindAllLocation() throws Exception {

        // Tạo ra một List<Location> 10 phần tử
        List<Location> allLocation= IntStream.range(0, 10)
                .mapToObj(i -> new Location(i, "country-" + i, "city-" + i))
                .collect(Collectors.toList());

        // giả lập todoService trả về List mong muốn
        given(locationService.getLocations()).willReturn(allLocation);

        mvc.perform(get("/api/v1/location").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)))
                .andExpect(jsonPath("$[0].locationId", is(0)))
                .andExpect(jsonPath("$[0].country", is("country-0")))
                .andExpect(jsonPath("$[0].city", is("city-0")));
    }

    @Test
    public void testGetLocationById() throws Exception {
        // Tạo ra một List<Location> 10 phần tử
        List<Location> allLocation= IntStream.range(0, 10)
                .mapToObj(i -> new Location(i, "country-" + i, "city-" + i))
                .collect(Collectors.toList());

        // giả lập todoService trả về List mong muốn
        given(locationService.getLocationById(1)).willReturn(new Location(1, "country-1", "city-1"));

        mvc.perform(get("/api/v1/location/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
              //  .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void testCreateLocation() throws Exception {
        String uri = "/api/v1/location";
        Location location = new Location();
        location.setLocationId(3);
        location.setCountry("country-3");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(location);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Product is created successfully");
    }

    @Test
    public void testUpdateLocation() throws Exception {
        String uri = "/api/v1/location/3";
        Location location = new Location();
        location.setCountry("country-3");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(location);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Product is updated successsfully");
    }

    @Test
    public void testDeleteLocation() throws Exception {
        String uri = "/api/v1/location/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Product is deleted successsfully");
    }

}
