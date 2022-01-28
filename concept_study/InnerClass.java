package pratice;

class OutClass { //내부 클래스 연습
    private int num = 10;
    private static int sNum =20;
    private InClass inclass;

    private class InClass { //대부분 내부 클래스는 private으로 쓰는게 일반적
        int inNum =200;
        static int temp =100;
        void inTest() {
            System.out.println(num); //해당 클래스가 속해있는 클래스의 따른 변수들도 사용이 가능하다.
            System.out.println(sNum);
        }
    }
    static class InStaticClass { //해당 클랫스의 상의 클래스의 객체를 생성하지 않고 사용이 가능하다.
        int inNum= 1000;
        static int temp = 2000; //해당 변수의 클래스의 객체를 생성하지 않고 사용이 가능하다.
        void inTest() {
            System.out.println(inNum);
            //System.out.println(num); XXX-> 해당 클래스의 상의 클래스의 객체를 생성하지 않으니 상의 클래스에 있는 변수또한 사용하지 못한다.
            System.out.println(temp);
            System.out.println(sNum); // "sNum"변수 같은 경우에는 상의 클래스의 변수인데 "static"변수이기 때문에 사용이 가능하다.
        }
        static void sTest() { //해당 메소드를 포함하는 클래스 객체를 생성하지 않고도 사용이 가능하다.
            //System.out.println(inNum); XXXX-> 해당 클래스 객체를 생성하지 않으니 클래스 내부에 일반 변수는 사용불가능
            System.out.println(temp);
            System.out.println(sNum);
        }
    }

    OutClass() {
        inclass = new InClass();
    }

    public void OutTest() {
        inclass.inTest();
    }
}

class out { //익명 클래스 연습
    int outNum=5;
    static int snum=50;

    public Runnable getRunnable() { //"Runnable"을 반환해주는 메소드
        int temp=1; //지역변수 -> 메소드가 종료되면 반환되는 변수

        /* 방법 1
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                //System.out.println(temp++);
                // ->"temp"는 "getRunnable"메소드의 변수이다 해당 "run"메소드는 "MyRunnable"객체의 메소드이기때문에 run메소드를 실행시킬때는 이미 temp변수는 반환되기 때문에 사용이 불가능하다
                System.out.println(++outNum); //인스턴스 변수는 사용가능
            }
        }
        return new MyRunnable(); //"Runnable"을 구현한 객체 반환   */

        /* 방법2 ->inner클래스에서 이름을 없앤 클래스 -->익명클래스(어나니머스 클래스)라고 한다. */
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(++outNum); //인스턴스 변수는 사용가능
            }
        };

        /* 익명클래스 사용 다른 예시!
        Runnable r =new Runnable() {
            @Override
            public void run() {
                System.out.println(++outNum);
            }
        };
        */
    }
}

public class InnerClass {
    public static void main(String[] args)  {
        //테스트1
        OutClass out = new OutClass();
        out.OutTest();

        //System.out.println(OutClass.InClass.temp);
        // ->InClass에 있는 static변수인 temp를 쓰려고 하는데 "InClass"가 private이니 접근 자체가 불가능 / private을 풀게 되면 가능해진다.

        //테스트2
        System.out.println(OutClass.InStaticClass.temp);
        OutClass.InStaticClass sta = new OutClass.InStaticClass();
        sta.inTest();

        //테스트3
        OutClass.InStaticClass.sTest();

        //테스트4 -> 익명클래스 (사용이유? 프로그램에서 한번만 객체를 만드는 클래스일 경우)
        out o = new out();
        Runnable r =o.getRunnable();
        r.run();

        //익명 클래스 사용 예시->보통 thread를 사용할때 사용
        Thread t = new Thread(r);
        t.start();
        }

}
