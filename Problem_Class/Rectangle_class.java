/*problem: 두(x,y)좌표가 사각형을 이룰수 있는지 판별 */

package Problem_Class;

class Rectangle {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    Rectangle() {}
    Rectangle(int x1, int x2, int y1, int y2) {
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
    }

    public void set(int x1, int x2, int y1, int y2){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
    }
    public boolean check() {
        if(x1!=x2 &&(y1!=y2))
            return true;
        else
            return false;
    }
    public int getArea(){
        int area=0;
        int x=0;
        int y=0;

        if(check()) {
            x=Math.abs(x1-x2);
            y=Math.abs(y1-y2);
            area=x*y;
            return area;
        }
        else
            return 0;
    }

    public void show() {
        if(check()) {
            int area= getArea();
            System.out.printf("1좌표:(%d,%d) 2좌표:(%d,%d) area:%d %n",x1,y1,x2,y2,area);
        }
        else
            System.out.println("잘못된 사각형의 좌표입니다.");
    }

    public boolean equals(Rectangle r){

        if((Math.abs(r.x1-r.x2)==Math.abs(this.x1-this.x2)) &&(Math.abs(r.y1-r.y2) == Math.abs(this.y1-this.y2)))
            return true;
        else
            return false;
    }
}
public class Rectangle_class {
    public static void main(String[] args){
        Rectangle r= new Rectangle();
        Rectangle s= new Rectangle(1,2,1,3);

        r.show();
        s.show();
        System.out.println("area: " + s.getArea());
        r.set(2,4,1,5);
        r.show();
        System.out.println(r.getArea());

        if(r.equals(s))
            System.out.println("두 사각형은 같습니다.");
        else
            System.out.println("두 사각형은 같지 않습니다. ");
    }
}
