import java.util.*;
import java.io.*;

public class PrintQueueSimulation
{
    private PriorityQueue<Job> waitQueue;
    private PriorityQueue<Job> finishedQueue;
    private int totalWaitTime;
    private int currentTime;
    private Printer[] printer;
    private Random randy;
    private int numberOfPrinters;
    private int numberOfPrintJobs;

    public PrintQueueSimulation(int numberOfJobs, int numberOfPrinters, int seed)
    {
        this.numberOfPrinters = numberOfPrinters;
        this.numberOfPrintJobs = numberOfJobs;
        this.randy = new Random(seed);

        waitQueue = new PriorityQueue<>();
        finishedQueue = new PriorityQueue<>();
        printer = new Printer[numberOfPrinters];

        for (int i = 0; i < numberOfPrinters; i++)
        {
            printer[i] = new Printer("Printer" + i);
        }
    }

    public void simulate()
    {
        int jobCounter = 0;
        boolean done = false;

        while (!done)
        {
            if (currentTime % 80 == 0 && jobCounter < numberOfPrintJobs)
            {
                int jobTime = randy.nextInt(1091) + 10;
                int jobPriority = randy.nextInt(11) + 1;
                Job newJob = new Job(currentTime, jobTime, jobPriority);
                waitQueue.add(newJob);
                jobCounter++;
            }

            for (Printer p : printer)
            {
                if (p.getJob() != null)
                {
                    Job job = p.getJob();
                    if (job.getStartTime() + job.getTimeForJob() <= currentTime)
                    {
                        job.setEndTime(currentTime);
                        finishedQueue.add(job);
                        p.setJob(null);
                        p.setStartIdleTime(currentTime);
                    }
                }
            }

            for (Printer p : printer)
            {
                if (p.getJob() == null && !waitQueue.isEmpty())
                {
                    Job job = waitQueue.remove();
                    job.setStartTime(currentTime);
                    p.setJob(job);
                    p.setStartInUseTime(currentTime);
                    totalWaitTime += job.getWaitTime();
                }
            }

            currentTime++;

            done = (jobCounter == numberOfPrintJobs && waitQueue.isEmpty());

            for (Printer p : printer)
            {
                if (p.getJob() != null)
                {
                    done = false;
                }
            }
        }
    }

    public void displayStatistics() throws Exception
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the output file name: ");
        String outFileName = keyboard.nextLine();

        PrintWriter writer = new PrintWriter(new File(outFileName));

        writer.println("Simulation Results");
        writer.println("Simulation with " + numberOfPrinters + " printers lasted " + currentTime + " seconds and processed " + numberOfPrintJobs + " jobs");
        writer.println("The average time in the wait queue for a job is " + (totalWaitTime * 1.0 / numberOfPrintJobs) + " seconds\n");

        writer.println("Printer Statistics");
        writer.printf("%10s %10s %10s %10s\n", "Name", "Jobs", "In Use", "Idle");

        for (Printer p : printer)
        {
            writer.printf("%10s %10d %10d %10d\n",
                p.getPrinterName(),
                p.getTotalJobsProcessed(),
                p.getTotalInUseTime(),
                p.getTotalIdleTime(currentTime)
            );
        }

        writer.println("\nJob Statistics");
        writer.printf("%5s %10s %10s %15s\n", "Job No.", "Priority", "Wait Time", "Length Of Job");

        while (!finishedQueue.isEmpty())
        {
            Job j = finishedQueue.remove();
            writer.printf("%5d %10d %10d %15d\n",
                j.getID(),
                j.getPriority(),
                j.getWaitTime(),
                j.getTimeForJob()
            );
        }

        writer.close();
        keyboard.close(); 
    }
}