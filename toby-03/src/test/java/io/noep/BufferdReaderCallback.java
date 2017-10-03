package io.noep;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 10. 3.
 * Time  : 오후 9:19
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface BufferdReaderCallback {
    Integer doSomethingWithReader(BufferedReader br) throws IOException;
}
