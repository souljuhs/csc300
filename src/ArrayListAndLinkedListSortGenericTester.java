import java.util.*;

public class ArrayListAndLinkedListSortGenericTester
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter size: ");
		int size = input.nextInt();

		Random rand = new Random();
		ListSortGeneric<Integer> listSorterInt = new ListSortGeneric<>();
		ListSortGeneric<String> listSorterStr = new ListSortGeneric<>();

		// ArrayList<Integer>
		List<Integer> intArrList = new ArrayList<>();
		for (int i = 0; i < size; i++)
			intArrList.add(rand.nextInt(2000));

		long start = System.currentTimeMillis();
		listSorterInt.insertionSort(intArrList);
		long end = System.currentTimeMillis();
		System.out.println("ArrayList<Integer> sort time: " + (end - start) + " ms");
		System.out.println(intArrList);

		// ArrayList<String>
		List<String> strArrList = new ArrayList<>();
		for (int i = 0; i < size; i++)
		{
			String s = "";
			for (int j = 0; j < 3; j++)
				s += (char)('A' + rand.nextInt(26));
			strArrList.add(s);
		}

		start = System.currentTimeMillis();
		listSorterStr.insertionSort(strArrList);
		end = System.currentTimeMillis();
		System.out.println("ArrayList<String> sort time: " + (end - start) + " ms");
		System.out.println(strArrList);

		// LinkedList<Integer>
		List<Integer> intLinkList = new LinkedList<>();
		for (int i = 0; i < size; i++)
			intLinkList.add(rand.nextInt(2000));

		start = System.currentTimeMillis();
		listSorterInt.insertionSort(intLinkList);
		end = System.currentTimeMillis();
		System.out.println("LinkedList<Integer> sort time: " + (end - start) + " ms");
		System.out.println(intLinkList);

		// LinkedList<String>
		List<String> strLinkList = new LinkedList<>();
		for (int i = 0; i < size; i++)
		{
			String s = "";
			for (int j = 0; j < 3; j++)
				s += (char)('A' + rand.nextInt(26));
			strLinkList.add(s);
		}

		start = System.currentTimeMillis();
		listSorterStr.insertionSort(strLinkList);
		end = System.currentTimeMillis();
		System.out.println("LinkedList<String> sort time: " + (end - start) + " ms");
		System.out.println(strLinkList);
	}
}