package com.lexiang.vertx.web.utils;

import java.io.*;
import java.util.List;

/**
 * @author wills.tan
 * @version 1.0
 */
public class Collections {

  public static <T> List<T> deepCopy(List<T> src) {
    List<T> dest = null;
    try {
      ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
      ObjectOutputStream out = new ObjectOutputStream(byteOut);
      out.writeObject(src);

      ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
      ObjectInputStream in = new ObjectInputStream(byteIn);
      dest = (List<T>) in.readObject();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return dest;
  }


}
