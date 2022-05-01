package src.final_assignment.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Attribute implements Comparable<Attribute>{

    private String[] attributeArray = {"Fire", "Water", "Wind", "Earth", "Light", "Dark", "Spell", "Trap"};
    
    private String attribute;

    public Attribute() {
        attribute = "Undefined";
    }

    public Attribute(String attribute) {
        setAttribute(attribute);
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        validateAttribute(attribute);
    }

    private void validateAttribute(String attribute) {
        List<String> attributeList = new ArrayList<>(Arrays.asList(attributeArray));
        if (attribute == null || attribute == "") {
            throw new IllegalArgumentException("Attribute is requied.");
        }
        if (attributeList.contains(attribute) == false) {
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
