/*problem: 세번의 길이를 입력받아<예) 3, 4, 5> 삼각형의 유무와 유일시 넓이 구하기 */
package Problem_array;
import java.util.Scanner;
import java.util.Arrays;

public class triangle_cal {

    public static double tri_area(int[] length){
        double result=0.0;
        double s=0.0;

        for(int i=0; i <length.length; i++) {
            int min_index=i;
            for (int j = i + 1; j < length.length; j++) {
                if(min_index>length[j])
                    min_index=j;
            }
            if(min_index!=i)
            {
                int temp=length[min_index];
                length[min_index]=length[i];
                length[i]=temp;
            }
        }
        if((length[0]+length[1]) >length[2]){
            s=(length[0]+length[1]+length[2])/2;
            result= Math.sqrt(s*(s-length[0])*(s-length[1])*(s-length[2]));
        }
        else
            System.out.println("error a,b,c length !!!");

        return result;
    }
    public static void main(String[] args){
        int []lens=new int[3];
        double result=0.0;

        System.out.print("input a,b,c length: ");
        Scanner in = new Scanner(System.in);
        String str= in.nextLine(); //한줄을 다 받아온다.

        String[] st=str.split(","); //String객체의 split 메소드를 이용하여 정의한 문자로 분할하여 배열로 저장됨
        //System.out.println(Arrays.toString(st));

        for(int i=0; i<st.length; i++){
            st[i]=st[i].trim(); //String객체의 trim메소드를 이용하여 양끝 공백만 제거가능 !!
        }

        for(int j=0; j<lens.length; j++){
            lens[j]=Integer.parseInt(st[j]);
        }

        result=tri_area(lens);
        System.out.println("trinagle_area : " + result);
    }
}
