package Domain;

public class Rental extends Entity {
    private String id;
    private String carid;
    private String day;
    private String distance;

    public Rental(String id, String carid, String day, String distance) {
        super(id);
        this.id = id;
        this.carid = carid;
        this.day = day;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id='" + id + '\'' +
                ", carid='" + carid + '\'' +
                ", day='" + day + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}