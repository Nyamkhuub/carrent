package mn.pcode.crm.ui.widget;


import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import mn.pcode.crm.ui.model.Car;
enum TRANS {
    M("Manual"),
    A("Automatic");
    public final String label;
    TRANS(String transmission) {
        this.label = transmission;
    }
}
public class CarUI extends VerticalLayout {
    private final Car carInfo;
    private Image carThumb;
    private H3 carTitle;
    private Text transmission, carYear, doors, seat, luggage, range, fuel;

    /**
     * Primary constructor function.
     * @param car Car information.
     */
    public CarUI(final Car car) {
       this.carInfo = car;
       initUI();
    }

    private void initUI() {
        this.carThumb = new Image(this.carInfo.getImage(), this.carInfo.getCarName());
        this.carTitle = new H3(this.carInfo.getCarName());
        String carTrans = this.carInfo.getTransmission() == 'A' ? TRANS.A.label : TRANS.M.label;
        this.transmission = new Text(carTrans);
        this.carYear = new Text(String.valueOf(this.carInfo.getCarYear()));
        this.doors = new Text(String.valueOf(this.carInfo.getDoors()));
        this.seat = new Text(String.valueOf(this.carInfo.getSeat()));
        this.luggage = new Text(String.valueOf(this.carInfo.getLuggage()));
        this.range = new Text(String.valueOf(this.carInfo.getCarRange()));
        this.fuel = new Text(String.valueOf(this.carInfo.getCapFuel()));
        HorizontalLayout carDetails = new HorizontalLayout();
        carDetails.add(new Icon(VaadinIcon.CAR), this.transmission);
        add(this.carThumb, carDetails);
    }
}
