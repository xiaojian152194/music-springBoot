/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzj.music.pojo.search;

import java.io.Serializable;
import com.yzj.music.entity.User;

/**
 * 用户的查询条件类。
 *
 * @author xiaojianzzz@163.com
 * @version 1.0.0-RELEASE
 */
public final class UserSearch implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String username; // eq用户名的参数值

  protected String nickname; // eq昵称的参数值

  protected String password; // eq密码的参数值

  protected String haveAuthority; // eq是否为管理员的参数值

  protected String sex; // eq0男 1女的参数值

  protected String avatarPath; // eq用户头像路径的参数值

  protected Long createDate; // eq创建时间的参数值

  protected java.lang.String likeUsername; // like图书名的参数值

  /**
   * 返回用户对象的eq用户名的参数值的值。
   * @return 用户对象的eq用户名的参数值的值
   */
  public final String getUsername() {
    return this.username;
  }

  /**
   * 设置用户对象的eq用户名的参数值的值。
   *
   * @param username
   *            eq用户名的参数值的值
   */
  public final void setUsername(String username) {
    this.username = username;
  }

  /**
   * 返回用户对象的eq昵称的参数值的值。
   * @return 用户对象的eq昵称的参数值的值
   */
  public final String getNickname() {
    return this.nickname;
  }

  /**
   * 设置用户对象的eq昵称的参数值的值。
   *
   * @param nickname
   *            eq昵称的参数值的值
   */
  public final void setNickname(String nickname) {
    this.nickname = nickname;
  }

  /**
   * 返回用户对象的eq密码的参数值的值。
   * @return 用户对象的eq密码的参数值的值
   */
  public final String getPassword() {
    return this.password;
  }

  /**
   * 设置用户对象的eq密码的参数值的值。
   *
   * @param password
   *            eq密码的参数值的值
   */
  public final void setPassword(String password) {
    this.password = password;
  }

  /**
   * 返回用户对象的eq是否为管理员的参数值的值。
   * @return 用户对象的eq是否为管理员的参数值的值
   */
  public final String getHaveAuthority() {
    return this.haveAuthority;
  }

  /**
   * 设置用户对象的eq是否为管理员的参数值的值。
   *
   * @param haveAuthority
   *            eq是否为管理员的参数值的值
   */
  public final void setHaveAuthority(String haveAuthority) {
    this.haveAuthority = haveAuthority;
  }

  /**
   * 返回用户对象的eq0男 1女的参数值的值。
   * @return 用户对象的eq0男 1女的参数值的值
   */
  public final String getSex() {
    return this.sex;
  }

  /**
   * 设置用户对象的eq0男 1女的参数值的值。
   *
   * @param sex
   *            eq0男 1女的参数值的值
   */
  public final void setSex(String sex) {
    this.sex = sex;
  }

  /**
   * 返回用户对象的eq用户头像路径的参数值的值。
   * @return 用户对象的eq用户头像路径的参数值的值
   */
  public final String getAvatarPath() {
    return this.avatarPath;
  }

  /**
   * 设置用户对象的eq用户头像路径的参数值的值。
   *
   * @param avatarPath
   *            eq用户头像路径的参数值的值
   */
  public final void setAvatarPath(String avatarPath) {
    this.avatarPath = avatarPath;
  }

  /**
   * 返回用户对象的eq创建时间的参数值的值。
   * @return 用户对象的eq创建时间的参数值的值
   */
  public final Long getCreateDate() {
    return this.createDate;
  }

  /**
   * 设置用户对象的eq创建时间的参数值的值。
   *
   * @param createDate
   *            eq创建时间的参数值的值
   */
  public final void setCreateDate(Long createDate) {
    this.createDate = createDate;
  }

  public final String getLikeUsername() {
    return likeUsername;
  }

  public final void setLikeUsername(String likeUsername) {
    this.likeUsername = likeUsername;
  }

  /**
   * 判断当前用户对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.username != null ) { return false; }
    if(this.nickname != null ) { return false; }
    if(this.password != null ) { return false; }
    if(this.haveAuthority != null ) { return false; }
    if(this.sex != null ) { return false; }
    if(this.avatarPath != null ) { return false; }
    if(this.createDate != null ) { return false; }
    if(this.likeUsername != null ) { return false; }
    return true;
  }

  @Override
  public String toString() {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }

  public void setEntity(User entity) {
    this.username = entity.getUsername();
    this.nickname = entity.getNickname();
    this.password = entity.getPassword();
    this.haveAuthority = entity.getHaveAuthority();
    this.sex = entity.getSex();
    this.avatarPath = entity.getAvatarPath();
    this.createDate = entity.getCreateDate();
  }
}