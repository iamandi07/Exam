package Domain;

public class Car extends Entity {
    private String id;
    private String model;
    private String distance;
    private String price;

    public Car(String id, String model, String distance, String price) {
        super(id);
        this.id = id;
        this.model = model;
        this.distance = distance;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", distance='" + distance + '\'' +
                ", Price='" + price + '\'' +
                '}';
    }
}