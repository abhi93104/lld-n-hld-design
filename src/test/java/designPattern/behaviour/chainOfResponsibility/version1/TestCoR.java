package designPattern.behaviour.chainOfResponsibility.version1;

import designPattern.behaviour.chainOfResponsibility.version1.middleware.Authentication;
import designPattern.behaviour.chainOfResponsibility.version1.middleware.Authorization;
import designPattern.behaviour.chainOfResponsibility.version1.middleware.MiddleWare;
import designPattern.behaviour.chainOfResponsibility.version1.middleware.Throttling;
import designPattern.behaviour.chainOfResponsibility.version1.server.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCoR {

    private static Server server;
    public static void init(){
        server = new Server();
        server.register("admin@domain.com", "admin@123");
        server.register("user1@domain.com", "user1@123");
        MiddleWare middleware = MiddleWare.link(
                new Throttling(2),
                new Authentication(server),
                new Authorization()
        );
        server.setMiddleware(middleware);
    }

    @BeforeEach
    public void setup(){
        init();
    }

    @AfterEach
    public void tearDown(){
    }

//    public void readInput(String email, String password){
//        String input = email + "\n" + password;
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//    }

    @Test
    public void Test1(){
        String email = "admin@domain.com";
        String password = "admin@123";
        Assertions.assertTrue(server.logIn(email, password));
    }


    @Test
    public void Test2(){
        String email = "user1@domain.com";
        String password = "user1@123";
        Assertions.assertTrue(server.logIn(email, password));

        email = "user2@domain.com";
        password = "user2@123";
        Assertions.assertFalse(server.logIn(email, password));

        email = "user3@domain.com";
        password = "user3@123";
        Assertions.assertFalse(server.logIn(email, password));

    }

}
