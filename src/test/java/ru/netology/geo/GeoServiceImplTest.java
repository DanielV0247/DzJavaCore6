package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class GeoServiceImplTest {

    private final GeoService geoService = new GeoServiceImpl();

    @Test
    void byIpCity(){
        Assertions.assertEquals("Moscow", geoService.byIp("172.0.32.12").getCity());
    }
    @Test
    void byIpCountry(){
        Assertions.assertEquals(Country.USA, geoService.byIp("96.44.183.149").getCountry());
    }
    @Test
    void byIpNull(){
        Assertions.assertNull(geoService.byIp("0.0.0.1"));
    }
    @Test
    void byIpStreet(){
        Assertions.assertEquals("Lenina", geoService.byIp("172.0.32.11").getStreet());
    }
    @Test
    void byIpBuilding(){
        Assertions.assertEquals(32, geoService.byIp("96.44.183.149").getBuiling());
    }
    @Test
    void byIpNullLocal(){
        Assertions.assertNull(geoService.byIp("127.0.0.1").getCity());
    }
    @Test
    void byCoordinates() {
        double a = 1234.56789;
        double b = 12345.6789;
        Assertions.assertThrows(RuntimeException.class, ()->{
            geoService.byCoordinates(a,b);
        });
    }
}