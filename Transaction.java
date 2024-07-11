// classe che rappresenta una transazione
public class Transaction {
    private int id;
    private String description;
    private String category;
    private boolean isIncome;
    private double amount;
    private String date;

    // costruttore
    public Transaction(int id, String description, String category, boolean isIncome, double amount, String date) {
        setId(id);
        setDescription(description);
        setCategory(category);
        setIsIncome(isIncome);
        setAmount(amount);
        setDate(date);
    }

    // setter
    public void setId(int id){
        this.id = id;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setIsIncome(boolean isIncome){
        this.isIncome = isIncome;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public void setDate(String date){
        this.date = date;
    }
    // getter
    public int getId(){
        return id;
    }
    public String getDescription(){
        return description;
    }
    public String getCategory(){
        return category;
    }
    public boolean getIsIncome(){
        return isIncome;
    }
    public double getAmount(){
        return amount;
    }
    public String getDate(){
        return date;
    }

}