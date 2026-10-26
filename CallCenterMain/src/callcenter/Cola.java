package callcenter;
public class Cola<T> {
   private Nodo<T> inicio;
   private Nodo<T> fin;
   private int nElementos;
   
    static class Nodo<T> {
       T dato;
       Nodo<T> sig;
       
       Nodo(T dato) {
           this.dato = dato;
           this.sig = null;
       }
   }
   
   public Cola(){
       this.inicio = null;
       this.fin = null;
       this.nElementos = 0;
   }
   
   public void enqueue (T dato){
       Nodo<T> nuevo = new Nodo<>(dato);
       if(empty()){
           inicio = nuevo;
           fin = nuevo;
       } else {
           fin.sig = nuevo;
           fin = nuevo;
       }
       nElementos++;
   }
   
   public void enqueuePrioritario(T dato){
       Nodo<T> nuevo = new Nodo<>(dato);
       if(empty()){
           inicio = nuevo;
           fin = nuevo;
       } else {
           nuevo.sig = inicio;
           inicio = nuevo;
       }
       nElementos++;
   }
   
   public T dequeue(){
       if (empty()){
           throw new RuntimeException("La cola esta vacia");
       }
       T dato = inicio.dato;
       inicio = inicio.sig;
       if(inicio == null){
           fin = null;
       }
       nElementos--;
       return dato;
   }
   
    public T peek(){
        if (empty()){
            throw new RuntimeException("La cola esta vacia");
        }
        return inicio.dato;
    }
    
    public boolean empty(){
        return nElementos == 0;
    }
    
    public int size(){
        return nElementos;
    }
    
    public  Nodo<T> getInicio(){
        return inicio;
    }
}
