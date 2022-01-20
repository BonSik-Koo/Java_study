① 기본 자료형(Primitive)
- Java언어에 이미 존재하고 있는 데이터 타입, 주로 간단한 데이터들이다. (예. int, double, boolean, char 등등..)

② 객체 자료형(Object)
- 여러가지 데이터들이 모여 있는 복잡한 데이터로 기본 자료형에 비해 크기가 크다. (예. String, Integer, Double, System, ArrayList 등등..)
- Object 클래스란 -> 모든 자바 클래스(Interge, String 등, 사용자가 지정한 class등)의 최고 조상 클래스이다. 즉 자바의 모든 클래스들은 Object 클래스를 모두 상속받아 만들어지는 것이다.

※기본 자료형은 제일 앞이 소문자로시작! 객체 자료형은 제일 앞이 대문자로 시작!


    public static void main(String[] args){

        String name="123";
        int x=100;
        double y=200;

        //자료형을 확인하는법->(객체).getClass().getName()
        //위 메소드는 객체에 대해서 자료형을 알아내는 방식이기 때문에 기본 자료형은 객체 자료형으로 변환 해야된다.
        System.out.println(name.getClass().getName());
        System.out.println(((Object) y).getClass().getName());
        System.out.println(((Object)x).getClass().getName());

        //자료형 변환
        //1) 기본자료형 - 기본자료형
        int num_1 = (int)y;
        double num_2=(double)x;

        //2) 기본자료형 - 객체자료형 ->객체 자료형의 메소드를 이용해서 변환시킨다.
        int num_3 = Integer.parseInt(name);
        String na = Integer.toString((x));

        double num_4=Double.parseDouble(name);
        String nb=Double.toString(y);
    }

