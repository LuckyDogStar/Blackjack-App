package com.example.blackjack;

public class BlackJackGame {

    private final Player player;
    private final Dealer dealer;
    private final Deck deck;

    public BlackJackGame() throws NoSuchFieldException, IllegalAccessException {
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();
        openingHand();
    }


    private void openingHand() throws NoSuchFieldException, IllegalAccessException {
        dealer.drawFirstCard(verifyDraw(deck.drawCard()));
        dealer.drawHiddenCard(verifyDraw(deck.drawCard()));
        player.drawCard(verifyDraw(deck.drawCard()));
    }


    public void playerStays() {
        player.setStaying(true);
    }

    public void playerChangeBet(int amt) {
        player.changeBet(amt);
    }

    public void resolveHand() throws NoSuchFieldException, IllegalAccessException {

            if (!player.isStaying() && !player.isBusted()) {
                player.drawCard(verifyDraw(deck.drawCard()));
            }
            if(player.isStaying() && !dealer.isStaying() && !player.isBusted() && !dealer.isBusted() && dealer.getHandValue() < player.getHandValue()){
                dealer.drawCard(verifyDraw(deck.drawCard()));
            }
            if(player.isStaying() && !dealer.isBusted() && dealer.getHandValue() < player.getHandValue()){
                dealer.drawCard(verifyDraw(deck.drawCard()));
            }

    }


    public Dealer getDealer() {
        return dealer;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean playerScoresHigher() {
        return player.getHandValue() > dealer.getHandValue() && !player.isBusted();
    }

    public boolean isDraw() {
        return player.getHandValue() == dealer.getHandValue();
    }

    public int getPlayerPool() {
        return player.getCashPool();
    }

    public int getPlayerHandsWon() {
        return player.getHandsWon();
    }

    public void resetGame() throws NoSuchFieldException, IllegalAccessException {
        dealer.discardDealerHand();
        player.discardPlayerHand();
        openingHand();
    }

    public Hand getPlayerHand() {
        return player.getHand();
    }

    public Hand getDealerHand() {
        return dealer.getHand();
    }

    public boolean deckNeedsShuffled() throws NoSuchFieldException, IllegalAccessException {
        boolean r = deck.needsShuffled();
        if (deck.needsShuffled()) {
            deck.setDeck();
        }
        return r;
    }



    private Card verifyDraw(Card c) throws NoSuchFieldException, IllegalAccessException {
        if(c == null){
            deck.setDeck();
            c = deck.drawCard();
        }
        return c;
    }





}
