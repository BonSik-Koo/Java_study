/*problem: collection-Vector와 Collections 클래스를 이용한 최대값, 최소값, 정렬 구하기*/
package Problem_Collection;
import java.util.Vector;
import java.util.Iterator;
import java.util.Random;
import java.util.Collections;

public class Collection_Vector {
    public static void GenNumber(Vector<Integer> v) {
        Random num =new Random();

        for(int i=0; i<v.capacity() ;i++) {
            int n = num.nextInt(1000)+100;
            v.add(n);
        }
    }
    public static void print( Vector<Integer> v) {
        Iterator<Integer> itr=  v.iterator();
        int x=0;

        while(itr.hasNext()) {
            int temp = itr.next();
            System.out.print(temp + " ");
            x++;
            if(x%10==0)
                System.out.println();
        }
        System.out.println();
    }
    public static int findMax(Vector<Integer> v) {
        int max=0;
        for(int i=0;i<v.size(); i++) {
            int value = v.get(i);
            if(max< value)
                max=value;
        }

        return max;
    }

    public static void main(String[] args) {
        Vector<Integer> v =new Vector<>(20);
        int Max=0 , Min=0;

        GenNumber(v);
        System.out.println("-before sort-");
        print(v);

        Collections.sort(v); //Collection클래스 sort 메소드 이용
        System.out.println("-after sort-");
        print(v);

        Max=findMax(v);
        Min= Collections.min(v); //Collection클래스 min 메소드 이용
        System.out.println("Max: " + Max);
        System.out.println("Min: " + Min);
    }
}
