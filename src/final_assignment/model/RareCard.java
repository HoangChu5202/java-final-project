package src.final_assignment.model;

public class RareCard extends Card{
    private String rareCard;
    private String[] rareCardArr = {"Rare", "SuperRare", "UltraRare"};

    public RareCard() {
        super();
        rareCard = "Unknow";
    }

    public RareCard(String cardName, Attribute attribute, int star, String rareCard) {
        super(cardName, attribute, star);
        setRareCard(rareCard);
    }

    public String getRareCard() {
        return this.rareCard;
    }

    public void setRareCard(String rareCard) {
        validateRareCard(rareCard);
        this.rareCard = rareCard;
    }
    private void validateRareCard(String rareCard) {
        boolean result = false;
        for (String string : rareCardArr) {
            if (string.equalsIgnoreCase(rareCard)) {
                result = true;
            }
        }
        if (rareCard == null || rareCard == "") {
            throw new IllegalArgumentException("You need to enter the rare of the card.");
        }
        if (!result) {
            throw new IllegalArgumentException("Rare card is not correct please check again. \nMake sure your attribute is in this list: \nRare, SuperRare, UltraRare ");
        }
        
    }
}
