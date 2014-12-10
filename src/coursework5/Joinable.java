package coursework5;

/**
 * @desc Interface to declare an abstract join() method.
 */
public interface Joinable<S,T> {
  public S join (S s,T t);
}
