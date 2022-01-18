/*problem: 10개를 입력받아 오름차순으로 선택 정렬해라 */

package Problem_array;
import java.util.Scanner;
import java.util.Arrays;

public class sort {
    public static void sort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int min_index=i;
            for(int j=i+1;j<array.length;j++){
                if(array[min_index] > array[j])
                    min_index=j;
            }
            if(min_index!=i)
            {
                int temp=array[min_index];
                array[min_index]=array[i];
                array[i]=temp;
            }
        }
    }
    public static void main(String[] args){
        int[] arr=new int[10];

        System.out.print("10의 정수를 입력하시오 :");
        Scanner in = new Scanner(System.in);
        for(int i=0;i<10;i++) {
            arr[i]= in.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
