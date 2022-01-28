package pratice.lambda;

//해당 인터페이스에 lambda식 메서드는 하나만 가질수 있다!!!!!! -> 이유는 구현부에서 해당 인터페이스에 어떤 메소드인지 구분이 불가능하기 때문이다
public interface StringConcat {
    public void makerString(String s1, String s2); //lambda 식으로 사용할 메서드의 이름 선언!!!!!
}

