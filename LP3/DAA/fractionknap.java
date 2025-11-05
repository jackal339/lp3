
import java.util.*;

class Item{
    double val, weight;

    Item(double val, double weight){
        this.val = val;
        this.weight = weight;
    }
}

public class fractionknap {
    
    // static Comparator <Item> cmp = (a,b)->{
    //     double r1 = a.val/a.weight;
    //     double r2 = b.val/b.weight;
    //     return Double.compare(r2,r1); // r2 before r1 for descending
    // };

    static double fracKnap(int n, int W, List<Item> items){
        
        // Collections.sort(items,cmp);

        items.sort((a,b)->Double.compare(b.val/b.weight,a.val/a.weight));

        double totalValue = 0;

        for(int i=0; i<n; i++){
            if (items.get(i).weight <= W){
                totalValue += items.get(i).val;
                W -= items.get(i).weight;
                System.out.println("("+items.get(i).val + "," + items.get(i).weight+")");
            }
            else{
                double fracVal = W * (items.get(i).val /items.get(i).weight);
                totalValue += ( W * (items.get(i).val /items.get(i).weight) );
                System.out.println("("+fracVal + "," + (double)W +")");
                break; 
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("enter total no. of items: ");
        int n = sc.nextInt();
        
        List <Item> items = new ArrayList<>();
        System.out.println("enter value and weight of each item: ");

        for(int i=0; i<n; i++){
            double val = sc.nextDouble();
            double weight = sc.nextDouble();
            items.add(new Item(val, weight));
        }

        System.out.println("enter capacity of knapsack: ");
        int W = sc.nextInt();

        double maxValue = fracKnap(n, W, items);
        System.out.println("max value possible in knapsack: " + maxValue);

        sc.close();
    }
}
