package com.example.blackjack;


import java.util.ArrayList;

public class Hand {

    private final ArrayList<Card> hand;
    private int handValue;
    private boolean busted;

    private void calculateHandValue(){
            handValue = 0;
            for(Card card :hand){
                handValue += card.getCardValue();
            }

        busted = handValue > 21;
        }

        public Hand(){
            hand = new ArrayList<>();
            busted = false;
        }


    public boolean addCard(Card toAdd){
        hand.add(toAdd);
        calculateHandValue();
        return isBusted();
    }

    public int getHandValue(){
        return handValue;
    }

    public Card getCard(int i){
        return hand.get(i);
    }


    public void discardHand(){
        hand.clear();
        handValue = 0;
        busted = false;
    }

    public boolean isBusted(){
        return busted;
    }

    public int size(){
        return hand.size();
    }
}
