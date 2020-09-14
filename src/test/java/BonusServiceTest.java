import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        long amount = 100060; // взнос с копейками умноженный на 100 для перехода к целочисленным значениям
        boolean registered = true;
        long expected = 30;               // ожидаемый размер бонуса

        long actual = service.calculate(amount, registered); // рассчитанный бонус

        assertEquals(expected, actual);                       // сравниваем ожидаемый и полученный результат

    }

    @Test
    void shouldCalculateNotRegisteredAndUnderLimit() {

        BonusService service = new BonusService();

        long amount = 100060;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateNotRegisteredAndUpLimit() {

        BonusService service = new BonusService();

        long amount = 80100100;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);

    }
    @Test
    void shouldCalculateRegisteredAndUpLimit() {

        BonusService service = new BonusService();

        long amount = 80100100;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);

    }

}