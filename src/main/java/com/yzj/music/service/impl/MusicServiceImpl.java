/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzj.music.service.impl;

import com.yzj.music.commons.exception.MusicException;
import com.yzj.music.service.IMusicService;
import com.yzj.music.commons.exception.MusicException;
import com.yzj.music.persistent.IUserPersistent;
import com.yzj.music.persistent.IMusicPersistent;
import com.yzj.music.entity.Music;
import com.yzj.music.commons.PageRange;
import com.yzj.music.commons.PageSerachParameters;
import com.yzj.music.entity.User;
import java.util.Collection;
import com.yzj.music.pojo.search.UserSearch;
import java.util.UUID;
import com.yzj.music.pojo.search.MusicSearch;

/**
 * 该类是以下对象操作的业务具休实现。
 * 用户
 * 歌曲信息
 *
 * @author xiaojianzzz@163.com
 * @version 1.0.0-RELEASE
 */
@org.springframework.stereotype.Service("com.yzj.music.MusicService")
@org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = java.lang.Exception.class)
public class MusicServiceImpl implements IMusicService {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(MusicServiceImpl.class);

  @javax.annotation.Resource(name = "com.yzj.music.UserPersistent")
  private IUserPersistent userPersistent;

  @javax.annotation.Resource(name = "com.yzj.music.MusicPersistent")
  private IMusicPersistent musicPersistent;

  @org.springframework.beans.factory.annotation.Autowired
  protected org.springframework.context.ApplicationEventPublisher publisher;
  // UserPersistentImpl
  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public User saveUser(User user) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.saveUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      user.clearPrimaryKeyValue();
      if (user.getId() == null || user.getId().trim().length() < 1) {
        user.setId(UUID.randomUUID().toString());
      }
      return userPersistent.saveUser(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveUser(Collection<User> users) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.batchSaveUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      for(User user : users) {
        if(user == null || user.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("user不能为空。");
        }
        user.clearPrimaryKeyValue();
        if (user.getId() == null || user.getId().trim().length() < 1) {
          user.setId(UUID.randomUUID().toString());
        }
      }
      userPersistent.batchSaveUser(users);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateUser(User user) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.updateUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      if (user.getId() == null || user.getId().trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      User userOld = userPersistent.getUserByPrimaryKey(user.getId());
      if (userOld == null) {
        throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
      }
      userPersistent.updateUser(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateUser(Collection<User> users) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.batchUpdateUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      for(User user : users) {
        if(user == null || user.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("user不能为空。");
        }
        if (user.getId() == null || user.getId().trim().length() < 1) {
          throw new java.lang.IllegalArgumentException("id不能为空。");
        }
        User userOld = userPersistent.getUserByPrimaryKey(user.getId());
        if (userOld == null) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
      }
      userPersistent.batchUpdateUser(users);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeUser(User user) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.removeUser ");
      log.debug("parameter user is : " + user);
    }
    try {
      if (user == null || user.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("user不能为空。");
      }
      java.util.Set<User> deleteUsers = new java.util.LinkedHashSet<>();
      if (user.getId() != null && user.getId().trim().length() > 0) {
        User userOld = userPersistent.getUserByPrimaryKey(user.getId());
        if (userOld == null ) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
        deleteUsers.add(userOld);
      } else {
        UserSearch userSearch = new UserSearch();
        userSearch.setEntity(user);
        deleteUsers.addAll(userPersistent.searchUser(userSearch));
      }
      if (deleteUsers != null && !deleteUsers.isEmpty()) {
        for(User deleteUser : deleteUsers) {
          MusicSearch cascadeDeleteMusicSearch = new MusicSearch();
          cascadeDeleteMusicSearch.setUserId(deleteUser.getId());
          Long count0 = musicPersistent.getCountMusic(cascadeDeleteMusicSearch);
          if (count0 > 0) {
            throw new MusicException(" 数据被歌曲信息引用不能删除。");
          }
        }
        userPersistent.batchRemoveUser(deleteUsers);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveUser(Collection<User> users) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.batchRemoveUser ");
      log.debug("parameter users is : " + users);
    }
    try {
      if (users == null || users.isEmpty()) {
        throw new java.lang.IllegalArgumentException("users不能为空。");
      }
      java.util.Set<User> deleteUsers = new java.util.LinkedHashSet<>();
      for(User user : users) {
        if (user.getId() != null && user.getId().trim().length() > 0) {
          User userOld = userPersistent.getUserByPrimaryKey(user.getId());
          if (userOld == null ) {
            throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
          }
          deleteUsers.add(userOld);
        } else {
          UserSearch userSearch = new UserSearch();
          userSearch.setEntity(user);
          deleteUsers.addAll(userPersistent.searchUser(userSearch));
        }
      }
      if (deleteUsers != null && !deleteUsers.isEmpty()) {
        for(User deleteUser : deleteUsers) {
          MusicSearch cascadeDeleteMusicSearch = new MusicSearch();
          cascadeDeleteMusicSearch.setUserId(deleteUser.getId());
          Long count0 = musicPersistent.getCountMusic(cascadeDeleteMusicSearch);
          if (count0 > 0) {
            throw new MusicException(" 数据被歌曲信息引用不能删除。");
          }
        }
        userPersistent.batchRemoveUser(deleteUsers);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public User getUserByPrimaryKey(java.lang.String id) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.getUserByPrimaryKey ");
      log.debug("parameter id is : " + id);
    }
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      return userPersistent.getUserByPrimaryKey(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getCountUser(final UserSearch userSearch) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.getCountUser ");
      log.debug("parameter userSearch is : " + userSearch);
    }
    try {
      return userPersistent.getCountUser(userSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<User> getAllUser() throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.getAllUser ");
    }
    try {
      return userPersistent.getAllUser();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<User> paginationGetAllUser(PageSerachParameters page) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.paginationGetAllUser ");
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return userPersistent.paginationGetAllUser(page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<User> searchUser(final UserSearch userSearch) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.searchUser ");
      log.debug("parameter userSearch is : " + userSearch);
    }
    try {
      return userPersistent.searchUser(userSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<User> searchUser1(final User user) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.searchUser ");
      log.debug("parameter userSearch is : " + user);
    }
    try {
      return userPersistent.searchUser1(user);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<User> paginationSearchUser(final UserSearch userSearch, PageSerachParameters page) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.paginationSearchUser ");
      log.debug("parameter userSearch is : " + userSearch);
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return userPersistent.paginationSearchUser(userSearch, page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  // MusicPersistentImpl
  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveMusic(Music music) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.saveMusic ");
      log.debug("parameter music is : " + music);
    }
    try {
      if (music == null || music.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("music不能为空。");
      }
      music.clearPrimaryKeyValue();
      if (music.getId() == null || music.getId().trim().length() < 1) {
        music.setId(UUID.randomUUID().toString());
      }
      musicPersistent.saveMusic(music);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveMusic(Collection<Music> musics) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.batchSaveMusic ");
      log.debug("parameter musics is : " + musics);
    }
    try {
      if (musics == null || musics.isEmpty()) {
        throw new java.lang.IllegalArgumentException("musics不能为空。");
      }
      for(Music music : musics) {
        if(music == null || music.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("music不能为空。");
        }
        music.clearPrimaryKeyValue();
        if (music.getId() == null || music.getId().trim().length() < 1) {
          music.setId(UUID.randomUUID().toString());
        }
      }
      musicPersistent.batchSaveMusic(musics);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateMusic(Music music) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.updateMusic ");
      log.debug("parameter music is : " + music);
    }
    try {
      if (music == null || music.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("music不能为空。");
      }
      if (music.getId() == null || music.getId().trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      Music musicOld = musicPersistent.getMusicByPrimaryKey(music.getId());
      if (musicOld == null) {
        throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
      }
      musicPersistent.updateMusic(music);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateMusic(Collection<Music> musics) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.batchUpdateMusic ");
      log.debug("parameter musics is : " + musics);
    }
    try {
      if (musics == null || musics.isEmpty()) {
        throw new java.lang.IllegalArgumentException("musics不能为空。");
      }
      for(Music music : musics) {
        if(music == null || music.selfIsNull()) {
          throw new java.lang.IllegalArgumentException("music不能为空。");
        }
        if (music.getId() == null || music.getId().trim().length() < 1) {
          throw new java.lang.IllegalArgumentException("id不能为空。");
        }
        Music musicOld = musicPersistent.getMusicByPrimaryKey(music.getId());
        if (musicOld == null) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
      }
      musicPersistent.batchUpdateMusic(musics);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeMusic(Music music) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.removeMusic ");
      log.debug("parameter music is : " + music);
    }
    try {
      if (music == null || music.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("music不能为空。");
      }
      java.util.Set<Music> deleteMusics = new java.util.LinkedHashSet<>();
      if (music.getId() != null && music.getId().trim().length() > 0) {
        Music musicOld = musicPersistent.getMusicByPrimaryKey(music.getId());
        if (musicOld == null ) {
          throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
        }
        deleteMusics.add(musicOld);
      } else {
        MusicSearch musicSearch = new MusicSearch();
        musicSearch.setEntity(music);
        deleteMusics.addAll(musicPersistent.searchMusic(musicSearch));
      }
      if (deleteMusics != null && !deleteMusics.isEmpty()) {
        musicPersistent.batchRemoveMusic(deleteMusics);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveMusic(Collection<Music> musics) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.batchRemoveMusic ");
      log.debug("parameter musics is : " + musics);
    }
    try {
      if (musics == null || musics.isEmpty()) {
        throw new java.lang.IllegalArgumentException("musics不能为空。");
      }
      java.util.Set<Music> deleteMusics = new java.util.LinkedHashSet<>();
      for(Music music : musics) {
        if (music.getId() != null && music.getId().trim().length() > 0) {
          Music musicOld = musicPersistent.getMusicByPrimaryKey(music.getId());
          if (musicOld == null ) {
            throw new java.lang.IllegalArgumentException(" 要修改的数据不存在。");
          }
          deleteMusics.add(musicOld);
        } else {
          MusicSearch musicSearch = new MusicSearch();
          musicSearch.setEntity(music);
          deleteMusics.addAll(musicPersistent.searchMusic(musicSearch));
        }
      }
      if (deleteMusics != null && !deleteMusics.isEmpty()) {
        musicPersistent.batchRemoveMusic(deleteMusics);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Music getMusicByPrimaryKey(java.lang.String id) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.getMusicByPrimaryKey ");
      log.debug("parameter id is : " + id);
    }
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      return musicPersistent.getMusicByPrimaryKey(id);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getCountMusic(final MusicSearch musicSearch) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.getCountMusic ");
      log.debug("parameter musicSearch is : " + musicSearch);
    }
    try {
      return musicPersistent.getCountMusic(musicSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Music> getAllMusic() throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.getAllMusic ");
    }
    try {
      return musicPersistent.getAllMusic();
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<Music> paginationGetAllMusic(PageSerachParameters page) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.paginationGetAllMusic ");
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return musicPersistent.paginationGetAllMusic(page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Music> searchMusic(final MusicSearch musicSearch) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.searchMusic ");
      log.debug("parameter musicSearch is : " + musicSearch);
    }
    try {
      return musicPersistent.searchMusic(musicSearch);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<Music> paginationSearchMusic(final MusicSearch musicSearch, PageSerachParameters page) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicService.paginationSearchMusic ");
      log.debug("parameter musicSearch is : " + musicSearch);
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      return musicPersistent.paginationSearchMusic(musicSearch, page);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

}