package mapper;

import pojo.Role;

import java.util.List;

/**
 * Created by zz_liu on 2018/1/18.
 */
public interface RoleMapper {
    int insertRole(Role role);
    int deleteRole(int id);
    int updateRole(Role role);
    Role getRole(int id);
}
