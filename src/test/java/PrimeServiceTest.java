import org.example.PrimeService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeServiceTest {
    private final PrimeService primeService = new SimplePrimeService();

    @Test
    void testIsPrimeWithPrimeNumbers() {
        assertTrue(primeService.isPrime(2));
        assertTrue(primeService.isPrime(3));
        assertTrue(primeService.isPrime(5));
        assertTrue(primeService.isPrime(7));
    }

    @Test
    void testIsPrimeWithNonPrimeNumbers() {
        assertFalse(primeService.isPrime(1));
        assertFalse(primeService.isPrime(4));
        assertFalse(primeService.isPrime(6));
        assertFalse(primeService.isPrime(8));
    }

    @Test
    void testIsPrimeWithNegativeNumbers() {
        assertFalse(primeService.isPrime(-1));
        assertFalse(primeService.isPrime(-2));
    }
}

class SimplePrimeService implements PrimeService {
    @Override
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}