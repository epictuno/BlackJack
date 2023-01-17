package test;

import BlackJack.Card;
import static org.junit.Assert.assertEquals;
import static BlackJack.Card.*;
import BlackJack.Hand;
import BlackJack.HandList;
import org.junit.Test;

public class HandTest {
    
    @Test
    public void test_hand_value_with_one_card() {
        assertEquals(3, createHand(_3).value());
        assertEquals(10, createHand(_10).value());
        assertEquals(10, createHand(Jack).value());
        assertEquals(10, createHand(Queen).value());
        assertEquals(10, createHand(King).value());
        assertEquals(11, createHand(Ace).value());
    }
    @Test
    public void test_hand_value_with_two_cards() {
        assertEquals(8, createHand(_3, _5).value()); 
        assertEquals(14, createHand(_3, Ace).value()); 
        assertEquals(11, createHand(_5, _6).value());        
        assertEquals(12, createHand(Ace, Ace).value());  
    }
    
    @Test
    public void given_hand_is_black_jack() {
        assertEquals(false, createHand(_3, _5).isBlackJack());        
        assertEquals(true, createHand(Ace, Jack).isBlackJack());
        assertEquals(true, createHand(Ace, King).isBlackJack());
        assertEquals(true, createHand(Ace, Queen).isBlackJack());
        assertEquals(true, createHand(_10, Ace).isBlackJack()); 
    }
    

    @Test 
    public void given_three_cards_should_determine_that_is_not_black_jack() {
       assertEquals(false, createHand(_5, _6, Queen).isBlackJack());               
    }
    
    @Test 
    public void given_two_cards_should_determine_that_is_not_bust() {
       assertEquals(false, createHand(_4,_3).isBust());               
    }
    
    @Test 
    public void given_three_cards_should_determine_that_is_bust_or_not() {
       assertEquals(true, createHand(_4, Jack, King).isBust());               
       assertEquals(false, createHand(_4, _2, _3).isBust());               
    }
    
    @Test 
    public void croupieradddecktest() {
        Hand H=createHand(_5);
        H.add(_7);
       assertEquals(12,H.value()); 
       H.add(Queen);
       assertEquals(22,H.value());
       H.add(Queen);
       assertEquals(32,H.value()); 
    }
    private Hand createHand(Card... cards){
        return new HandList(cards);
    }
    

}
