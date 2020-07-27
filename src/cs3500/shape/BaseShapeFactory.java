package cs3500.shape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BaseShapeFactory {

  /**
   * Creates shapes according to given type.
   *
   * @param name of the shape.
   * @param type of the shape.
   * @return new Shape.
   */
  public Shape make(String name, String type) {
    Map<String, Function<String, Shape>> declarableShapes = new HashMap<>();
    declarableShapes.put("ellipse", (String n) -> {
      return new Ellipse(n);
    });
    declarableShapes.put("rectangle", (String n) -> {
      return new Rect(n);
    });

    Function<String, Shape> shape = declarableShapes.getOrDefault(type, null);
    if (shape == null) {
      throw new IllegalArgumentException();
    }

    Shape declare = shape.apply(name);
    return declare;
  }
}
