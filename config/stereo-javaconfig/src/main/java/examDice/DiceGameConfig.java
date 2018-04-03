package examDice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DiceGameConfig {
    @Bean
    public Dice dice(){
        return new Dice(6);
    }

    @Bean
    public List<Player> dicePlayers(Dice dice){
        List<Player> list = new ArrayList<>();

        Player kim = new Player();
        kim.setName("kim");
        kim.setDice(dice);
        list.add(kim);

        Player lee = new Player();
        lee.setName("lee");
        lee.setDice(dice);
        list.add(lee);

        Player kang = new Player();
        kang.setName("kang");
        kang.setDice(dice);
        list.add(kang);
        return list;
    }

    @Bean
    public Game game(List<Player> dicePlayers){
        Game game = new Game();
        game.setPlayerList(dicePlayers);
        return game;
    }
}




