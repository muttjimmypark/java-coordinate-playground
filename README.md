##미션 1. 연료 주입
###Interface vs Abstract Method
1. 인터페이스는 상수, 추상메서드, 스태틱 메서드를 작성할 수 있다.
2. 여러 인터페이스가 하나의 구현체에 구현(implement)될 수 있다.
3. 인터페이스에서 default method를 작성할 수 있다. 허나 한들,
   1. 이를 구현한(!= 상속) 구현체의 state를 참조할 수 없음
   2. equals, hashcode를 제공해서는 안됨
4. 추상 메서드는 생성자가 있음. state를 들고 있을 수 있음 (<- ?)
5. 추상 메서드는 그 자체로 인스턴스화 할 수 없음
   1. 인터페이스는 인스턴스화 해서 구현체들로 자유자제 생성될 수 있다 (Car car = new Sonata(); 같이)
###Factory Method
* 생성자를 리턴하는 메서드
#
##미션 2. 좌표계산기 (선 길이)
###기능 요구사항
1. 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
2. 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
3. X, Y좌표 모두 최대 24까지만 입력할 수 있다.
4. 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다.
5. 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
6. 좌표값을 두 개 입력한 경우, 두 점을 잇는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
7. 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.
###구현할 기능 목록 (구현 전)
1. Dot dot = new dot(int x, int y)
   1. AXIS_MAX 초과하면 IllegalArgumentException
2. Dots dots = new dots(List<Dot> axis)
   1. y값을 입력받으면 해당하는 좌표의 x값들을 return한다.
3. CoordinateCalculator
   1. AXIS_MAX = 24
   2. lineLength()
4. InputView
   1. scanAxises : 점1개, 2개, n개 받는 경우
      1. "-"으로 스플릿한 (0,0) 녀석들을 dots로 하고,
      2. 여러개의 (0,0)를 커스텀구분자로 다시 해체해서
      3. 원시 x,y값을 dot들의 생성자에 넣는다 : exception을 catch하면 pri
      4. 묶어서 dots를 만든다
5. OutputView
   1. printIllegalInputMessage : sout(e.getMessage); (InputView.scanTwoAxis;)
   2. printGraph (Dots dots)
      1. y축과 그 왼편 index를 순차적으로 출력한다 
         1. dots에 y값을 물어보고, 해당하는 좌표가 존재하면 x값만큼 공백을 출력 후 특수문자(#)로 점을 찍는다
      2. y값이 0이되면 x축 줄을 출력한다
         1. 역시 y가 0인 좌표가 있을수 있으므로 그럴땐 줄 대신 #을 출력하여 점을 찍는다
      3. x축 밑에 x축 index를 출력한다
   3. printCalculateMessage
      1. CoordinateCalculator.lineLength()의 결과물을 출력
      2. 향후 넓이값도 받으면 결과물을 출력
6. Application psvm
   1. Dots dots; double calculateResult;
   2. dots = InputView.scanAxises();
   3. OutputView.printGraph(dots);
   4. calculateResult = CoordinateCalculator(dots);
   5. OutputView.printCalculateMessage(calculateResult);