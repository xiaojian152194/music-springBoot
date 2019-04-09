package com.yzj.music.service.impl;

import com.yzj.music.commons.contants.Contants;
import com.yzj.music.commons.exception.MusicException;
import com.yzj.music.entity.User;
import com.yzj.music.service.ILoginService;
import com.yzj.music.service.IMusicService;
import com.yzj.music.pojo.search.UserSearch;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service("com.yzj.music.LoginService")
public class LoginServiceImpl implements ILoginService {

    @javax.annotation.Resource(name = "com.yzj.music.MusicService")
    private IMusicService musicService;

    /**
     * {@inheritDoc}
     */
    @Override
    public User login(User user) throws MusicException {
        User searchUser = new User(), success = null;
        searchUser.setUsername(user.getUsername());
        List<User> users = new ArrayList<>(musicService.searchUser1(searchUser));
        if (users.isEmpty()) {
            throw new MusicException(" 用户名不存在 ");
        }
        success = users.get(0);
        if (!success.getPassword().equals(user.getPassword())) {
            throw new MusicException(" 密码错误 ");
        }
        return success;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public User register(User user) throws MusicException {
        User searchUser = new User(), success = null;
        searchUser.setUsername(user.getUsername());
        List<User> users = new ArrayList<>(musicService.searchUser1(searchUser));
        if (!users.isEmpty()) {
            throw new MusicException(user.getUsername() + " 已被注册 ");
        }
        user.setHaveAuthority(Contants.NoOrFalse);
        success = musicService.saveUser(user);
        return success;
    }

}
