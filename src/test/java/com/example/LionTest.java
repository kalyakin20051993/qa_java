package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {
    @Mock
    Feline feline;

    @Test
    void getExceptionOther() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно", feline));

        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void getFoodShouldReturnPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", feline);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        Mockito.verify(feline).getFood("Хищник");
    }
}
