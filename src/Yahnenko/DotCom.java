package Yahnenko;

import java.util.ArrayList;

/**
 * Created by dront on 11.03.17.
 */
public class DotCom {

    private ArrayList<String> locationCeels;
    private String name;

    public void setLocationCeels(ArrayList<String> locationCeels) {
        this.locationCeels = locationCeels;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCeels.indexOf(userInput);
        if (index >= 0) {
            locationCeels.remove(index);
            if (locationCeels.isEmpty()) {
                result = "Потопил";
            } else {
                result = "Попал";
            }
        }
        return result;
    }

}