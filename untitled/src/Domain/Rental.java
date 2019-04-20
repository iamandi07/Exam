package Domain;

public class Rental extends Entity {
    private String id;
    private String carid;
    private String day;
    private String distance1;

    public Rental(String id, String carid, String day, String distance1) {
        super(id);
        this.id = id;
        this.carid = carid;
        this.day = day;
        this.distance1 = distance1;
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

    public String getDistance1() {
        return distance1;
    }

    public void setDistance1(String distance) {
        this.distance1 = distance;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id='" + id + '\'' +
                ", carid='" + carid + '\'' +
                ", day='" + day + '\'' +
                ", distance='" + distance1 + '\'' +
                '}';
    }
}