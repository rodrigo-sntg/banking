package question1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Solution {
    public static void main(String[] args) throws IOException {

        List<BinRange> binRanges = new ArrayList<>();

//        String cardNumber = "4111111111111111";
        String cardNumber = "5111111111111111";

        String start = "400000000000";
        String end = "499999999999";
        String cardType = "visa";
        binRanges.add(new BinRange(start, end, cardType));
        
        String start2 = "500000000000";
        String end2 = "599999999999";
        String cardType2 = "mc";
        binRanges.add(new BinRange(start2, end2, cardType2));
        
        CardTypeCache cache = buildCache(binRanges);
        CardTypeCache cache2 = buildCache2(binRanges);
        CardTypeCache cache3 = buildCache3(binRanges);
        if (cache != null) {
        	Long init = System.nanoTime();
            String valueOf = String.valueOf(cache.get(cardNumber));
            Long finish = System.nanoTime();
            System.out.println(valueOf);
			System.out.println("time - " + (finish - init));                
        }
        if (cache2 != null) {
        	Long init = System.nanoTime();

            String valueOf = String.valueOf(cache2.get(cardNumber));
            Long finish = System.nanoTime();
            System.out.println(valueOf);
            
			System.out.println("time2 - " + (finish - init));
        }
        
        if (cache2 != null) {
        	Long init = System.nanoTime();

            String valueOf = String.valueOf(cache3.get(cardNumber));
            Long finish = System.nanoTime();
            
            System.out.println(valueOf);
			System.out.println("time3 - " + (finish - init));
        }
        
        
    }
    public static CardTypeCache buildCache(List<BinRange> binRanges) {
        // TODO return a new instance of CardTypeCache
        CardTypeCache cache = new CardTypeCacheImpl(binRanges);
        
        return cache;
    }
    
    public static CardTypeCache buildCache2(List<BinRange> binRanges) {
        // TODO return a new instance of CardTypeCache
        CardTypeCache cache = new CardTypeCacheImpl2(binRanges);
        
        return cache;
    }
    
    public static CardTypeCache buildCache3(List<BinRange> binRanges) {
        // TODO return a new instance of CardTypeCache
        CardTypeCache cache = new CardTypeCacheImpl3(binRanges);
        
        return cache;
    }
}