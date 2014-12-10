package coursework5;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class which implements Joinable and
 * returns a Sorted ArrayList after inserting the given integer
 * in a Sorted Array List. 
 */
public class InsertInOrderedList implements
    Joinable<ArrayList<Integer>, Integer> {
  @Override
  public ArrayList<Integer> join(ArrayList<Integer> s, Integer t) {
    s.add(InsertInOrderedList.getIndexForInsertion(s, t), t);
    return s;
  }
  
  /**
   * Function to get the index to insert element t in the ArrayList s
   * @param s
   * @param t
   * @return index
   */
  private static Integer getIndexForInsertion(ArrayList<Integer> s, Integer t) {
    int index = 0;
    Iterator<Integer> it = s.iterator();
    while (it.hasNext()) {
      if (it.next() < t) {
        index++;
      }
      else {
        break;
      }
    }
    return index;
  }

}
