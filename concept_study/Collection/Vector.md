1) List  [순서O, 중복O]
- 원소들의 순서를 저장해서 index를 사용하여 특정위치에 원소를 삽입하거나 접근할 수 있으며 중복을 허용한다.

(2) Vector
- ArrayList에 동기화가 보장되도록 최적화한 클래스. -> 다중 스레드를 사용할 경우 동기화가 보장되므로 ArrayList보다 적합
- 동기화가 보장되므로 ArrayList보다 느리다!!!!
- 객체를 생성하기전 지정한 최대 인덱스를 초과할 경우 현재 배열의 크기의 100%만큼(현재배열크기와 같은 크기) 증가된다. 

```
package pratice;
import java.util.Vector;

public class Collection_Vector {

    public static void main(String[] args) {
        Vector<Integer> v= new Vector<Integer>(6);
        v.add(1);
        v.add(3);
        v.add(15);
        v.add(3,10);

        System.out.println("capacity :" +v.capacity()); //ArrayList에는 없는 메소드

        for(int i=0; i<v.size() ;i++) {
            int temp = v.get(i);
            System.out.println(temp);
        }
        System.out.println();

        v.remove(0);
        v.remove(0);
        for(int A : v)
            System.out.println(A);
        System.out.println();

        v.removeAll(v);
        System.out.println("size: " + v.size());
    }
}
```

