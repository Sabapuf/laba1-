import org.example.NumberStatistics;
import org.example.StatisticsService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import static org.mockito.Mockito.*;

class StatisticsServiceTest {
    @Test
    void testGenerateReport() {
        NumberStatistics numberStatistics = mock(NumberStatistics.class);
        when(numberStatistics.sum(anyList())).thenReturn(15);
        when(numberStatistics.average(anyList())).thenReturn(3.0);
        when(numberStatistics.max(anyList())).thenReturn(5);
        when(numberStatistics.min(anyList())).thenReturn(1);
        when(numberStatistics.isPrimeNumber(2)).thenReturn(true);
        when(numberStatistics.isPrimeNumber(3)).thenReturn(true);
        when(numberStatistics.isPrimeNumber(5)).thenReturn(true);

        StatisticsService service = new StatisticsService(numberStatistics);
        String report = service.generateReport(List.of(1, 2, 3, 4, 5));

        assertTrue(report.contains("Sum: 15"));
        assertTrue(report.contains("Average: 3.0"));
        assertTrue(report.contains("Max: 5"));
        assertTrue(report.contains("Min: 1"));
        assertTrue(report.contains("Prime numbers: 2 3 5"));

        verify(numberStatistics).sum(anyList());
        verify(numberStatistics).average(anyList());
        verify(numberStatistics).max(anyList());
        verify(numberStatistics).min(anyList());
        verify(numberStatistics, times(5)).isPrimeNumber(anyInt());
    }
}