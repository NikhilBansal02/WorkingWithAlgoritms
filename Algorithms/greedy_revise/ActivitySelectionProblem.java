/* Revision
 * Data is not sorted.
 * We will sort data first.
 * Then select the activities.
 */
package greedy_revise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

class Activity{
	
	int start;
	int finish;
	
	public Activity(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}
	
	public static Comparator<Activity> activityComparator = new Comparator<Activity>() {
			
			public int compare(Activity a, Activity b) {
				return a.finish - b.finish;
			}
	};
}

public class ActivitySelectionProblem {
	
	public static void main(String[] args) {
		
		Activity[] arr = new Activity[6];
		
		arr[0] = new Activity(5,9);
	    arr[1] = new Activity(1,2);
	    arr[2] = new Activity(3,4);
	    arr[3] = new Activity(0,6);
	    arr[4] = new Activity(5,7);
	    arr[5] = new Activity(8,9);	
	    
	    System.out.println("Before Sorting");
	    Stream.of(arr)
	    .forEach(e ->{
	    	System.out.print(e.start +" "+e.finish);
	    	System.out.println();
	    });
	    
	    Arrays.sort(arr,Activity.activityComparator);
	    
	    System.out.println("After Sorting");
	    Stream.of(arr)
	    .forEach(e ->{
	    	System.out.print(e.start +" "+e.finish);
	    	System.out.println();
	    });
	    printActivities(arr);
	}

	public static void printActivities(Activity[] arr) {
		
		if(arr == null) {
			System.out.println("No data. All null");
			return;
		}
		
		if(arr.length == 0) {
			System.out.println("No data.");
			return;
		}
		
		int size = arr.length;
		int i =0;
		int j =0;
		
		System.out.print("Activities selected are - " +i);
		for(j=1; j<size;j++) {
			if(arr[j].start >= arr[i].finish) {
				System.out.print("," +j);
				i=j;
			}
		}
	}
}
