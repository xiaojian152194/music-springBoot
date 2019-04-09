/*
 * Copyright (c) 2017, 2026, Nmxpsoft and Nmgzhigang and/or its affiliates. All rights reserved.
 * Nmxpsoft and  Nmgzhigang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.yzj.music.commons.exception;


/**
 * 异常类。
 *
 * @author xiaojianzzz@163.com
 * @version 1.0.0-RELEASE
 */
public class MusicException extends Exception {

  private static final long serialVersionUID = 1L;

  public MusicException() {
    super();
  }

  public MusicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public MusicException(String message, Throwable cause) {
    super(message, cause);
  }

  public MusicException(String message) {
    super(message);
  }

  public MusicException(Throwable cause) {
    super(cause);
  }

  public MusicException getException() {
    return null;
  }
}