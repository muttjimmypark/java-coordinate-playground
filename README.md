
## 미션 1. 연료 주입
### Interface vs Abstract Method
1. 인터페이스는 상수, 추상메서드, 스태틱 메서드를 작성할 수 있다.
2. 여러 인터페이스가 하나의 구현체에 구현(implement)될 수 있다.
3. 인터페이스에서 default method를 작성할 수 있다. 허나 한들,
   1. 이를 구현한(!= 상속) 구현체의 state를 참조할 수 없음
   2. equals, hashcode를 제공해서는 안됨
4. 추상 메서드는 생성자가 있음. state를 들고 있을 수 있음 (<- ?)
5. 추상 메서드는 그 자체로 인스턴스화 할 수 없음
   1. 인터페이스는 인스턴스화 해서 구현체들로 자유자제 생성될 수 있다 (Car car = new Sonata(); 같이)

### Factory Method
* 생성자를 리턴하는 메서드
#

## 미션 2. 좌표계산기 (선 길이)
### 기능 요구사항
1. 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다.
2. 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다.
3. X, Y좌표 모두 최대 24까지만 입력할 수 있다.
4. 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다.
5. 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다.
6. 좌표값을 두 개 입력한 경우, 두 점을 잇는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다.
7. 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.

### 구현할 기능 목록
1. Dot dot = new dot(int x, int y)
   1. VALUE_MAX 초과하면 IllegalArgumentException
2. Dots dots = new dots(List$<$Dot$>$ dots)
   1. DOT_VALUE_MIN = 0, DOT_VALUE_MAX = 24
   2. existValue(x,y) : 해당 좌표값을 가진 dot이 있는지 t/f를 return한다. <- contains로 명명
   3. howManyDots : (입력받아 가지고 있을) 점의 갯수를 return한다. <- getSize로 명명
   4. coordinateCalculate : 점의 갯수에 따라 메서드 호출
      1. lineLength : 점이 2개일때 두 점 사이 길이 리턴
3. InputView
   1. scanValues : 점1개, 2개, n개 받는 경우
      1. "-"으로 스플릿한 (0,0) 녀석들을 dots로 하고,
      2. 여러개의 (0,0)를 커스텀구분자로 다시 해체해서
      3. 원시 x,y값을 dot들의 생성자에 넣는다 : exception은 Application으로 throw
      4. 묶어서 dots를 만든다
4. OutputView
   1. printGraph (Dots dots)
      1. y축과 그 왼편 index를 순차적으로 출력한다 
         1. dots.contains false면 공백을 출력, true면 특수문자(#)로 점을 찍는다
         2. y값이 0이되면 x축 줄을 출력한다
         3. 역시 y가 0인 좌표가 있을수 있으므로 그럴땐 줄 대신 #을 출력하여 점을 찍는다
      2. x축 밑에 x축 index를 출력한다
   2. printCalculateMessage (Dots dots)
      1. dots.size()에 따라 길이는~ 넓이는~ 말머리 출력
      2. dots.coordinateCalculate()를 연이어 출력
5. Application psvm
   1. Dots dots; double calculateResult;
   2. dots = InputView.scanValues();
      1. exception 발생하면 OutputView.printIllegalInputMessage() 후 처음부터 다시 입력받기
   3. OutputView.printGraph(dots);
   4. OutputView.printCalculateMessage(dots)
#

## 미션 3. 좌표계산기 (사각형 면적)
### 기능 요구사항
1. 좌표값을 네 개 입력한 경우, 네 점을 연결하는 사각형으로 가정한다.
   1. 네 점이 뒤틀어진 사다리꼴이나 마름모는 제외하고 직사각형만 허용하도록 검사한다.
   2. 사각형의 넓이를 계산해서 출력한다.

### 구현할 기능 목록
1. Dot dot : 그대로
2. Dots dots
   1. coordinateCalculate에서 직사각형조건(validRactangle)으로 별개의 메서드를 호출한다. (점4개가 직사각형을 구성하지 않아도 그래프는 출력되게끔)
      1. lineLength가 2개의 점을 인자로 받도록 리팩터링 (미션4를 훑어봤는데 거기서 필요함)
   2. boolean validRactangle() : 모든 점의 x,y값은 다른 점에서 각각 한번씩 쓰였다. (x1y1, x1y2, x2y1, x2y2)
   3. double rectangleSize() : 직사각형 넓이를 리턴
3. InputView : 그대로
4. OutputView
   1. printCalculateMessage() : 점 갯수가 아닌 좌표계산값의 예외를 통해 출력여부를 결정짓게끔 리팩터링 했음.
5. Application : 그대로
#

## 미션 4. 좌표계산기 (삼각형 면적)
### 기능 요구사항
1. 좌표값을 세 개 입력한 경우, 세 점을 연결하는 삼각형으로 가정한다.
   1. 삼각형인 경우 삼각형의 넓이를 게산해서 출력한다.
   2. 세 변의 길이를 알 때 삼각형의 넓이를 구하는 공식은 헤론의 공식을 이용해 구할 수 있다.

### 구현할 기능 목록
1. Dot dot : 그대로
2. Dots dots
   1. coordinateCalculate에서 점3개인 경우 별개의 메서드를 호출한다.
   2. double triangleSize() : 헤론의 공식 기반으로 삼각형 넓이를 리턴
3. InputView : 그대로
4. OutputView : 그대로
5. Application : 그대로