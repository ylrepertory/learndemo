/**
 * @program: learndemo
 * @description:
 * @author: leo
 * @create: 2019-01-24 16:25
 **/
public class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "Hi, " + name;
    }

}