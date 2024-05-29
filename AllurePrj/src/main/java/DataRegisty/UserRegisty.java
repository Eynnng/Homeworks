package DataRegisty;

import PageObject.ValueObject.TestBot;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UserRegisty {
    private static Set<TestBot> testBots = new HashSet<>();

    public static TestBot getUniqueTestBot(){
        TestBot testBot;
        do{
            String username = generateRandomUsername();
            String password = generateRandomPassword();
            testBot = new TestBot(username, password);
        } while (testBots.contains(testBot));
        testBots.add(testBot);
        return testBot;
    }

    private static String generateRandomUsername(){
        return "user" + new Random().nextInt(1000);
    }
    private static String generateRandomPassword(){
        return "password" + new Random().nextInt(1000);
    }
}
