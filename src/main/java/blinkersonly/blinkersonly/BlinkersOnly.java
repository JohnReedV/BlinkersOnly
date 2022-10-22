package blinkersonly.blinkersonly;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class BlinkersOnly extends JavaPlugin implements Listener  {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        System.out.println("Blinkers only is ON");
    }

    @Override
    public void onDisable() {
        System.out.println("Blinkers only is OUT");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("ping")){
            Player player = (Player) sender;
            player.sendMessage(("Your ping is " + player.getPing()));
        }
        return true;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        String joinInfo = "tell John player join message is broke";
        Player player = event.getPlayer();

        String[] Possibilites = {"ip", "health", "xp", "name", "time",
        "bed", "total exp", "getFacing", "holding", "ping", "poop"};

        String selection =
                Possibilites[(int) Math.round(((Math.random() * (Possibilites.length - 0)) + 0))];

        if (selection.equals(Possibilites[0])){
            joinInfo = "Your ip address is "+player.getAddress()+" xD";
        }else if (selection.equals(Possibilites[1])){
            joinInfo = "your health is "+player.getHealth();
        }else if (selection.equals(Possibilites[2])){
            joinInfo = "you need "+player.getExpToLevel()+" more exp to level up";
        }else if (selection.equals(Possibilites[3])){
            joinInfo = "your name is "+player.getName() + ChatColor.ITALIC + " so cool right!";
        }else if (selection.equals(Possibilites[4])){
            joinInfo = "the current time is "+player.getPlayerTime();
        }else if (selection.equals(Possibilites[5])){
            joinInfo = "your bed is at "+player.getBedSpawnLocation();
        }else if (selection.equals(Possibilites[6])){
            joinInfo = "your total EXP gained is at "+player.getTotalExperience();
        }else if (selection.equals(Possibilites[7])){
            joinInfo = "you are facing "+player.getFacing();
        }else if (selection.equals(Possibilites[8])){
            joinInfo = "you are holding "+player.getItemInUse();
        }else if (selection.equals(Possibilites[9])){
            joinInfo = "your ping is "+player.getPing();
        } else if (selection.equals(Possibilites[10])) {
            joinInfo = ChatColor.RESET + "hahaha you got the" + ChatColor.DARK_GREEN +
                    ChatColor.MAGIC + ChatColor.BOLD + "POOP" +  ChatColor.RESET +" option HAHAH";
        }
        player.sendMessage(ChatColor.GOLD + player.getName() + " " + ChatColor.BLUE + joinInfo);

        event.setJoinMessage(ChatColor.BLUE+"nooooooooooo " +
                ChatColor.GOLD + player.getName() + ChatColor.BLUE+" is here :(");
    }
}
