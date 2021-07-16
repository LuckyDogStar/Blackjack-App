package com.example.blackjack;



import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public enum Suit{SPADES, HEARTS, DIAMONDS, CLUBS}
    public enum Rank{TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE}

    private final ArrayList<Card> deck;
    private final int numberOfSets;



    public Deck() throws NoSuchFieldException, IllegalAccessException {
        numberOfSets = 4;
        deck = new ArrayList<>(Suit.values().length*Rank.values().length*numberOfSets);
        initializeDeck();
    }

    public Deck(int sets) throws NoSuchFieldException, IllegalAccessException {
        numberOfSets = sets;
        deck = new ArrayList<>(Suit.values().length*Rank.values().length*numberOfSets);
        setDeck();
    }
    public void setDeck() throws NoSuchFieldException, IllegalAccessException {
            deck.clear();
        for (int i = 0; i < numberOfSets; i++) {
            for (Suit s : Suit.values()) {
                for (Rank r : Rank.values()) {
                    Card cardToAdd = new Card(s, r,R.drawable.class.getField(setCardFaceId(r,s)).getInt(null));
                    deck.add(cardToAdd);
                }
            }
        }
        Collections.shuffle(deck);
    }

    public void initializeDeck() throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < numberOfSets; i++) {
            for (Suit s : Suit.values()) {
                for (Rank r : Rank.values()) {
                    Card cardToAdd = new Card(s,r,R.drawable.class.getField(setCardFaceId(r,s)).getInt(null));
                    deck.add(cardToAdd);
                }
            }
        }
        Collections.shuffle(deck);
    }

    public Card drawCard(){
        if(isEmpty()){
            return null;
        }
        Card temp = deck.remove(0);
        return temp;
    }

    public boolean needsShuffled(){

        return !(deck.size() >= 5);
    }

    public boolean isEmpty(){
        return deck.isEmpty();
    }


    private String setCardFaceId(Rank rank, Suit suit){
        String r="";
        String s="";
        switch (rank){
            case ACE:
                r = "a";
                break;
            case TWO:
                r = "two";
                break;
            case THREE:
                r = "three";
                break;
            case FOUR:
                r = "four";
                break;
            case FIVE:
                r = "five";
                break;
            case SIX:
                r = "six";
                break;
            case SEVEN:
                r = "seven";
                break;
            case EIGHT:
                r = "eight";
                break;
            case NINE:
                r = "nine";
                break;
            case TEN:
                r = "ten";
                break;
            case JACK:
                r = "j";
                break;
            case QUEEN:
                r = "q";
                break;
            case KING:
                r = "k";
                break;
        }
         switch(suit){
             case HEARTS:
                 s = "h";
                 break;
             case CLUBS:
                 s = "c";
                 break;
             case SPADES:
                 s = "s";
                 break;
             case DIAMONDS:
                 s = "d";
                 break;

        }
        return r+s;
    }


}
