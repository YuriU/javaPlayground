package Demo;

import Service.HiByeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

// Was inspired by https://www.youtube.com/watch?v=Og9Fyew8ltQ
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Component
public class AspectDemo {

    private final HiByeService service;

    public AspectDemo(HiByeService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("Service", "Demo", "Aspects");
        AspectDemo demo = ctx.getBean(AspectDemo.class);
        demo.runDemo();
    }

    public void runDemo() {
        service.sayHi("Yurii");
        service.sayBye();
        service.returnSomething();
    }
}
