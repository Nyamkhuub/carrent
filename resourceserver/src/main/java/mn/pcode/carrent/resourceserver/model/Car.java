package mn.pcode.carrent.resourceserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private String carid;
   @Column(name = "carname", length = 100, nullable = false)
   private String carName;
   @Column(name = "transmission", nullable = false)
   private char transmission;
   @Column(nullable = false)
   private int doors;
   @Column(name = "caryear", nullable = false)
   private int carYear;
   @Column(name = "seats", nullable = false)
   private int seat;
   @Column(name = "luggages", nullable = false)
   private int luggage;
   @Column(nullable = false)
   private int price;
   @Column(nullable = false)
   private String image;
   @Column(name = "carrange", nullable = false)
   private int carRange;
   @Column(name = "capfuel", nullable = false)
   private int capFuel;

   public String getCarid() {
      return carid;
   }

   public void setCarid(String carid) {
      this.carid = carid;
   }

   public String getCarName() {
      return carName;
   }

   public void setCarName(String carName) {
      this.carName = carName;
   }

   public char getTransmission() {
      return transmission;
   }

   public void setTransmission(char transmission) {
      this.transmission = transmission;
   }

   public int getDoors() {
      return doors;
   }

   public void setDoors(int doors) {
      this.doors = doors;
   }

   public int getCarYear() {
      return carYear;
   }

   public void setCarYear(int carYear) {
      this.carYear = carYear;
   }

   public int getSeat() {
      return seat;
   }

   public void setSeat(int seat) {
      this.seat = seat;
   }

   public int getLuggage() {
      return luggage;
   }

   public void setLuggage(int luggage) {
      this.luggage = luggage;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public int getCarRange() {
      return carRange;
   }

   public void setCarRange(int carRange) {
      this.carRange = carRange;
   }

   public int getCapFuel() {
      return capFuel;
   }

   public void setCapFuel(int capFuel) {
      this.capFuel = capFuel;
   }
}
