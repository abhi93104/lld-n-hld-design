package designPattern.behaviour.chainOfResponsibility.version1.server;

import designPattern.behaviour.chainOfResponsibility.version1.middleware.MiddleWare;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Server {

    private Map<String, String> users = new HashMap<>();
    private MiddleWare middleware;


    public boolean logIn(String email, String password) {
        if (middleware.handle(email, password)) {
            System.out.println("Login have been successful!");

            // Do something

            return true;
        }
        return false;
    }


    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean validEmailPassword(String email, String password){
        return users.get(email).equals(password);
    }

    public boolean hasEmail(String email){
        return users.containsKey(email);
    }

}
