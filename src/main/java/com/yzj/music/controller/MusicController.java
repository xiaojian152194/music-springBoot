/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzj.music.controller;

import com.yzj.music.commons.*;
import com.yzj.music.commons.contants.Contants;
import com.yzj.music.commons.exception.MusicException;
import com.yzj.music.entity.Music;
import com.yzj.music.entity.User;
import com.yzj.music.commons.FileOperateUtils;
import com.yzj.music.pojo.search.MusicSearch;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yzj.music.service.IMusicService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该类是歌曲信息控制器。
 *
 * @author xiaojianzzz@163.com
 * @version 1.0.0-RELEASE
 */
@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "/music" })
public class MusicController {
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(MusicController.class);

  @javax.annotation.Resource(name = "com.yzj.music.MusicService")
  private IMusicService musicService;


  @RequestMapping(value = { "single" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<Music> save(CommonParameters commonParameters, @RequestBody Music music) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicController.save ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter music is : " + music);
    }
    ResponseRange<Music> responseRange = new ResponseRange<>();
    try {
      if (music == null || music.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("music不能为空。");
      }
      musicService.saveMusic(music);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<Music> batchSave(CommonParameters commonParameters, @RequestBody List<Music> musics) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicController.batchSave ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter musics is : " + musics);
    }
    ResponseRange<Music> responseRange = new ResponseRange<>();
    try {
      if (musics == null || musics.isEmpty()) {
        throw new java.lang.IllegalArgumentException("musics不能为空。");
      }
      musicService.batchSaveMusic(musics);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "single" }, method = { RequestMethod.PUT })
  @ResponseBody
  public ResponseRange<Music> update(CommonParameters commonParameters, @RequestBody Music music) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicController.update ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter music is : " + music);
    }
    ResponseRange<Music> responseRange = new ResponseRange<>();
    try {
      if (music == null || music.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("music不能为空。");
      }
      musicService.updateMusic(music);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.PUT })
  @ResponseBody
  public ResponseRange<Music> batchUpdate(CommonParameters commonParameters, @RequestBody List<Music> musics) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicController.batchUpdate ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter musics is : " + musics);
    }
    ResponseRange<Music> responseRange = new ResponseRange<>();
    try {
      if (musics == null || musics.isEmpty()) {
        throw new java.lang.IllegalArgumentException("musics不能为空。");
      }
      musicService.batchUpdateMusic(musics);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "single" }, method = { RequestMethod.DELETE })
  @ResponseBody
  public ResponseRange<Music> remove(CommonParameters commonParameters, @RequestBody Music music) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicController.remove ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter music is : " + music);
    }
    ResponseRange<Music> responseRange = new ResponseRange<>();
    try {
      if (music == null || music.selfIsNull()) {
        throw new java.lang.IllegalArgumentException("music不能为空。");
      }
      musicService.removeMusic(music);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.DELETE })
  @ResponseBody
  public ResponseRange<Music> batchRemove(CommonParameters commonParameters, @RequestBody List<Music> musics) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicController.batchRemove ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter musics is : " + musics);
    }
    ResponseRange<Music> responseRange = new ResponseRange<>();
    try {
      if (musics == null || musics.isEmpty()) {
        throw new java.lang.IllegalArgumentException("musics不能为空。");
      }
      musicService.batchRemoveMusic(musics);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "/{id}" }, method = { RequestMethod.GET })
  @ResponseBody
  public ResponseRange<Music> getByPrimaryKey(CommonParameters commonParameters, @PathVariable java.lang.String id) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicController.getByPrimaryKey ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter id is : " + id);
    }
    ResponseRange<Music> responseRange = new ResponseRange<>();
    try {
      if (id == null || id.trim().length() < 1) {
        throw new java.lang.IllegalArgumentException("id不能为空。");
      }
      responseRange.setData(musicService.getMusicByPrimaryKey(id));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(method = { RequestMethod.GET })
  @ResponseBody
  public ResponseRange<Music> get(CommonParameters commonParameters, MusicSearch musicSearch) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicController.get ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter musicSearch is : " + musicSearch);
    }
    ResponseRange<Music> responseRange = new ResponseRange<>();
    try {
      if (musicSearch == null || musicSearch.selfIsNull()) {
        if (commonParameters.isPageSerach()) {
          responseRange.setData(musicService.paginationGetAllMusic(commonParameters.getPageSerachParameters()));
        } else {
          responseRange.setData(musicService.getAllMusic());
        }
      } else {
        if (commonParameters.isPageSerach()) {
          responseRange.setData(musicService.paginationSearchMusic(musicSearch, commonParameters.getPageSerachParameters()));
        } else {
          responseRange.setData(musicService.searchMusic(musicSearch));
        }
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "import" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<Music> batchImport(CommonParameters commonParameters, Music music, @RequestParam CommonsMultipartFile importFile) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicController.batchImport ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter music is : " + music);
      log.debug("parameter importFile is : " + importFile);
    }
    ResponseRange<Music> responseRange = new ResponseRange<>();
    try {
      java.io.InputStream inputXML = new java.io.BufferedInputStream(getClass().getResourceAsStream("/template/read/Music.xml"));
      org.jxls.reader.XLSReader mainReader = org.jxls.reader.ReaderBuilder.buildFromXML(inputXML);
      java.io.InputStream inputXLS = new java.io.BufferedInputStream(importFile.getInputStream());
      java.util.List<Music> musicList = new java.util.LinkedList<>();
      java.util.Map<String, Object> beans = new java.util.HashMap<>();
      beans.put("musicList", musicList);
      org.jxls.reader.XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
      if (readStatus.isStatusOK()) {
        if (music != null && !music.selfIsNull()) {
          music.cloneThisToCollection(musicList);
        }
        musicService.batchSaveMusic(musicList);
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "export" }, method = { RequestMethod.GET })
  @ResponseBody
  public org.springframework.http.ResponseEntity<byte[]> export(CommonParameters commonParameters, MusicSearch musicSearch) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call MusicController.export ");
      log.debug("parameter commonParameters is : " + commonParameters);
      log.debug("parameter musicSearch is : " + musicSearch);
    }
    org.springframework.http.ResponseEntity<byte[]> response = null;
    try {
      List<PageRange<Music>> pageRangeList = new java.util.LinkedList<>();
      List<String> sheetNames = new java.util.LinkedList<>();
      if (musicSearch == null || musicSearch.selfIsNull()) {
        PageSerachParameters page = new PageSerachParameters();
        page.setPageSize(60000l);
        long pageIndex = 1;
        PageRange<Music> pageRange = null;
        do {
          page.setPageNumber(pageIndex);
          pageRange = musicService.paginationGetAllMusic(page);
          pageRangeList.add(pageRange);
          sheetNames.add("第" + pageIndex + "页");
          pageIndex++;
        } while (pageRange.getPageCount() >= pageIndex);
      } else {
        PageSerachParameters page = new PageSerachParameters();
        page.setPageSize(60000l);
        long pageIndex = 1;
        PageRange<Music> pageRange = null;
        do {
          page.setPageNumber(pageIndex);
          pageRange = musicService.paginationSearchMusic(musicSearch, commonParameters.getPageSerachParameters());
          pageRangeList.add(pageRange);
          sheetNames.add("第" + pageIndex + "页");
          pageIndex++;
        } while (pageRange.getPageCount() >= pageIndex);
      }
      java.io.InputStream is = this.getClass().getResourceAsStream("/template/write/Music.xls");
      org.jxls.common.Context context = new org.jxls.common.Context();
      context.putVar("pageRangeSet", pageRangeList);
      context.putVar("sheetNames", sheetNames);
      java.io.ByteArrayOutputStream os = new java.io.ByteArrayOutputStream();
      org.jxls.util.JxlsHelper.getInstance().processTemplate(is,os, context);
      org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
      byte[] by= os.toByteArray(); 
      headers.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM);
      headers.setContentDispositionFormData("attachment",java.net.URLEncoder.encode("歌曲信息.xls", "UTF-8"));
      headers.setContentLength(by.length);
      response= new org.springframework.http.ResponseEntity<byte[]>(by, headers, org.springframework.http.HttpStatus.OK);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
    }
    return response;
  }
//  @RequestMapping(value = { "get_user_musics" }, method = { RequestMethod.GET })
//  @ResponseBody
//  public ResponseRange<Music> getUserMusics(CommonParameters commonParameters, HttpServletRequest request) {
//    ResponseRange<Music> responseRange = new ResponseRange<>();
//    try {
//      MusicSearch music = new MusicSearch();
//      if(request.getSession().getAttribute(Contants.LOGIN_PROVE_FG) != null) {
//        User user = (User) request.getSession().getAttribute(Contants.LOGIN_PROVE_FG);
//        music.setUserId(user.getId());
//      } else if(request.getSession().getAttribute(Contants.LOGIN_PROVE_BG) != null){
//        User user = (User) request.getSession().getAttribute(Contants.LOGIN_PROVE_BG);
//        music.setUserId(user.getId());
//      }
//      Collection<Music> musics = musicService.searchMusic(music);
//      for (Music m : musics) {
//        m.setUploadTimeString(simpleDateFormat.format(m.getUploadTime()));
//      }
//      if (musics.isEmpty()) {
//        throw new MusicException("没有数据信息！");
//      }
//      responseRange.setData(musics);
//    } catch (Exception e) {
//      responseRange.setException(e);
//    }
//    return responseRange;
//  }
@RequestMapping(value = { "get_user_musics" }, method = { RequestMethod.POST })
@ResponseBody
public ResponseRange<Music> getUserMusic(CommonParameters commonParameters, @RequestBody  MusicSearch musicSearch) {
  if (log.isDebugEnabled()) {
    log.debug("Staring call MusicController.get ");
    log.debug("parameter commonParameters is : " + commonParameters);
    log.debug("parameter musicSearch is : " + musicSearch);
  }
  ResponseRange<Music> responseRange = new ResponseRange<>();
  try {
    if (musicSearch == null || musicSearch.selfIsNull()) {
      if (commonParameters.isPageSerach()) {
        responseRange.setData(musicService.paginationGetAllMusic(commonParameters.getPageSerachParameters()));
      } else {
        responseRange.setData(musicService.getAllMusic());
      }
    } else {
      if (commonParameters.isPageSerach()) {
        responseRange.setData(musicService.paginationSearchMusic(musicSearch, commonParameters.getPageSerachParameters()));
      } else {
        responseRange.setData(musicService.searchMusic(musicSearch));
      }
    }
  } catch (Exception e) {
    if (log.isErrorEnabled()) {
      log.error(e.getMessage(), e);
    }
    responseRange.setException(e);
  }
  return responseRange;
}
  @RequestMapping(value = { "upload" }, method = { RequestMethod.POST })
  @ResponseBody
  public ResponseRange<String> uploadMusic(HttpServletRequest request, CommonParameters commonParameters,
                                           @RequestParam(value = "music",required = false) MultipartFile music) {
    ResponseRange<String> responseRange = new ResponseRange<>();
    try {
      if (music == null || music.getSize() == 0) {
        throw new MusicException("上传音乐不能为空！");
      }
//      if (music.getSize() > 1024 * 1024 * 100) {
//        throw new MusicException("音乐不能大于100M！");
//      }
//      if (music.getName() != null) {
//        int len = music.getName().length();
//        String str = music.getName().substring(music.getName().lastIndexOf("."), len);
//        if (!str.equals(".mp3")) {
//          throw new MusicException("请选择正确类型！");
//        }
//      }
      Music music1 = new Music();
      music1.setDownloadNum(0);
      music1.setUploadIp(request.getRemoteAddr());
      music1 = FileOperateUtils.uploadMusic(music, music1);
      if(request.getSession().getAttribute(Contants.LOGIN_PROVE_FG) != null) {
        User user = (User) request.getSession().getAttribute(Contants.LOGIN_PROVE_FG);
        music1.setUserId(user.getId());
      } else if(request.getSession().getAttribute(Contants.LOGIN_PROVE_BG) != null){
        User user = (User) request.getSession().getAttribute(Contants.LOGIN_PROVE_BG);
        music1.setUserId(user.getId());
      }
      musicService.saveMusic(music1);
      responseRange.setData("上传成功！！");
    } catch (Exception e) {
      responseRange.setException(e);
    }
    return responseRange;
  }

  @RequestMapping(value = { "download/{id}" }, method = { RequestMethod.POST, RequestMethod.GET })
  @ResponseBody
  public ResponseRange<String> downloadMusic(@PathVariable String id, HttpServletResponse response,
                                             CommonParameters commonParameters) {
    ResponseRange<String> responseRange = new ResponseRange<>();
    try {
      Music music = musicService.getMusicByPrimaryKey(id);
      if (music == null) {
        throw new MusicException("音乐不存在！");
      }
      String path = music.getMusicPath() + "/" + music.getMusicRealName();// 拼接文件路径
      File musicFile = new File(path);
      String musicName = music.getMusicName();// 获取文件名称准备下载时显示
      InputStream muF = new BufferedInputStream(new FileInputStream(path));
      byte[] buffer = new byte[muF.available()];
      muF.read(buffer);
      muF.close();
      response.reset();
      // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
      response.addHeader("Content-Disposition",
              "attachment;filename=" + new String(musicName.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
      response.addHeader("Content-Length", "" + musicFile.length());
      java.io.OutputStream os = new BufferedOutputStream(response.getOutputStream());
      response.setContentType("application/octet-stream");
      os.write(buffer);
      os.flush();
      os.close();
      music.setDownloadNum(music.getDownloadNum() + 1);
      musicService.updateMusic(music);
    } catch (Exception e) {
      responseRange.setException(e);
    }
    return responseRange;
  }

}
