package at.nacs.threepwoodfamilycinema;

import org.springframework.stereotype.Component;

@Component
public class TextMessageSender {
    public void display(String template) {
        System.out.println(template);
    }

//    CustomerLoader loader;
//
//    public void provideDefaultTemplate(String name) {
//        String template = "Hello {name}! How about a Friday night movie? This week with a 20% discount!";
//        String message = template.replace("{name}", name);
//        System.out.println(message);
//    }
//
//    public void provideThreepwoodTemplate(String name) {
//        String template = "Dear {name}, you and your friends will have so much fun at the cinema this Friday with a 20% discount!";
//        String message = template.replace("{name}", name);
//        System.out.println(message);
//    }
//
//    public void provideWomenTemplate(String name) {
//        String template = "My dearest {name}, your lovely family gives you a 20% discount on tickets this Friday!";
//        String message = template.replace("{name}", name);
//        System.out.println(message);
//    }
//
//    public void provideManTemplate(String name) {
//        String template = "Hello {name}! How about a Friday night movie? This week with a 20% discount!";
//        String message = template.replace("{name}", name);
//        System.out.println(message);
//    }
}