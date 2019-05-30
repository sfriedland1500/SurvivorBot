package dc.bot.survivor.try1;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.Permission;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import net.dv8tion.jda.core.managers.GuildController;
import net.dv8tion.jda.core.hooks.EventListener;

import javax.security.auth.login.LoginException;



public class PingPongTryBot extends ListenerAdapter {

    private int test = 0;
    private String channelName = "";

    public static void main(String[] args) throws LoginException {

        String token = System.getProperty("token");
        System.out.println(token);
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(token);
        builder.addEventListener(new PingPongTryBot());
        builder.build();
        //GuildController create = new GuildController();
    }

    public void onMessageReceived(MessageReceivedEvent event){


        System.out.println("We received a message from " + event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());
        if(event.getMessage().getContentRaw().equals("!ping"))
            event.getChannel().sendMessage("pong!").queue();
        if(event.getMessage().getContentRaw().equals("!create")) {
            GuildController create = new GuildController(event.getGuild());
            create.createTextChannel(channelName).queue();
        }

        if(event.getMessage().getContentRaw().equals("!changename")) {
            event.getChannel().sendMessage("type name you would like to change it to").queue();
            if(event.getMember().hasPermission(Permission.MANAGE_PERMISSIONS))
                channelName = event.wait(event);
            channelName = "gon";
        }





    // public void createChannel(GuildController creator){
       // creator.createTextChannel("hello");
    //}




}
    public void wait(EventListener listener){

    }
}
