package question1;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * Approach using Google's Guava's RangeMap
 * @author rodrigo
 *
 */
public class CardTypeCacheImpl3 implements CardTypeCache{
    public TreeMap<Long, BinRange> rangeTreeMap;

    public CardTypeCacheImpl3(List<BinRange> binRanges){
    	
    	rangeTreeMap = new TreeMap<Long, BinRange>();
    	
    	for (Iterator iterator = binRanges.iterator(); iterator.hasNext();) {
			BinRange binRange = (BinRange) iterator.next();
			rangeTreeMap.put(Long.valueOf(binRange.start), binRange);
			rangeTreeMap.put(Long.valueOf(binRange.end), binRange);
		}
    }

	@Override
	public synchronized String get(String cardNumber){
        
	  	Long range1 = rangeTreeMap.firstKey();
	  	Long valueOf = Long.valueOf(cardNumber.substring(0, String.valueOf(range1).length()));
	  	Entry<Long, BinRange> binRange = rangeTreeMap.ceilingEntry(valueOf);
	  	
	  	
	  	
      
      
	  	return binRange.getValue().cardType;
  }
}