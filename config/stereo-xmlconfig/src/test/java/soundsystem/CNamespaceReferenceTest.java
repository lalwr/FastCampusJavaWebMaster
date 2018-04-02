package soundsystem;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// ApplicationContext가 context = new ClassPathXmlApplicationContext("CNamespaceReferenceTest-context.xml");
// @RunWith(SpringJUnit4ClassRunner.class) : junit이 실행하면서 @Test할때 내부적으로 ApplicationContext를 생성한다.
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext가 생성할때 클래스이름-context-xml파일을 설정파일로하여 읽어들이도록한다. ex) CNamespaceReferenceTest-context.xml
@ContextConfiguration
public class CNamespaceReferenceTest {

  // System.out.println(값) 으로 출력한 결과를 가질 수 있는 객체
  @Rule
  public final StandardOutputStreamLog log = new StandardOutputStreamLog();

  // 자동으로 DI (의존성 주입)
  // ApplicationContext가 관리하는 Bean중에서 MediaPlayer타입의 객체를 주입.
  @Autowired
  private MediaPlayer player;

  @Test
  public void notNull(){
    assertNotNull(player);
    //import static org.junit.Assert.* : static메소드라서 Assert.assertNotNull로 선언을 하지 않아도 된다.
  }

  @Test
  public void play() { //window : /r/n
    player.play();
    assertEquals(
        "Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n",
        log.getLog());
  }

}
