package cn.springmvc.service.impl;

import cn.springmvc.dao.UserDAO;
import cn.springmvc.model.User;
import cn.springmvc.service.LogAnnotation;
import cn.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 王涛涛 on 2016/2/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDAO userDAO;
    @LogAnnotation
    @Override
    @Async
    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }
}
