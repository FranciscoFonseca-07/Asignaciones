package linkedlist;
public class LinkedList {
    public static void main(String[] args) {
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        
        
        System.out.println("Probando append y size");
        lista.append("Java");
        lista.append("Python");
        lista.append("C++");
        imprimirLista(lista);
        System.out.println("Tamaño: " + lista.size());
        
        System.out.println("\n Probando insert");
        lista.insert("JavaScript", 1);
        imprimirLista(lista);
        
        System.out.println("\n Probando get y set");
        System.out.println("Elemento en indicie 2: " + lista.get(2));
        lista.set("TypeScript", 2);
        imprimirLista(lista);
        
        System.out.println("\n Probando remove");
        String removido = lista.remove(1);
        System.out.println("Removido del indice 1: " + removido);
        imprimirLista(lista);
        
        System.out.println("\n Probando invetir");
        lista.invertir();
        imprimirLista(lista);
        
        System.out.println("\n Probando concatenar");
        ListaEnlazada<String> otraLista = new ListaEnlazada<>();
        otraLista.append("Rust");
        otraLista.append("Go");
        
        lista.concatenar(otraLista);
        imprimirLista(lista);
        
        System.out.println("\n Probando clear y empty");
        lista.clear();
        System.out.println("¿Esta vacia?: " + lista.empty());
        System.out.println("Tamaño final: " + lista.size());
        
    }
    
    private static <T> void imprimirLista(ListaEnlazada<T> lista){
        System.out.println("Lista: [");
        for(T elemento : lista){
            System.out.println(elemento + " ");
        }
        System.out.println("]");
    }
}
