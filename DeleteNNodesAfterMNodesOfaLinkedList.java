class Solution {
    static void linkdelete(Node head, int n, int m) {
        Node tmp = head;
        Node tmp1 = head;
        int skipCount = m - 1; 
        int totalTraverse = m + n; 

        while (tmp != null) {
           
            for (int i = 0; i < skipCount && tmp != null; i++) {
                tmp = tmp.next;
            }

           
            if (tmp == null) break;

          
            tmp1 = tmp.next;
            for (int i = 0; i < n && tmp1 != null; i++) {
                tmp1 = tmp1.next;
            }

           
            tmp.next = tmp1;

           
            tmp = tmp1;
        }
    }
}
