public class Printer
{
    private Job printJob;
    private String printerName;
    private int startIdleTime;
    private int startInUseTime;
    private int totalIdleTime;
    private int totalInUseTime;
    private int totalJobsProcessed;

    public Printer() {}

    public Printer(String printerName)
    {
        setPrinterName(printerName);
    }

    public void setPrinterName(String printerName)
    {
        this.printerName = printerName;
    }

    public String getPrinterName()
    {
        return printerName;
    }

    public void setJob(Job printJob)
    {
        this.printJob = printJob;
    }

    public Job getJob()
    {
        return printJob;
    }

    public void setStartInUseTime(int time)
    {
        startInUseTime = time;
        totalJobsProcessed++;
    }

    public void setStartIdleTime(int time)
    {
        totalInUseTime += (time - startInUseTime);
    }

    public int getTotalIdleTime(int currentTime)
    {
        return currentTime - totalInUseTime;
    }

    public int getTotalInUseTime()
    {
        return totalInUseTime;
    }

    public int getTotalJobsProcessed()
    {
        return totalJobsProcessed;
    }
}