package com.yzj.music.service;

import com.yzj.music.commons.exception.MusicException;
import com.yzj.music.entity.User;

public interface ILoginService {
    /**
     * 前端用户登录方法
     *
     * @param user
     * @return
     * @throws MusicException
     */
    public User login(User user) throws MusicException;

    /**
     * 前端用户注册方法
     *
     * @param user
     * @return
     * @throws MusicException
     */
    public User register(User user) throws MusicException;
}
