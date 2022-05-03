package src.final_assignment.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Attribute implements Comparable<Attribute>{

    private String[] attributeArray = {"fire", "water", "wind", "earth", "light", "dark"};
    
    private String attribute;

    public Attribute() {
        attribute = "Unknow";
    }

    public Attribute(String attribute) {
        setAttribute(attribute);
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String attribute) {
        validateAttribute(attribute);
        this.attribute = attribute;
    }

    public String[] getAttributeList() {
        return this.attributeArray;
    }

    private void validateAttribute(String attribute) {
        List<String> attributeList = new ArrayList<>(Arrays.asList(attributeArray));
        if (attribute == null || attribute == "") {
            throw new IllegalArgumentException("Attribute is requied.");
        }
        if (attributeList.contains(attribute.toLowerCase()) == false) {
            throw new IllegalArgumentException("Card's attribute is not correct please check again. \nMake sure your attribute is in this list: \n Fire, Water, Wind, Earth, Light, Dark, Spell, Trap");
        }
    }

    @Override
    public String toString() {
        String result = String.format("%s", attribute);
        return result;
    }
    @Override
    public int compareTo(Attribute other) {
        int result = this.compareTo(other);
        return result;
    }
}
