###이번 단원 공부 1 - Interface vs Abstract Method
1. 인터페이스는 상수, 추상메서드, 스태틱 메서드를 작성할 수 있다.
2. 여러 인터페이스가 하나의 구현체에 구현(implement)될 수 있다.
3. 인터페이스에서 default method를 작성할 수 있다. 허나 한들,
   1. 이를 구현한(!= 상속) 구현체의 state를 참조할 수 없음
   2. equals, hashcode를 제공해서는 안됨
4. 추상 메서드는 생성자가 있음. state를 들고 있을 수 있음 (<- ?)
5. 추상 메서드는 그 자체로 인스턴스화 할 수 없음
   1. 인터페이스는 인스턴스화 해서 구현체들로 자유자제 생성될 수 있다 (Car car = new Sonata(); 같이)
###
###Factory Method
생성자를 리턴하는 메서드