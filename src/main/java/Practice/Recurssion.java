package Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Recurssion {

    public String getSmallestNo(String pattern){
        int counter = 0;
        int[] smallestNoArray = new int[pattern.length()+1];
        Map<Integer, Boolean> numberMap = new HashMap<>();
        for(int i = 0;i<pattern.length()+1;i++){
            smallestNoArray[i] = 0;
        }
        numberMap.putIfAbsent(1, Boolean.TRUE);
        smallestNoArray[counter] = 1;
        getSmallestNoRecur(pattern, smallestNoArray, numberMap, counter+1);
        return Arrays.toString(smallestNoArray);

    }

    private boolean checkAndUpdateArray(int potentialNo, int previousNo, int[] smallestNoArray, Map<Integer, Boolean> numberMap, int counter ){
        if(numberMap.containsKey(potentialNo) && numberMap.get(potentialNo) == Boolean.TRUE){
            return false;
        }else{
            smallestNoArray[counter] = potentialNo;
            numberMap.putIfAbsent(potentialNo, Boolean.TRUE);
            return true;
        }
    }

    private void getSmallestNoRecur(String pattern, int[] smallestNoArray, Map<Integer, Boolean> numberMap, int counter){
        int potentialNo, previousNo=0;
        if(pattern.charAt(counter-1) == 'I'){
            if(smallestNoArray[counter] != 0){
                potentialNo = smallestNoArray[counter] +1;
                previousNo = smallestNoArray[counter];
            }else{
                potentialNo = smallestNoArray[counter-1] +1;
            }

            if(checkAndUpdateArray(potentialNo, previousNo,smallestNoArray,numberMap,counter)){
                getSmallestNoRecur(pattern, smallestNoArray, numberMap, counter+1);
            }else{
                getSmallestNoRecur(pattern, smallestNoArray, numberMap, counter-1);
            }

        }else{
            if(smallestNoArray[counter] != 0){
                potentialNo = smallestNoArray[counter] -1;
                previousNo = smallestNoArray[counter];
            }else{
                potentialNo = smallestNoArray[counter-1] -1;
            }
            if(checkAndUpdateArray(potentialNo, previousNo,smallestNoArray,numberMap,counter)){
                getSmallestNoRecur(pattern, smallestNoArray, numberMap, counter+1);
            }else{
                getSmallestNoRecur(pattern, smallestNoArray, numberMap, counter-1);
            }
        }
    }



    public static void main(String[] args){
        String pattern = "IIIDIDDD";
        Recurssion r = new Recurssion();
        System.out.println(r.getSmallestNo(pattern));
    }
}
