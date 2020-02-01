package model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "idCar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "mark")
    private String mark;

    @Column(name = "fuel_level")
    private int fuel_level;

    @Column(name = "production_year")
    private int productionYear;

    @Column(name ="car_condition_node")
    private String carConditionNode;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "model")
    private Model model;

    @Column(name = "staus")
    private String status;

    public Car(String registrationNumber, String mark, int fuel_level, int productionYear, String carConditionNode, Model model, String status) {
        this.registrationNumber = registrationNumber;
        this.mark = mark;
        this.fuel_level = fuel_level;
        this.productionYear = productionYear;
        this.carConditionNode = carConditionNode;
        this.model = model;
        this.status = status;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getFuel_level() {
        return fuel_level;
    }

    public void setFuel_level(int fuel_level) {
        this.fuel_level = fuel_level;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getCarConditionNode() {
        return carConditionNode;
    }

    public void setCarConditionNode(String carConditionNode) {
        this.carConditionNode = carConditionNode;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model mode) {
        this.model = mode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public static final class CarBuilder {
        private Long id;
        private String registrationNumber;
        private String mark;
        private int fuel_level;
        private int productionYear;
        private String carConditionNode;
        private Model mode;
        private String status;

        private CarBuilder() {
        }

        public static CarBuilder aCar() {
            return new CarBuilder();
        }

        public CarBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CarBuilder withRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public CarBuilder withMark(String mark) {
            this.mark = mark;
            return this;
        }

        public CarBuilder withFuel_level(int fuel_level) {
            this.fuel_level = fuel_level;
            return this;
        }

        public CarBuilder withProductionYear(int productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public CarBuilder withCarConditionNode(String carConditionNode) {
            this.carConditionNode = carConditionNode;
            return this;
        }

        public CarBuilder withMode(Model mode) {
            this.mode = mode;
            return this;
        }

        public CarBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Car build() {
            Car car = new Car(registrationNumber, mark, fuel_level, productionYear, carConditionNode, mode, status);
            car.setId(id);
            return car;
        }
    }
}
