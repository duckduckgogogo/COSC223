import java.util.LinkedList;

public class FIFOCache implements CacheInterface{

  private int cacheSize, sequenceSize, hitrate;
  private int[] sequence;
  private LinkedList<Integer> cache = new LinkedList<Integer>();
  //private static int hitrate;

  public FIFOCache (int cacheSize, int[] sequence) {
    this.cacheSize = cacheSize;
    this.sequence = sequence;
    this.sequenceSize = sequence.length;
    this.hitrate = 0;
  }

  //Size < cacheSize --> returns false
  public boolean checkCacheFull () {
    if (cache.size() < cacheSize) return false;
    return true;
  }

  //Input already in cache --> returns true
  public boolean checkPresence (int input) {
    return cache.contains(input);
  }

  //If input not already in cache, remove first element and add input to end
  public void replace (int input, boolean keep) {
    if (checkPresence(input) && keep) {
      hitrate++;
    }
    else {
      cache.add(input);
      cache.remove();
    }
  }

  //Returns hitrate of simulation
  public double simulation () {

    //Initially fill cache
    int sIndex = 0;
    int cIndex = 0;
    while (checkCacheFull() == false && (sIndex < sequenceSize)) {
      if (checkPresence(sequence[sIndex])) {
        sIndex++;
        if (sIndex > 10000){
          hitrate++;
        }
      }
      else {
        cache.add(sequence[sIndex]);
        sIndex++;
      }
    }

    //Rest of simulation
    for (int i = sIndex; i < sequenceSize; i++) {
      boolean keep = i > 10000;
      replace (sequence[i], keep);
    }
    //System.out.println ("Hitrate: " + hitrate);
    return ((double)(hitrate))/((double)(sequenceSize));
  }


}
