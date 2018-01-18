package main;

import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import pojo.Role;
import util.SqlSessionFactoryUtil;

/**
 * Created by zz_liu on 2018/1/18.
 */
public class MybatisTest {
    public static void main(String... args){
        Logger log = Logger.getLogger(MybatisTest.class);
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role role = mapper.getRole(1);
            log.info(role.getRoleName());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
