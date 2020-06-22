package mn.pcode.crm.ui.widget;


import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import mn.pcode.crm.ui.model.Car;

public class MovieShort extends VerticalLayout {
    private final Car carInfo;
    private Image carThumb;
    private H3 carTitle;
    private Text transmission, carYear, doors, seat, luggage, range, fuel;

    /**
     * Primary constructor function.
     * @param car Car information.
     */
    public MovieShort(final Car car) {
       this.carInfo = car;
       initUI();
    }

    private void initUI() {
        this.carThumb = new Image(this.carInfo.getImage(), this.carInfo.getCarName());
        this.carTitle = new H3(this.carInfo.getCarName());
        this.transmission = new Text(String.valueOf(this.carInfo.getTransmission()));
        this.carYear = new Text(String.valueOf(this.carInfo.getCarYear()));
    }
}
