class Result {

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int equalizeArray(List<Integer> arr) {
    // Write your code here
    ArrayList<List<Integer>> groupedList= new ArrayList<List<Integer>>();
      int max=0;   
      for(int i=0;i<arr.size();i++){
           ArrayList<Integer> subGroup= new ArrayList<Integer>();
          for(int j=i;j<arr.size();j++){
             
              if(arr.get(i)==arr.get(j)){
                subGroup.add(arr.get(i));
                
              }
          }
          groupedList.add(subGroup);
          max= groupedList.get(i).size()>max?groupedList.get(i).size():max; 
      } 
        return arr.size()-max;
    }

}
