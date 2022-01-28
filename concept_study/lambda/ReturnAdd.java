package pratice.lambda;

//해당 인터페이스에 lambda식 메서드는 하나만 가질수 있다!!!!!! -> 이유는 구현부에서 해당 인터페이스에 어떤 메소드인지 구분이 불가능하기 때문이다
public interface ReturnAdd {
    public int adder(int x, int y);
}
