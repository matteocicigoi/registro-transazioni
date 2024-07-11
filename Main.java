import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.InputMismatchException;

public class Main {
        private static Scanner scanner = new Scanner(System.in);
        private static TransactionManager transactionManager = new TransactionManager();
        private static final String red = "\u001B[31m";
        private static final String green = "\u001B[32m";
        private static final String yellow = "\u001B[33m";
        private static final String blue = "\u001B[34m";
        private static final String cyan = "\u001B[36m";
    public static void main(String[] args){
        System.out.println("-----------------------------------------");
        System.out.println("-------------- Transazioni --------------");

        while(true){
        System.out.println("-----------------------------------------\n");
            System.out.println("1. Aggiungi transazione");
            System.out.println("2. Visualizza tutte le transazioni");
            System.out.println("3. Aggiorna transazione");
            System.out.println("4. Rimuovi transazione");
            System.out.println("5. Visualizza totale transazioni");
            System.out.println("6. Esci");
            System.out.print("\n" + blue + "Scegli un'opzione:\u001B[0m ");
            int choice;
            try{
                    choice = scanner.nextInt();
            }catch(InputMismatchException e){
                choice = 999;
            }
            scanner.nextLine();
            
            switch(choice){
                case 1:
                    addTransaction();
                    break;
                case 2:
                    viewTransactions();
                    break;
                case 3:
                    updateTransaction();
                    break;
                case 4:
                    removeTransaction();
                    break;
                case 5:
                    viewTotalTransactions();
                    break;
                case 6:
                    System.out.println(green + "------\u001B[0m");
                    return;
                default:
                    System.out.println("\n" + red + "Opzione non valida\u001B[0m");
            }
        }
    }
    // aggiunge una transazione
    private static void addTransaction(){
        System.out.print("\n" + cyan + "Descrizione:\u001B[0m ");
        String description = scanner.nextLine();
        System.out.print("" + cyan + "Categoria:\u001B[0m ");
        String category = scanner.nextLine();
        System.out.print("" + cyan + "è una spesa? (si o no):\u001B[0m ");
        String isIncomeString = scanner.nextLine();
        boolean isIncome = false;
        if(isIncomeString.equals("no")){
            isIncome = true;
        }
        System.out.print("" + cyan + "Importo:\u001B[0m ");
        double amount = scanner.nextDouble();
        System.out.print("" + cyan + "Data (AAAA-MM-GG):\u001B[0m ");
        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);

        Transaction transaction = new Transaction(transactionManager.getAllTransactions().size() + 1, description, category, isIncome, amount, date);
        transactionManager.addTransaction(transaction);
        System.out.println("\n" + green + "Transazione aggiunta\u001B[0m");
    }

    // mostra tutte le transazioni
    private static void viewTransactions(){
        System.out.println("\n" + green + "Transazioni\u001B[0m" + yellow + "");
        List<Transaction> transactions = transactionManager.getAllTransactions();
        for(Transaction transaction : transactions){
            System.out.print(transaction.getId() + ": ");
            System.out.print(transaction.getDescription() + " - ");
            System.out.print(transaction.getCategory() + " - ");
            System.out.print(transaction.getIsIncome() ? "" : "SPESA" + " - ");
            System.out.print(transaction.getAmount() + " - ");
            System.out.print(transaction.getDate() + "\n");
        }
        System.out.print("\u001B[0m");
    }

    // aggiorma una transazione
    private static void updateTransaction(){
        System.out.print("\n" + cyan + "ID della transazione da aggiornare:\u001B[0m ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("" + cyan + "Descrizione:\u001B[0m ");
        String description = scanner.nextLine();
        System.out.print("" + cyan + "Categoria:\u001B[0m ");
        String category = scanner.nextLine();
        System.out.print("" + cyan + "è una spesa? (si o no):\u001B[0m ");
        String isIncomeString = scanner.nextLine();
        boolean isIncome = false;
        if(isIncomeString.equals("no")){
            isIncome = true;
        }
        System.out.print("" + cyan + "Importo:\u001B[0m ");
        double amount = scanner.nextDouble();
        System.out.print("" + cyan + "Data (AAAA-MM-GG):\u001B[0m ");
        String dateString = scanner.next();
        LocalDate date = LocalDate.parse(dateString);
       
        transactionManager.updateTransaction(id, description, category, isIncome, amount, date );
    }

    // rimuove una transazione
    private static void removeTransaction(){
        System.out.print("\n" + cyan + "ID della transazione da rimuovere:\u001B[0m ");
        int id = scanner.nextInt();
        boolean remove = transactionManager.removeTransaction(id);
        if(remove){
            System.out.println("\n" + green + "Transazione rimossa\u001B[0m");
        }else{
            System.out.println("\n\u001B[31m- ID non valido\u001B[0m");
        }
    }

    // mostra il totale delle transazioni
    private static void viewTotalTransactions(){
        double total = transactionManager.getTotalTransactions();
        System.out.println("\n" + green + "Totale transazioni:\u001B[0m " + yellow + "" + total + "\u001B[0m");
    }
}