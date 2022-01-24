/*problem: ArrayList<Student> , Collections 클래스를 이용한 학생정보 저장 및 정렬*/
package Problem_Collection;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//사용자가 만든 객체를 정렬할때 사용되는 comparable인터페이스 ->자동정렬(Arrays.sort()등)에서 사용되는데 String,Integer등은 자동으로 compareTo메소드가구현되어 있다.
//하지만 사용자가 지정한 클래스 같은 경우에는 자동 정렬에서 사용되는 크기비교 메소드(compareTo)가 정의되어 있지 않으므로 해당 클래스가 compareable<타입> 인터페이스를 상속받고 comparable메소드를 반드시 구현해야된다.!
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

public class Collection_ArrayList {
    public static Student Find_Max_Score(ArrayList<Student> list ) {
        Student st=new Student();
        int max_score = list.get(0).getSocre();

        for(int i=1; i<list.size() ;i++ ){
            if(max_score < list.get(i).getSocre()) {
                max_score = list.get(i).getSocre();
                st=list.get(i);
            }
        }
        return st;
    }

    public static void main(String [] args)  {

        File f = new File("D:\\java\\fin.txt");
        String temp;
        String[]str= new String[3];
        Student student = new Student();
        ArrayList<Student> My_list = new ArrayList<Student>();

        try {
            BufferedReader buff_r =new BufferedReader(new FileReader(f),20); //버퍼를 사용하여 한줄씩 읽을수 있게 한다. 버퍼 크기는->20으로 지정

            while((temp=buff_r.readLine())!=null) {
                str= temp.split(",");
                for(int i=0; i<str.length; i++)
                    str[i]=str[i].trim(); //String객체의 trim메소드를 이용하여 양끝 공백만 제거가능 !!

                Student st= new Student(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]));
                System.out.println(st);
                My_list.add(st);
                }
            student = Find_Max_Score(My_list);
            System.out.println("\nmax_score_student: " + student);
            System.out.println();

            Collections.sort(My_list,Collections.reverseOrder()); //내림차순으로 정렬
            for(int i=0;i <My_list.size() ; i++ )
                System.out.println(My_list.get(i));

        }catch(Exception e) {
            System.out.println("file open error");
        }
    }
}
