package mainpila;
public class Pila<T> {
   private Nodo<T> tope;
   private int nElementos;
   
   private static class Nodo<T>{
       private T dato;
       private Nodo<T> sig;
       
       public Nodo(T dato){
           this.dato = dato;
           this.sig = null;
       }
   }
   
   public Pila(){
       this.tope = null;
       this.nElementos = 0;
   }
   
   public void push(T elemento){
      Nodo<T> nuevoNodo = new Nodo<>(elemento);
      nuevoNodo.sig = tope;
      tope = nuevoNodo;
      nElementos++;
   }
   
   public T pop() throws StackException{
       if (empty()){
           throw new StackException("Error: la pila esta vacia, no se puede hacer pop.");
       }
       T datoRemovido = tope.dato;
       tope = tope.sig;
       nElementos--;
       return datoRemovido;
   }
   
   public T peek() throws StackException{
       if(empty()){
           throw new StackException("Error: La pila esta vacia, no se puede hacer peek.");
       }
       return tope.dato;
   }
   
   public boolean empty(){
       return nElementos == 0;
   }
   
   public int size(){
       return nElementos;
   }
    
}
