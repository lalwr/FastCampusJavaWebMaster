Tomcat
+
------ bin : startup.sh , shutdown.sh
+
------ conf : Tomcat 설정 파일
+
------ lib : tomcat 라이브러리 (serlvet , jstl, EL 라이브러리등은 기본으로 들어가있다.)
+
------ webapps : 웹 어플리케이션들
          |
          +----- ROOT
          |
          +----- manager
          .....
http://localhost:8080/{context root}/path?{파라미터들}

context root는 웹 어플리케이션마다 유일한 값을 가져야 한다.
WAS마다 설정방법이 다르다. (Tomcat, Weblogic 등에 따라 다르다.)
tomcat은 ROOT 라는 이름의 웹어플리케이션은 / 로 인식을 한다.
나머지는 보통 폴더이름이 context root가 된다.

http://localhost:8080/hello.jsp (ROOT 웹어플리케이션의 hello.jsp)
http://localhost:8080/manager/hello.jsp (manager 웹 어플리케이션의 hello.jsp)

웹펄플리케이션이(board) - 예를들어 게시판 웹 어플리케이션
    |
    +---- WEB-INF -- WEB.xml
    |           +
    |           ----- classes : 사용자가 만든 package와 class들
    |           |
    |           ----- lib : *.jar
    |           |
    |           ---- 각종폴더와 파일들
    |
    +---- 폴더, 각종 파일들

manager폴더 안의 내용을 jar로 묶어서 하나의 파일로 만든다. board.war 로 만든다.

tomcat에 배포하려면 어떻게 하는가?

webapps폴더에 복사를 하고 tomcat을 실행한다. tomcat이 실행되면서 board.war의 압축을 해제한다.
webapps ---- board ---- war파일의 내용이 묶인것이 풀린다.

http://localhost:8080/board/list.jsp 이런식으로 호출을 할 수 있다.

maven프로젝트?

src - main --- java - 패키지및 자바 소스
            |
            --- webapp ---- WEB-INF ---- web.xml

intelliiJ에서 tomcat local로 실행하도록 설정하는데.... 프로젝트 이름이 mvcexam 일 경우에

intellij가 관리하는 tomcat에 IntelliJ가 board.war파일을 만들어서 배포한다.(deploy)

웹어플리케이션 구조를 가지고 있다면 war파일로 묶지 않아도 구동될수 있다.
war파일은 전달하기 편하기 위해서 사용

-----------------------------------

    <!-- maven에서 tomcat을 실행한다. -->
    <build>
        <finalName>mvcexam</finalName>
        <plugins>
            <!-- 해당 플러그인이 지정안되어 있다면 maven프로젝트는 JDK 1.5를 사용 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.6.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>

            <!-- maven에서 tomcat을 실행한다. -->
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.1</version>
                <configuration>
                    <charset>UTF-8</charset>
                    <uriEncoding>UTF-8</uriEncoding>
                    <port>8080</port>
                </configuration>
            </plugin>
        </plugins>
    </build>

라이프 사이클의 하나의 단위 명령을 goal이라고 한다. (clean, compile , package등등)

콘솔입력

mvn tomcat7:run (톰캣실행)
위와 같을경우 <finalName>mvcexam</finalName> 이름이 context path(application path, Context root)가 된다.
http://localhost:8080/mvcexam

            <!-- maven에서 tomcat을 실행한다. -->
			<plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<version>2.1</version>
				<configuration>
					<charset>UTF-8</charset>
					<uriEncoding>UTF-8</uriEncoding>
					<port>8080</port>
					<path>/</path>
				</configuration>
			</plugin>

mvn tomcat7:run (톰캣실행)
<path>/</path>를 추가 설정하면
http://localhost:8080/ 로 접속이 가능하다.

mvn plugin 설정을 활용하면 GUI환경을 사용하지않고 JAVA와 MAVEN만 있으면 실행할 수 있다.