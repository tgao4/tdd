import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void normal_numbers() {
        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();

        //Act
        String result = fizzBuzz.printFizzBuzz(1);

        //Assert
        assertEquals("1", result);
    }

    @Test
    public void multiple_of_3() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.printFizzBuzz(3);
        assertEquals("Fizz", result);
    }

    @Test
    public void multiple_of_5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.printFizzBuzz(5);
        assertEquals("Buzz", result);
    }

    @Test
    public void multiple_of_15() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.printFizzBuzz(15);
        assertEquals("FizzBuzz", result);
    }
}

