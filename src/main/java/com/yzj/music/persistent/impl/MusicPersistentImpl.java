/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzj.music.persistent.impl;

import com.yzj.music.commons.PageRange;
import com.yzj.music.commons.PageSerachParameters;
import com.yzj.music.commons.SecurityContext;
import com.yzj.music.commons.Sort;
import com.yzj.music.entity.Music;
import com.yzj.music.persistent.IMusicPersistent;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import com.yzj.music.commons.exception.MusicException;
import java.util.Collection;
import com.yzj.music.pojo.search.MusicSearch;

/**
 * 该类是完成对数据库表P_CLOUD_MUSIC_MUSIC的持久化实现，包括对该表的增、删、改、查等基本操作的的具休实现。
 *
 * @author xiaojianzzz@163.com
 * @version 1.0.0-RELEASE
 */
@org.springframework.stereotype.Repository("com.yzj.music.MusicPersistent")
public class MusicPersistentImpl extends com.yzj.music.persistent.impl.BasePersistent implements IMusicPersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(MusicPersistentImpl.class);


  public static final String TABLE_NAME = "P_CLOUD_MUSIC_MUSIC";
  public static final String TABLE_ALIAS = "music";

  public static final String COLUMN_ID = "ID";
  public static final String COLUMN_MUSIC_NAME = "MUSIC_NAME";
  public static final String COLUMN_MUSIC_REAL_NAME = "MUSIC_REAL_NAME";
  public static final String COLUMN_MUSIC_PATH = "MUSIC_PATH";
  public static final String COLUMN_MUSIC_SIZE = "MUSIC_SIZE";
  public static final String COLUMN_DOWNLOAD_NUM = "DOWNLOAD_NUM";
  public static final String COLUMN_UPLOAD_TIME = "UPLOAD_TIME";
  public static final String COLUMN_UPLOAD_IP = "UPLOAD_IP";
  public static final String COLUMN_USER_ID = "USER_ID";

  public static final LinkedHashSet<String> COLUMNS = new LinkedHashSet<>();
  public static final LinkedHashSet<String> PRIMARY_KEY = new LinkedHashSet<>();
  public static final LinkedHashMap<String, String> COLUMNS_PARAMETER = new LinkedHashMap<>();

  private static final LinkedHashSet<String> NOT_INSERTABLE_COLUMNS = new LinkedHashSet<>();
  private static final LinkedHashSet<String> NOT_UPDATABLE_COLUMNS = new LinkedHashSet<>();

  public static final LinkedHashSet<String> KEY_SEARCH_COLUMNS = new LinkedHashSet<>();

  private static final StringBuilder INSERT_SQL;
  private static final StringBuilder UPDATE_SQL;
  private static final StringBuilder DELETE_SQL_BY_PRIMARY_KEY;
  public static final StringBuilder SELECT_BASE_SQL;
  public static final StringBuilder COUNT_BASE_SQL;
  static {
    COLUMNS.add(COLUMN_ID);
    COLUMNS.add(COLUMN_MUSIC_NAME);
    COLUMNS.add(COLUMN_MUSIC_REAL_NAME);
    COLUMNS.add(COLUMN_MUSIC_PATH);
    COLUMNS.add(COLUMN_MUSIC_SIZE);
    COLUMNS.add(COLUMN_DOWNLOAD_NUM);
    COLUMNS.add(COLUMN_UPLOAD_TIME);
    COLUMNS.add(COLUMN_UPLOAD_IP);
    COLUMNS.add(COLUMN_USER_ID);


    COLUMNS_PARAMETER.put(COLUMN_ID , "id");
    COLUMNS_PARAMETER.put(COLUMN_MUSIC_NAME , "musicName");
    COLUMNS_PARAMETER.put(COLUMN_MUSIC_REAL_NAME , "musicRealName");
    COLUMNS_PARAMETER.put(COLUMN_MUSIC_PATH , "musicPath");
    COLUMNS_PARAMETER.put(COLUMN_MUSIC_SIZE , "musicSize");
    COLUMNS_PARAMETER.put(COLUMN_DOWNLOAD_NUM , "downloadNum");
    COLUMNS_PARAMETER.put(COLUMN_UPLOAD_TIME , "uploadTime");
    COLUMNS_PARAMETER.put(COLUMN_UPLOAD_IP , "uploadIp");
    COLUMNS_PARAMETER.put(COLUMN_USER_ID , "userId");


    PRIMARY_KEY.add(COLUMN_ID);

    KEY_SEARCH_COLUMNS.add(COLUMN_ID);
    KEY_SEARCH_COLUMNS.add(COLUMN_MUSIC_NAME);
    INSERT_SQL = generateInsertSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, NOT_INSERTABLE_COLUMNS);
    UPDATE_SQL = generateUpdateSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, PRIMARY_KEY, NOT_UPDATABLE_COLUMNS);
    DELETE_SQL_BY_PRIMARY_KEY = generateDeleteSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY);
    SELECT_BASE_SQL = generateBaseSelectSql(TABLE_NAME, COLUMNS, PRIMARY_KEY, TABLE_ALIAS);
    COUNT_BASE_SQL = generateBaseCountSql(TABLE_NAME, PRIMARY_KEY, TABLE_ALIAS);
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public void saveMusic(Music music) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.saveMusic ");
      log.debug("parameter music is : " + music);
    }
    try {
      if (music == null || music.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("music不能为空。");
      }
      this.namedParameterJdbcTemplate.update(INSERT_SQL.toString(), new BeanPropertySqlParameterSource(music));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void batchSaveMusic(Collection<Music> musics) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.batchSaveMusic ");
      log.debug("parameter musics is : " + musics);
    }
    try {
      if (musics == null || musics.isEmpty()) {
        throw new java.lang.IllegalArgumentException("musics不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(INSERT_SQL.toString(), SqlParameterSourceUtils.createBatch(musics.toArray()));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void updateMusic(Music music) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.updateMusic ");
      log.debug("parameter music is : " + music);
    }
    try {
      if (music == null || music.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("music不能为空。");
      }
      this.namedParameterJdbcTemplate.update(UPDATE_SQL.toString(), new BeanPropertySqlParameterSource(music));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void batchUpdateMusic(Collection<Music> musics) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.batchUpdateMusic ");
      log.debug("parameter musics is : " + musics);
    }
    try {
      if (musics == null || musics.isEmpty()) {
        throw new java.lang.IllegalArgumentException("musics不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(UPDATE_SQL.toString(), SqlParameterSourceUtils.createBatch(musics.toArray()));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void removeMusic(Music music) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.removeMusic ");
      log.debug("parameter music is : " + music);
    }
    try {
      if (music == null || music.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("music不能为空。");
      }
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      paramSource.addValue("id", music.getId());
      this.namedParameterJdbcTemplate.update(DELETE_SQL_BY_PRIMARY_KEY.toString(), paramSource);
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void batchRemoveMusic(Collection<Music> musics) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.batchRemoveMusic ");
      log.debug("parameter musics is : " + musics);
    }
    try {
      if (musics == null || musics.isEmpty()) {
        throw new java.lang.IllegalArgumentException("musics不能为空。");
      }
      this.namedParameterJdbcTemplate.batchUpdate(DELETE_SQL_BY_PRIMARY_KEY.toString(), SqlParameterSourceUtils.createBatch(musics.toArray()));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Music getMusicByPrimaryKey(java.lang.String id) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.getMusicByPrimaryKey ");
      log.debug("parameter id is : " + id);
    }
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_ID).append(" = :").append(COLUMNS_PARAMETER.get(COLUMN_ID));
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      paramSource.addValue(COLUMNS_PARAMETER.get(COLUMN_ID), id);
      Collection<Music> musicList = this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(Music.class));
      return (musicList != null && !musicList.isEmpty() && musicList.size() > 0) ? musicList.iterator().next() : null;
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getCountMusic(final MusicSearch musicSearch) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.getCountMusic ");
      log.debug("parameter musicSearch is : " + musicSearch);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_BASE_SQL);
      if (musicSearch != null){
        buildObjectValueIsNotNullOfSql(countSql, musicSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())) {
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          countSql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(musicSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          return this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
        }
      }
      return this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), new BeanPropertySqlParameterSource(musicSearch), Long.class);
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Music> getAllMusic() throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.getAllMusic ");
    }
    try {
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          appendOrderBy(sql);
          return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(Music.class));
        }
      }
      appendOrderBy(sql);
      return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(Music.class));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<Music> paginationGetAllMusic(PageSerachParameters page) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.paginationGetAllMusic ");
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      if (page.getFirstReslut() < 0) {
        throw new java.lang.IllegalArgumentException("page.firstReslut取值错误，最大为。大于等于0");
      }
      if (page.getPageSize() < 1) {
        throw new java.lang.IllegalArgumentException("page.maxReslut取值错误，最大为。大于等于1");
      }
      PageRange<Music> pageRange = new PageRange<>(page);
      StringBuilder countSql = new StringBuilder(COUNT_BASE_SQL);
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())) {
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          countSql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
          pageRange.setTotalCount(count);
          if (count > 0) {
            SqlParameterSource pageParamSource = super.getPaginationParameter(paramSource, page);
            appendOrderBy(sql);
            Collection<Music> musicList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(Music.class));
            pageRange.setDatas(musicList);
          }
          return pageRange;
        }
      }
      Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
      pageRange.setTotalCount(count);
      if (count > 0) {
        SqlParameterSource pageParamSource = super.getPaginationParameter(paramSource, page);
        appendOrderBy(sql);
        Collection<Music> musicList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(Music.class));
        pageRange.setDatas(musicList);
      }
      return pageRange;
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Music> searchMusic(final MusicSearch musicSearch) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.searchMusic ");
      log.debug("parameter musicSearch is : " + musicSearch);
    }
    try {
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      if (musicSearch != null){
        buildObjectValueIsNotNullOfSql(sql, musicSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(musicSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          appendOrderBy(sql);
          return this.namedParameterJdbcTemplate.query(sql.toString(), paramSource, BeanPropertyRowMapper.newInstance(Music.class));
        }
      }
      appendOrderBy(sql);
      return this.namedParameterJdbcTemplate.query(sql.toString(), new BeanPropertySqlParameterSource(musicSearch), BeanPropertyRowMapper.newInstance(Music.class));
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PageRange<Music> paginationSearchMusic(final MusicSearch musicSearch, PageSerachParameters page) throws MusicException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicPersistent.paginationSearchMusic ");
      log.debug("parameter musicSearch is : " + musicSearch);
      log.debug("parameter page is : " + page);
    }
    try {
      if (page == null) {
        throw new java.lang.IllegalArgumentException("page不能为空。");
      }
      if (page.getFirstReslut() < 0) {
        throw new java.lang.IllegalArgumentException("page.firstReslut取值错误，最大为。大于等于0");
      }
      if (page.getPageSize() < 1) {
        throw new java.lang.IllegalArgumentException("page.maxReslut取值错误，最大为。大于等于1");
      }
      PageRange<Music> pageRange = new PageRange<Music>(page);
      StringBuilder countSql = new StringBuilder(COUNT_BASE_SQL);
      StringBuilder sql = new StringBuilder(SELECT_BASE_SQL);
      if (musicSearch != null){
        buildObjectValueIsNotNullOfSql(countSql, musicSearch);
        buildObjectValueIsNotNullOfSql(sql, musicSearch);
      }
      if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())){
        if (SecurityContext.getOperateInfo().getSearchKey() != null && !SecurityContext.getOperateInfo().getSearchKey().trim().isEmpty()) {
          countSql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          sql.append(" AND ").append(generateKeySearchWhereSql(KEY_SEARCH_COLUMNS, TABLE_ALIAS));
          MapSqlParameterSource paramSource = getMapSqlParameterSource(new BeanPropertySqlParameterSource(musicSearch));
          paramSource.addValue(SEARCH_KEY_PARAMETER, getLikeValue(SecurityContext.getOperateInfo().getSearchKey().trim()));
          Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(), paramSource, Long.class);
          pageRange.setTotalCount(count);
          if (count > 0) {
            SqlParameterSource pageParamSource = super.getPaginationParameter(paramSource, page);
            appendOrderBy(sql);
            Collection<Music> musicList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), pageParamSource, BeanPropertyRowMapper.newInstance(Music.class));
            pageRange.setDatas(musicList);
          }
          return pageRange;
        }
      }
      Long count = this.namedParameterJdbcTemplate.queryForObject(countSql.toString(),new BeanPropertySqlParameterSource(musicSearch), Long.class);
      pageRange.setTotalCount(count);
      if (count > 0) {
        SqlParameterSource paramSource = super.getPaginationParameter(new BeanPropertySqlParameterSource(musicSearch), page);
        appendOrderBy(sql);
        Collection<Music> musicList = this.namedParameterJdbcTemplate.query(super.getPaginationBySimpleSql(sql).toString(), paramSource, BeanPropertyRowMapper.newInstance(Music.class));
        pageRange.setDatas(musicList);
      }
      return pageRange;
    } catch (org.springframework.dao.DataAccessException e) {
      throw new MusicException(" 数据库错误:" + e.getMessage() , e);
    } catch (Exception e) {
      throw new MusicException(" 错误:" + e.getMessage() , e);
    }
  }


  protected final void appendOrderBy(StringBuilder sql) {
    java.util.Set<Sort> sortList = new java.util.LinkedHashSet<>();
    if (SecurityContext.getOperateInfo() != null && OPERATE_TARGET.equals(SecurityContext.getOperateInfo().getOperateTarget())) {
      if (SecurityContext.getOperateInfo().getSortList() != null && !SecurityContext.getOperateInfo().getSortList().isEmpty()) {
        sortList.addAll(SecurityContext.getOperateInfo().getSortList());
      }
    }
    if (sortList != null && !sortList.isEmpty()) {
      appendOrderBy(sql, COLUMNS_PARAMETER, sortList, TABLE_ALIAS);
    }
  }

  private final void buildObjectValueIsNotNullOfSql(StringBuilder sql, MusicSearch musicSearch) {
    if (musicSearch.getMusicName() != null && musicSearch.getMusicName().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_MUSIC_NAME).append(" = :musicName");
    }
    if (musicSearch.getMusicRealName() != null && musicSearch.getMusicRealName().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_MUSIC_REAL_NAME).append(" = :musicRealName");
    }
    if (musicSearch.getMusicPath() != null && musicSearch.getMusicPath().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_MUSIC_PATH).append(" = :musicPath");
    }
    if (musicSearch.getMusicSize() != null && musicSearch.getMusicSize().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_MUSIC_SIZE).append(" = :musicSize");
    }
    if (musicSearch.getDownloadNum() != null) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_DOWNLOAD_NUM).append(" = :downloadNum");
    }
    if (musicSearch.getUploadTime() != null) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_UPLOAD_TIME).append(" = :uploadTime");
    }
    if (musicSearch.getUploadIp() != null && musicSearch.getUploadIp().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_UPLOAD_IP).append(" = :uploadIp");
    }
    if (musicSearch.getUserId() != null && musicSearch.getUserId().trim().length() > 0) {
      sql.append(" AND ").append(TABLE_ALIAS).append('.').append(COLUMN_USER_ID).append(" = :userId");
    }
  }
}