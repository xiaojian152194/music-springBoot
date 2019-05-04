/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzj.music.service;

import com.yzj.music.commons.exception.MusicException;
import com.yzj.music.commons.PageRange;
import com.yzj.music.commons.PageSerachParameters;
import com.yzj.music.entity.User;
import java.util.Collection;
import com.yzj.music.pojo.search.UserSearch;
import com.yzj.music.entity.Music;
import com.yzj.music.pojo.search.MusicSearch;
import org.omg.CORBA.UserException;

/**
 * 该接口是对以下对象操作的接口。
 * <b>用户</b>
 * <b>歌曲信息</b>
 * @author xiaojianzzz@163.com
 * @version 1.0.0-RELEASE
 */
public interface IMusicService {

  // UserPersistentImpl
  /**
   * 保存单个用户对象。
   *
   * @param user
   *            要保存的对象。
   * @throws MusicException 运行出错会抛出该异常
   */
  public User saveUser(User user) throws MusicException;

  /**
   * 批量保存用户对象。
   *
   * @param users
   *            要保存的对象集合。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void batchSaveUser(Collection<User> users) throws MusicException;

  /**
   * 修改单个用户对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param user
   *            要修改的对象。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void updateUser(User user) throws MusicException;

  /**
   * 批量修改用户对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param users
   *            要修改的对象集合。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void batchUpdateUser(Collection<User> users) throws MusicException;

  /**
   * 删除用户对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   * 
   * @param user
   *            要删除的对象。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void removeUser(User user) throws MusicException;

  /**
   * 批量删除用户对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   *
   * @param users
   *            要删除的对象集合。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void batchRemoveUser(Collection<User> users) throws MusicException;

  /**
   * 根据主键查询用户对象，如果未找到将返回NULL。
   * 
   * @param id
   *            要查询的主键。
   * @return 查询到的对象如果没有查到返回null
   * @throws MusicException 运行出错会抛出该异常
   */
  public User getUserByPrimaryKey(java.lang.String id) throws MusicException;

  /**
   * 根据条件进行查询用户对象个数。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   * 
   * @param userSearch
   *            查询条件
   * @return 查询到的数据条数
   * @throws MusicException 运行出错会抛出该异常
   */
  public Long getCountUser(final UserSearch userSearch) throws MusicException;

  /**
   * 查询所有用户对象。
   *
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws MusicException 运行出错会抛出该异常
   */
  public Collection<User> getAllUser() throws MusicException;

  /**
   * 分页查询用户对象。
   *
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws MusicException 运行出错会抛出该异常
   */
  public PageRange<User> paginationGetAllUser(PageSerachParameters page) throws MusicException;

  /**
   * 根据条件进行查询用户对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param userSearch
   *            查询条件
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws MusicException 运行出错会抛出该异常
   */
  public Collection<User> searchUser(final UserSearch userSearch) throws MusicException;

  /**
   * 根据条件进行，分页查询用户对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param userSearch
   *            查询条件
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws MusicException 运行出错会抛出该异常
   */
  public PageRange<User> paginationSearchUser(final UserSearch userSearch, PageSerachParameters page) throws MusicException;

  // MusicPersistentImpl
  /**
   * 保存单个歌曲信息对象。
   *
   * @param music
   *            要保存的对象。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void saveMusic(Music music) throws MusicException;

  /**
   * 批量保存歌曲信息对象。
   *
   * @param musics
   *            要保存的对象集合。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void batchSaveMusic(Collection<Music> musics) throws MusicException;

  /**
   * 修改单个歌曲信息对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param music
   *            要修改的对象。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void updateMusic(Music music) throws MusicException;

  /**
   * 批量修改歌曲信息对象。
   * 根据主键，修改表中已有的记录，修改后的值取至于要修改对象属性值。
   *
   * @param musics
   *            要修改的对象集合。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void batchUpdateMusic(Collection<Music> musics) throws MusicException;

  /**
   * 删除歌曲信息对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   * 
   * @param music
   *            要删除的对象。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void removeMusic(Music music) throws MusicException;

  /**
   * 批量删除歌曲信息对象。
   * 如果主键不为空，那么就根据主键删除表中的记录，否则根据转入对象的非空属性进行全完匹配进行删除。
   *
   * @param musics
   *            要删除的对象集合。
   * @throws MusicException 运行出错会抛出该异常
   */
  public void batchRemoveMusic(Collection<Music> musics) throws MusicException;

  /**
   * 根据主键查询歌曲信息对象，如果未找到将返回NULL。
   * 
   * @param id
   *            要查询的主键。
   * @return 查询到的对象如果没有查到返回null
   * @throws MusicException 运行出错会抛出该异常
   */
  public Music getMusicByPrimaryKey(java.lang.String id) throws MusicException;

  /**
   * 根据条件进行查询歌曲信息对象个数。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   * 
   * @param musicSearch
   *            查询条件
   * @return 查询到的数据条数
   * @throws MusicException 运行出错会抛出该异常
   */
  public Long getCountMusic(final MusicSearch musicSearch) throws MusicException;

  /**
   * 查询所有歌曲信息对象。
   *
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws MusicException 运行出错会抛出该异常
   */
  public Collection<Music> getAllMusic() throws MusicException;

  /**
   * 分页查询歌曲信息对象。
   *
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws MusicException 运行出错会抛出该异常
   */
  public PageRange<Music> paginationGetAllMusic(PageSerachParameters page) throws MusicException;

  /**
   * 根据条件进行查询歌曲信息对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param musicSearch
   *            查询条件
   * @return 查询到的对象集合如果没有查到返回null或者空集合
   * @throws MusicException 运行出错会抛出该异常
   */
  public Collection<Music> searchMusic(final MusicSearch musicSearch) throws MusicException;

  /**
   * 根据条件进行，分页查询歌曲信息对象。
   * 当查询条件对象当中的属性不为空将按该条件进行eq查询。
   *
   * @param musicSearch
   *            查询条件
   * @param page
   *            分页参数。
   * @return 当前面的对象集合以及总数据量
   * @throws MusicException 运行出错会抛出该异常
   */
  public PageRange<Music> paginationSearchMusic(final MusicSearch musicSearch, PageSerachParameters page) throws MusicException;

}