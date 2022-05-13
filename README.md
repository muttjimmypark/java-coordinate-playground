# Step 2 : 다형성 제거 실습
### 프로그래밍 요구사항 분석
* 완성된 코드가 담긴 브랜치가 주어졌으며, ```FigureFactory.getInstance()```의 if문을 제거할 수 있도록, FigureCreator라는 인터페이스를 활용해 구현하는 미션이다.
* Map Collection을 활용한다.
```
   //변경 전 원본
   static Figure getInstance(List<Point> points) {
       if (points.size() == Line.LINE_POINT_SIZE) {
           return new Line(points);
       }

       if (points.size() == Triangle.TRIANGLE_POINT_SIZE) {
            return new Triangle(points);
       }

       if (points.size() == Rectangle.RECTANGLE_POINT_SIZE) {
            return new Rectangle(points);
       }

       throw new IllegalArgumentException("유효하지 않은 도형입니다.");
   }
```