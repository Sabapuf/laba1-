package org.example;

import java.util.List;

public class NumberStatistics {
    private final PrimeService primeService;

    public NumberStatistics(PrimeService primeService) {
        this.primeService = primeService;
    }

    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public double average(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        return (double) sum(numbers) / numbers.size();
    }

    public int max(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElseThrow();
    }

    public int min(List<Integer> numbers) {
        return numbers.stream().min(Integer::compare).orElseThrow();
    }

    public boolean isPrimeNumber(int number) {
        return primeService.isPrime(number);
    }
}