package enumerable;

import java.util.*;

public class Card {

	public enum Face { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

	public enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }

	private final Face face;
	private final Suit suit; 
	private static final List<Card> theDeck = new ArrayList<Card>();

	private Card(Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}

	private static List<Card> initializeDeck (){
		for (Suit suit : Suit.values())
			for (Face face : Face.values())
				theDeck.add(new Card(face, suit));
		return theDeck;
	}  

	public Face getFace() { 
		return face; 
	}

	public Suit getSuit() { 
		return suit; 
	}

	public String toString() { 
		return face + " of " + suit; 
	}

	public static void main(String [] args){
		List<Card> aDeck = Card.initializeDeck();
		System.out.println(aDeck);
	}
}