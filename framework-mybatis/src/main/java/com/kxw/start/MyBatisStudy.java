package com.kxw.start;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangxiongwei on 2017/7/3.
 */
public class MyBatisStudy {

    private SqlSessionFactory factory;

    public static void main(String[] args) throws SQLException {
        MyBatisStudy study = new MyBatisStudy();
        User user = new User("lisi", "lisi123", "李四");
        //初始化
        study.init();
        //插入
        study.insert(user);
        System.out.println(user);
        //查询
        User result = study.selectById(1);
        System.out.println(result);

        //查询列表
        List<User> list = study.list();
        for (User u: list) {
            System.out.println(u);
        }

    }

    public void init() {
        factory = SqlSessionUtil.getInstance().getFactory();
    }


    private void insert(User user) {
        SqlSession session = factory.openSession();
        try {
            session.insert("insert", user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public User selectById(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("selectUserById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> list() {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("select");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>(1);
    }


}
