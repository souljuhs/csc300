import java.util.*;

public class TestPrintQueueSimulation
{
    public static void main(String[] args) throws Exception
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the number of printers for the simulation: ");
        int printers = keyboard.nextInt();

        System.out.print("Please enter the number of printer jobs for the simulation: ");
        int jobs = keyboard.nextInt();

        System.out.print("Please enter a random number seed for the simulation: ");
        int seed = keyboard.nextInt();

        PrintQueueSimulation sim = new PrintQueueSimulation(jobs, printers, seed);
        sim.simulate();
        sim.displayStatistics();
        
        keyboard.close();
    }
}