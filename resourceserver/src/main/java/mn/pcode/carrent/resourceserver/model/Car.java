package mn.pcode.carrent.resourceserver.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cars")
@Getter @Setter
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
}
