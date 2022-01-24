__제네릭(generic)이란 -> c/c++에서의 템플릿의 역할__ 
===================================================
- 특정 타입만 다루지 않고, 여러 종류의 타입으로 변신할 수 있도록 클래스나 메소드를 일반화 시키는 기법
- 하나의 값이 여러 데이터의 값을 가질 수 있다.
- 사용자가 정의한 클래스, 필드, 메소드등을 자료형에 따라 변경할 필요없이 모든 자료형에 적용할 수 있다.  

※주의
- 제네릭 타입의 배열을 선언할 수 없음  ex) T[]a=new T[10] --> xxx!!
- 제네릭 클래스 또는 인터페이스의 배열도 허용하지 않음 ex) Stack<Integer>[] s=new Stack<Integer>[10] --> xxx!!!!!!   
▶ 이유?: new 연산자는 컴파일 시점에서 타입 변수가 어떤 것인지 정확하게 알아야 하는데 제네릭 클래스는 컴파일하는 시점에 타입 변수가 어떤 타입이 될지 전혀 알수 없다.(런타임에서 알수있음)
         new연산자는 heap 영역에 충분한 공간이 있는지 확인한 수 메모리를 확보하는 역할을 하는데, 충분한 공간이 있는지를 확인하기 위해 타입으 알아야 하는데 컴파일 시점에서 타입 T가 무엇인지              알수 없기 때문에 제네릭으로 배열을 생성할수 없다.!!

```
class Sample<T> { //받을 객체의 타입이 지정하지 않는다.(제네릭은 Object(객체) 자료형만 받을수 있다!!!!!, int,double(기본자료형)은 안된다!!
    private T obj;
    Sample(T x) { this.obj=x; }
    T getObj() { return obj;}
    void printinfo() { System.out.println(obj.getClass().getName());}
}
public class Generic {
    public static void main(String[] args){

        Sample<Integer> sam= new Sample<Integer>(10);
        sam.printinfo();
        System.out.println(sam.getObj());
    }
}
```
