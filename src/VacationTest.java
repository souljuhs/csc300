public class VacationTest
{
    public static void main(String[] args)
    {
        AllInclusiveVacation aiv1 = new AllInclusiveVacation("Orlando", 1000.00, "Disney", 4, 989.49);
        AllInclusiveVacation aiv2 = new AllInclusiveVacation("Bahamas", 2000.00, "ClubMed", 4, 2049.99);

        System.out.printf("The first all-inclusive vacation is:\n%s\n\n", aiv1);
        System.out.printf("It is %s budget by $%.2f\n\n", 
                          (aiv1.overbudget() < 0 ? "under" : "over"), 
                          Math.abs(aiv1.overbudget()));

        System.out.printf("The second all-inclusive vacation is:\n%s\n\n", aiv2);
        System.out.printf("It is %s budget by $%.2f\n\n", 
                          (aiv2.overbudget() < 0 ? "under" : "over"), 
                          Math.abs(aiv2.overbudget()));

        System.out.printf("aiv1 and aiv2 are %sequal\n\n", aiv1.equals(aiv2) ? "" : "not ");

        aiv2.setBrand(aiv1.getBrand());
        aiv2.setPrice(aiv1.getPrice());
        System.out.printf("aiv1 and aiv2 are now %sequal\n\n", aiv1.equals(aiv2) ? "" : "not ");

        String[] items1 = {"hotel", "meals", "airfare", "windsurfing"};
        double[] costs1 = {750.00, 250.00, 400.00};

        PieceMealVacation pmv1 = new PieceMealVacation("Miami", 1500.00, items1, costs1);
        System.out.printf("The first piecemeal vacation is:\n%s\n", pmv1);

        System.out.printf("It is %s budget by $%.2f\n\n", 
                          (pmv1.overbudget() < 0 ? "under" : "over"), 
                          Math.abs(pmv1.overbudget()));
    }
}