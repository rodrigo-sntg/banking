package question1;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * Approach using Google's Guava's RangeMap
 * @author rodrigo
 *
 */
public class CardTypeCacheImpl2 implements CardTypeCache{
    public RangeMap<Long, BinRange> rangeMap;

    public CardTypeCacheImpl2(List<BinRange> binRanges){
    	rangeMap = TreeRangeMap.create();
    	for (Iterator iterator = binRanges.iterator(); iterator.hasNext();) {
			BinRange binRange = (BinRange) iterator.next();
			rangeMap.put(Range.closed(Long.valueOf(binRange.start), Long.valueOf(binRange.end)), binRange);
		}
    }

	@Override
	public String get(String cardNumber){
        
	  	Range<Long> range1 = rangeMap.asMapOfRanges().keySet().stream().findFirst().orElse(null);
	  	Long valueOf = Long.valueOf(cardNumber.substring(0, String.valueOf(range1.lowerEndpoint()).length()));
	  	BinRange binRange = rangeMap.get(valueOf);
      
      
	  	return binRange.cardType;
  }
}