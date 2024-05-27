package Utils;

public class Numbers {
    public static int prependNumber(int origNum, int prepend){
        String numberAsString = Integer.toString(origNum);
        String prependAsString = Integer.toString(prepend);
        //if the origNum is smaller than 100 a 0 should be added after the prepend
        if(origNum < 100){
            prependAsString = prependAsString + "0";
        }
        String prepended = prependAsString + numberAsString;
        return Integer.parseInt(prepended);
    }
}
