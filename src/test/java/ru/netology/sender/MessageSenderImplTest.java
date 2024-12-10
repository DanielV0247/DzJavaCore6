package ru.netology.sender;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MessageSenderImplTest {

    private GeoService geoService;
    private LocalizationService localizationService;
    private MessageSender messageSender;

    @BeforeEach
    void BeforeEach() {
        geoService = Mockito.mock(GeoService.class);
        localizationService = Mockito.mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }
    @Test
    void testSendMessageRus() {
        String ip = "172.0.0.1";
        when(geoService.byIp(ip)).thenReturn(new Location("Moscow", Country.RUSSIA,  "street", 2));
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Ru");
        Map<String, String> map = new HashMap<>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        String result = messageSender.send(map);

        assertEquals("Ru", result);
    }
    @Test
    void testSendMessageUsa() {
        String ip = "96.0.0.1";
        when(geoService.byIp(ip)).thenReturn(new Location("New York", Country.USA, "street", 12));
        when(localizationService.locale(Country.USA)).thenReturn("Eng");
        Map<String, String> map = new HashMap<>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        String result = messageSender.send(map);

        assertEquals("Eng", result);
    }
}