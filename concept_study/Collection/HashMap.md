__※ Map__
-------------
- 키(key), 값(value)로 구성된 객체를 저장하는 구조이다.
- 키와 값 모두 객체이며 키는 중복될수 없다. 또한 동일한 키를 가지고 있는 value를 Map에 저장하면 기존의 value는 없어지고 새로운 값으로 대체된다.
- 데이터를 삽입순서를 보장하지 않는다 -> 순서가 뒤죽박죽이다.
- iteraot가 제공되지 않는다.

__HashMap__
===============
- Map인터페이스의 기본 특징을 유지함
- HashMap은 Map인터페이스에서 대표적으로 많이 사용되는 Map 컬렉션이다.
- 동기화가 지원되지 않는다. ->처리속도가 Map인터페이스 종류중에서 빠르다.
- 키 값을 이용하여 원하는 정보를 검색하는 능력이 탁월하다.

```
package pratice;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

class Stu {
    private int id;
    private String tell;

    Stu(int id, String tell) {
        this.id=id;
        this.tell=tell;
    }
    public String toString() { return id+ ":"+tell;}   //오버라이딩 함수!!
    
    public boolean equals(Object temp) {  //오버라이딩 함수!!
        if(temp instanceof Stu) {
            if(((Stu)temp).id==this.id && this.tell == ((Stu)temp).tell){ return true; }
            else { return false;}
        }
        else { return false;}
    }
}
public class Collection_HashMap {
    public static void main(String[] args) {
        /* 예제1)
        HashMap<String, Integer> score = new HashMap<>();
        score.put("Koo" , 97);
        score.put("Bon" , 100);
        score.put("Sik" , 95);
        score.put("Joon", 80);
        System.out.println("HashMap의 요소 개수:" + score.size());

        //HashMap에 있는 모든 key,value출력하기
        Set<String> set =score.keySet(); //HashMap의 모든 키를 Set로 구성후 리턴
        Iterator<String> itr =set.iterator();

        while(itr.hasNext()) {
            String key = itr.next();
            int sco = score.get(key);
            System.out.println(key + ":" + sco);
        }
        */

        //예제2)
        HashMap<String, Stu> stu_info = new HashMap<String, Stu> ();
        stu_info.put("황기태" ,new Stu(1, "010-3456-3245")); //key, value 쌍으로 저장
        stu_info.put("한원선" ,new Stu(2, "010-2222-2222"));
        stu_info.put("이영희" ,new Stu(3, "010-3333-3333"));
        stu_info.put("구본식" ,new Stu(4, "010-4444-4444"));
        stu_info.put("구본식" ,new Stu(4, "010-5555-5555")); //중복된 키를 허용하지 않는다 젤 마지막 value가 삽입된다.

        Set<String> set_2 = stu_info.keySet(); //HashMap에 있는 모든 key들을 set으로 리턴받는다!!!!.
        Iterator<String> itr_2 = set_2.iterator();

        while(itr_2.hasNext()) {
            String key_2 = itr_2.next();
            Stu st = stu_info.get(key_2);
            System.out.println(st);
        }
        System.out.println();

        set_2.remove("구본식"); //해당 key와 매핑된 value를 삭제한다.
        itr_2= set_2.iterator();
        while(itr_2.hasNext()) { //HashMap은 저장순서를 보장하지 않음.
            String key_2 = itr_2.next();
            Stu st = stu_info.get(key_2);
            System.out.println(st);
        }

        /** map에서 key,value의 유무를 boolean으로 조히하는 함수**/
        System.out.println();
        System.out.println("boolean:" + stu_info.containsKey("이영희"));
        Stu t = new Stu(3, "010-3333-3333");
        System.out.println("boolean:" + stu_info.containsValue(t));

        set_2.clear(); //모든 값을 삭제한다.
        System.out.println(set_2.size());
    }
}
```

