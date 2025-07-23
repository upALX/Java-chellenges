package com.challenges.elevator;

import java.util.List;

public interface IElevatorService {
    List<Integer> leastUsedFloors();
    List<Character> mostUsedElevators();
    List<Character> leastUsedElevators();
    List<Character> busiestShiftsForMostUsedElevators();
    List<Character> quietestShiftsForLeastUsedElevators();
    List<Character> busiestShiftsOverall();
    float usagePercentage(char elevator);
}
