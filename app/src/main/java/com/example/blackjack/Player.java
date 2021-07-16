package com.example.blackjack;

public class Player {

    private final Hand playerHand;
    private int cashPool;
    private int handsWon;
    private int bet;
    private boolean staying;




    public Player(){
        playerHand = new Hand();
        staying = false;
        cashPool = 500;
        handsWon = 0;
        bet = 0;
    }

    public int handSize(){
        return playerHand.size();
    }

    public boolean isStaying(){
        return staying;
    }

    public void setStaying(boolean stay){
        staying = stay;
    }

    public int getHandValue(){
        return playerHand.getHandValue();
    }

    public int getCashPool(){return cashPool;}

    public int getHandsWon(){return handsWon;}

    public void subtractCash(int toSubtract){
        cashPool -= toSubtract;
    }

    public void addCash(int toAdd){
      cashPool += toAdd;
    }

    public int getBet(){
        return bet;
    }

    public void wonAHand(){
        handsWon++;
    }

    public boolean isBusted(){
        return playerHand.isBusted();
    }

    public Card drawCard(Card drawnCard){
       playerHand.addCard(drawnCard);
       return drawnCard;
    }

    public Hand getHand(){
        return playerHand;
    }

    public void discardPlayerHand(){
        playerHand.discardHand();
        staying = false;
        bet = 0;
    }

    public void changeBet(int newAmount){
        bet = newAmount;
    }



}
