package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ParameterizedTests {
    @Mock
    Feline feline;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5})
    void getLionKittensShouldReturnValue(int kittensCount) throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(kittensCount);
        Lion lion = new Lion("Самец", feline);

        assertEquals(kittensCount, lion.getKittens());
        Mockito.verify(feline).getKittens();
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesLionHaveManeShouldDependOnSex(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, feline);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5})
    void getFelineKittensShouldReturnValue(int kittensCount) {
        Mockito.when(feline.getKittens()).thenReturn(kittensCount);

        assertEquals(kittensCount, feline.getKittens());
        Mockito.verify(feline).getKittens();
    }
}
