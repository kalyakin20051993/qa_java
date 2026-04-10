package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FelineTest {
    Feline feline = new Feline();

    @Test
    void eatMeatShouldReturnGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    void getFamilyReturnValue() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensShouldReturnDefaultValue() {
        assertEquals(1, feline.getKittens());
    }
}
