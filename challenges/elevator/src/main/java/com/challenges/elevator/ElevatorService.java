package com.challenges.elevator;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class ElevatorService implements IElevatorService {

    private List<ElevatorUsageRecord> records;

    public ElevatorService(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ElevatorUsageRecord[] data = mapper.readValue(new File(filePath), ElevatorUsageRecord[].class);
        this.records = Arrays.asList(data);
    }

    public ElevatorService(InputStream inputStream) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ElevatorUsageRecord[] data = mapper.readValue(inputStream, ElevatorUsageRecord[].class);
        this.records = Arrays.asList(data);
    }

    private Map<Integer, Long> countByFloor() {
        return records.stream()
                .collect(Collectors.groupingBy(record -> Integer.valueOf(record.getFloor()), Collectors.counting()));
    }
    
    private Map<Character, Long> countByElevator() {
        return records.stream()
                .collect(Collectors.groupingBy(record -> Character.valueOf(record.getElevator()), Collectors.counting()));
    }
    
    private Map<String, Long> countByShift() {
        return records.stream()
                .collect(Collectors.groupingBy(record -> record.getShift(), Collectors.counting()));
    }
    
    private Map<Character, Map<String, Long>> countElevatorByShift() {
        return records.stream()
                .collect(Collectors.groupingBy(
                        record -> Character.valueOf(record.getElevator()),
                        Collectors.groupingBy(record -> record.getShift(), Collectors.counting())
                ));
    }

    @Override
    public List<Integer> leastUsedFloors() {
        long min = countByFloor().values().stream().min(Long::compare).orElse(0L);
        return countByFloor().entrySet().stream()
                .filter(e -> e.getValue().equals(min))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<Character> mostUsedElevators() {
        long max = countByElevator().values().stream().max(Long::compare).orElse(0L);
        return countByElevator().entrySet().stream()
                .filter(e -> e.getValue().equals(max))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<Character> leastUsedElevators() {
        long min = countByElevator().values().stream().min(Long::compare).orElse(0L);
        return countByElevator().entrySet().stream()
                .filter(e -> e.getValue().equals(min))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<Character> busiestShiftsForMostUsedElevators() {
        List<Character> mostUsed = mostUsedElevators();
        Map<Character, Map<String, Long>> shiftMap = countElevatorByShift();

        Set<String> result = new HashSet<>();

        for (char elevator : mostUsed) {
            Map<String, Long> shiftCounts = shiftMap.get(elevator);
            if (shiftCounts != null) {
                long max = shiftCounts.values().stream().max(Long::compare).orElse(0L);
                shiftCounts.entrySet().stream()
                        .filter(entry -> entry.getValue().equals(max))
                        .map(Map.Entry::getKey)
                        .forEach(result::add);
            }
        }

        return result.stream().map(s -> s.charAt(0)).collect(Collectors.toList());
    }

    @Override
    public List<Character> quietestShiftsForLeastUsedElevators() {
        List<Character> leastUsed = leastUsedElevators();
        Map<Character, Map<String, Long>> shiftMap = countElevatorByShift();

        Set<String> result = new HashSet<>();

        for (char elevator : leastUsed) {
            Map<String, Long> shiftCounts = shiftMap.get(elevator);
            if (shiftCounts != null) {
                long min = shiftCounts.values().stream().min(Long::compare).orElse(Long.MAX_VALUE);
                shiftCounts.entrySet().stream()
                        .filter(entry -> entry.getValue().equals(min))
                        .map(Map.Entry::getKey)
                        .forEach(result::add);
            }
        }

        return result.stream().map(s -> s.charAt(0)).collect(Collectors.toList());
    }

    @Override
    public List<Character> busiestShiftsOverall() {
        long max = countByShift().values().stream().max(Long::compare).orElse(0L);
        return countByShift().entrySet().stream()
                .filter(e -> e.getValue().equals(max))
                .map(e -> e.getKey().charAt(0))
                .collect(Collectors.toList());
    }

    @Override
    public float usagePercentage(char elevator) {
        long total = records.size();
        long count = records.stream().filter(r -> r.getElevator() == elevator).count();
        return total > 0 ? ((float) count / total) * 100 : 0;
    }
}
