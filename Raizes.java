import java.lang.reflect.Constructor;

public class Raizes {
    private double raiz1, raiz2;

    Raizes (double raiz1, double raiz2) {
        this.raiz1 = raiz1;
        this.raiz2 = raiz2;
    }
    
    
    public String toString(){
        return String.format("Raiz 1 = %.2f, Raiz 2 = %.2f", raiz1, raiz2);     
    }
}
