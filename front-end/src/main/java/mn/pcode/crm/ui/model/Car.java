package mn.pcode.crm.ui.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Car {
    private String carid;
    private String carName;
    private char transmission;
    private int doors;
    private int carYear;
    private int seat;
    private int luggage;
    private int price;
    private String image;
    private int carRange;
    private int capFuel;
}
