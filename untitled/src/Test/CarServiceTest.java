package Test;

import Domain.CarValidator;
import Domain.IValidator;
import Repository.InMemoryRepository;
import Service.CarService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    private CarValidator validator = new CarValidator();
    private InMemoryRepository repository = new InMemoryRepository((IValidator) validator);
    private CarService service = new CarService(repository);

    @Test
    void testsIfInputIsCorrect() {
        service.upsert("1","scoala","11.11.2018","60");
        assertEquals(32, service.getAll().get(0).getDistance());


        try {
            service.upsert("1","scoala","11.11.2018","60");
        } catch (RuntimeException rex) { assertTrue(true); }
    }
}