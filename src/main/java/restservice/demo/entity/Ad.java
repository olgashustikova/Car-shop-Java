package restservice.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private Number year;
    private Number price;
    private String description;
    private String transmission;
    private Number kilometres;
    private String bodyType;
    private String sellerType;


    public Ad() {
    }

    public Ad(String make, String model, Number year, Number price, String description, String transmission, Number kilometres, String bodyType, String sellerType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.description = description;
        this.transmission = transmission;
        this.kilometres = kilometres;
        this.bodyType = bodyType;
        this.sellerType = sellerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {this.make = make;}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {this.model = model;}
    public Number getYear() {
        return year;
    }

    public void setYear(Number year) {this.year = year;}
    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {this.price = price;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getTransmission() {return transmission;}
    public void setTransmission(String transmission) {this.transmission = transmission;}
    public Number getKilometres() {
        return kilometres;
    }
    public void setKilometres(Number kilometres) {this.kilometres = kilometres;}
    public void setBodyType(String bodyType) {this.bodyType = bodyType;}
    public String getBodyType() {return bodyType;}
    public void setSellerType(String sellerType) {this.sellerType = sellerType;}
    public String getSellerType() {return sellerType;}

    @Override
    public String toString() {
        return "restservice.demo.dto.Ad{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", transmission='" + transmission + '\'' +
                ", kilometres='" + kilometres + '\'' +
                ", body type='" + bodyType + '\'' +
                ", seller type='" + sellerType + '\'' +
                '}';
    }
}






