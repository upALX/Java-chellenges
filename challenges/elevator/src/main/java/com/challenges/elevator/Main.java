package com.challenges.elevator;

import java.io.InputStream;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Main.class.getResourceAsStream("/input.json");
        if (inputStream == null) {
            System.err.println("Arquivo input.json não encontrado em resources!");
            return;
        }

        ElevatorService service = new ElevatorService(inputStream); 

        System.out.println("Andares menos utilizados: " + service.leastUsedFloors());
        System.out.println("Elevadores mais utilizados: " + service.mostUsedElevators());
        System.out.println("Elevadores menos utilizados: " + service.leastUsedElevators());
        System.out.println("Turnos de maior fluxo para os elevadores mais utilizados: " + service.busiestShiftsForMostUsedElevators());
        System.out.println("Turnos de menor fluxo para os elevadores menos utilizados: " + service.quietestShiftsForLeastUsedElevators());
        System.out.println("Turno de maior uso no geral: " + service.busiestShiftsOverall());

        for (char elevator : new char[]{'A', 'B', 'C', 'D', 'E'}) {
            System.out.printf("Porcentagem de uso do elevador %c: %.2f%%\n", elevator, service.usagePercentage(elevator));
        }
    }
}
