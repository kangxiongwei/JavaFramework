package com.kxw.start;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kangxiongwei on 2017/7/3.
 */
public class SqlSessionUtil {

    private static SqlSessionUtil util = new SqlSessionUtil();
    SqlSessionFactory factory;

    private SqlSessionUtil() {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static SqlSessionUtil getInstance() {
        return util;
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }
}
