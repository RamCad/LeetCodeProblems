package Easy.Merge2SortedLists;

public class Merge2Lists {

  public static void main(String[] args) {
    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(2);
    list1.next.next = new ListNode(4);

    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(3);
    list2.next.next = new ListNode(4);

    System.out.println(new ListNode().val);

    merge(list1, list2);
  }

  private static void merge(ListNode list1, ListNode list2) {
    if(list1 == null && list2 == null) {
      System.out.println("Empty");
    } else if(list1 == null && list2 != null) {
      System.out.println("list2");
    } else if(list1 != null && list2 == null) {
      System.out.println("list1");
    }

    ListNode dummyHead = new ListNode();
    ListNode head = dummyHead;
    while(list1 != null && list2 != null) {
      if(list1.val <= list2.val) {
        head.next = list1;
        list1 = list1.next;
      } else {
        head.next = list2;
        list2 = list2.next;
      }
      head = head.next;
    }
    head.next = list1 != null ? list1 : list2;
    printLL(dummyHead.next);
  }

  private static void printLL(ListNode head) {
    while(head != null) {
      System.out.print(head.val + " -> ");
      head = head.next;
    }
  }

  /**
   * if(list1==null) return list2;
   *         else if(list2==null) return list1;
   *         if(list1.val<=list2.val){
   *             list1.next=mergeTwoLists(list1.next,list2);
   *             return list1;
   *         }
   *         else{
   *             list2.next=mergeTwoLists(list2.next,list1);
   *             return list2;
   *         }
   */

}
