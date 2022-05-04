package src.final_assignment.model;


import java.util.Scanner;

import src.final_assignment.utililties.InputUtility;
import src.final_assignment.utililties.UIUtility;

public class CardHolder {
    
    private Card[] cards;
    private static int cardCount = 0;

    public CardHolder() {
        cards = new Card[18];
        cards[cardCount++] = new Card("Utopia", new Attribute("Light"), 4);
        cards[cardCount++] = new Card("Red-eyes Black Dragon", new Attribute("Dark"), 7);
        cards[cardCount++] = new Card("Summon Skull", new Attribute("Dark"), 6);
        cards[cardCount++] = new RareCard("Blue-eyes White Dragon", new Attribute("Light"), 8, "Rare");
        cards[cardCount++] = new RareCard("Black Magician", new Attribute("Dark"), 7, "SuperRare");
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
                    System.out.println(e.getMessage());
                } 
            }
            //Set rare card
            if (cardType.equalsIgnoreCase("Rare")) {
                while (true) {
                    String cardRare = InputUtility.validateUserString("How rare is this card?", in, "Rare", "SupperRare", "UltraRare");
                    try {
                        ((RareCard)card).setRareCard(cardRare);
                        break;
                    } catch (Exception e) {
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
        if (choice > menuOptions.length || choice < 1) {
            System.out.println("Exiting update method");
            return;
        }
        //update new name
        Card card = cards[choice -1];
        while (true) {
            String  cardName = InputUtility.getString("New name? [Press Enter to keep \"" + card.getCardName() + "\"]", in);   
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
        //update attribute
        while (true) {
            String strAttribute = InputUtility.getString("What is the new attribute? [Press Enter to keep \"" + card.getAttribute() + "\"]", in);
            Attribute attribute;
            if (strAttribute == "") {
                attribute = card.getAttribute();
            } else {
                attribute = new Attribute(strAttribute);
            }
            try {
                card.setAttribute(attribute);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        //Update Star
        while (true) {
            int star = InputUtility.getIntInRange("New star [Press 0 to keep " + card.getStar()+ "star]", 0, 13, in);
            if (star == 0) {
                star = card.getStar();
            }
            try {
                card.setStar(star);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (card instanceof RareCard) {
            String cardRare = InputUtility.validateUserString("How rare is this card?", in, "Rare", "SupperRare", "UltraRare");
            while (true) {
                try {
                    ((RareCard)card).setRareCard(cardRare);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        cards[choice - 1] = card;
        UIUtility.showMenuTitle("Card successfully updated");
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
        choice--;
        Card card = cards[choice];
        int moveToIndex = InputUtility.getIntInRange("Where would you like to move this card", 1, cardCount, in);
        moveToIndex--;
        Card[] newCards = new Card[cardCount];
        for (int i = 0; i < cardCount; i++) {
            newCards[i] = new Card();
        }
   
        if (choice == moveToIndex) {
            System.out.println("Nothing change. Exitting update method");
            return;
        } else if (choice < moveToIndex) {
            
            //Shift to the left all the card between them.
            int count = moveToIndex - 1;
            for (int i = moveToIndex; i > choice; i--) {
                if (cards[i] instanceof RareCard) {
                    newCards[count] = new RareCard(cards[i].getCardName(), cards[i].getAttribute(), cards[i].getStar(), (((RareCard)cards[i]).getRareCard()) );

                } else {
                    newCards[count].setCardName(cards[i].getCardName());
                    newCards[count].setAttribute(cards[i].getAttribute());
                    newCards[count].setStar(cards[i].getStar());
                }
                count--;
            }
            //This loop change the card of moveToIndex to the card we choose
            if (card instanceof RareCard) {
                newCards[moveToIndex] = new RareCard(card.getCardName(), card.getAttribute(), card.getStar(), (((RareCard)card).getRareCard()) );

            } else {
                newCards[moveToIndex].setCardName(card.getCardName());
                newCards[moveToIndex].setAttribute(card.getAttribute());
                newCards[moveToIndex].setStar(card.getStar());
            }
            //Copy from the begin of the cardHolder to the card before the choice card into new array
            for (int i = 0; i < choice; i++) {
                if (cards[i] instanceof RareCard) {
                    newCards[i] = new RareCard(cards[i].getCardName(), cards[i].getAttribute(), cards[i].getStar(), (((RareCard)cards[i]).getRareCard()) );
                } else {
                    newCards[i].setCardName(cards[i].getCardName());
                    newCards[i].setAttribute(cards[i].getAttribute());
                    newCards[i].setStar(cards[i].getStar());
                }
            }
            //This loop copy all value from the next card of the move to index card to the end into the new array
            for (int i = moveToIndex + 1; i < cardCount; i++) {
                if (cards[i] instanceof RareCard) {
                    newCards[i] = new RareCard(cards[i].getCardName(), cards[i].getAttribute(), cards[i].getStar(), (((RareCard)cards[i]).getRareCard()) );
                } else {
                    newCards[i].setCardName(cards[i].getCardName());
                    newCards[i].setAttribute(cards[i].getAttribute());
                    newCards[i].setStar(cards[i].getStar());
                }
            }
        } else if (choice > moveToIndex) {
            
            //Shift to the right all the card between them.
            int count = moveToIndex + 1;
            for (int i = moveToIndex; i < choice; i++) {
                if (cards[i] instanceof RareCard) {
                    newCards[count] = new RareCard(cards[i].getCardName(), cards[i].getAttribute(), cards[i].getStar(), (((RareCard)cards[i]).getRareCard()) );

                } else {
                    newCards[count].setCardName(cards[i].getCardName());
                    newCards[count].setAttribute(cards[i].getAttribute());
                    newCards[count].setStar(cards[i].getStar());
                }
                count++;
            }
            //This loop change the card of moveToIndex to the card we choose
            if (card instanceof RareCard) {
                newCards[moveToIndex] = new RareCard(card.getCardName(), card.getAttribute(), card.getStar(), (((RareCard)card).getRareCard()) );

            } else {
                newCards[moveToIndex].setCardName(card.getCardName());
                newCards[moveToIndex].setAttribute(card.getAttribute());
                newCards[moveToIndex].setStar(card.getStar());
            }
            //Copy from the begin of the cardHolder to the card before the choice card into new array
            for (int i = 0; i < moveToIndex; i++) {
                if (cards[i] instanceof RareCard) {
                    newCards[i] = new RareCard(cards[i].getCardName(), cards[i].getAttribute(), cards[i].getStar(), (((RareCard)cards[i]).getRareCard()) );
                } else {
                    newCards[i].setCardName(cards[i].getCardName());
                    newCards[i].setAttribute(cards[i].getAttribute());
                    newCards[i].setStar(cards[i].getStar());
                }
            }
            //This loop copy all value from the next card of the move to index card to the end into the new array
            for (int i = choice + 1; i < cardCount; i++) {
                if (cards[i] instanceof RareCard) {
                    newCards[i] = new RareCard(cards[i].getCardName(), cards[i].getAttribute(), cards[i].getStar(), (((RareCard)cards[i]).getRareCard()) );
                } else {
                    newCards[i].setCardName(cards[i].getCardName());
                    newCards[i].setAttribute(cards[i].getAttribute());
                    newCards[i].setStar(cards[i].getStar());
                }
            }
        }
        //The different between the two code is choice < moveToIndex then all card between them is shift to left 
        // choice > moveToIndex then all card between them is shift to right

        cards = newCards;
        System.out.println("Card successfully moved.");
    }

    public void swapTwoCard(Scanner in) {
        String menuTitle = "Swap two card";
        String prompt = "Select first card";
        String[] menuOptions = new String[cardCount];
        for (int i = 0; i < cardCount; i++) {
            menuOptions[i] = cards[i].toString();
        }
        int choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, in);
        if (choice > menuOptions.length + 1 || choice < 1) {
            System.out.println("Exiting swap method");
            return;
        }
        choice--;
        // Card card = cards[choice];
        int moveToIndex = InputUtility.getIntInRange("Which card you want to swap with", 1, cardCount, in);
        moveToIndex--;

        Card tempCard = new Card();

        if (cards[choice] instanceof RareCard) {
            tempCard = new RareCard(cards[choice].getCardName(), cards[choice].getAttribute(), cards[choice].getStar(), (((RareCard)cards[choice]).getRareCard()) );
        } else {
            tempCard.setCardName(cards[choice].getCardName());
            tempCard.setAttribute(cards[choice].getAttribute());
            tempCard.setStar(cards[choice].getStar());
        }

        if (cards[moveToIndex] instanceof RareCard) {
            cards[choice] = new RareCard(cards[moveToIndex].getCardName(), cards[moveToIndex].getAttribute(), cards[moveToIndex].getStar(), (((RareCard)cards[moveToIndex]).getRareCard()) );
        } else {
            cards[choice].setCardName(cards[moveToIndex].getCardName());
            cards[choice].setAttribute(cards[moveToIndex].getAttribute());
            cards[choice].setStar(cards[moveToIndex].getStar());
        }

        if (tempCard instanceof RareCard) {
            cards[moveToIndex] = new RareCard(tempCard.getCardName(), tempCard.getAttribute(), tempCard.getStar(), (((RareCard)tempCard).getRareCard()) );
        } else {
            cards[moveToIndex].setCardName(tempCard.getCardName());
            cards[moveToIndex].setAttribute(tempCard.getAttribute());
            cards[moveToIndex].setStar(tempCard.getStar());
        }
        System.out.println("Card successfully swap.");
    }

    public void deleteCard(Scanner in) {
        String menuTitle = "Remove Card";
        String prompt = "Which card you want to remove";
        String[] menuOptions = new String[cardCount];
        if (cardCount == 0) {
            System.out.println("There are no card left");
            System.out.println("Exiting remove method...");
            return;
        }
        for (int i = 0; i < cardCount; i++) {
            menuOptions[i] = cards[i].toString();
        }
        int choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, in);
        if (choice > menuOptions.length + 1 || choice < 1) {
            System.out.println("Exiting delete method");
            return;
        }
        choice--;
        Card[] newCards = new Card[cardCount];
        for (int i = 0; i < cardCount; i++) {
            newCards[i] = new Card();
        }
        cards[choice] = new Card();
        cards[choice].setCardName("remove");
        int count = 0;
        for (int i = 0; i < cardCount; i++) {
            String name = cards[i].getCardName();
            if (!name.equalsIgnoreCase("remove")) {
                newCards[count++] = cards[i];
            }
        }
        cards = newCards;
        cardCount--;
        System.out.println("Card successfully delete");
    }

    public void sortCardByName() {
        //Im using Insertion-Sort Algorithm to sort the array
        //It check if the current name came before the infront name then insert it before those name
        for (int i = 1; i < cardCount; i++) {
            int count = i - 1;
            Card tempCard = cards[i];


            while (count >= 0 && (cards[count].compareTo(tempCard) > 0)) {

                cards[count + 1] = cards[count];
                count--;
            }

            cards[count+1] = tempCard;
        }

        System.out.println("Sort Card success");
    }
}
