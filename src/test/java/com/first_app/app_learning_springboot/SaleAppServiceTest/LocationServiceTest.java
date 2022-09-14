package com.first_app.app_learning_springboot.SaleAppServiceTest;

import com.first_app.app_learning_springboot.sale_app.model.Location;
import com.first_app.app_learning_springboot.sale_app.repository.LocationRepository;
import com.first_app.app_learning_springboot.sale_app.service.LocationServiceInteface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @BeforeEach
    public void setUp() {

        // set up for test findAll function
        Mockito.when(locationRepository.findAll())
                .thenReturn(IntStream.range(0, 10)
                        .mapToObj(i -> new Location(i, "country-" + i, "city-" + i))
                        .collect(Collectors.toList()));

        // set up for test findById function
        Location location = new Location();
        location.setCountry("country-0");
        Mockito.when(locationRepository.findById(Mockito.eq(0)))
                .thenReturn(Optional.of(location));

        // set up for test update function
//        Mockito.when(locationRepository.(Mockito.eq(0)))
//                .thenReturn(Optional.of(location));
    }

    @Test
    public void testCount() {
        Assertions.assertEquals(10, locationService.countLocation());
    }

    // error in this test: locationService is not active in this test case
    @Test
    public void testGetLocationById() {
        Location location = locationService.getLocationById(0);
        // locationService.deleteLocation(1);

        Assertions.assertEquals("country-0", location.getCountry());
    }
}
