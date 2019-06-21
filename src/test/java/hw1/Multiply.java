package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Multiply extends BaseClass {
    //    TODO Why you decide use this set of the test data?
    // Для того чтобы проверить на различных типах данных
    // 1) умножение одинаковые чисел, 2) умножение любых чисел,
    // 3) умножение на ноль, 4) умножение на двузначное число
    // 4) умножение трехзначных, 5)умножение двузначных
    // аналогично для wrongMultData
    @DataProvider
    public static Object[][] correctMultData() {
        return new Object[][]{{1, 1, 1}, {5, 5, 25}, {0, 5, 0}, {5, 27, 135}, {100, 212, 21200}, {30, 30, 900}};
    }

    @DataProvider
    public static Object[][] wrongMultData() {
        return new Object[][]{{3, 3, 6}, {2, 9, 12}, {0, 4, 4}, {16, 4, 12}, {147, 113, 12548}, {15, 28, 24274}};
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
