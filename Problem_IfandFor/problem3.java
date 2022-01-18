/*problem: 올해 1월 1일이 어떤요일인지 입력 받은후 달력을 출력하시오. 2월은 28일이라고 가정한다 */

package Problem_IfandFor;
import java.util.Scanner;

public class problem3 {

    public static void calender(String day){
        String []days_name={"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
        int i=0;
        int y=1;
        int []days={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int count=0;

        System.out.println(day);
        for(i=0;i<days_name.length; i++){
            if(days_name[i].equals(day))
                break;
        }
        System.out.println(i);

        for(int x=1; x<=12; x++){
            System.out.printf("%d월%n",x);
            for(y=1; y<=days[x]; y++){
                if(y==1){
                    for(int j=0;j<i; j++) {
                        System.out.print("*");
                        count+=1;
                    }
                }
                System.out.print(y);
                count+=1;
                if(count%7==0)
                    System.out.println();
            }
            System.out.println();
            i=y % 7;
            count=0;
        }
    }

    public static void main(String[] args){

        System.out.print("올해 1월 1일은 어떤 요일인가요? ");
        Scanner in = new Scanner(System.in);
        String day_na=in.next();

        calender((day_na));
    }
}
