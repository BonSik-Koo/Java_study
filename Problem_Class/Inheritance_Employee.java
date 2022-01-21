/*problem: 상속 -> Emplyee(부모), Manager(자식) */
package Problem_Class;
import java.lang.String;

class Employee{
    protected String name;
    private int salary;
    protected String ID;

    Employee(){
        name="";
        ID="";
        salary=0;
    }
    Employee(String name, int salary, String ID){
        this.name=name;
        this.salary=salary;
        this.ID=ID;
    }

    public int getSalary(){ return this.salary;}
    public String toString() {
        return name+"\t"+salary+"\t"+ID;
    }
}
class Manager extends Employee{
    private String department;

    Manager(){
        super();
        department="";
    }
    Manager(String name, int salary, String ID, String department) {
        super(name,salary, ID);
        this.department=department;
    }

    public String getDepart() {return this.department;}
    public String toString(){
        return name+"\t"+getSalary()+"\t"+ID+"\t"+department;
    }
}

class EmployeeTest{
    Employee e1,e2,e3;
    Manager m1,m2,m3;

    public EmployeeTest(){
        e1= new Employee("아이유",3000000,"kd039482");
        e2=new Employee("에일리",3500000,"ek827593");
        e3=new Employee();

        m1=new Manager("김건모",7000000,"lg837593","인사부");
        m2=new Manager("서태지",6000000,"je934827","괸리부");
        m3=new Manager();
    }

    public void showinfo(){
        String info="이름\t\t월금\t\t사번\t\t\t관리부서\n";
        info+="===================================\n";
        info+=e1+"\n"+e2+"\n"+e3+"\n"+m1+"\n"+m2+"\n"+m3;
        System.out.println(info);
    }
}

public class Inheritance_Employee {
    public static void main(String[] args){
        EmployeeTest test=new EmployeeTest();
        test.showinfo();
    }
}
