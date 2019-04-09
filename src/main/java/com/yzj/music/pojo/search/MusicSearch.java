/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzj.music.pojo.search;

import java.io.Serializable;
import com.yzj.music.entity.Music;

/**
 * 歌曲信息的查询条件类。
 *
 * @author xiaojianzzz@163.com
 * @version 1.0.0-RELEASE
 */
public final class MusicSearch implements Serializable {

  private static final long serialVersionUID = 1L;

  protected String musicName; // eq歌曲名称,上传时的歌曲名称,也是显示的歌曲名称的参数值

  protected String musicRealName; // eq存储的真实歌曲名称的参数值

  protected String musicPath; // eq歌曲在服务器中的真实路径的参数值

  protected String musicSize; // eq歌曲大小 单位根据大小定的参数值

  protected Integer downloadNum; // eq歌曲下载次数的参数值

  protected Long uploadTime; // eq歌曲上传时间的参数值

  protected String uploadIp; // eq歌曲上传的IP地址的参数值

  protected String userId; // eq所属用户ID的参数值

  /**
   * 返回歌曲信息对象的eq歌曲名称,上传时的歌曲名称,也是显示的歌曲名称的参数值的值。
   * @return 歌曲信息对象的eq歌曲名称,上传时的歌曲名称,也是显示的歌曲名称的参数值的值
   */
  public final String getMusicName() {
    return this.musicName;
  }

  /**
   * 设置歌曲信息对象的eq歌曲名称,上传时的歌曲名称,也是显示的歌曲名称的参数值的值。
   *
   * @param musicName
   *            eq歌曲名称,上传时的歌曲名称,也是显示的歌曲名称的参数值的值
   */
  public final void setMusicName(String musicName) {
    this.musicName = musicName;
  }

  /**
   * 返回歌曲信息对象的eq存储的真实歌曲名称的参数值的值。
   * @return 歌曲信息对象的eq存储的真实歌曲名称的参数值的值
   */
  public final String getMusicRealName() {
    return this.musicRealName;
  }

  /**
   * 设置歌曲信息对象的eq存储的真实歌曲名称的参数值的值。
   *
   * @param musicRealName
   *            eq存储的真实歌曲名称的参数值的值
   */
  public final void setMusicRealName(String musicRealName) {
    this.musicRealName = musicRealName;
  }

  /**
   * 返回歌曲信息对象的eq歌曲在服务器中的真实路径的参数值的值。
   * @return 歌曲信息对象的eq歌曲在服务器中的真实路径的参数值的值
   */
  public final String getMusicPath() {
    return this.musicPath;
  }

  /**
   * 设置歌曲信息对象的eq歌曲在服务器中的真实路径的参数值的值。
   *
   * @param musicPath
   *            eq歌曲在服务器中的真实路径的参数值的值
   */
  public final void setMusicPath(String musicPath) {
    this.musicPath = musicPath;
  }

  /**
   * 返回歌曲信息对象的eq歌曲大小 单位根据大小定的参数值的值。
   * @return 歌曲信息对象的eq歌曲大小 单位根据大小定的参数值的值
   */
  public final String getMusicSize() {
    return this.musicSize;
  }

  /**
   * 设置歌曲信息对象的eq歌曲大小 单位根据大小定的参数值的值。
   *
   * @param musicSize
   *            eq歌曲大小 单位根据大小定的参数值的值
   */
  public final void setMusicSize(String musicSize) {
    this.musicSize = musicSize;
  }

  /**
   * 返回歌曲信息对象的eq歌曲下载次数的参数值的值。
   * @return 歌曲信息对象的eq歌曲下载次数的参数值的值
   */
  public final Integer getDownloadNum() {
    return this.downloadNum;
  }

  /**
   * 设置歌曲信息对象的eq歌曲下载次数的参数值的值。
   *
   * @param downloadNum
   *            eq歌曲下载次数的参数值的值
   */
  public final void setDownloadNum(Integer downloadNum) {
    this.downloadNum = downloadNum;
  }

  /**
   * 返回歌曲信息对象的eq歌曲上传时间的参数值的值。
   * @return 歌曲信息对象的eq歌曲上传时间的参数值的值
   */
  public final Long getUploadTime() {
    return this.uploadTime;
  }

  /**
   * 设置歌曲信息对象的eq歌曲上传时间的参数值的值。
   *
   * @param uploadTime
   *            eq歌曲上传时间的参数值的值
   */
  public final void setUploadTime(Long uploadTime) {
    this.uploadTime = uploadTime;
  }

  /**
   * 返回歌曲信息对象的eq歌曲上传的IP地址的参数值的值。
   * @return 歌曲信息对象的eq歌曲上传的IP地址的参数值的值
   */
  public final String getUploadIp() {
    return this.uploadIp;
  }

  /**
   * 设置歌曲信息对象的eq歌曲上传的IP地址的参数值的值。
   *
   * @param uploadIp
   *            eq歌曲上传的IP地址的参数值的值
   */
  public final void setUploadIp(String uploadIp) {
    this.uploadIp = uploadIp;
  }

  /**
   * 返回歌曲信息对象的eq所属用户ID的参数值的值。
   * @return 歌曲信息对象的eq所属用户ID的参数值的值
   */
  public final String getUserId() {
    return this.userId;
  }

  /**
   * 设置歌曲信息对象的eq所属用户ID的参数值的值。
   *
   * @param userId
   *            eq所属用户ID的参数值的值
   */
  public final void setUserId(String userId) {
    this.userId = userId;
  }


  /**
   * 判断当前歌曲信息对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.musicName != null ) { return false; }
    if(this.musicRealName != null ) { return false; }
    if(this.musicPath != null ) { return false; }
    if(this.musicSize != null ) { return false; }
    if(this.downloadNum != null ) { return false; }
    if(this.uploadTime != null ) { return false; }
    if(this.uploadIp != null ) { return false; }
    if(this.userId != null ) { return false; }
    return true;
  }

  @Override
  public String toString() {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }

  public void setEntity(Music entity) {
    this.musicName = entity.getMusicName();
    this.musicRealName = entity.getMusicRealName();
    this.musicPath = entity.getMusicPath();
    this.musicSize = entity.getMusicSize();
    this.downloadNum = entity.getDownloadNum();
    this.uploadTime = entity.getUploadTime();
    this.uploadIp = entity.getUploadIp();
    this.userId = entity.getUserId();
  }
}