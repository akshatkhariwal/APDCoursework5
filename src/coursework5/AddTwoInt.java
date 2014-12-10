package coursework5;

/**
 * Class which implements Joinable and adds two integers
 */
public class AddTwoInt implements Joinable<Integer, Integer> {
  @Override
  public Integer join(Integer s, Integer t) {
    return s + t;
  }

}
