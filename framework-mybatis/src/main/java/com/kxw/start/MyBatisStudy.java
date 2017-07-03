package com.kxw.start;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by kangxiongwei on 2017/7/3.
 */
public class MyBatisStudy {

    public static void main(String[] args) {
        MyBatisStudy study = new MyBatisStudy();
        SqlSessionFactory factory = SqlSessionUtil.getInstance().getFactory();

        //插入
        study.insert(factory);
    }


    private void insert(SqlSessionFactory factory) {
        SqlSession session = factory.openSession();
        try {
            session.insert("insert");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
