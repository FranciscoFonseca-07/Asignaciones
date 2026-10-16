package mainpila;
public class MainPila {
    public static void main(String[] args) {
        Pila<String> pila = new Pila<>();
        
        System.out.println("Probando empty() al inicio");
        System.out.println("¿La pila esta vacia?: " + pila.empty());
        
        System.out.println("Probando push");
        pila.push("Primero (Base)");
        pila.push("Segundo");
        pila.push("Tercero (Tope)");
        System.out.println("Se agregaron 3 elementos.");
        System.out.println("¿La pila esta vacia?: " + pila.empty());
        
        System.out.println("Probando peek()");
        System.out.println("Elemento en el tope (sin extraer): " + pila.peek());
        
        System.out.println("Probando pop()");
        System.out.println("Elemento extraido del tope: " + pila.pop());
        System.out.println("Nuevo elemento en el tope despues del pop: " + pila.peek());
        
        System.out.println("Vaciando la pila");
        System.out.println("Extrayendo: " + pila.pop());
        System.out.println("Extrayendo: " + pila.pop());
        
        System.out.println("¿La pila esta vacia ahora?: " + pila.empty());
    }
    
}
