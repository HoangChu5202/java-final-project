package src.final_assignment.model;

import src.final_assignment.model.Attribute;

public class Card implements Comparable<Card>{

    private String cardName;
    private Attribute attribute;
    private int level;

    public Card() {
        cardName = "Undefined";
        attribute = new Attribute();
        level = 0;
    }

    public Card(String cardName, Attribute attribute, int level) {
        setCardName(cardName);
        setAttribute(attribute);
        setLevel(level);
    }

    //Card name
    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(String cardName) {
        validateCardName(cardName);
        this.cardName = cardName;
    }

    private void validateCardName(String cardName) {
        if (cardName == null || cardName == "") {
            throw new IllegalArgumentException("Card name is requied.");
        }
    }
    //Level
    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        validateLevel(level);
        this.level = level;
    }

    private void validateLevel(int level) {
        if (level < 0) {
            throw new IllegalArgumentException("Level have to be greater or equal 0.");
        }
        if (level > 13) {
            throw new IllegalArgumentException("Level have to less than 13.");
        }
        if (level == 0) {
            if ( !(attribute.toString().equalsIgnoreCase("Spell") || attribute.toString().equalsIgnoreCase("Trap")) ) {
                throw new IllegalArgumentException("Attribute must be \"Spell\" or \"Trap\" when level is 0");
            }
        }
    }
    //Attribute
    public Attribute getAttribute() {
        return this.attribute;
    }

    public void setAttribute(Attribute attribute) {
        validateAttribute(attribute);
        this.attribute = attribute;
    }

    private void validateAttribute(Attribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("Attribute is requied.");
        }
    }

    @Override
    public String toString() {
        return String.format("Card Name: %s%Level: %d%nAttribute: %s%n", cardName, level, attribute);
    }

    @Override
    public int compareTo(Card other) {
        int result = this.cardName.compareTo(other.cardName);
        if (result == 0) {
            result = this.attribute.compareTo(other.attribute);
        }
        return result;
    }
    
}
