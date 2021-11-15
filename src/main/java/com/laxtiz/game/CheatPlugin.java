package com.laxtiz.game;

import arc.util.CommandHandler;
import mindustry.Vars;
import mindustry.gen.Player;
import mindustry.mod.Plugin;

@SuppressWarnings("unused")
public class CheatPlugin extends Plugin {
    private static void showMeTheMoney(String[] arg, Player player) {
        if (!player.admin) {
            player.sendMessage("[red]you can't do this.[]");
            return;
        }

        if (!String.join(" ", arg).equals("me the money")) {
            player.sendMessage("what mean?");
            return;
        }

        for (var item : Vars.content.items()) {
            player.core().items.add(item, 10_000);
        }
        player.sendMessage("[green]Gift for you.[]");
    }

    @Override
    public void registerClientCommands(CommandHandler handler) {
        handler.register("show", "[what...]", "Have you played StarCraft?", CheatPlugin::showMeTheMoney);
    }
}
