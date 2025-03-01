public class VacationTest
{
    public static void main(String[] args)
    {
        AllInclusiveVacation aiv1 = new AllInclusiveVacation("Orlando", 1000.00, "Disney", 4, 989.49);
        System.out.printf("The first all-inclusive vacation is:\n%s\n\n", aiv1);
        System.out.printf("It is %s budget by $%.2f\n\n", 
                          (aiv1.overbudget() < 0 ? "under" : "over"), 
                          Math.abs(aiv1.overbudget()));

        String[] items1 = {"hotel", "meals", "airfare", "windsurfing"};
        double[] costs1 = {750.00, 250.00, 400.00};

        PieceMealVacation pmv1 = new PieceMealVacation("Miami", 1500.00, items1, costs1);
        System.out.printf("The first piecemeal vacation is:\n%s\n", pmv1);
        System.out.printf("It is %s budget by $%.2f\n\n", 
                          (pmv1.overbudget() < 0 ? "under" : "over"), 
                          Math.abs(pmv1.overbudget()));
    }
}