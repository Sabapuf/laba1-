package org.example;

import java.util.List;

public class StatisticsService {
    private final NumberStatistics numberStatistics;

    public StatisticsService(NumberStatistics numberStatistics) {
        this.numberStatistics = numberStatistics;
    }

    public String generateReport(List<Integer> numbers) {
        StringBuilder report = new StringBuilder();
        report.append("Sum: ").append(numberStatistics.sum(numbers)).append("\n");
        report.append("Average: ").append(numberStatistics.average(numbers)).append("\n");
        report.append("Max: ").append(numberStatistics.max(numbers)).append("\n");
        report.append("Min: ").append(numberStatistics.min(numbers)).append("\n");

        report.append("Prime numbers: ");
        numbers.stream()
                .filter(numberStatistics::isPrimeNumber)
                .forEach(num -> report.append(num).append(" "));

        return report.toString();
    }
}