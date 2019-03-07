//Key: RAM address
//Value: frequency
import java.util.HashMap;

public class LFUCache implements CacheInterface {

  private int cacheSize, sequenceSize, hitrate;
  private int[] sequence;
  private HashMap<Integer, Integer> cache;
  //private static int hitrate;

  public LFUCache (int cacheSize, int[] sequence) {
    this.cacheSize = cacheSize;
    this.sequence = sequence;
    this.sequenceSize = sequence.length;
    this.hitrate = 0;
    this.cache = new HashMap<Integer, Integer>();
  }

  //Size < cacheSize --> returns false
  public boolean checkCacheFull () {
    if (cache.size() < cacheSize) return false;
    return true;
  }

  //Input already in cache --> returns true
  public boolean checkPresence (int input) {
    return cache.containsKey(input);
  }

  //If input already in cache, increment hitrate and frequency
  //If input not already in cache, replace LFU with it
  public void replace (int input) {
    if (checkPresence(input)) {
      cache.replace(input, cache.get(input)+1);
      hitrate++;
    }
    else {
      //Find LFU
      int lowestFreqKey = 0;
      int lowestFreqVal = 0;
      for (int key : cache.keySet()) {
        if (cache.get(key) < lowestFreqVal) {
          lowestFreqVal = cache.get(key);
          lowestFreqKey = key;
        }
      }
      //Replace
      cache.remove(lowestFreqKey);
      cache.put(input, 1);
    }
  }

  //Returns hitrate of simulation
  public int simulation () {

    //Initially fill cache
    int sIndex = 0;
    int cIndex = 0;
    while (checkCacheFull() == false && (sIndex < sequenceSize)) {
      if (checkPresence(sequence[sIndex])) {
        cache.replace(sequence[sIndex], cache.get(sequence[sIndex])+1);
        sIndex++;
        hitrate++;
      }
      else {
        cache.put(sequence[sIndex], 1);
        sIndex++;
      }
    }

    //Rest of simulation
    for (int i = sIndex; i < sequenceSize; i++) {
      replace (sequence[i]);
    }
    System.out.println ("Hitrate: " + hitrate);
    return hitrate/sequenceSize;
  }


}
