package com.example.blackjack;



public class Card {
  private final int cardFaceId;
  private final Deck.Suit suit;
  private final Deck.Rank rank;

public Card(Deck.Suit suit, Deck.Rank rank,int cardFace){
    this.suit = suit;
    this.rank = rank;
    this.cardFaceId = cardFace;
}

public Deck.Rank getRank(){
    return rank;
}

public Deck.Suit getSuit(){
    return suit;
}

public int getCardValue(){
    if(rank == Deck.Rank.JACK ||rank == Deck.Rank.KING || rank == Deck.Rank.QUEEN || rank == Deck.Rank.ACE){
        return 10;
    }
    return rank.ordinal() + 2;
}

public int getCardFace(){
    return cardFaceId;
}

@Override
    public boolean equals(Object that){
    return (that != null && that instanceof Card && ((Card)that).rank == this.rank && ((Card)that).suit == this.suit);
}

}
