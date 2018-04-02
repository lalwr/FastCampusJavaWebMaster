package soundsystem.examDice;

import java.util.List;

public class Game {
    List<Player> list;

    public void setPlayerList(List<Player> list){
        this.list = list;
    }

    public void play(){
        for(Player player : list){
            player.play();
        }
    }
}
