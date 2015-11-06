package io.github.gefangshuai.permission.service;

import io.github.gefangshuai.permission.model.User;
import io.github.gefangshuai.permission.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gefangshuai on 2015/11/6.
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 根据用户名和密码检查用户是否存在，返回user对象证明检查通过，返回null检查失败。
     * @param username
     * @param password
     * @return
     */
    public User checkByUsernameAndPassword(String username, String password) {
        User user = findByUsername(username);
        if (password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
