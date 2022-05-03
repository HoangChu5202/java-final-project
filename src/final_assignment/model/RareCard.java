package src.final_assignment.model;

public class RareCard extends Card{
    private String rareCard;
    //private String[] rareCardArr = {"Rare", "SuperRare", "UltraRare"};

    public RareCard() {
        super();
        rareCard = "Unknow";
    }

    public RareCard(String cardName, Attribute attribute, int star) {
        super(cardName, attribute, star);
        setRareCard();
    }

    public String getRareCard() {
        return this.rareCard;
    }

    public void setRareCard() {
        if (super.getStar() >= 7) {
            rareCard = "Rare";
        } else if (super.getStar() >= 10) {
            rareCard = "SuperRare";
        } else if ( super.getStar() == 13) {
            rareCard = "UltraRare";
        } else if (super.getStar() < 7){
            throw new IllegalArgumentException("This card is not rare.");
        }
    }
}
