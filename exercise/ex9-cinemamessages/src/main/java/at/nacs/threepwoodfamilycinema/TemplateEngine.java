package at.nacs.threepwoodfamilycinema;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class TemplateEngine {

    private final TextMessageSender messageSender;
    //    private final CustomerLoader loader;
    private final MessageLoader messageLoader;

    public void provideMessage(String name) {
        Map<String, String> templateMessages = messageLoader.getTemplate();
//        System.out.println("map size: " + templateMessages.size());
//        boolean condition = templateMessages.containsKey(name);
        if (name) {
            String message = templateMessages.get(name);
            System.out.println(message);
            String template = message.replace("{name}", name);
            messageSender.display(template);
        }
//receives the customer name and
// returns the right template text with the replaced {name}.
    }
}

//        if (name.contains("Threepwood")) {
//            messageSender.provideThreepwoodTemplate(name);
//        } else if (name.startsWith("Ms.") || name.startsWith("Mrs.")) {
//            messageSender.provideWomenTemplate(name);
//        } else if (name.startsWith("Mr.")) {
//            messageSender.provideManTemplate(name);
//        } else
//            messageSender.provideDefaultTemplate(name);