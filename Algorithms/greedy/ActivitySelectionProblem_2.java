/*The program is for Activity Selection problem.
 * Here the input data is not sorted on finish time.
 * We sort the data according to finish time first using custom comparator.
 * Then follow the greedy approach to select the activities.
 * We have printed activities here as part of this program.
 * We can also print the indexes. Simply put i and j to print the indexes.
 * TC - O(n)
 * SC - O(1)
 */

package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

class Activity{
	
	int start;
	int finish;
	
	Activity(int start, int finish){
		this.start = start;
		this.finish = finish;
	}
	
	public static Comparator<Activity> activityComparator = new Comparator<Activity>() {
		
		@Override
		public int compare(Activity one, Activity two) {
			return one.finish - two.finish;
		}
		
	};
}

public class ActivitySelectionProblem_2 {

	public static void main(String[] args) {
		
		Activity arr[] = new Activity[6];
		
		arr[0] = new Activity(5,9);
	    arr[1] = new Activity(1,2);
	    arr[2] = new Activity(3,4);
	    arr[3] = new Activity(0,6);
	    arr[4] = new Activity(5,7);
	    arr[5] = new Activity(8,9);
	    
	    System.out.println("Before Sorting");
	    Stream.of(arr)
	    .forEach(e -> {
	    	System.out.print(e.start+" "+ e.finish+"    ");
	    });
	    
	    System.out.println();
	    
	    Arrays.sort(arr,Activity.activityComparator);
	    System.out.println("After Sorting");
	    
	   Stream.of(arr)
	    .forEach(e -> {
	    	System.out.print(e.start+" "+ e.finish+"    ");
	    });
	   
	   System.out.println();
	   printActivities(arr);
		
	}

	public  static void printActivities(Activity[] arr) {
		
		if(arr == null) {
			System.out.println("Enpty data");
			return;
		}
		int n = arr.length;
		int i=0;
		int j=0;
		
		System.out.print("Selected activities are - (" + arr[i].start +","+arr[i].finish+")");//Selected the first activity
		for (j=1;j<n;j++) {
			if(arr[j].start >= arr[i].finish) {
				System.out.print(", (" + arr[j].start +","+arr[j].finish+")");
				i=j;
			}
		}
	}

}
