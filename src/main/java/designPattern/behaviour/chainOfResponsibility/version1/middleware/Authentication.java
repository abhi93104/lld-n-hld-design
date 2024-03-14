package designPattern.behaviour.chainOfResponsibility.version1.middleware;

import designPattern.behaviour.chainOfResponsibility.version1.server.Server;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Authentication extends MiddleWare{

    private Server server;


    /**
     * Verify email and password of the user and send to next handler
     * @param email User email
     * @param password User password
     * @return if user doesnot exist or pssword incorrect the return false else return response from next handler;
     */
    @Override
    public boolean handle(String email, String password) {
        if(!server.hasEmail(email)){
            System.out.println("This email is not registered!");
            return false;
        }
        if(!server.validEmailPassword(email, password)){
            System.out.println("Wrong password!");
            return false;
        }
        return sendToNextHandler(email, password);
    }
}
