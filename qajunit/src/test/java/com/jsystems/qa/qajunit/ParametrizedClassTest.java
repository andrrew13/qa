package com.jsystems.qa.qajunit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parametrized test")
public class ParametrizedClassTest {

        @DisplayName(" First parametrized test")
        @ParameterizedTest(name = "Parametrized test with value {0}")
        @ValueSource( ints = {5,15,25})
        public void paramFirstTest(int number) {

                assertTrue(number % 5== 0);


        }
                @DisplayName(" parametrized test")
                @ParameterizedTest(name = "Parametrized test with value {0}")
//        @ValueSource( ints = {5,15,25})
                @ValueSource(strings = {"Hello", "Hello Junit", "Hello Students"})
                //     public void paramFirstTest(int number){
                public void paramFirstTest (String value){

                        assertTrue(value.contains("Hello"));

                }

}
