package src.final_assignment.model;


import java.util.Scanner;

import src.final_assignment.model.Card;
import src.final_assignment.utililties.InputUtility;
import src.final_assignment.utililties.UIUtility;

public class CardHolder {
    
    private Card[] cards;
    private static int cardCount = 0;

    public CardHolder() {
        cards = new Card[10];
        cards[cardCount++] = new Card("Blue-eyes White Dragon", new Attribute("Light"), 8);
        cards[cardCount++] = new Card("Black Magician", new Attribute("Dark"), 7);
    }

    public boolean isFull() {
        boolean result = false;
        if (cardCount == cards.length) {
            result = true;
        }
        return result;
    }

    public void addCard(Scanner in) {
        
    }

    public void showAllCards() {
        
    }
}
