package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public abstract class BaseClass {
    //    TODO I think it will be better to move it to BaseClass
    //    TODO Why is this field has protected modifier?
    //    ANSWER:  to give access to subclasses (to extend here)
    protected Calculator calc;

    //    TODO I think it will be better to move it to BaseClass
    @BeforeMethod
    public void createCalc() {
        calc = new Calculator();
    }

}

