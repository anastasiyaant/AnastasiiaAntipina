package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Divide {
    //    TODO I think it will be better to move it to BaseClass
//    TODO Why is this field has protected modifier?
    protected Calculator calc;

//    TODO Why you decide use this set of the test data?
    @DataProvider
    public static Object[][] correctDivideData() {
        return new Object[][]{{1, 1, 1}, {25, 5, 5}, {0, 5, 0}, {1, 2, 0}, {1, 3, 0}, {147896, 212, 697}, {25874, 2, 12937}};
    }

    @DataProvider
    public static Object[][] wrongDivideData() {
        return new Object[][]{{5, 5, 0}, {100, 4, 2}, {0, 2, 1}, {16, 4, 5}, {1, 8, 4}, {14789, 113, 14}, {24274, 2, 4254}};
    }


    //    TODO I think it will be better to move it to BaseClass
    @BeforeMethod
    public void createCalc() {
        calc = new Calculator();
    }

    @Test(dataProvider = "correctDivideData")
    public void divideTest(long a, long b, long res) {
        long realRes = calc.div(a, b);
        assertEquals(realRes, res);

    }

    @Test(dataProvider = "wrongDivideData")
    public void divideTestFail(long a, long b, long res) {
        long realRes = calc.div(a, b);
        assertNotEquals(realRes, res);

    }
}
