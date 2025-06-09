
import org.example.NumberStatistics;
import org.example.PrimeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Collections;
import static org.mockito.Mockito.*;

class NumberStatisticsTest {
    private PrimeService primeService;
    private NumberStatistics numberStatistics;

    @BeforeEach
    void setUp() {
        primeService = mock(PrimeService.class);
        numberStatistics = new NumberStatistics(primeService);
    }

    @Test
    void testSum() {
        assertEquals(15, numberStatistics.sum(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void testAverage() {
        assertEquals(3.0, numberStatistics.average(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void testAverageWithEmptyList() {
        assertThrows(IllegalArgumentException.class,
                () -> numberStatistics.average(Collections.emptyList()));
    }

    @Test
    void testMax() {
        assertEquals(5, numberStatistics.max(List.of(1, 5, 3)));
    }

    @Test
    void testMin() {
        assertEquals(1, numberStatistics.min(List.of(1, 5, 3)));
    }

    @Test
    void testIsPrimeNumber() {
        when(primeService.isPrime(7)).thenReturn(true);
        when(primeService.isPrime(8)).thenReturn(false);

        assertTrue(numberStatistics.isPrimeNumber(7));
        assertFalse(numberStatistics.isPrimeNumber(8));

        verify(primeService).isPrime(7);
        verify(primeService).isPrime(8);
    }
}