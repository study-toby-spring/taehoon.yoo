package io.noep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 3.
 * Time  : 오후 9:03
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class Calculator {

    public Integer calcSum(String filePath) throws IOException {

        LineCallback<Integer> sumCallback = (line, value) -> value + Integer.valueOf(line);
        return lineReadTemplate(filePath, sumCallback, 0);
    }

    public Integer calcMultiply(String filePath) throws IOException {
        return lineReadTemplate(filePath, (line, value) -> value * Integer.valueOf(line), 1);
    }

    public String concatenate(String filePath) throws IOException {
        LineCallback<String> concatenateCallback = ((line, value) -> {
            return value + line;
        });
        return lineReadTemplate(filePath, concatenateCallback, "");
    }

    public <T> T lineReadTemplate(String filePath, LineCallback<T> callback, T initVal) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            T res = initVal;
            String line = null;

            while ((line = br.readLine()) != null) {
                res = callback.doSomethingWithLine(line, res);
            }
            return res;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


}
