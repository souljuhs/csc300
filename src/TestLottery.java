import java.io.IOException;
import java.util.Scanner;

class TestLottery
{
    public static void main(String[] args) throws IOException
    {
        Scanner inputScanner = new Scanner(System.in);  
        StoreLottery storeLottery = new StoreLottery();
        storeLottery.addCustomers(inputScanner); 
        inputScanner.close();  
    }
}