  package me.totalfreedom.totalfreedommod.command;

  import me.libraryaddict.disguise.DisallowedDisguises;
  import me.totalfreedom.totalfreedommod.rank.Rank;
  import me.totalfreedom.totalfreedommod.util.FUtil;
  import org.bukkit.command.Command;
  import org.bukkit.ChatColor;
  import org.bukkit.command.CommandSender;
  import org.bukkit.entity.Player;
  
  @CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
  @CommandParameters(description = "Toggle disguises", usage = "/<command>", aliases = "dtoggle")
  public class Command_disguisetoggle extends FreedomCommand
  {
  
      @Override
      public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
      {
          
          if (!DisallowedDisguises.disabled)
          {
              
              plugin.ldb.undisguiseAll(true);
              plugin.ldb.enableDisguises(false);
          }
              
          else
          {
              plugin.ldb.enableDisguises(true);
          }
          
          FUtil.adminAction(sender.getName(), (DisallowedDisguises.disabled ? "Enabling" : "Disabling") + " Disguises", false);
          sender.sendMessage(ChatColor.DARK_GRAY + "Disguises" + (DisallowedDisguises.disabled ? "enabled." : "disabled."));
          
          return true;
      }
  }
