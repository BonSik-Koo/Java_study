① Iterator란?
- java collection에 저장되어 있는 요소들을 읽어오는 방법의 인터페이스.
- 보통 for반복문을 사용하여 순회할 때 -> 인덱스로 각요소를 순회 --> Iterator를 이용하면 조금더 편리하게 사용 가능.

② 사용하는 이유
- collectio의 종류에 관계없이 일광성 있게 프로그래밍을 할수 있다. 
- 한 행씩 삭제하는 경우에는 별 문제가 없으나 --> 반복문 안에서 순회하면서 삭제시 반복문에 들어가기 전의 기존 list 배열의 요소를 삭제하면서 size(length)나 index의 정보가 변경되면서 순회시 정보가 맞지 않아 오류 발생!
- 인덱스로 순차 검색하는 것보다 훨씬 빠르다.

```
package pratice;
import java.util.ArrayList;
import java.util.Iterator;

public class Collection_Iterator {
    public static void main(String[] args){

        ArrayList<String> list5 = new ArrayList<String>(); //String형의 객체를 생성한다.
        list5.add("홀길동"); //element추가 -> 인덱스를 지정해주지 않으면 자동으로 0-1-2...인덱스에 추가된다.
        list5.add("100");
        list5.add("구본식");
        list5.add(2, "우리나라");  //해당 인덱스에  element추가

        //Iterator 생성-> iterator로 지정한 클래스(객체)에 아무런 요소가 없으면 error 발생!
        Iterator<String> itr = list5.iterator(); //해당 클래스(list5)의 iterator 객체 생성

        while(itr.hasNext()) { //다음 요소가 있으면 true반환, 없으면 false반환
            String st= itr.next(); //다음 요소를 반환한다.
            //System.out.println(st);
            String strr= "구본식";

            if(st.equals(strr)) {   //String는객체이기 때문에 "=="가 아닌 "equals"메소드 사용하기!!
                System.out.println("delete complete: " + st);
                //itr.remove(): 마지막으로 리턴된 요소를 제거
                //현재 요소를 삭제 + 마지막으로 리턴된(사용된) 요소 제거 ->추가적으로 위의 itr.next()등 요소들을 호출,사용하지 않고 remove를 하게 되면 Exception오류가 발생한다.
                itr.remove();
            }
        }

        //출력
        itr= list5.iterator();
        while(itr.hasNext()) {
            String st = itr.next();
            System.out.println(st);
        }
    }
}
```
