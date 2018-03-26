package examples;

import java.io.FileOutputStream;

public class IOExam03 {
    public static void main(String[] args){
        // The try-with-resources Statement
        // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try(FileOutputStream fos = new FileOutputStream("data03.dat");) {

            long start = System.currentTimeMillis(); // 현재시간을 밀리초로 구함.
            // 파일에 1byte씩 1024* 1024번 저장.
//        int value = 0;
//        for(int i = 0; i < 1024 * 1024; i++){
//            fos.write(value);
//        }

            // 파일에 1024byte씩 1024번 저장
            byte[] buffer = new byte[1024];
            for (int i = 0; i < 1024; i++) {
                fos.write(buffer, 0, 1024);
            }
            long end = System.currentTimeMillis(); // 현재시간을 밀리초로 구함.
            System.out.println(end - start);
        }catch(Exception ex){
            System.out.println(ex);
        }

    }
}
