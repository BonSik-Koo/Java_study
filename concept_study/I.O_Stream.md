__Stream 이란?__
===================
- 다양한 입출력 장치와 프로그램 사이의 데이터를 전달받는 입출력 방식
- 스트림은 운영체제에 의해 생성된 가상의 연결 고리를 의미하며, 중간 매개자 역할을 한다.
![3333](https://user-images.githubusercontent.com/96917871/151021600-2a36c4b0-dc21-4f9e-a873-f35c756a17c0.PNG)

__Stream의 구분__
----------------------
(1) 대상기준 -> 입력 스트림/출력 스트림  
(2) 자료의 종류 기준 -> 바이트 스트림/문자 스트림  
(3) 기능 기준                                              
-> 기반 스트림(1차 스트림) : 대상에 직접 자료를 읽고 쓰는 기능의 스트림      
-> 보조 스트림(2차 스트림) : 직접 읽고 쓰는 기능 없이 기반스트림에 추가적인 기능을 더해주는 스트림, 기반스트림의 종류(바이트, 문자스트림)에 맞는 보조스트림을 사용해야 된다, 항상 기반스트림이    나 또 다른 보조 스트림을 생성자 매개변수로 가진다.




__<바이트 스트림>__       
(1) 1바이트씩 읽고 쓰는 스트림(정수형 데이터, 문자 데이터들을 한자씩 읽고 쓴다)               
(2) 바이트 단위로 자료를 처리하기 때문에 문자 데이터는 깨진다!!! -> 2바이트 단위로 처리하는 문자 스트림을 사용해야지만 문자가 깨지지 않는다.                
(3) 종류                 
-입력관련 -> System.in(기반), FileInputStream(기반), DateInputStream(기반), BufferedInputStream(보조)                                      
-출력관련 -> System.out(기반), FileOuputStream(기반), DateOuputStream(기반), BufferedOutputStream(보조)

-System.in / System.out -->기반스트림
```
        System.out.println("알파벳 하나는 입력하시오");
        int i=0;

        try {
            i =System.in.read(); //한바이트씩 읽는다(즉 한글자씩), 주의할점: System.in.read()의 반환값은 int형이다!!!!!!!
        }catch(IOException e) {
            System.out.println(e);
        }
        System.out.println((char)i);
```

-FileInputStream / FileOutputStream -->기반스트림
```
        File f = new File("input.txt");
        FileInputStream file = null;
        FileOutputStream file2 =null;

        int i=0;
        try {
            file = new FileInputStream(f); //1바이트씩 읽는 파일 입력스트림 생성 -> 마찬가지로 한글을 읽을 수 없다.
            file2 = new FileOutputStream("output.txt");

            while((i=file.read())!=-1) //마찬가지로 int형으로 반환이 된다!!!! , 공백또한 읽음 당연히.
            {
                file2.write(i); //write는 int형만 받고 파일에 해당 정수값에 해당하는 아스키 코드의 문자로 쓰여진다!!!!!!!
            }
        }catch(IOException e) {
            System.out.println(e);
        }finally {
            try {
                file.close();
                file2.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
```

-BufferedInputStream / BufferedInputStream  -->보조 스트림
```     
        System.out.println("알파벳 10개를 입력하시오");
        int i=0;
        BufferedInputStream bu = null;
        byte[] b = new byte[10];

        try {
            bu = new BufferedInputStream(System.in,5); //바이트스트림의 보조스트림인 "BufferedInputStream"사용!!->바이트스트림(기반)은 아무거나 사용하능
            bu.read(b); //버퍼의 크기는 5이고 1바이트(한글자)씩 5개를 읽을수 있고 5개 읽으면 읽은 데이터를 배열에 저장하게 된다.

            for(int j=0;j<b.length;j++)
                System.out.print((char)b[j]);

        }catch(Exception e) {
            System.out.println(e);
        }
```
```
        System.out.println("입력하시오");
        int k=0;
        BufferedOutputStream out = null;
        try {
            out =new BufferedOutputStream(System.out,5); //5바이트크기의 버퍼를 설정
            while((k=System.in.read())!= 97) { //키보드로 부터 1바이트씩 입력받는다. (참고.System.in 스트림은 int 형을 반환)
                out.write((char)k); //5바이트(5글자) 읽게 되면 출력하게 된다.
            }
            out.flush(); //출력버퍼에 남아있는 데이터를 모드 출력
        }catch (IOException e) {
            e.printStackTrace();
        }
```




__<문자 스트림>__           
(1) 2바이트 단위로 처리하는 스트림(문자 데이터(한글)들을 처리할때 주로 사용) -> 한글을 깨지지 않고 읽고 쓸수 있다.                  
(2) 종류              
- 입력 관련: FileReader(기반), InputStreamReader(보조), BufferedReader(보조)           
- 출력 관련: FileWriter(기반), OutputStreamWriter(보조) ,BufferedWriter(보조)       

-FileReader / FileWriter  -->기반 스트림    
```
        File f = new File("input.txt");
        FileReader fin = null;
        FileWriter out = null;
        int i=0;

        try {
            out = new FileWriter("fwn.txt");
            fin = new FileReader(f); //문자스트림(기반) 생성
            //out = new FileWriter("output2.txt");

            while((i=fin.read())!=-1) { //File에서 문자를 하나 읽은 후 int형으로 반환해준다. -> 한글인(2바이트) 경우에도 깨지지 않는다.
                out.write(i); //int형을 받아서 매칭되는 문자를 출력해준다. (String,char[]등..전달할수 있는 인수다양)
            }
            out.flush(); //출력버퍼에 남아있는 값들을 출력
        }catch (IOException e) {
            System.out.print(e);
        }
```

-OutputStreamReader / OutputStreamWriter  -->보조 스트림      
```
        try {
            // 바이트로 읽은 데이터를 문자(2바이트)로 변환시키는 2차 스트림("InputStreamReader") -> 한글도 사용이 가능해짐
            InputStreamReader input =new InputStreamReader(System.in);
            //"FileOutputStream은 바이트스트림이기 때문에 한글이 깨지는 현상이 일어난다. 보조스트림인 "OutputStreamWriter"를 사용하여 문자로 변환시켜 출력할수 있다 ->한글도 깨지지 않는다.
            OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream("output4.txt"));
            int i=0;

            while((i=input.read()) != 97) { //System.in 스트림을 통해 1바이트씩 읽고 읽은 바이트 데이터를 문자로(2바이트) 변경된다.
                output.write(i);
            }
            output.flush();

        }catch (Exception e) {
            System.out.println(e);
        }
```

-BufferedReader / BufferedWrite  -->보조 스트림    
```
        File file = new File("input.txt");
        String temp;
        int i=0;
        BufferedReader bu = null;
        BufferedWriter bo =null;

        try {
            //문자스트림("FileReader")의 보조스트림인 "BufferedReader"사용!!->문자스트림(기반)은 아무거나 사용하능
            bu = new BufferedReader(new FileReader(file));
            bo = new BufferedWriter(new FileWriter("output10.txt") ,5);

            while((temp = bu.readLine()) !=null) {// "BufferedReader" 보조스트림에서만 한줄씩 읽기가 가능한 메소드를 제공해준다.
                bo.write(temp);
                //System.out.println(temp);
            }
            bo.flush();

        }catch(Exception e) {
            System.out.println(e);
        }
```




