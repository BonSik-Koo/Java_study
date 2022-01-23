1) List  [순서O, 중복O]
- 원소들의 순서를 저장해서 index를 사용하여 특정위치에 원소를 삽입하거나 접근할 수 있으며 중복을 허용한다.

(1) ArrayList
- List 이터페이스를 상속받으므로 인덱스가 있고, 저장 순서가 유지되고, 데이터 중복이 가능하다.
- 제네릭 문법을 사용할수 있다 -> 사용하지 않는다면 내부적으로 Object 타입으로 처리된다.
- 동기화를 보장하지 않는다. 
- ArrayList는 내부적으로 데이터를 배열로 관리하며 데이터의 추가, 삭제를 위해 임시 배열을 생성해 데이터를 복사하는 방법을 사용하고 있다.
- 그래서 대량의 데이터를 추가/삭제하는 경우에는 그만큼의 데이터 복사가 일어나게 되어 성능저하를 일으킬 수 있다.
- 하지만, 인덱스를 통해 한번에 참조가 가능해 데이터의 검색에는 유리한 구현체다.
- 배열에 동적 메모리 증가 기능을 구현한 클래스. (마음대로 크기조절 가능한 배열)

```
package pratice;
import java.util.ArrayList; //ArrayList 클래스를 사용하기 위해

public class Collection_framwork {
    public static void main(String[] args) {

        //(1)ArrayList를 제네릭이 아닌 Object타입으로 사용하는 경우
        ArrayList list1 = new ArrayList();

        list1.add("홀길동"); //element추가 -> 인덱스를 지정해주지 않으면 자동으로 0-1-2...인덱스에 추가된다.
        list1.add(100);
        list1.add(2,3.14);  //해당 인덱스에  element추가

        String temp = (String)(list1.get(0)); //ArrayList가 Object타입이르 형변환을 해야된다.
        int temp1 = (int)(list1.get(1)); //ArrayList가 Object타입이르 형변환을 해야된다.
        double temp2= (double)(list1.get(2)); //ArrayList가 Object타입이르 형변환을 해야된다.

        for( int i=0 ; i<list1.size(); i++) //(객체).size -> ArrayList에 포함하는 요소의 개수를 반환
            System.out.println(list1.get(i));
        System.out.println();


        //(2)ArrayList를 제네릭을 사용한 경우
        ArrayList<String> list2 = new ArrayList<String>(); //String형의 객체를 생성한다.

        //[1]:추가--> add()
        list2.add("홀길동"); //element추가 -> 인덱스를 지정해주지 않으면 자동으로 0-1-2...인덱스에 추가된다.
        list2.add("100");
        list2.add("구본식");
        list2.add(2, "우리나라");  //해당 인덱스에  element추가

        //[2]: 가져오기-->get(인덱스)
        String tem = list2.get(0); //제네릭을 사용하였기 때문에 형변환을 할필요없다
        int qer = Integer.parseInt(list2.get(1)); // String 자료형을 int자료형으로 변환시켜본것.

        //[3]:수정--> set(인덱스, 수정값)
        list2.set(1,"천재");
        //System.out.println(list2.get(2));

        //[4]:삭제--> 2가지(하나만 삭제, 한꺼번에 삭제) --> remove(인덱스) ,removeAll(배열명)
        list2.remove(0); //0인덱스에 element을 삭제되고 뒤에 있는 요소가 자동으로 땡겨진다.
        list2.remove(1);
        list2.remove("천재"); //"o"와 같은 객체를 삭제한다.
        //list2.removeAll(list2);

        //출력 -->향상된 for문
        for(String str : list2)
            System.out.println(str);
        
        //============================================================================================

        //ArrayList을 이용한 2차원 배열
        ArrayList<Integer[]> list3= new ArrayList<Integer[]>(); //Integer객체 배열로 ArrayList로 생성한다.

        //[1]add
        list3.add(new Integer[] {1,2,3}); //ArrayList인덱스 하나하나에 Integer배열 객체를 생성하여 넣는다.
        list3.add(new Integer[] {4,5,6});

        //[2]출력
        for(int i=0; i<list3.size(); i++) {
            for (int j = 0; j < list3.get(i).length; j++)
                System.out.print(list3.get(i)[j] + " ");
            System.out.println();
        }
        System.out.println();

        //[3]삭제
        list3.remove(0); //0인덱스에 Integer배열이 있는데 그 배열이 삭제된다.-> ArrayList은 인덱스가 자동으로 땡겨지므로 자동으로 땡겨진다.

        for(int i=0; i<list3.size(); i++) {
            for (int j = 0; j < list3.get(i).length; j++)
                System.out.print(list3.get(i)[j] + " ");
            System.out.println();
        }
    }
}
```



(2) Vector
- ArrayList에 동기화가 보장되도록 최적화한 클래스.
- 모든 메소드가 동기화 되어있어서 잘 사용하지 않음.

(3) LinkedList
- 노드, 링크 로 구성된다.
- 양방향 포인터 구조로 데이터의 삽입, 삭제가 빈번할 경우에 빠른 성능을 보장함. 삽입, 삭제 : O(1) / 검색 : O(n)
- 배열과의 비교 : 배열은 검색하는데 O(1)이지만, 삽입, 삭제할때는 배열의 복사, 이동 과정에 많이 소요됨. 그래서 탐색이 많이 필요한 상황에서는 배열을 사용하고, 삽입/삭제가 필요한 상황에서는 LinkedList를 사용하는 것이 효율적이다.
- 이름처럼 데이터를 담고있는 노드들이 연결되어 있는데, 노드의 포인터가 다음이나 이전노드와의 연결을 담당한다.
- 스택, 큐, 양방향큐(덱) 등을 만들기 위한 용도로 사용.

2) Set  [순서X, 중복X]
- 수학의 집합 같은 개념의 콜렉션.
- 순서가 상관없고, 요소의 중복을 허용하지 않는다.

(1) HashSet
- Hashing을 이용해서 구현한 컬렉션.
- 데이터를 중복저장할 수 없고, 순서를 보장하지 않음.
- equals()나 hashCode()를 오버라이딩해서, 인스턴스가 달라도 동일 객체를 구분해 중복저장을 막을 수 있다.
-> HashSet에 객체를 저장하기 전에 hashCode()를 호출해서 해시코드를 얻어내는데,
이미 저장되어있는 객체들의 해시코드와 비교해서 만약 동일한 해시코드가 있다면
다시 equals()로 두 객체를 비교해 true가 나오면 동일객체로 판단하여 중복저장을 하지 않는 방식임! ^_^

(2) LinkedHashSet
- HashSet클래스를 상속받은 LinkedList다.
- 데이터가 삽입된 순서대로 데이터를 관리한다.

(3) TreeSet
- 정렬O
- 정렬된 순서대로 보관하며 정렬방법을 지정할 수 있음.
- 이진탐색트리(Red-Black-Tree) 형태로 데이터를 저장함.
- 데이터를 추가,삭제에는 시간이 더 걸리지만, 검색과 정렬이 더 뛰어나다.
- 기본적으로는 오름차순으로 데이터를 저장한다.

