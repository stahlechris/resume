//This program highlights how easy it is to sort and manipulate mass data within a java program when Java 1.8 is installed. 
package tradersandtransactionsstreams;

import java.util.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author stahl
 */
public class TradersAndTransactionsStreams {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        
        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );
        
        /*
        think of .map as SQL SELECT and .filter as SQL WHERE 
        .map transforms Object values. It maps them to a new Object.
        .filter filters the data and always returns a boolean, if true, it is mapped to list, else not
        */
        //1.) Find all transactions in the year 2011 and sort them by value(0-100).
        List<Transaction>allTransactionsIn2011SmallToLarge = transactions.stream()
                .filter (m -> m.getYear() == 2011) //check if year is == 2011
                .sorted(comparing(Transaction::getValue))//sort by value
                .collect(toList()); //collect objects to a list 
        
        //2.) What are all the unique cities where the traders work?
        List<String> uniqueCitiesWhereTradersWorks = transactions.stream()
                .map(m -> m.getTrader().getCity()) 
                .distinct()
                .collect(toList());
        
        //3.) Find all traders from Cambridge and sort them by name.
        List<Trader> allTradersFromCambridgeByName = transactions.stream()
                .map(Transaction::getTrader) //retrieve each trader from each transaction
                .filter(m -> m.getCity().equalsIgnoreCase("cambridge")) //check if their city == cambridge
                .distinct() //no duplicates
                .sorted(comparing(Trader::getName)) //sort alphabetically by name
                .collect(toList());
        
        //4.) Return a String of all traders' names sorted alphabetically.
        String allTradersAlphabetically = transactions.stream()
                .map(m -> m.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining()); //uses a StringBuilder
        
        //5.Are any traders based in Milan?
        boolean areAnyTradersBasedInMilan = transactions.stream()
                .anyMatch( m -> m.getTrader().getCity().equals("Milan")); 
        
        //6.) Print all transactions' values from the traders living in Cambridge
        transactions.stream()
                .filter(m -> "Cambridge".equals(m.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        
        //7.) What's the highest value of all the transactions?
        /*
        Optional<Integer> highestValueTransactionOutOfAll = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        */
        
        OptionalInt highestValueTransactionOutOfAll = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();
        
        //8.) Find the transaction with the smallest value.
        Optional<Integer> lowestValueTransactionOutOfAll = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        //OR REPLACE BOTH LINES WITH ONE: .min(comparing(Transaction::getValue));
        //must change DT to Optional<Transaction> 
        
        //9.) Find all transactions from 2012 with a value greater than or equal to 100 
        List<Transaction> transactionsFrom2012GreaterThan100 = transactions.stream()
                .filter(m -> m.getYear() == 2012)
                .filter(m -> m.getValue() >= 100)
                .collect(toList());
        System.out.println(transactionsFrom2012GreaterThan100);
    }
    
}
