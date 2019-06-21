package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Subtract extends BaseClass {

    //    TODO Why you decide use this set of the test data?
    // Для того чтобы проверить на различных типах данных
    // 1) вычитание любых, 2) вычитание из нуля, 3) вычитание для получения нуля,
    // 4) вычитание из отрицательного положительного, 5) вычитание из трехзначного отрацительного,
    // 5) вычитание отрицательного, 6) вычитание больших чисел
    // аналогично для wrongSubtractData
    @DataProvider
    public static Object[][] correctSubtractData() {
        return new Object[][]{{5, 2, 3}, {0, 1, -1}, {0, 0, 0}, {-1, 1, -2}, {-100, 15, -115}, {-2, -2, 0}, {12345, 12300, 45}};
    }

    @DataProvider
    public static Object[][] wrongSubtractData() {
        return new Object[][]{{3, 2, 0}, {0, 6, 0}, {-7, 7, 0}, {-80, 40, 40}, {-200, -220, -400}, {548, -87, 110}, {12345, 45, 12390}};
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
