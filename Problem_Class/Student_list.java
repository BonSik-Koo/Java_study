/*Student 클래스 list를 관리하는 문제 */
package Problem_Class;
import java.lang.String;

class Student{
    private static int staticID=2017000;
    private int studentID;
    private String studentName;
    private double midScore, finalScore;

    Student(){}
    Student(String name, double min, double fina){
        this.studentName=name;
        this.midScore= min;
        this.finalScore= fina;
        this.studentID=staticID++;
    }

    public double getAvgScore() { return (midScore+finalScore)/2.0;}

    /* -toString 메소드-
       :Java에서 제공하는 클래스들의 최상위에 Object라는 클래스가 존재한다. 즉 java에서 사용되는 모든 클래스들은 Object객체를 모두 상속받아 사용되는 것이다.
        또한 Object의 메소드중에 toString이 있다. toString 메소드는 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드 이다.
        즉 Object객체를 상속받아 우리가 정의한 클래스에 toString메소드를 오버라이딩(재정의)하여 사용하는 것이다!!!
    */
    public String toString() { //Object의 toString 메소드를 오버라이딩을 사용하여 재정의!!!!!!!!!!!!!
        double avg = getAvgScore();
        return "("+studentID+") "+studentName+ " : "+midScore+" , "+finalScore+" , " +avg;
    }

    //main 메소드에서 객체(클래스)를 생성하지 않고도 해당 메소드를 사용할수 있게 된다.->static으로 선언하였기 때문에
    public static Student findBestStudent(Student[] arr){
        double max_avg= arr[0].getAvgScore();
        int max_index=0;
        int i=0;

        for(i=0;i<arr.length;i++){
            if(max_avg<arr[i].getAvgScore()){
                max_avg=arr[i].getAvgScore();
                max_index=i;
            }
        }

        return arr[max_index];
    }
    public static Student findWorstStudent(Student[] arr){
        double min_avg= arr[0].getAvgScore();
        int min_index=0;
        int i=0;

        for(i=0;i<arr.length;i++){
            if(min_avg>arr[i].getAvgScore()){
                min_avg=arr[i].getAvgScore();
                min_index=i;
            }
        }
        return arr[min_index];
    }

}
public class Student_list {
    public static void main(String[] args){
        Student[] st= new Student[10];
        st[0]=new Student("Jane",57.8, 79.5);
        st[1]= new Student("Pole", 68.7, 77.0);
        st[2] =new Student("John", 34.8, 56.0);
        st[3]=new Student("K", 50.0,50.0);
        st[4]=new Student("O", 50.0,50.0);
        st[5]=new Student("M", 50.0,50.0);
        st[6]=new Student("I", 50.0,50.0);
        st[7]=new Student("Q", 50.0,50.0);
        st[8]=new Student("A", 50.0,50.0);
        st[9]= new Student("Amian", 69.2, 60.7);

        System.out.println("-------------Student LIST ---------------");
        for(int i=0;i<st.length;i++)
        {
            System.out.println(st[i]);
        }
        System.out.println();

        System.out.println("The best student: " + Student.findBestStudent(st)); //해당 메소드를 static으로 선언하여 객체생성없이 사용가능
        System.out.println("The Worst student: " + Student.findWorstStudent(st));

    }
}
