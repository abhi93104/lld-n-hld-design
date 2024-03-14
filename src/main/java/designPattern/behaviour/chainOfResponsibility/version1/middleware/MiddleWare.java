package designPattern.behaviour.chainOfResponsibility.version1.middleware;

import lombok.Data;

@Data
public abstract class MiddleWare {
    private MiddleWare next;

    public abstract boolean handle(String email, String password);

    public static MiddleWare link(MiddleWare first, MiddleWare... chainOfMiddleware){
        MiddleWare head = first;
        for(MiddleWare handler : chainOfMiddleware){
            head.setNext(handler);
            head = head.getNext();
        }
        return first;
    }

    public boolean sendToNextHandler(String email, String password){
        if(next == null){
            /* no next handler i.e. all handlers processed it properly and return true */
            return true;
        }
        return next.handle(email, password);
    }
}
