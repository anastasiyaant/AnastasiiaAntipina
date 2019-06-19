package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Multiply {
    //    TODO I think it will be better to move it to BaseClass
//    TODO Why is this field has protected modifier?
    protected Calculator calc;

    //    TODO Why you decide use this set of the test data?
    @DataProvider
    public static Object[][] correctMultData() {
        return new Object[][]{{1, 1, 1}, {5, 5, 25}, {0, 5, 0}, {5, 27, 135}, {100, 212, 21200}, {30, 30, 900}};
    }

    @DataProvider
    public static Object[][] wrongMultData() {
        return new Object[][]{{3, 3, 6}, {0, 4, 4}, {16, 4, 12}, {147, 113, 12548}, {24274, 2, 24274}};
    }

    //    TODO I think it will be better to move it to BaseClass
    @BeforeMethod
    public void createCalc() {
        calc = new Calculator();
    }

    @Test(dataProvider = "correctMultData")
    public void multiplyLongTest(long a, long b, long res) {
        long realRes = calc.mult(a, b);
        assertEquals(realRes, res);
    }


    @Test(dataProvider = "wrongMultData")
    public void multiplyLongTestFail(long a, long b, long res) {
        long expected = calc.mult(a, b);
        assertNotEquals(expected, res);
    }
}
