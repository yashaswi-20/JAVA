class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Main {

    // 🔴 YOUR ORIGINAL FUNCTION (unchanged)
    static Node swap(Node head, int left, int right) {
        Node temp=head;
        int check=0;
        while(temp!=null){
            check++;
            temp=temp.next;
        }
        if(left<0 || right>=check || left>right ){
            return null;
        }
        if(left==right)return head;

        Node temp1 = head;
        int a = 0;
        if(a==left || a==left+1){
            
        }
        while (a<left-1) {
            temp1 = temp1.next;
            //System.out.println("Asd");
            a++;
        }
        Node temp2 = temp1.next;

        a = 0;
        Node temp3 = head;
        while (a < right - 1) {
            temp3 = temp3.next;
            a++;
        }
        Node temp4 = temp3.next;
        System.out.println(temp1.data+" "+temp2.data+" "+temp3.data+" "+temp4.data);

        if (left == 0) {
            temp3.next = temp1;
            Node temp5=temp4.next;
            temp4.next = temp1.next;
            temp1.next = temp5;
            return temp4;
        } else {
            if(temp2==temp3){
                Node temp5 = temp4.next;   // save 4

                temp1.next = temp4;        // 1 -> 3
                temp4.next = temp2;        // 3 -> 2   ✅ THIS was missing
                temp2.next = temp5;        // 2 -> 4

                return head;
            }else{

            temp1.next = temp4;
            Node temp5 = temp4.next;
            temp4.next = temp2.next;
            temp3.next = temp2;
            temp2.next = temp5;
            return temp1;
            }
        }
    }

    // 🔧 Build list
    static Node createList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // 🚨 SAFE traversal (detect cycle / infinite loop)
    static int[] toArraySafe(Node head, int limit) {
        int[] result = new int[limit];
        int i = 0;

        Node slow = head, fast = head;

        while (head != null && i < limit) {
            result[i++] = head.data;
            head = head.next;

            // cycle detection (Floyd)
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    throw new RuntimeException("Cycle detected (infinite loop)");
                }
            }
        }

        if (head != null) {
            throw new RuntimeException("Traversal limit exceeded (possible infinite loop)");
        }

        int[] trimmed = new int[i];
        for (int j = 0; j < i; j++) trimmed[j] = result[j];
        return trimmed;
    }

    // 🔍 Compare arrays
    static boolean isEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    // 🧪 Test runner
    static void runTest(int id, int[] input, int left, int right, int[] expected) {
        try {
            Node head = createList(input);

            Node result = swap(head, left, right);

            int[] output = toArraySafe(result, 100); // limit prevents infinite loop

            if (isEqual(output, expected)) {
                System.out.println("Test " + id + ": PASS");
            } else {
                System.out.println("Test " + id + ": FAIL");
                printArray("Expected", expected);
                printArray("Got     ", output);
            }

        } catch (Exception e) {
            System.out.println("Test " + id + ": CRASH");
            System.out.println("Reason: " + e.getMessage());
        }
    }

    static void printArray(String label, int[] arr) {
        System.out.print(label + ": ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        // 🧪 JUDGE TEST SUITE
          // 🧪 ORIGINAL TESTS
        runTest(1, new int[]{1,2,3,4,5}, 1, 3, new int[]{1,4,3,2,5});
        runTest(2, new int[]{1,2,3,4,5}, 0, 4, new int[]{5,2,3,4,1});
        runTest(3, new int[]{1,2,3,4}, 1, 2, new int[]{1,3,2,4});
        runTest(4, new int[]{1,2,3}, 2, 2, new int[]{1,2,3});
        runTest(5, new int[]{1,2}, 0, 1, new int[]{2,1});
        runTest(6, new int[]{1}, 0, 0, new int[]{1});

        // 🔥 EDGE CASES
        runTest(7, new int[]{1,2,3}, -1, 2, new int[]{});
        runTest(8, new int[]{1,2,3}, 0, 10, new int[]{});
        runTest(9, new int[]{1,2,3}, 0, 3, new int[]{});
        runTest(10, new int[]{1,2,3,4}, 3, 1, new int[]{});
        runTest(11, new int[]{}, 0, 0, new int[]{});
        runTest(12, new int[]{1}, 0, 1, new int[]{});

        // ⚡ STRESS CASES
        runTest(13, new int[]{1,2,3,4,5,6,7}, 1, 5, new int[]{1,6,3,4,5,2,7});
        runTest(14, new int[]{1,2,3}, 0, 1, new int[]{2,1,3});
        runTest(15, new int[]{1,2,3,4,5}, 3, 4, new int[]{1,2,3,5,4});
        runTest(16, new int[]{1,2,2,3}, 1, 2, new int[]{1,2,2,3});
        runTest(17, new int[]{1,2,3}, 0, 2, new int[]{3,2,1});
        runTest(18, new int[]{1,2,3,4,5}, 0, 3, new int[]{4,2,3,1,5});
    }
}
