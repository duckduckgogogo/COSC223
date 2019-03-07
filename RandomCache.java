public class RandomCache implements CacheInterface {

  private int cacheSize, sequenceSize, hitrate;
  private int[] sequence, cache;
  //private static int hitrate;

  public RandomCache (int cacheSize, int[] sequence) {
    this.cacheSize = cacheSize;
    this.cache = new int[cacheSize];
    this.sequence = sequence;
    this.sequenceSize = sequence.length;
    this.hitrate = 0;
  }

  //At least one element = 0 --> returns false
  public boolean checkCacheFull () {
    for (int i = 0; i < cacheSize; i++) {
      if (cache[i] == 0) return false;
    }
    return true;
  }

  //Input already in cache --> returns true
  public boolean checkPresence (int input) {
    for (int i = 0; i < cacheSize; i++) {
      if (input == cache[i]) return true;
    }
    return false;
  }

  public void replace (int input) {
    if (checkPresence(input)) {
      hitrate++;
    }
    else {
      cache[(int)(Math.random()*cacheSize)] = input;
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
        hitrate++;
      }
      else {
        cache[cIndex] = sequence[sIndex];
        cIndex++;
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
