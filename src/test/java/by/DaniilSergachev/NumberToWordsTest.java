package by.DaniilSergachev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberToWordsTest {



    @Test
    public void testConvert_WhenHundred() {
        assertEquals("сто", SecondTask.convert(100));
    }


    @Test
    public void testConvert_WhenTwoThousand() {
        assertEquals("две тысячи", SecondTask.convert(2000));
    }

    @Test
    public void testConvert_WhenTwoThousandThreeHundred() {
        assertEquals("две тысячи триста", SecondTask.convert(2300));
    }

    @Test
    public void testConvert_WhenThirteenThousand() {
        assertEquals("тринадцать тысяч", SecondTask.convert(13000));
    }

    @Test
    public void testConvert_WhenTwentyThousand() {
        assertEquals("двадцать тысяч", SecondTask.convert(20000));
    }

    @Test
    public void testConvertDouble_WhenWholeNumber() {
        assertEquals("пять целых десять сотых", SecondTask.convertDouble(5.1));
    }



    @Test
    public void testConvertDouble_WhenZeroWholePart() {
        assertEquals("ноль целых девяносто девять сотых", SecondTask.convertDouble(0.99));
    }

}
