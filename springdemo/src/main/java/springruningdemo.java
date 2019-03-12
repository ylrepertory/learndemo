import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @program: learndemo
 * @description: spring运行代码
 * @author: leo
 * @create: 2019-02-25 10:15
 **/
public class springruningdemo {
    public static void main(String[] args) {

        ClassPathResource resource = new ClassPathResource("application.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
//        SpringTestService springTestService = (SpringTestService) factory.getBean(SpringTestService.class);
//        springTestService.doTest();

    }
}
