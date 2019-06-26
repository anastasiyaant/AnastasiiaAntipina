package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Sum extends BaseClass {

    // Для того чтобы проверить на различных типах данных
    // 1)сложение любых, 2)сложение нулей, 3) сложение с нулем,
    // 4) сложение противоположных по знаку, но равных по значению чисел
    // 5)сложение с отрицательным, 6) сложение двух отрицательных, 7) сложение больших чисел
    // аналогично для wrongSumData
    @DataProvider
    public static Object[][] correctSumData() {
        return new Object[][]{{1, 2, 3}, {0, 0, 0}, {0, 1, 1}, {-1, 1, 0}, {-100, 15, -85}, {-2, -2, -4}, {12345, 12345, 24690}};
    }

    @DataProvider
    public static Object[][] wrongSumData() {
        return new Object[][]{{12, 2, 12}, {0, 5, 0}, {-10, 10, 1}, {-10, 50, 15}, {-7, -9, -30}, {85245, 7412, 0}};
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
