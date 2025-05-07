import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yunost.BonusService;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные
        long amount = 1000;
        boolean registered = true;
        long expected = 100;

        //вызываем целевой метод
        long actual = service.calculate(amount, registered);

        //производим проверку (сравниваем ожидаемый и фактический)
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные
        long amount = 1000000;
        boolean regestered = true;
        long expected = 5000;

        //вызываем целевой метод
        long actual = service.calculate(amount, regestered);

        //производим проверку (сравниваем ожидаемый и фактический)
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNumber4999() {
        BonusService service = new BonusService();
        long amount = 49999;
        boolean registered = true;
        long expected = 4999;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNumber5000() {
        BonusService service = new BonusService();
        long amount = 50000;
        boolean registered = true;
        long expected = 5000;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCapAt5000WhenExceedingLimit() {
        BonusService service = new BonusService();
        long amount = 50001;
        boolean registered = true;
        long expected = 5000;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }
}
