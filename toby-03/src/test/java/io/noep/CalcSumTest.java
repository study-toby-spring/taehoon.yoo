package io.noep;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 3.
 * Time  : 오후 9:01
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class CalcSumTest {

    Calculator calculator;
    String numFilePath;

    @Before
    public void setUp() {
        this.calculator = new Calculator();
        this.numFilePath = getClass().getResource("/numbers.txt").getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException {
        assertThat(calculator.calcSum(this.numFilePath), is(10));
    }

    @Test
    public void multiplyOfNumbers() throws IOException {
        assertThat(calculator.calcMultiply(this.numFilePath), is(24));
    }

    @Test
    public void concatenateStrings() throws IOException{
        assertThat(calculator.concatenate(this.numFilePath), is("1234"));
    }

}
