__Stream 이란?__
===================
- 다양한 입출력 장치와 프로그램 사이의 데이터를 전달받는 입출력 방식
- 스트림은 운영체제에 의해 생성된 가상의 연결 고리를 의미하며, 중간 매개자 역할을 한다.
![3333](https://user-images.githubusercontent.com/96917871/151021600-2a36c4b0-dc21-4f9e-a873-f35c756a17c0.PNG)

__Stream의 구분__
----------------------
(1) 대상기준 -> 입력 스트림/출력 스트림  
(2) 자료의 종류 기준 -> 바이트 스트림/문자 스트림  
(3) 기능 기준 -> 기반 스트림(1차 스트림) / 보조 스트림(2차 스트림)  

__<바이트 스트림>__
- 1바이트씩 읽고 쓰는 스트림(정수형 데이터, 문자 데이터들을 한자씩 읽고 쓴다)
- 바이트 단위로 자료를 처리하기 때문에 문자 데이터는 깨진다!!! ->2 바이트 단위로 처리하는 문자 스트림을 사용해야지만 문자가 깨지지 않는다.
- 종류 : 입력관련 -> System.in , FileInputStream , DateInputStream      
           출력관련 -> System.in , FileOuputStream, DateOuputStream    

-System.in-
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

-FileInputStream-
```
File f = new File("input.txt");
        FileInputStream file = null;
        int i=0;
        try {
            file = new FileInputStream(f); //1바이트씩 읽는 파일 입력스트림 생성 -> 마찬가지로 한글을 읽을 수 없다.
            while((i=file.read())!=-1) //마찬가지로 int형으로 반환이 된다!!!! , 공백또한 읽음 당연히.
            {
                System.out.println((char)i);
            }
        }catch(IOException e) {
            System.out.println(e);
        }finally {
            try {
                file.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
```













__<문자 스트림>__
- 2바이트 단위로 처리하는 스트림(문자 데이터들을 처리할때 주로 사용)
- 



