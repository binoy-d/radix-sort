import java.util.ArrayList;
class RadixSort {
  public static void main(String[] args) {
    System.out.println("hello world");
    int[] ar = new int[100];
    for(int i = 0;i<ar.length;i++){
      ar[i] = (int)(Math.random()*1000);
      System.out.print(ar[i]+",");
      
    }
    System.out.println();
    radixSort(ar,0,2);
    
  }
  
  public static int[] radixSort(int[] array,int digits,int maxDigits){
    int[] retarr = array;
    ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
    //setting up array with blank integers
    for(int i = 0;i<10;i++){
      buckets.add(new ArrayList<Integer>());
    }
    //aesthetics
     for(int i = 0;i<retarr.length;i++){
      System.out.println("**********************BUCKETS**********************");
      //actual calculation:
      buckets.get((int)(array[i]/(Math.pow(10,digits))%10)).add(new Integer(array[i]));
      
      printArray(buckets);
      System.out.println("***************************************************");
    }
    int pos = 0;
    for(int i = 0;i<buckets.size();i++){
      for(int j = 0;j<buckets.get(i).size();j++){
        retarr[pos] = buckets.get(i).get(j);
        pos++;
      }
    }
    System.out.print("\nNew Array: ");
    for(int i:retarr){
      System.out.print(i+",");
    }
    if(digits == maxDigits){
      return retarr;
    }
    return radixSort(retarr,digits+1,2);
  }
  
  
  public static void printArray(ArrayList<ArrayList<Integer>> array){ 
    for(ArrayList<Integer> arr:array){
      System.out.println(arr);
    }
  }
}