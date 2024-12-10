package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    private final LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void testLocaleRu() {
        String message = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", message);
    }

    @Test
    void testLocaleUsa() {
        String message = localizationService.locale(Country.USA);
        assertEquals("Welcome", message);
    }
}