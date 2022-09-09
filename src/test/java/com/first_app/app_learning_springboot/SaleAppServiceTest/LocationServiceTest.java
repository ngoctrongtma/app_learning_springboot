package com.first_app.app_learning_springboot.SaleAppServiceTest;

import com.first_app.app_learning_springboot.sale_app.model.Location;
import com.first_app.app_learning_springboot.sale_app.repository.LocationRepository;
import com.first_app.app_learning_springboot.sale_app.service.LocationServiceInteface;
import com.first_app.app_learning_springboot.sale_app.service.implement.LocationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest // test way 1
public class LocationServiceTest {

// test way 2
//    @TestConfiguration
//    public static class LocationServiceTestConfiguration{
//
//        /*
//        Tạo ra trong Context một Bean TodoService
//         */
//        @Bean
//        LocationService locationService(){
//            return new LocationService();
//        };
//
//    }

    /**
     * Đối tượng locationRepository sẽ được mock, chứ không phải bean trong context
     */
    @MockBean
    LocationRepository locationRepository;

    @Autowired
    LocationServiceInteface locationService;


    @Before
    public void setUp() {
        Mockito.when(locationRepository.findAll())
                .thenReturn(IntStream.range(0, 10)
                        .mapToObj(i -> new Location(i, "country-" + i, "city-" + i))
                        .collect(Collectors.toList()));
    }

    @Test
    public void testCount() {
        Assert.assertEquals(10, locationService.countLocation());
    }

    // error in this test: locationService is not active in this test case
    @Test
    public void testGetLocationById(){
        System.out.println("test location --------" + locationService.getLocations().toString());
        System.out.println("test location --------" + locationService.getLocations().get(0).toString());
        locationService.deleteLocation(1);

         // Assert.assertEquals("country-0", locationService.getLocationById(0));
    }
}
