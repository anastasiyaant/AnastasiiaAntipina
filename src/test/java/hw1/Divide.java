package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Divide extends BaseClass {
    // Для того чтобы проверить на различных типах данных
    // 1) данные с одинаковыми a и b, 2) данные с любыми числами, 3) данные, где a = 0, b - любое число,
    // 4) для проверки округления, 5) деление большого числа для получения ненулевого результата,
    // 6) деление большого числа на однозначное, чтобы получить так же большое число
    // аналогично для wrongDivideData
    @DataProvider
    public static Object[][] correctDivideData() {
        return new Object[][]{{1, 1, 1}, {25, 5, 5}, {0, 5, 0}, {1, 2, 0}, {147896, 212, 697}, {25874, 2, 12937}};
    }

    @DataProvider
    public static Object[][] wrongDivideData() {
        return new Object[][]{{5, 5, 0}, {100, 4, 2}, {0, 2, 1}, {1, 8, 4}, {14789, 113, 14}, {24274, 2, 4254}};
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
