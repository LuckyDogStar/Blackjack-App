package com.example.blackjack;

public class Dealer {

    private final Hand dealerHand;
    private boolean staying;
    private Card hiddenCard;
    private boolean resolvedStay;


public Dealer(){
    dealerHand = new Hand();
    staying = false;
    hiddenCard = null;
    resolvedStay = false;
}


    public void drawCard(Card drawnCard) {
        if (!resolvedStay) {
            revealHiddenCard();

            return;
        }
        dealerHand.addCard(drawnCard);
        if (!dealerHand.isBusted()) {
            dealerRules();
        }
    }

    public void drawFirstCard(Card drawnCard){
            dealerHand.addCard(drawnCard);
            if(!isBusted()){
                dealerRules();
            }
        }



    private void  dealerRules(){
        if (dealerHand.getHandValue() > 16) {
        staying = true;
        }
    }


    public boolean hasResolvedStay(){
        return resolvedStay;
    }

    public void drawHiddenCard(Card card){
    hiddenCard = card;
    }

    private void revealHiddenCard(){
    dealerHand.addCard(hiddenCard);
    hiddenCard = null;
    resolvedStay = true;
    }

    public void discardDealerHand(){
        dealerHand.discardHand();
        hiddenCard = null;
        staying = false;
    }

    public int handSize(){
    return dealerHand.size();
    }

    public Hand getHand(){
        return dealerHand;
    }

    public int getHandValue(){
        return dealerHand.getHandValue();
    }

    public boolean isBusted(){
    return dealerHand.isBusted();
    }
    public boolean isStaying(){
        return staying;
    }




}
