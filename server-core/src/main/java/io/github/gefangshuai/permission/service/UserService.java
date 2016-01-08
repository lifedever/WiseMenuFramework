package io.github.gefangshuai.permission.service;

import io.github.gefangshuai.constant.StatusEnum;
import io.github.gefangshuai.ext.shiro.utils.HashUtils;
import io.github.gefangshuai.permission.dao.UserDao;
import io.github.gefangshuai.permission.model.Role;
import io.github.gefangshuai.permission.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by gefangshuai on 2015/11/6.
 */
@Service
@Transactional(readOnly = true)
public class UserService {
    @Resource
    private UserDao userDao;

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 根据用户名和密码检查用户是否存在，返回user对象证明检查通过，返回null检查失败。
     *
     * @param username
     * @param password
     * @return
     */
    public User checkByUsernameAndPassword(String username, String password) {
        User user = findByUsername(username);
        if (user != null && password.equals(user.getPassword()) && StatusEnum.VALID == user.getStatus()) {
            return user;
        }
        return null;
    }

    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    /**
     * 创建新商户
     * @param user
     */
    @Transactional
    public User createUser(User user, Role role) {
        String salt = HashUtils.generateSalt();
        user.setSalt(salt);
        user.setRole(role);
        user.setStatus(StatusEnum.VALID);
        String password = HashUtils.toMd5(user.getPassword(), salt);
        user.setPassword(password);
        return userDao.save(user);
    }
}
