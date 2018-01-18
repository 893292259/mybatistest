package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zz_liu on 2018/1/18.
 */
public class SqlSessionFactoryUtil {
    private final static Class<SqlSessionFactoryUtil> LOCK = SqlSessionFactoryUtil.class;
    private static SqlSessionFactory sqlSessionFactory = null;

    public SqlSessionFactoryUtil() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        synchronized (LOCK){
            if (sqlSessionFactory!=null){
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
            catch (IOException e){
                e.printStackTrace();
                return  null;
            }
            return  sqlSessionFactory;
        }
    }
    public static SqlSession openSqlSession(){
        if (sqlSessionFactory == null){
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
