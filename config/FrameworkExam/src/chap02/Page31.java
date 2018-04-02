package chap02;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


// log4j.xml , applicationContextPage31.xml 파일을 resource 소스 디렉토리에 생성한다.
public class Page31 {
	public static void main(String args[]){
		BeanFactory cxt = null;
		cxt = new XmlBeanFactory(new FileSystemResource("./resource/applicationContextPage31.xml"));
		System.out.println("초기화 완료.");
	}
}
