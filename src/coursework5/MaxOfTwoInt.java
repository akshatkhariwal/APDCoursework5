package coursework5;

/**
 * Class which implements Joinable and return maximum of two integers.
 */
public class MaxOfTwoInt implements Joinable<Integer, Integer> {
  @Override
  public Integer join(Integer s, Integer t) {
    if (s.intValue() > t.intValue()) {
      return s;
    }
    else {
      return t;
    }
  }

}
