import java.util.ArrayList;
import java.util.List;

// gestione delle transazioni
public class TransactionManager {
    private List<Transaction> transactions;

    // costruttore
    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    // restituisce la transazione che corrispone all'id
    public Transaction getTransactionById(int id){
        for(Transaction transaction : transactions){
            if(transaction.getId() == id) {
                return transaction;
            }
        }
        return  null;
    }

    // aggiunge una transazione
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    // modifica una transazione
    public boolean updateTransaction(int id, String description, String category, boolean isIncome, double amount, String date){
        Transaction transaction  = getTransactionById(id);
        if(transaction != null) {
            transaction.setId(id);
            transaction.setDescription(description);
            transaction.setCategory(category);
            transaction.setIsIncome(isIncome);
            transaction.setAmount(amount);
            transaction.setDate(date);
            return true;
        }
        return false;
    }

    // rimuove una transazione
    public boolean removeTransaction(int id){
        Transaction transaction  = getTransactionById(id);
        if(transaction != null) {
            transactions.remove(transaction);
            return true;
        }
        return false;
    }

    // restituisce la lista cone le transazioni
    public List<Transaction> getAllTransactions(){
        return transactions;
    }

    // restituisce il totlale delle transazioni
    public double getTotalTransactions(){
        double total = 0;
        for(Transaction transaction : transactions){
            if(transaction.getIsIncome() == false) {
                total -= transaction.getAmount();
            }else{
                total += transaction.getAmount();
            }
        }
        return total;
    }
}