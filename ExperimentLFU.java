public class ExperimentLFU {

  public int length;
  public ExperimentLFU(int l){
    //length is the length of the sequence we want
    length = l;
  }

  public double runUniformForSize(int cacheSize){
    double sum = 0;
    for (int i=0;i<100;i++){
      UniformDis dis = new UniformDis(1000);
      int[] requests = dis.generateUniform(length);
      LFUCache cache = new LFUCache(cacheSize, requests);
      double hitrate = cache.simulation();
      //System.out.println(hitrate);
      sum += hitrate;
    }
    return sum/100;

  }

  public double[] runUniform(){
    double[] hitRates = new double[191];
    for(int i=10; i<201;i++){
      double avgHitRate = runUniformForSize(i);
      hitRates[i-10] = avgHitRate;
      System.out.println("done with uniform of size " + i);
    }
    return hitRates;
  }

  public double runZipfForSize(int cacheSize) {
    double sum = 0;
    for (int i=0;i<100;i++){
      ZipfD dis = new ZipfD(1000);
      int[] requests = dis.generateZipf(length);
      LFUCache cache = new LFUCache(cacheSize, requests);
      double hitrate = cache.simulation();
      sum += hitrate;
    }
    return sum/100;

  }

  public double[] runZipf(){
    double[] hitRates = new double[191];
    for(int i=10; i<201;i++){
      double avgHitRate = runZipfForSize(i);
      hitRates[i-10] = avgHitRate;
    }
    return hitRates;
  }


}
