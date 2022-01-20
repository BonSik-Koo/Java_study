① 다형성이란?
- 다양한 형태 또는 특성을 가진다는 의미
- 부모클래스의 상속받은 자식 클래스의 객체가 부모객체로 사용되고, 자식클래스의 객체로도 사용될 수 있다는 의미이다.

② upcasting
- 자식클래스의 객체를 부모 클래스의 객체로 사용되는 경우 -> 기본적으로 모든 멤버를 접근할 수 없고 부모 클래스의 멤버에만 접근이 가능하다.
- 예외!) upcasting-> 오버라이딩된 메소드 호출 --> 부모클래스의 메소드가 호출되는 것이 아니라 오버라이딩된 자식클래스의 메소드가 호출 된다.!!
  ex) Person p = new Student(); // Person->부모클래스, Student->자식클래스
- 자식클래스의 메서드를 직접 호출하여 사용하는법 -> "캐스트"를 사용  
  ex) Person p = new Student(); 
      (Student)p.메소드이름(); //자식클래스로 "캐스트"후 사용

③ downcasting
- 부모클래스의 객체를 자식클래스의 객체로 사용되는 경우 -> error!!!!
- 사용하기 위해선 강제 타입변환이 필요! -> 



④ 자식클래스에서 오버라이딩된 부모 클래스의 원본 메소드 호출 방식
- 오버라이딩된 자식 클래스의 메소드에 "super"의 키워드와 메소드 이름을 적어주어 호출한다.

  ex) class Person { //자식 클래스
      public void printf() { System.out.println("Person"):} }
      class Student extends Person {
      public void printf() { super.printf(); } }
      


    
  
