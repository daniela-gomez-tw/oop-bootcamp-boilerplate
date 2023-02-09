package oop.rectangle;

public final class Rectangle {
  private final Integer width;
  private final Integer height;

  public Rectangle(Integer width, Integer height) {
    this.width = width;
    this.height = height;
  }

  public Integer perimeter() {
    return 2 * (width + height);
  }

  public Integer area() {
    return width * height;
  }
}
