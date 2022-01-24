__① Comparable<T> 인터페이스란?__
================================
- Comparable<T> 인터페이스는 객체간의 비교를 가능하게 해주는 인터페이스이다. 
- 해당 인터페이스를 구현(implements)한 클래스는 반드시 compareTo(T obj) 메소드를 정의해야 한다.   
  ※ compareTo(T obj): 이 객체가 obj보다 작으면 음수, 같으면 0, 크면 양수를 리턴하는 메소드.
- 자바에서는 원시형(primitive) 타입의 Wrapper 클래스들은 모두 compareTo() 메소드를 오버라이드 하였다. 따라서 쉽게 객체간의 비교를 할 수 있다. (compareTo() 메소드가 구현 객체는 Arrays.sort()   , Collections.sort() 등의 메소드를 통해 자동 정렬 가능)
- 사용자가 지정한 클래스 같은 경우에는 compareTo()메소드가 정의되어 있지 않으므로 구현해야만 Arrays.sort()등의 메소드를 통해 자동 정렬이 가능하다.

```
class Student implements Comparable<Student> {
    private int ID;
    private String name;
    private int score;

    Student() { }
    Student(int id, String name, int score) {
        this.ID = id;
        this.name = name;
        this.score = score;
    }
    public int getSocre() { return score;}
    public String toString() { return ID + "," + name + "," + score; }
    public int compareTo(Student st) { //comparable인터페이스에 compareTo() 메소드
        if( this.score< st.getSocre() )
            return -1;
        else if(this.score > st.getSocre())
            return 1;
        else
            return 0;
    }
}
```
