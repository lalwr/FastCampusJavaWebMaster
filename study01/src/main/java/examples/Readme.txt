1. 이름을 알 수 없는 클래스가 여러개 만들어질 경우,
어떻게 인스턴스를 생성할 것인가?

1단계.
```
package examples;

public class Hello1{
    public void hello(){
        System.out.println("hello1");
    }
}

package examples;

public class Hello2{
    public void hello(){
        System.out.println("hello2");
    }
}

// 클래스 이름이 바뀌면 레퍼런스타입과 생성자부분의 코드가 바뀌어야 한다.
Hello1 hello1 = new Hello1();
Hello2 hello2 = new Hello2();
```

레퍼런스타입을 하나로 일치하려면?

```
package examples;

public interface Hello {
    public void hello();
}

package examples;

public class Hello1 implements Hello{
    public void hello(){
        System.out.println("hello1");
    }
}

package examples;

public class Hello2 implements Hello {
    public void hello(){
        System.out.println("hello2");
    }
}

// 클래스 이름이 바뀌면 생성자부분의 코드가 바뀌어야 한다.
Hello hello1 = new Hello1();
Hello hello2 = new Hello2();

생성자를 사용하지 않고 객체를 생성할 수 없을까?

        for(int i = 1; i <= 2; i++) {
            //Hello hello = new Hello1();
            //문자열로 된 클래스 이름을 가지고 인스턴스를 생성하는 법
            String className1 = "examples.Hello" + i;
            // className1에 해당하는 클래스 정보를 clazz에 대입
            Class clazz = Class.forName(className1);
            // clazz가 가지고 있는 정보를 이용해 인스턴스를 생성
            Hello hello = (Hello) clazz.newInstance();
            hello.hello();
        }
```

* HttpServlet과 유사한 구조를 구현하려고 한다.


2. git에 특정 파일을 올리지 않으려면?
.gitignore 를 만들고 디렉토리와 파일 이름 패턴을 등록한다.
인텔리J에서는 이름이 회색으로 나온다.


3. mini was만들기

요청정보는 아래와 같은 형태다.

```
GET / HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
Accept-Encoding: gzip, deflate, br
Accept-Language: ko,en-US;q=0.9,en;q=0.8
Cookie: SESSION=aa4738ea-e521-4065-9934-1720bf3fe6b6; count=99; JSESSIONID=2F3A58790BB59D43DE831C8DDE16C9EB

```

```
POST / HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 11
Origin: chrome-extension://aejoelaoggembcahagimdiliamlcdmfm
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36
Content-Type: text/plain
Accept: */*
Accept-Encoding: gzip, deflate, br
Accept-Language: ko,en-US;q=0.9,en;q=0.8
Cookie: SESSION=aa4738ea-e521-4065-9934-1720bf3fe6b6; count=99; JSESSIONID=2F3A58790BB59D43DE831C8DDE16C9EB

body내용
``

응답.

```
HTTP/1.1 200 OK
Date: Mon, 23 May 2005 22:38:34 GMT
Content-Type: text/html; charset=UTF-8
Content-Encoding: UTF-8
Content-Length: 138
Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT
Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)
ETag: "3f80f-1b6-3e1cb03b"
Accept-Ranges: bytes
Connection: close

<html>
<head>
  <title>An Example Page</title>
</head>
<body>
  Hello World, this is a very simple HTML document.
</body>
</html>
``

4. rest client 설치

구글에서 "크롬 웹스토어"  검색어 : restlet , postman과 유사한 프로그램

Restlet Client - REST API Testing 설치한다.`

브라우저의 URL입력창에 주소를 입력하거나 링크를 클릭하면 GET요청한다.
POST, UPDATE, DELETE , PUT 과 같은 요청을 받으려면 rest client가 필요한다.



5. c:/tmp/wasroot 폴더를 만든다. (windows)
   /tmp/wasroot 폴더를 만든다. (mac)


6. 웹 브라우저의 요청을 받고, 그냥 클라이언트 정보 출력하기

```
package examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WASMain {
    public static void main(String[] args){
        ServerSocket listener = null;
        try{
            //특정 port에서 기다린는 ServerSocket을 생성한다.
            listener = new ServerSocket(8080);
            System.out.println("client를 기다립니다.");
            // 클라이언트가 접속할때까지 기다린다.
             Socket client = listener.accept(); // 블러킹 메소드.
            System.out.println(client);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally { // finally부분에서 서버소켓을 close한다.
            try {
                listener.close();
            }catch(Exception e){}
        }
    }
}
```

7. 클라이언트가 동시에 여러개의 요청을 보내도, 클라이언트 정보를 출력한다.

```
package examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WASMain {
    public static void main(String[] args){
        ServerSocket listener = null;
        try{
            //특정 port에서 기다린는 ServerSocket을 생성한다.
            listener = new ServerSocket(8080);
            System.out.println("client를 기다립니다.");
            // 클라이언트가 접속할때까지 기다린다.
            while(true){
                 Socket client = listener.accept(); // 블러킹 메소드.

                 new Thread(() -> {
                     try {
                         handleSocket(client);
                     } catch (Exception ex) {
                         ex.printStackTrace();
                     }
                 }).start();
             }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally { // finally부분에서 서버소켓을 close한다.
            try {
                listener.close();
            }catch(Exception e){}
        }
    }

    private static void handleSocket(Socket socket){
        System.out.println(socket);
    }
}
```

8. handleSocket의 구현

8.1. 브라우저의 요청정보를 읽어들인다.
( http method정보, path정보 등 )

8.1.1. path가 /면 /index.html파일을 보여준다.(welcome file)

8.2. path정보에 해당하는 파일을 읽어들여 응답으로 전송한다.
Socket.getOutputStream()으로 부터 얻은 OutputStream을 이용해
전송한다.

8.3. 파일이 없을 경우 404 처리


9. 8에서 작성한 내용을 DefaultServlet으로 처리하게 한다.
10. 사용자가 만든 Servlet을 실행한다.