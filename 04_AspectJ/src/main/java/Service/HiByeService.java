package Service;

import org.springframework.stereotype.Component;

@Component
public class HiByeService {

    public void sayHi(String name) {
        System.out.println("Hi " + name);
    }

    public void sayBye() {
        System.out.println("Bye");
    }

    public String returnSomething() {
        return "Hi Bye";
    }
}
