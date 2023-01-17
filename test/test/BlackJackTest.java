package test;

import BlackJack.Card;
import BlackJack.BlackJack;
import static org.junit.Assert.assertEquals;
import static BlackJack.Card.*;
import BlackJack.HandList;
import org.junit.Test;

public class BlackJackTest{
    
    @Test 
    public void test_blackjack_croupier_winsall() {
        //no cards drawn from deck
        Card[] Player1= new Card[]{Jack,_2,Ace}; //13
        Card[] Player2= new Card[]{_10, _5,_6}; //21
        Card[] Player3= new Card[]{_3, _6,Ace,_3,Ace,King}; //24
        Card[] Croupier=new Card[]{_9,_7,_5}; //21
        Card[] Deck= new Card[]{_5, _4};
        BlackJack black=new BlackJack();
        
        String[] win=black.getWinners(Player1,Player2,Player3,Croupier,Deck);
        assertEquals(0,win.length);
        //no cards drawn from deck similar to 1st test
        Player1= new Card[]{Jack,_2,Ace}; //13
        Player2= new Card[]{_10, _4,_6}; //20
        Player3= new Card[]{_3, _6,Ace,_3,Ace,King}; //24
        Croupier=new Card[]{_9,_7,_4}; //20
        Deck= new Card[]{_5, _4};
        
        win=black.getWinners(Player1,Player2,Player3,Croupier,Deck);
        assertEquals(0,win.length);
        //card drawn from deck
        Player1= new Card[]{Jack,_2,Ace}; //13
        Player2= new Card[]{_10, _5,_6}; //21
        Player3= new Card[]{_3, _6,Ace,_3,Ace,King}; //24
        Croupier=new Card[]{Ace}; //11
        Deck= new Card[]{_10, _4};//11+10=21=blackjack
        
        win=black.getWinners(Player1,Player2,Player3,Croupier,Deck);
        assertEquals(0,win.length);
    }
    @Test 
    public void test_blackjack_oneplayerwin() {
        //card drawn from deck
        Card[] Player1= new Card[]{Jack,Ace}; //blackjack 21
        Card[] Player2= new Card[]{_10, _5,_6}; //21
        Card[] Player3= new Card[]{_3, _6,Ace,_3,Ace,King}; //24
        Card[] Croupier=new Card[]{_9,_7};
        Card[] Deck= new Card[]{_5, _4};
        BlackJack black=new BlackJack();
        String[] win=black.getWinners(Player1,Player2,Player3,Croupier,Deck);
        assertEquals("Player1",win[0]);
        //multiple cards drawn
        Player1= new Card[]{Jack,_2,Ace,_3}; //16
        Player2= new Card[]{_10, _5,_6}; //21
        Player3= new Card[]{_3, _6,Ace,_3,Ace,King}; //24
        Croupier=new Card[]{Ace,_2,King}; //13
        Deck= new Card[]{_3, _2,_4};//13+3+2=17
        
        win=black.getWinners(Player1,Player2,Player3,Croupier,Deck);
        assertEquals("Player2",win[0]);
        assertEquals(1,win.length);
    }
    
    @Test 
    public void test_blackjack_twoplayerwin() {
        //multiple cards drawn from deck
        Card[] Player1= new Card[]{_10,King}; //blackjack 21
        Card[] Player2= new Card[]{_10, _5,_6}; //21
        Card[] Player3= new Card[]{_3, _6,Ace,_3,Ace,King}; //24
        Card[] Croupier=new Card[]{_9,_7};
        Card[] Deck= new Card[]{_2, _3};
       BlackJack black=new BlackJack();
        String[] win=black.getWinners(Player1,Player2,Player3,Croupier,Deck);
        assertEquals("Player1",win[0]);
        assertEquals("Player2",win[1]);
        assertEquals(2,win.length);
    }
    
    @Test 
    public void CroupierBust() {
        Card[] Player1= new Card[]{_10,King}; //21 BJ
        Card[] Player2= new Card[]{_10,_6}; //16
        Card[] Player3= new Card[]{_3, _6,Ace,_3,Ace,King}; //24 Bust
        Card[] Croupier=new Card[]{_9,_5}; //14
        Card[] Deck= new Card[]{King, _3};//14+10=24=BUST
       BlackJack black=new BlackJack();
        String[] win=black.getWinners(Player1,Player2,Player3,Croupier,Deck);
        assertEquals(2,win.length);
    }
    
    
}
