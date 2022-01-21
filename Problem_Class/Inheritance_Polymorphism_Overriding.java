/*problem: 상속 및 다형성 구현 */
package Problem_Class;
import java.lang.String;

class Student_2{
    private String name;
    private int ID;

    Student_2(String name, int ID){
        this.name=name;
        this.ID=ID;
    }

    public String getName() {return name;}
    public int getID() {return ID;}
    public int getAnnualSalary(){ return 100;}
    public String toString() {return name+"\t"+ID;}
}
class Undergraduate extends Student_2{
    private int semesteSalary;

    Undergraduate(String name, int id, int sem){
        super(name,id);
        this.semesteSalary=sem;
    }

    public int getAnnualSalary() {
        return semesteSalary*2;
    }
    public String toString() {return getName()+"\t"+getID()+"\t"+semesteSalary+"\t"+getAnnualSalary();}
}
class Graduate extends Student_2{
    private int monthSalary;
    Graduate(String name, int id, int monthSalary){
        super(name,id);
        this.monthSalary=monthSalary;
    }
    public int getAnnualSalary(){return monthSalary*12;}
    public String toString() {return getName()+"\t"+getID()+"\t"+monthSalary+"\t"+getAnnualSalary(); }
}

public class Inheritance_Polymorphism_Overriding {
    public static void main(String[] args){

        Student_2[] s=new Student_2[8]; //부모클래스

        /*
           *다형성 (자식클래스로 객체를 만들면서 타입은 부모클래스 타입을 쓰는것)
           :객체생성->upcasting->오버라이딩된 메소드 호출-
           : upcasting됬으니 부모클래스의 메소드가 호출될줄 알았으나 자식 클래스의 오버라이딩한 메소드가 호출된다.!!!
        */
        s[0]=new Graduate("Giggs", 20163103,400000); //upcasting->부모클래스에 자식클래스 대입
        s[1]= new Graduate("Carrick", 20163003, 500000);
        s[2]= new Graduate("Evra", 20155511, 350000);
        s[3]= new Graduate("Saha", 20143323, 550000);

        s[4]=new Undergraduate("Crouch", 20170103,1000000);
        s[5]= new Undergraduate("Nevile", 20170012, 1200000);
        s[6]= new Undergraduate("Ji-sung", 20160429, 1100000);
        s[7]= new Undergraduate("Rooney", 20150718, 900000);

        for(int i=0;i<s.length;i++)
            System.out.println(s[i]);

        int index=0;
        int max_salary=s[0].getAnnualSalary();
        for(int i=0;i<s.length;i++){
            if(max_salary<s[i].getAnnualSalary()){
                max_salary=s[i].getAnnualSalary();
                index=i;
            }
        }

        System.out.println("\nA student who receives the highest salary:" + s[index].getName() + "("+s[index].getID() +")");
    }
}