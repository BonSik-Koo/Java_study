__Strema이란__
------------------------
- Java 8부터 지원하는 기능으로써 컬렉션, 배열등에 대한 저장되어 있는 요소들을 하나씩 참조하여 반복적인 처리를 하는 기능이다. 
- Stream을 사용하면 불필요한 for문과 그안에서 이루어지는 if문등을 사용하지 않고 짧고 간결한 코드를 구현할 수 있다.

__Stream 기능__
--------------------------
- 데이터를 변경할 수 없다 -> 원본데이터를 읽기만 할 뿐, 원본데이터를 변경할 수 없다.
- Stream은 일회용이다 -> Stream을 생성하여 사용하면 재사용이 불가능하다, 새로운 Stream을 생성해야 된다.
- Stream연산은 중간 연산과 최종 연산으로 구분된다. -> 중간연산은 여러개 적용될수 있지만 최종 연산은 마지막에 한번만 적용이 가능하다.
- 최종 연산이 호출되어야지 정의한 중간연산의 결과가 모두 적용된다!.
  
__Stream 구조__
---------------------
- 데이터소스객체집합.Stream생성().중간연산().최종연산();

ex)      
```
package pratice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pratice_Stream {
    public static void main(String[] args) {

        //[1]배열
        int [] temp = {2,1,4,5,2,10};
        IntStream str = Arrays.stream(temp); //배열의 경우에 자료형이 int이니 "IntStream"이 반환된다.!
        str.forEach(x -> System.out.println(x));

        //[2]ArrayList
        List<String> sList = new ArrayList<String> ();
        sList.add("tomas");
        sList.add("jamesaa");
        sList.add("eache");

        Stream<String> stream = sList.stream(); //Stream 생성 부분
        stream.forEach(s -> System.out.println(s)); //Stream의 최종연산자인 "forEach"는 for문과 같은 역할을 한다. -> 람다식표현으로 구현

        sList.stream().sorted().forEach(s->System.out.println(s)); //Stream을 재생성!
        System.out.println((int)sList.stream().count()); //stream()의 최종연산자인 count()는 반환값이 "Long"형이다!

        /*최종 연산지인 reduce 사용 예시-> reduce 는 사용자가 직접 구현이 가능하게 하는것이다.*/
        System.out.println( sList.stream().reduce("", (s1,s2)-> {
                        if(s1.length() > s2.length())
                            return s1;
                        else return s2;
                } ) );

        /*중간연산자인 filter() 사용 예시*/
        String x="eache";
        sList.stream()
                .filter(s -> s.equals(x)) //중간연산자 -> stream을 반환한다.
                .forEach(a-> System.out.println(a)); //최종연산이 호출되어야 중간연산결과가 적용된다.

    }
}
```
