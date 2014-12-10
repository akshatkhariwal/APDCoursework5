package coursework5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Menu for user.
    String menu = "Main Menu:-\n 1. Sum of Integers\n 2. Max of Integers"
        + "\n 3. Max length of Strings\n 4. Order a list of Integers"
        + "\n 5. Exit\n Enter your choice: ";
    Scanner in = new Scanner(System.in);
    boolean check = true;
    // The answer variable to store the answer for fold operation.
    Object answer = new Object();
    while (check) {
      // print the menu.
      System.out.println(menu);
      // get input from the user.
      int choice = Integer.parseInt(in.nextLine());
      String[] elements = null;
      // get the input for ArrayList from user.
      if (choice >= 1 && choice <= 4) {
        System.out.println("Enter the elements separated by space: ");
        String input = in.nextLine();
        elements = input.split(" ");
      }
      switch(choice) {
      // Sum of elements of an Integer ArrayList
      case 1:
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < elements.length; i++) {
          list1.add(Integer.parseInt(elements[i]));
        }
        System.out.println("You Entered: " + list1);
        // Marking the first Integer as 0.
        answer = Main.fold(list1, new AddTwoInt(), new Integer(0));
        break;
      // Maximum element from an Integer ArrayList.
      case 2:
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < elements.length; i++) {
          list2.add(Integer.parseInt(elements[i]));
        }
        System.out.println("You Entered: " + list2);
        // First comparison is with minimum Integer value.
        answer = Main.fold(list2, new MaxOfTwoInt(), Integer.MIN_VALUE);
        break;
      // Maximum length of String element from a String ArrayList.
      case 3:
        ArrayList<String> list3 = new ArrayList<String>();
        for (int i = 0; i < elements.length; i++) {
          list3.add(elements[i]);
        }
        System.out.println("You Entered: " + list3);
        // First comparison is with 0.
        answer = Main.fold(list3, new LongestString(), new Integer(0));
        break;
      // Change Unordered Integer ArrayList to Ordered Integer ArrayList.
      case 4:
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        for (int i = 0; i < elements.length; i++) {
          list4.add(Integer.parseInt(elements[i]));
        }
        System.out.println("You Entered: " + list4);
        // Empty sorted ArrayList by default.
        answer = Main.fold(list4, new InsertInOrderedList(), new ArrayList<Integer>());
        break;
      default :
        check = false;
      }
      if (check) {
        System.out.println("Output after fold() is: " + answer);
      }
    }
    in.close();
  }
  
  /**
   * Function fold to call join() from implementations of Joinable
   * on a class which Implements Collection.
   * @param c
   * @param j
   * @param s
   * @return
   */
  private static <S,T> S fold(Collection<T> c, Joinable<S,T> j, S s) {
    T t = Main.popCollection(c);
    if (t != null) {
      return j.join(Main.fold(c, j, s), t);
    }
    else {
      return s;
    }
  }
  
  /**
   * Pop the first element out of the given Collection.
   * @param c
   * @return
   */
  private static <T> T popCollection(Collection<T> c) {
    Iterator<T> it = c.iterator();
    if (it.hasNext()) {
      T t = it.next();
      it.remove();
      return t;
    }
    return null;
  }

}
