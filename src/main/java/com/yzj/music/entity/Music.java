/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzj.music.entity;


/**
 * 歌曲信息的实体类，关联的表名为P_CLOUD_MUSIC_MUSIC。
 *
 * @author xiaojianzzz@163.com
 * @version 1.0.0-RELEASE
 */
public class Music implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected String id; // 歌曲编号

  protected String musicName; // 歌曲名称,上传时的歌曲名称,也是显示的歌曲名称

  protected String musicRealName; // 存储的真实歌曲名称

  protected String musicPath; // 歌曲在服务器中的真实路径

  protected String musicSize; // 歌曲大小 单位根据大小定

  protected Integer downloadNum; // 歌曲下载次数

  protected Long uploadTime; // 歌曲上传时间

  protected String uploadTimeString; // 文件上传时间字符串

  protected String uploadIp; // 歌曲上传的IP地址

  protected String userId; // 所属用户ID

  /**
   * 返回歌曲信息对象的歌曲编号的值。
   * @return 歌曲信息对象的歌曲编号的值
   */
  public final String getId() {
    return this.id;
  }

  /**
   * 设置歌曲信息对象的歌曲编号的值。
   *
   * @param id 
   *            歌曲编号的值
   */
  public final void setId(String id) {
    this.id = id;
  }

  /**
   * 返回歌曲信息对象的歌曲名称,上传时的歌曲名称,也是显示的歌曲名称的值。
   * @return 歌曲信息对象的歌曲名称,上传时的歌曲名称,也是显示的歌曲名称的值
   */
  public final String getMusicName() {
    return this.musicName;
  }

  /**
   * 设置歌曲信息对象的歌曲名称,上传时的歌曲名称,也是显示的歌曲名称的值。
   *
   * @param musicName 
   *            歌曲名称,上传时的歌曲名称,也是显示的歌曲名称的值
   */
  public final void setMusicName(String musicName) {
    this.musicName = musicName;
  }

  /**
   * 返回歌曲信息对象的存储的真实歌曲名称的值。
   * @return 歌曲信息对象的存储的真实歌曲名称的值
   */
  public final String getMusicRealName() {
    return this.musicRealName;
  }

  /**
   * 设置歌曲信息对象的存储的真实歌曲名称的值。
   *
   * @param musicRealName 
   *            存储的真实歌曲名称的值
   */
  public final void setMusicRealName(String musicRealName) {
    this.musicRealName = musicRealName;
  }

  /**
   * 返回歌曲信息对象的歌曲在服务器中的真实路径的值。
   * @return 歌曲信息对象的歌曲在服务器中的真实路径的值
   */
  public final String getMusicPath() {
    return this.musicPath;
  }

  /**
   * 设置歌曲信息对象的歌曲在服务器中的真实路径的值。
   *
   * @param musicPath 
   *            歌曲在服务器中的真实路径的值
   */
  public final void setMusicPath(String musicPath) {
    this.musicPath = musicPath;
  }

  /**
   * 返回歌曲信息对象的歌曲大小 单位根据大小定的值。
   * @return 歌曲信息对象的歌曲大小 单位根据大小定的值
   */
  public final String getMusicSize() {
    return this.musicSize;
  }

  /**
   * 设置歌曲信息对象的歌曲大小 单位根据大小定的值。
   *
   * @param musicSize 
   *            歌曲大小 单位根据大小定的值
   */
  public final void setMusicSize(String musicSize) {
    this.musicSize = musicSize;
  }

  /**
   * 返回歌曲信息对象的歌曲下载次数的值。
   * @return 歌曲信息对象的歌曲下载次数的值
   */
  public final Integer getDownloadNum() {
    return this.downloadNum;
  }

  /**
   * 设置歌曲信息对象的歌曲下载次数的值。
   *
   * @param downloadNum 
   *            歌曲下载次数的值
   */
  public final void setDownloadNum(Integer downloadNum) {
    this.downloadNum = downloadNum;
  }

  /**
   * 返回歌曲信息对象的歌曲上传时间的值。
   * @return 歌曲信息对象的歌曲上传时间的值
   */
  public final Long getUploadTime() {
    return this.uploadTime;
  }

  /**
   * 设置歌曲信息对象的歌曲上传时间的值。
   *
   * @param uploadTimeString
   *            歌曲上传时间的值
   */
  public final void setUploadTimeString(String uploadTimeString) {
    this.uploadTimeString = uploadTimeString;
  }

  /**
   * 返回歌曲信息对象的歌曲上传时间的值。
   * @return 歌曲信息对象的歌曲上传时间的值
   */
  public final String getUploadTimeString() {
    return this.uploadTimeString;
  }

  /**
   * 设置歌曲信息对象的歌曲上传时间的值。
   *
   * @param uploadTime
   *            歌曲上传时间的值
   */
  public final void setUploadTime(Long uploadTime) {
    this.uploadTime = uploadTime;
  }

  /**
   * 返回歌曲信息对象的歌曲上传的IP地址的值。
   * @return 歌曲信息对象的歌曲上传的IP地址的值
   */
  public final String getUploadIp() {
    return this.uploadIp;
  }

  /**
   * 设置歌曲信息对象的歌曲上传的IP地址的值。
   *
   * @param uploadIp 
   *            歌曲上传的IP地址的值
   */
  public final void setUploadIp(String uploadIp) {
    this.uploadIp = uploadIp;
  }

  /**
   * 返回歌曲信息对象的所属用户ID的值。
   * @return 歌曲信息对象的所属用户ID的值
   */
  public final String getUserId() {
    return this.userId;
  }

  /**
   * 设置歌曲信息对象的所属用户ID的值。
   *
   * @param userId 
   *            所属用户ID的值
   */
  public final void setUserId(String userId) {
    this.userId = userId;
  }



  @Override
  public String toString() {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }

  @Override
  public boolean equals(Object object) {
    return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, object);
  }

  @Override
  public int hashCode() {
    return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(this);
  }

  /**
   * 判断当前歌曲信息对象本身是否为空，只要对象的属性全部为null是返回true，否则返回 false。
   * @return true代表当前对象所有属性全部为空，，false代表当前对象并非所有属性都为空
   */
  public boolean selfIsNull() {
    if(this.id != null ) { return false; }
    if(this.musicName != null ) { return false; }
    if(this.musicRealName != null ) { return false; }
    if(this.musicPath != null ) { return false; }
    if(this.musicSize != null ) { return false; }
    if(this.downloadNum != null ) { return false; }
    if(this.uploadTime != null ) { return false; }
    if(this.uploadTimeString != null ) { return false; }
    if(this.uploadIp != null ) { return false; }
    if(this.userId != null ) { return false; }
    return true;
  }

  /**
   * 检查歌曲信息对象与目标歌曲信息对象的逻辑版本是否一致。
   *
   * @param entity
   *            要对比的歌曲信息对象。
   * @return true代表两个对象的版本一致，false代表两个对象的版本不一致
   */
  public boolean checkVersion(Music entity){
    if (this == entity) return true;
    if (entity == null || getClass() != entity.getClass()) return false;
    return true;
  }

  /**
   * 将当前歌曲信息对象当中的非空属性，逐一克隆到目标歌曲信息当中。
   *
   * @param entity
   *            将被克隆到的目标歌曲信息对象。
   */
  public void cloneThis(Music entity ) {
    if (this.id != null && this.id.trim().length() > 0) 
      entity.id = this.id;
    if (this.musicName != null && this.musicName.trim().length() > 0) 
      entity.musicName = this.musicName;
    if (this.musicRealName != null && this.musicRealName.trim().length() > 0) 
      entity.musicRealName = this.musicRealName;
    if (this.musicPath != null && this.musicPath.trim().length() > 0) 
      entity.musicPath = this.musicPath;
    if (this.musicSize != null && this.musicSize.trim().length() > 0) 
      entity.musicSize = this.musicSize;
    if (this.downloadNum != null) 
      entity.downloadNum = this.downloadNum;
    if (this.uploadTime != null) 
      entity.uploadTime = this.uploadTime;
    if (this.uploadTimeString != null && this.uploadTimeString.trim().length() > 0)
      entity.uploadTimeString = this.uploadTimeString;
    if (this.uploadIp != null && this.uploadIp.trim().length() > 0) 
      entity.uploadIp = this.uploadIp;
    if (this.userId != null && this.userId.trim().length() > 0) 
      entity.userId = this.userId;
  }

  /**
   * 将当前歌曲信息对象当中的非空属性，逐一克隆到到目标歌曲信息对象集合当中。
   *
   * @param entities
   *            将被克隆到的目标歌曲信息对象集合。
   */
  public void cloneThisToCollection(java.util.Collection<Music> entities ) {
    for(Music entity : entities) {
      cloneThis(entity);
    }
  }

  /**
   * 将当前歌曲信息对象的主键的值设置为null。
   */
  public void clearPrimaryKeyValue() {
    this.id = null;
  }
}