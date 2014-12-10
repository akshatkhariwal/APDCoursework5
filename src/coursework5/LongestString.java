package coursework5;

/**
 * Class which implements Joinable and
 * returns the maximum of the given integer or the length of the string.
 */
public class LongestString implements Joinable<Integer, String> {
  @Override
  public Integer join(Integer s, String t) {
    if (s.intValue() > t.length()) {
      return s;
    }
    else {
      return new Integer (t.length());
    }
  }

}
