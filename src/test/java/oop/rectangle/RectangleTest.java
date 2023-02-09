package oop.rectangle;

import oop.rectangle.Rectangle;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class RectangleTest {

  @Test
  public void itShouldCalculateItsPerimeter() {
    Rectangle rectangle = new Rectangle(60, 20);
    int actual = rectangle.perimeter();
    assertEquals(160, actual);
  }

  @Test
  public void itShouldCalculateArea() {
    Rectangle rectangle = new Rectangle(80, 20);
    int actual = rectangle.area();
    assertEquals(1600, actual);
  }

}
