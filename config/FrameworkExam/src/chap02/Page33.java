package chap02;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


public class Page33 {
	public static void main(String args[]){
		BeanFactory cxt = null;
		cxt = new XmlBeanFactory(new FileSystemResource("./resource/applicationContextPage33.xml"));
		System.out.println("초기화 완료.");
	}
}
