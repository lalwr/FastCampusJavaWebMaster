package examples;

// 파일의 내용을 표준 입력으로 받는다.
// java examples.IOExam02 < io1.txt
// read()메소드는 byte를 리턴하는 것이 아니라 int를 반환한다.
// 그 이유는 EoF를 표현하려고. EoF는 음수값이다.
public class IOExam02 {
    public static void main(String[] args) throws Exception{
        int read = -1;
        while((read = System.in.read()) != -1){ // EOF : -1
            System.out.write(read); // common + d : 종료
        }
    }
}
/*
JAVA IO : 데코레이터 패턴
가장 핵심인 주인공
1) 생성자에 InputStream, OutputStream, Reader, writer가
   파라미터에 없는 클래스
2) InputStream, OutputStream, Reader, writer를 상송받고
   있어야 한다.
   java.io 패키지를 선택 한 후, 클래스를 찾아본다.
3) 주인공들은 1byte or 1char, byte[] or char[] 을 읽어들이는 read()메소드를 가지고 있다.
4) 주인공들은 어디에서 읽은 것인지, 어디에 쓸것인지를 결정한다.
5) 장식은 다양한 기능의 메소드를 제공한다.
   ex) int단위로 읽기, double단위로 읽기, 한줄 읽기 등, 버퍼내장

   System.in, System.out, System.err 도 주인공
   ByteArrayInputStream
   CharArrayReader
   CharArrayWriter
   FileInputStream
   FileOutputStream 등등
*/