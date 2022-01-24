__① 제네릭(generic)이란 -> c/c++에서의 템플릿의 역할__ 
- 특정 타입만 다루지 않고, 여러 종류의 타입으로 변신할 수 있도록 클래스나 메소드를 일반화 시키는 기법
- 하나의 값이 여러 데이터의 값을 가질 수 있다.
- 사용자가 정의한 클래스, 필드, 메소드등을 자료형에 따라 변경할 필요없이 모든 자료형에 적용할 수 있다.ㅁ

※
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
