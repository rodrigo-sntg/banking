package question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CardTypeCacheImpl implements CardTypeCache{
	private List<BinRange> binRanges = Collections.synchronizedList(new ArrayList<>());
	
	CardTypeCacheImpl(List<BinRange> binRanges){
		this.binRanges = binRanges;
	}
    
    public synchronized String get(String cardNumber){
        
        BinRange val = binRanges.stream().filter(item -> {
        	Long start = Long.valueOf(item.start);
        	Long end = Long.valueOf(item.end);
        	Long valueOf = Long.valueOf(cardNumber.substring(0, item.start.length()));
        	return valueOf >= start && valueOf <= end;
        }).findAny().orElse(null);
        
        
        return val.cardType;
    }
}