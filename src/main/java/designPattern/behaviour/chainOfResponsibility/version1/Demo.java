package designPattern.behaviour.chainOfResponsibility.version1;

import designPattern.behaviour.chainOfResponsibility.version1.middleware.Authentication;
import designPattern.behaviour.chainOfResponsibility.version1.middleware.Authorization;
import designPattern.behaviour.chainOfResponsibility.version1.middleware.MiddleWare;
import designPattern.behaviour.chainOfResponsibility.version1.middleware.Throttling;
import designPattern.behaviour.chainOfResponsibility.version1.server.Server;

import java.util.Scanner;

public class Demo {

    private static Server server;

    public static void init(){
        server = new Server();
        server.register("admin@domain.com", "admin@123");
        server.register("user1@domain.com", "user1@123");

        // All checks are linked. Client can build various chains using the same
        // components.
        MiddleWare middleware = MiddleWare.link(
                new Throttling(2),
                new Authentication(server),
                new Authorization()
        );

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args){
        init();
        Scanner sc = new Scanner(System.in);
        boolean success = false;
        while (!success) {
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            System.out.print("Input password: ");
            String password = sc.nextLine();
            success = server.logIn(email, password);
        }
    }

}
