package dc.bot.survivor.try1;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class PingPongTryBot extends ListenerAdapter {


    public static void main(String[] args) throws LoginException {

        String token = System.getProperty("token");
        System.out.println(token);
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(token);
        builder.addEventListener(new PingPongTryBot());
        builder.build();
    }

    public void onMessageReceived(MessageReceivedEvent event){
        System.out.println("We received a message from " + event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());
        if(event.getMessage().getContentRaw().equals("!ping"))
            event.getChannel().sendMessage("Pong!").queue();
    }

}
