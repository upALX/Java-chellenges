package challenges.elevator;

public class Main {
    public static void main(String[] args) throws Exception {
        ElevatorService service = new ElevatorService("input.json"); //TODO: criar service

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
