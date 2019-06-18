package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Sum {
    protected Calculator calc;

    @DataProvider
    public static Object[][] correctSumData() {
        return new Object[][]{{1, 2, 3}, {0, 0, 0}, {0, 1, 1}, {-1, 1, 0}, {-100, 15, -85}, {-2, -2, -4}, {12345, 12345, 24690}};
    }

    @DataProvider
    public static Object[][] wrongSumData() {
        return new Object[][]{{12, 2, 12}, {0, 5, 0}, {-10, 10, 1}, {-10, 50, 15}, {-7, -9, -30}, {85245, 7412, 0}};
    }

    @BeforeMethod
    public void createCalc() {
        calc = new Calculator();
    }

    @Test(dataProvider = "correctSumData")
    public void sumLongTest(long a, long b, long res) {
        long realRes = calc.sum(a, b);
        assertEquals(realRes, res);
    }


    @Test(dataProvider = "wrongSumData")
    public void sumLongTestFail(long a, long b, long res) {
        long realRes = calc.sum(a, b);
        assertNotEquals(realRes, res);
    }
}
