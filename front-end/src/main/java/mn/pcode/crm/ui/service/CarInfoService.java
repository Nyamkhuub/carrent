package mn.pcode.crm.ui.service;

import lombok.Getter;
import mn.pcode.crm.ui.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class CarInfoService {
    private final List<Car> carInfoList;

    public CarInfoService() {
        carInfoList = new ArrayList<Car>();
        downloadCarInfo();
    }

    private void downloadCarInfo() {
        Car carInfo = new Car();
        carInfo.setImage("http://www.car4rent.lv/images/2_TY-prieksa-200x140px.jpg");
        carInfo.setCarName("Toyota Yaris");
        carInfo.setTransmission('M');
        carInfo.setCarYear(2014);
        carInfo.setDoors(5);
        carInfo.setSeat(5);
        carInfo.setLuggage(2);
        carInfo.setPrice(20);
        carInfo.setCarRange(5);
        carInfo.setCapFuel(42);
        carInfoList.add(carInfo);
    }
}
