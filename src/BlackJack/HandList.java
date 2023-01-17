package BlackJack;

import static BlackJack.Card.Ace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandList implements Hand {
    public List<Card> cards;
    public HandList(Card... cards){
        this.cards=new ArrayList<>();
        for(Card card:cards){
            this.cards.add(card);
        }
    }
    public int value() {
        return canUseAceExtendedValue() ? sum() + 10 : sum();
    }
    private int sum() {
        return cards.stream().mapToInt(e->e.value()).sum();
    }
    private boolean canUseAceExtendedValue() {
        return sum() <= 11 && containsAce();
    }

    private boolean containsAce() {
        return cards.stream().anyMatch(e->e==Ace);
    }

    @Override
    public boolean isBlackJack() {
        return value() == 21 && cards.size() == 2;
    }

    @Override
    public boolean isBust() {                
        return value() > 21;
    }

    @Override
    public void add(Card card) {
        cards.add(card);
            }
}
    
