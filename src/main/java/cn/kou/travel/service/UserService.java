package cn.kou.travel.service;

import cn.kou.travel.domain.User;

/**
 * @author dell
 */
public interface UserService {
    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
