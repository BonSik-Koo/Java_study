package pratice.lambda;

public class TestString {
    public static void main(String[] args) {

        /* Test1 */
        StringConcat s =(s1, s2) -> System.out.println(s1 +" " +s2); //lambda 식의 구현부 구현!!!!
        s.makerString("hello" , "java"); //lambda 식으로 구현한 메소드 호출
        /*기존과 차이점!!!!!!-> 기존에는 interface를 구현하면 해당 interface를 구혀한 클래스도 지정하고 해당 클래스에서 interface의 메소드 를 구현하여야만 하는데
         lambda식을 사용하게 되면 그러한 과정이 없이 간단하게 구현할수 있다. --> 즉!!)인터페이스를 구현하는 클래스를 따로 구현하지 않아도 된다.!!!!!! */

        //익명클래스 방식으로 구현한것
        StringConcat ca = new StringConcat() {
            @Override
            public void makerString(String s1, String s2) {
                System.out.println(s1+ " " + s2);
            }
        };
        ca.makerString("hello", "java");

        /* Test2 */
        ReturnAdd add = (x1, y1) -> { return x1+y1;};
        int z =add.adder(3,4);
        System.out.println(z);

    }
}
