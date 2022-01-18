package Problem_IfandFor;

public class problem1 {

    public static void printMultTable(int time){
        int count=1;

        for(int i=0;i< time;i++){
            int temp=count;
            for(int j=0; j <=i; j++){
                temp=count*(j+1);
                System.out.printf("%d ",temp);
            }
            System.out.println();
            count++;
        }
    }

    public static void main(String[] args){
        printMultTable(7);
    }
}
