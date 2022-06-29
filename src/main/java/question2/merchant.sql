/*
Enter your query below.
Please append a semicolon ";" at the end of the query
*/

select m.merchantName,t.hashedShopperReference,  ROUND(AVG(t.riskScore),2) as averageRiskScore, COUNT(t.hashedShopperReference) as totalNumberOfTransactions
from transaction as t
left join merchant m on t.merchantId = m.merchantid 
where t.hashedShopperReference IN(select distinct(hashedShopperReference) from transaction where t.merchantId = m.merchantid) 
group by m.merchantName,t.hashedShopperReference 
HAVING AVG(t.riskScore) >= 100.0
ORDER BY m.merchantName ASC, averageRiskScore DESC;
