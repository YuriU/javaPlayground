package Service;

import org.springframework.stereotype.Component;

@Component
public class HiByeService {

    public void sayHi() {
        System.out.println("Hi");
    }

    public void sayBye() {
        System.out.println("Bye");
    }

    public String returnSomething() {
        return "Hi Bye";
    }
}
