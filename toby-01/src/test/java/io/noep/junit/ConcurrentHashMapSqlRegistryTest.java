package io.noep.junit;

import io.noep.service.sqlservice.ConcurrentHashMapSqlRegistry;
import io.noep.service.sqlservice.SqlNotFoundException;
import io.noep.service.sqlservice.SqlUpdateFailureException;
import io.noep.service.sqlservice.UpdatableSqlRegistry;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 11. 27.
 * Time  : 오후 11:02
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class ConcurrentHashMapSqlRegistryTest extends AbstractUpdatableSqlRegistryTest {

    UpdatableSqlRegistry sqlRegistry;

    @Override
    protected UpdatableSqlRegistry createUpdatableSqlRegistry() {
        return new ConcurrentHashMapSqlRegistry();
    }
}
