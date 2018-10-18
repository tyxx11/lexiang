package com.lexiang.vertx.web.provider;

import com.lexiang.vertx.web.utils.ResourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wills
 * @since 1.0.0
 */
public class ResourceResolver {
  private final static Logger logger = LoggerFactory.getLogger(ResourceResolver.class);
  private final static String path ="com/lexiang/vertx/web/resource";

  public static List<Resource> resolve() {
    return findAllClassWithAnnotation(path, Path.class).stream().map(c -> Resource.builder(c).build()).collect(Collectors.toList());
  }

  public static List<Class> findAllClassWithAnnotation(String path, Class clazz) {
      return ResourceUtils.findAllClass(path).stream().filter(c -> c.getAnnotation(clazz) != null).collect(Collectors.toList());
  }
}
