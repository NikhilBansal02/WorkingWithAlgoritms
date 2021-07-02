/*
 * The following implementation assumes that the activities
 * are already sorted according to their finish time.
 * TC - O(N)
 * SC - O(1)
 */
package greedy;

public class ActivitySelectionProblem {

	public static void main(String[] args) {

		int s[] =  {1, 3, 0, 5, 8, 5};
		int f[] =  {2, 4, 6, 7, 9, 9};

		getActivities(s,f);
	}

	/**
	 * @param s , array with start time of activities.
	 * @param f , array with end time of activities.
	 * @implNote, As activities are already sorted according to finish time in ascending order,
	 * We start by selecting first activity as it takes the minimum time to complete the task.
	 * As the motive is to cover the maximum activities, we only looks for activities which took less time to complete.
	 * This is the reason activities are sorted on finish time.
	 * Next, select the activity which has start time greater than or equal to finish time to previously selected activity.
	 * Follow the same process on all the activities.
	 */
	public static void getActivities(int[] s, int[] f) {

		if(s.length!= f.length) {
			System.out.println("Incorrect Activities Data");
			return;
		}
		int n = s.length;
		int i = 0;
		int j = 0;

		System.out.print("Selected activities are - " + i);//First activity is always selected.

		for(j=1; j<n; j++) {

			if(s[j] >= f[i] ) {
				System.out.print(" " +j);
				i=j;
			}

		}
	}
}
