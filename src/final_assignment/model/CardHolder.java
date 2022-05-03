package src.final_assignment.model;


import java.util.Scanner;

import src.final_assignment.utililties.InputUtility;
import src.final_assignment.utililties.UIUtility;

public class CardHolder {
    
    private Card[] cards;
    private static int cardCount = 0;

    public CardHolder() {
        cards = new Card[18];
        cards[cardCount++] = new Card("N39:Utopia", new Attribute("Light"), 4);
        cards[cardCount++] = new RareCard("Blue-eyes White Dragon", new Attribute("Light"), 8);
        cards[cardCount++] = new RareCard("Black Magician", new Attribute("Dark"), 7);
    }

    public boolean isFull() {
        boolean result = false;
        if (cardCount == cards.length) {
            result = true;
        }
        return result;
    }

    public void addCard(Scanner in) {
        if (isFull()) {
            throw new IllegalArgumentException("Card holder is full, you can't add any more.");
        } else {
            Card card;
            String cardName;
            int star;
            Attribute attribute = new Attribute();
            String cardType = InputUtility.validateUserString("What type of card you want to add?", in, "Normal", "Rare");
            if (cardType.equalsIgnoreCase("Normal")) {
                card = new Card();
            } else {
                card = new RareCard();
            }
            //Set Card's name
            while (true) {
                cardName = InputUtility.getString("What is the name of the card", in);
                try {
                    card.setCardName(cardName);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            //Set card's attribute
            while (true) {
                String userAttributeSet = InputUtility.validateUserString("What attribute of the card?", in, attribute.getAttributeList());
                attribute.setAttribute(userAttributeSet); ;
                try {
                    card.setAttribute(attribute);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            //Set level
            while (true) {
                star = InputUtility.getIntInRange("What is the card's star?", 1, 13, in);
                try {
                    card.setStar(star);
                    break;
                } catch (IllegalArgumentException e) {
                    if (cardType.equalsIgnoreCase("Rare")) {
                        String choice = InputUtility.getString("This card is not rare. \nDo you want to add it to card holder as a nomarl card? \n[Yes to continues]", in);
                        choice = choice.toLowerCase();
                        if (choice.contains("y")) {
                            card = new Card(cardName, attribute, star);
                        }
                        else {
                            System.out.println("Faid to add new card. \nExiting method...");
                            return;
                        }
                    } else {
                        System.out.println(e.getMessage());
                    }
                } 
            }

            cards[cardCount++] = card;
            UIUtility.showMenuTitle("Card successfully added");
        }
    }

    public void showAllCards() {
        for (int i = 0; i < cardCount; i++) {
            System.out.println(cards[i].toString());
        }
    }

    public void updateCard(Scanner in) {
        String menuTitle = "Update a card";
        String prompt = "Select an option";
        String[] menuOptions = new String[cardCount];
        for (int i = 0; i < cardCount; i++) {
            menuOptions[i] = cards[i].toString();
        }
        int choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, in);
        if (choice > menuOptions.length + 1 || choice < 1) {
            System.out.println("Exiting update method");
            return;
        }
        //update new name
        Card card = cards[choice -1];
        while (true) {
            String  cardName = InputUtility.getString("New name? [Press Enter to keep \"" + card.getCardName() + "\"]: ", in);   
            if (cardName == "") {
                cardName = card.getCardName();
            }
            try {
                card.setCardName(cardName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        //need to update attribute and star
    }

    public void moveCard(Scanner in) {
        String menuTitle = "Update a card";
        String prompt = "Select an option";
        String[] menuOptions = new String[cardCount];
        for (int i = 0; i < cardCount; i++) {
            menuOptions[i] = cards[i].toString();
        }
        int choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, in);
        if (choice > menuOptions.length + 1 || choice < 1) {
            System.out.println("Exiting update method");
            return;
        }
        Card card = cards[choice - 1];
        int moveToIndex = InputUtility.getIntInRange("Where would you like to move this book", 1, cardCount, in);
        moveToIndex--;
        //Add code later
    }
}
