package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Subtract {
    protected Calculator calc;

    @DataProvider
    public static Object[][] correctSubtractData() {
        return new Object[][]{{5, 2, 3}, {0, 1, -1}, {0, 0, 0}, {-1, 1, -2}, {-100, 15, -115}, {-2, -2, 0}, {12345, 12300, 45}};
    }

    @DataProvider
    public static Object[][] wrongSubtractData() {
        return new Object[][]{{3, 2, 0}, {0, 6, 0}, {-7, 7, 0}, {-80, 40, 40}, {-200, -220, -400}, {12345, 45, 12390}};
    }

    @BeforeMethod
    public void createCalc() {
        calc = new Calculator();
    }

    @Test(dataProvider = "correctSubtractData")
    public void subtractLongTest(long a, long b, long res) {
        long realRes = calc.sub(a, b);
        assertEquals(realRes, res);
    }

    @Test(dataProvider = "wrongSubtractData")
    public void subtractLongTestFail(long a, long b, long res) {
        long realRes = calc.sub(a, b);
        assertNotEquals(realRes, res);
    }

}
