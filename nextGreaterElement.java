import java.util.*;

public class nextGreaterElement {
    
    List<Integer> nextGreaterEle(List<Integer> arr) {
        int n = arr.size();

        Stack<Integer> myStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        // Iterate through the list in the reverse order
        for(int i = n - 1; i >= 0; i--) {
            while(!myStack.isEmpty() && myStack.peek() <= arr.get(i)) {
                myStack.pop();
            }

            result.add(myStack.isEmpty() ? -1 : myStack.peek());

            myStack.push(arr.get(i));
        }

        int m = result.size();

        // converted list<Integer> result to array
        Integer[] resultArray = result.toArray(new Integer[result.size()]);

        resultArray(m - 1) == -1
        if(result.get(m - 1) == -1) {
            result.set(m - 1, arr[0]);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(11, 13, 21, 3);
        List<Integer> arr2 = Arrays.asList(4, 5, 2, 25);
        List<Integer> arr3 = Arrays.asList(13, 7, 6, 12);

        // [13, 21, -1, -1]
        // [5, 25, 25, -1]
        //  [-1, 12, 12, -1]

        nextGreaterElement nge = new nextGreaterElement();

        // Find and print the next greater ele for each list
        System.out.println(nge.nextGreaterEle(arr));
        System.out.println(nge.nextGreaterEle(arr2));
        System.out.println(nge.nextGreaterEle(arr3));
    }
}
