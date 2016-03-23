package cn.springmvc.dao;

import cn.springmvc.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 王涛涛 on 2016/2/15.
 */
@Repository("userDao")
public interface UserDAO {

    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
}
