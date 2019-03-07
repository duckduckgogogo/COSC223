import java.util.LinkedList;

public class LRUCache implements CacheInterface {

  private int cacheSize, sequenceSize, hitrate;
  private int[] sequence;
  private LinkedList<Integer> cache;
  //private static int hitrate;

  public LRUCache (int cacheSize, int[] sequence) {
    this.cacheSize = cacheSize;
    this.sequence = sequence;
    this.sequenceSize = sequence.length;
    this.hitrate = 0;
    this.cache = new LinkedList<Integer>();
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

  //If input already in cache, move it to front
  //If input not already in cache, remove first element (LRU) and add input to end
  public void replace (int input) {
    if (checkPresence(input)) {
      cache.removeFirstOccurrence(input);
      cache.add(input);
      hitrate++;
    }
    else {
      cache.remove();
      cache.add(input);
    }
  }

  //Returns hitrate of simulation
  public double simulation () {

    //Initially fill cache
    int sIndex = 0;
    int cIndex = 0;
    while (checkCacheFull() == false && (sIndex < sequenceSize)) {
      if (checkPresence(sequence[sIndex])) {
        cache.removeFirstOccurrence(sequence[sIndex]);
        cache.add(sequence[sIndex]);
        sIndex++;
        hitrate++;
      }
      else {
        cache.add(sequence[sIndex]);
        sIndex++;
      }
    }

    //Rest of simulation
    for (int i = sIndex; i < sequenceSize; i++) {
      replace (sequence[i]);
    }
    //System.out.println ("Hitrate: " + hitrate);
    return ((double)(hitrate))/((double)(sequenceSize));
  }


}
