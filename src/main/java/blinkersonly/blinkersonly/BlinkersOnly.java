package blinkersonly.blinkersonly;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemStack;

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
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta meta = (SkullMeta)head.getItemMeta();
        meta.setOwner(player.getDisplayName());
        meta.setDisplayName(ChatColor.GREEN + player.getDisplayName() + "s" + ChatColor.AQUA + " head");
        head.setItemMeta(meta);
        event.getDrops().add(head);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.BLUE + "yooo... you NEED to get some head!");
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

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        event.setQuitMessage(ChatColor.GOLD + event.getPlayer().getName() +
                ChatColor.BLUE + " left the mofo game!");
    }
}
