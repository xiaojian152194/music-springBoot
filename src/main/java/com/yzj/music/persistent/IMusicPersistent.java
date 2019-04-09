/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzj.music.persistent;

import com.yzj.music.commons.PageRange;
import com.yzj.music.commons.PageSerachParameters;
import com.yzj.music.entity.Music;
import com.yzj.music.commons.exception.MusicException;
import java.util.Collection;
import com.yzj.music.pojo.search.MusicSearch;

/**
 * 该接口是完成对数据库表P_CLOUD_MUSIC_MUSIC的持久化申明，包括对该表的增、删、改、查等基本操作的接口定义。
 *
 * @author xiaojianzzz@163.com
 * @version 1.0.0-RELEASE
 */
public interface IMusicPersistent {
  public static final String OPERATE_TARGET = "com.yzj.music.Music";

  /**
   * 将对象保存到数据库 P_CLOUD_MUSIC_MUSIC 表中。
   *
   * @param music
   *            要保存的对象。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void saveMusic(Music music) throws MusicException;

  /**
   * 将对象集合保存到数据库 P_CLOUD_MUSIC_MUSIC 表中。
   *
   * @param musics
   *            要保存的对象集合。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void batchSaveMusic(Collection<Music> musics) throws MusicException;

  /**
   * 修改数据库 P_CLOUD_MUSIC_MUSIC 表的记录。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param music
   *            要修改的对象。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void updateMusic(Music music) throws MusicException;

  /**
   * 批量修改数据库 P_CLOUD_MUSIC_MUSIC 表的记录。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param musics
   *            要修改的对象集合。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void batchUpdateMusic(Collection<Music> musics) throws MusicException;

  /**
   * 根据主键删除数据库 P_CLOUD_MUSIC_MUSIC 表的记录。
   * 
   * @param music
   *            要删除的对象。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void removeMusic(Music music) throws MusicException;

  /**
   * 根据主键批量删除数据库 P_CLOUD_MUSIC_MUSIC 表的记录。
   *
   * @param musics
   *            要删除的对象集合。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void batchRemoveMusic(Collection<Music> musics) throws MusicException;

  /**
   * 根据主键查询数据库 P_CLOUD_MUSIC_MUSIC 表中的记录，如果未找到将返回NULL。
   * 
   * @param id
   *            要查询的主键。
   * @return 根据主键查询到的对象，查询不到返回 null
   * @throws MusicException 运行出错会抛出该异常
   */
  public Music getMusicByPrimaryKey(java.lang.String id) throws MusicException;

  /**
   * 根据条件进行查询数据库 P_CLOUD_MUSIC_MUSIC 表的记录条数。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   * 
   * @param musicSearch
   *            查询条件
   * @return 返回查询到的记录个数
   * @throws MusicException 运行出错会抛出该异常
   */
  public Long getCountMusic(final MusicSearch musicSearch) throws MusicException;

  /**
   * 查询数据库 P_CLOUD_MUSIC_MUSIC 表的所有记录。
   * @return 返回所有查询到的对象集合
   * @throws MusicException 运行出错会抛出该异常
   */
  public Collection<Music> getAllMusic() throws MusicException;

  /**
   * 分页查询数据库 P_CLOUD_MUSIC_MUSIC 表的所有记录。。
   *
   * @param page
   *            分页参数。
   * @return 返回当前页数据以及数据总条数等相关信息
   * @throws MusicException 运行出错会抛出该异常
   */
  public PageRange<Music> paginationGetAllMusic(PageSerachParameters page) throws MusicException;

  /**
   * 根据条件进行查询数据库 P_CLOUD_MUSIC_MUSIC 表的记录。
   * 当查询条件对象当中的属性不为空将按该条件有效。
   *
   * @param musicSearch
   *            查询条件
   * @return 返回所有查询到的对象集合
   * @throws MusicException 运行出错会抛出该异常
   */
  public Collection<Music> searchMusic(final MusicSearch musicSearch) throws MusicException;

  /**
   * 根据条件进行，分页查询数据库 P_CLOUD_MUSIC_MUSIC 表的记录。
   * 当查询条件对象当中的属性不为空将按该条件有效。
   *
   * @param musicSearch
   *            查询条件
   * @param page
   *            分页参数。
   * @return 返回当前页数据以及数据总条数等相关信息
   * @throws MusicException 运行出错会抛出该异常
   */
  public PageRange<Music> paginationSearchMusic(final MusicSearch musicSearch, PageSerachParameters page) throws MusicException;
}