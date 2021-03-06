package Service;

import Domain.Rental;
import Repository.IRepository;

import java.util.List;

public class RentalService {

    private IRepository<Rental> rentalRepository;

    public RentalService(IRepository<Rental> rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    /**
     * insert a rent
     * @param id
     * @param carid
     * @param day
     * @param distance1
     */
    public void upsert(String id, String carid, String day, String distance1) {
        Rental rental = new Rental(id, carid, day, distance1);
        rentalRepository.upsert(rental);
    }

    /**
     * @return an List with all rental
     */
    public List<Rental> getAll() {
        return rentalRepository.getAll();
    }
}