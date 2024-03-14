package designPattern.behaviour.chainOfResponsibility.version1.middleware;

import lombok.Data;

@Data
public class Throttling extends MiddleWare{
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public Throttling(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }


    /**
     * Check if number of request within a minute exceeded more than given limit
     * @param email User email for next handler
     * @param password User password for next handler
     * @return if number of request within limit then send to next handler and return its response else return false
     */
    @Override
    public boolean handle(String email, String password) {
        if(System.currentTimeMillis() > currentTime + 60000){
            currentTime = System.currentTimeMillis();
            request = 0;
        }
        request++;

        if(request > requestPerMinute){
            System.out.println("Request limit exceeded!");
        }else{
            return sendToNextHandler(email, password);
        }
        return false;
    }
}
