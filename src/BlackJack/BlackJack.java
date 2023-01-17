package BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//there would be an error if deck were to have not enough points but that would 
//be very weird in a game of blackjack with 3 players
public class BlackJack {
    public String[] getWinners(Card[] player1,Card[] player2,Card[] player3,
            Card[] croupier,Card[] RCards){
        Hand Player1=new HandList(player1);
        Hand Player2=new HandList(player2);
        Hand Player3=new HandList(player3);
        Hand Croupier=new HandList(croupier);
        // Croupier obtiene cartas hasta que tenga 17 puntos
        //entre 4 jugadores es imposible que nos falten cartas en este juego
        int index=0;
        for (int i = 0; Croupier.value()<=17 ; i++) {
            Croupier.add(RCards[i]);
        }
       //logica de ganadores
       List<String> winners=new ArrayList<>(); 
       //no tiene sentido continuar si el croupier tiene un blackjack
       //lucha por parejas de jugador con croupier este sistema les permitiria
       //a los jugadores tener nombres si se decidiera implementar
       if(!Croupier.isBlackJack()){
           //Como solo tenemos 3 jugadores no senti la necesidad de hacer un bucle
        BJFight(winners,Player1,Croupier,"Player1");
        BJFight(winners,Player2,Croupier,"Player2");
        BJFight(winners,Player3,Croupier,"Player3");
       }
       return winners.toArray(new String[0]);
    }
    private void BJFight(List<String> winners, Hand Player, Hand Croupier,
            String playername){
        if(Player.isBlackJack()){
            winners.add(playername);
            return;
        }
        if(!Player.isBust()){
            if(Croupier.isBust()){
                winners.add(playername);
            }
            else{
                if(Player.value()>Croupier.value()){winners.add(playername);}
            }
        }  
    }
}
