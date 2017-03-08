package rubrica.rubrica;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
	   ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

      obj.getMessage();
      
      GoodbyeWorld obj2 = (GoodbyeWorld) context.getBean("adios");
      obj2.getMessage();
   }
}
