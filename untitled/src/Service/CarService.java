package Service;

import Domain.Car;
import Repository.IRepository;

import java.util.List;

public class CarService {

    private IRepository<Car> carRepository;

    public CarService(IRepository<Car> carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * insert a car
     * @param id
     * @param model
     * @param distance
     * @param price
     */
    public void upsert(String id, String model, String distance, String price) {
        Car car = new Car(id, model, distance, price);
        carRepository.upsert(car);
    }

    /**
     * @return an List with all invoices
     */
    public List<Car> getAll() {
        return carRepository.getAll();
    }

}