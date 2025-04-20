import java.util.*;

public class AsListWithWrapperClass
{
	public static void main(String[] args)
	{
		Integer[] nums = {1, 2, 3, 4};
		System.out.println("Original Array:");
		for (int num : nums)
			System.out.print(num + " ");
		System.out.println();

		List<Integer> list = Arrays.asList(nums);
		System.out.println("List from Arrays.asList:");
		System.out.println(list);

		nums[2] = 99;
		System.out.println("Modified Array Element:");
		System.out.println(list);
	}
}