package BlackJack;

public interface Hand {
        int value();
        boolean isBlackJack();
        boolean isBust();
        void add(Card card);
    }
