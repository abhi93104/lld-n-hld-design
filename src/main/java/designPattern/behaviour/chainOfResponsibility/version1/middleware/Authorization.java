package designPattern.behaviour.chainOfResponsibility.version1.middleware;

import lombok.Data;

@Data
public class Authorization extends MiddleWare{

    /**
     * Check user has admin access or not
     * @param email User email
     * @param password User password
     * @return return true for admin else return response of next handler
     */

    @Override
    public boolean handle(String email, String password) {
        if(email.equals("admin@domain.com")){
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return sendToNextHandler(email, password);
    }
}
