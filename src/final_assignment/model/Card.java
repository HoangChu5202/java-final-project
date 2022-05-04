package src.final_assignment.model;


public class Card implements Comparable<Card>{

    private String cardName;
    private Attribute attribute;
    private int star;

    public Card() {
        cardName = "Undefined";
        attribute = new Attribute();
        star = 0;
    }

    public Card(String cardName, Attribute attribute, int star) {
        setCardName(cardName);
        setAttribute(attribute);
        setStar(star);
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
    public int getStar() {
        return this.star;
    }

    public void setStar(int star) {
        validateLevel(star);
        this.star = star;
    }

    private void validateLevel(int star) {
        if (star < 0) {
            throw new IllegalArgumentException("Level have to be greater or equal 0.");
        }
        if (star > 13) {
            throw new IllegalArgumentException("Level have to less than 13.");
        }
        if (star == 0) {
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
        return String.format("Card Name: %s%nLevel: %d%nAttribute: %s%n", cardName, star, attribute.toString());
    }

    @Override
    public int compareTo(Card other) {
        int result = this.cardName.compareTo(other.getCardName());
        // if (result == 0) {
        //     result = this.attribute.compareTo(other.attribute);
        // }
        return result;
    }
    
}
