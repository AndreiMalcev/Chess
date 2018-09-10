package frontend;

import frontend.Enum.COLOR;
import frontend.Enum.FIGURE;

public class Address {
    private String address;

    public Address(COLOR color, FIGURE figure){
        address = (figure.name() + "/" + color.name() + "_" + figure.name()).toLowerCase();
    }

    public String getAddress() {
        return address;
    }
}
