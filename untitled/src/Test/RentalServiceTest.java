package Test;

import Domain.RentalValidator;
import Domain.IValidator;
import Repository.InMemoryRepository;
import Service.RentalService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalServiceTest {
    private RentalValidator validator = new RentalValidator();
    private InMemoryRepository repository = new InMemoryRepository((IValidator) validator);
    private RentalService service = new RentalService(repository);

    @Test
    void testsIfInputIsCorrect() {
        service.upsert("1","scoala","11.11.2018","60");
        assertEquals(32, service.getAll().get(0).getDistance());


        try {
            service.upsert("1","scoala","11.11.2018","60");
        } catch (RuntimeException rex) { assertTrue(true); }
    }
}