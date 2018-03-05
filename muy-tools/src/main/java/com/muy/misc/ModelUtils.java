package com.muy.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.cglib.beans.BeanCopier;

/**
 * Created by yanglikai on 2018/3/1.
 */
public final class ModelUtils {
  private ModelUtils() {
  }

  public static <T> List<T> parse(List source, Class<T> target) {
    Objects.requireNonNull(source, "souce must not be null");
    List<T> list = new ArrayList<>(source.size());

    source.forEach(el -> {
      T result = parse(el, target);
      list.add(result);
    });

    return list;
  }

  public static <T> T parse(Object source, Class<T> target) {
    Objects.requireNonNull(source, "souce must not be null");
    BeanCopier bc = BeanCopier.create(source.getClass(), target, false);

    T result = instantiate(target);

    bc.copy(source, result, null);

    return result;
  }

  private static <T> T instantiate(Class<T> target) {
    Objects.requireNonNull(target, "Class must not be null");

    if (target.isInterface()) {
      throw new IllegalArgumentException("Specified class is an interface");
    }

    try {
      return target.newInstance();
    } catch (InstantiationException ex) {
      throw new IllegalArgumentException("Is it an abstract class?", ex);
    } catch (IllegalAccessException ex) {
      throw new IllegalArgumentException("Is the constructor accessible?", ex);
    }
  }
}
