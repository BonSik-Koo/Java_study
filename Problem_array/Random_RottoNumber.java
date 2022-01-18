/*problem: 자동 로또 번호 생성 및 정렬 */
package Problem_array;
import java.util.Random;
import java.util.Arrays;

public class Random_RottoNumber {

    public static void gen_random(int[][] arr){
        Random R_num= new Random(); //Random 객체 생성
        int temp=0;
        int j=0;
        boolean bo=false;
        int []compare =new int[6]; //0으로 초기화됨

        for(int i=0; i<5; i++){
            while(j <arr[i].length) {
                temp=R_num.nextInt(45) +1; //1~45랜덤 생성
                for(int k=0; k<compare.length; k++){
                   if(compare[k] == temp)
                       bo=true;
                }

                if(bo==true)
                    continue;
                else {
                    compare[j] = temp;
                    arr[i][j] = temp;
                }
                j+=1;
            }
            bo=false;
            j=0;
            //초기화 시키는 두가지 방법
            Arrays.fill(compare,0);
            //for(int x=0;x<compare.length;x++){
            //    compare[x]=0;
            //}
        }
    }
    public static void print(int[][] arr){
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 6; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
    public static void sort(int[][] array){
        for(int i=0;i<array.length;i++) {
            for (int k = 0; k < array[i].length-1; k++) {
                int min_index = k;
                for (int j = k + 1; j < array[i].length; j++) {
                    if (array[i][min_index] > array[i][j])
                        min_index = j;
                }
                if (min_index != k) {
                    int temp = array[i][min_index];
                    array[i][min_index] = array[i][k];
                    array[i][k] = temp;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        int[][] Lotto_num= new int[5][6];

        System.out.println("Lotto number_gen");
        gen_random(Lotto_num);
        print(Lotto_num);

        System.out.println("\nsort Lotto number");
        sort(Lotto_num);
        print(Lotto_num);

    }
}
