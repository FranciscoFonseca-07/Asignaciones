package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<T> implements IList<T>, Iterable<T>{
protected NodoDoble<T> inicio;
protected NodoDoble<T> ultimo;
protected int nElementos;
protected NodoDoble<T> iteradorActual;

protected class NodoDoble<T>{
    private T dato;
    private NodoDoble<T> sig;
    private NodoDoble<T> ant;
    
    public NodoDoble(T dato){
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }
}
    
   

    public ListaEnlazada() {
        inicio = null;
        ultimo = null;
        nElementos = 0;
        iteradorActual = null;

    }
    @Override
    public void append(T elemento) throws ListException {
       NodoDoble<T> nodoNuevo = new NodoDoble<>(elemento);

        if (empty()) {
        inicio = nodoNuevo;
        ultimo = nodoNuevo;
        inicio.sig = inicio;
        inicio.ant = inicio;
        iteradorActual = inicio;
        } else {
            ultimo.sig = nodoNuevo;
            nodoNuevo.ant = ultimo;
            nodoNuevo.sig = inicio;
            inicio.ant = nodoNuevo;
            ultimo = nodoNuevo;
    }
    nElementos++;
    }
    @Override
    public void insert(T elemento, int index) throws ListException {
        if (index < 0 || index > nElementos){
            throw new ListException("Indice fuera de rango: " + index);
        }
        
        if(index == 0){
            NodoDoble<T> nodoNuevo = new NodoDoble<>(elemento);
            if (empty()){
                inicio = nodoNuevo;
                ultimo = nodoNuevo;
                inicio.sig = inicio;
                inicio.ant = inicio;
                iteradorActual = inicio;
            } else {
                ultimo.sig = nodoNuevo;
                nodoNuevo.ant = ultimo;
                nodoNuevo.sig = inicio;
                inicio.ant = nodoNuevo;
                ultimo = nodoNuevo;
            }
            nElementos++;
        } else if (index == nElementos){
            append(elemento);
            } else {
                NodoDoble<T> actual = inicio;
                for (int i = 0; i < index; i++){
                    actual = actual.sig;
                }
                NodoDoble<T> nodoNuevo = new NodoDoble<>(elemento);
                NodoDoble<T> anterior = actual.ant;
                
                anterior.sig = nodoNuevo;
                nodoNuevo.ant = anterior;
                nodoNuevo.sig = actual;
                actual.ant = nodoNuevo;
                nElementos++;
        }
    }

    @Override
    public T remove(int index) throws ListException {
        if (empty() || index < 0 || index >= nElementos){
            throw new ListException("Indice fuera de rango o lista vacia: " + index);
        }
        
        T elementoEliminado;
        
        if (nElementos == 1){
            elementoEliminado = inicio.dato;
            clear();
            return elementoEliminado;
        } 
        
        NodoDoble<T> actual = inicio;
        for (int i = 0; i < index; i++){
        actual = actual.sig;
        }
        elementoEliminado = actual.dato;
        
        actual.ant.sig = actual.sig;
        actual.sig.ant = actual.ant;
        
        if (actual == inicio){
            inicio = actual.sig;
        }
        if (actual == ultimo){
            iteradorActual = inicio;
        }
        
        nElementos--;
        return elementoEliminado;
    }
   

    @Override
    public boolean removeObj(T elemento) throws ListException {
        if (empty()){
            return false;
        }
        NodoDoble<T> actual = inicio;
        int i = 0;
        do{
            if ((actual.dato == null && elemento == null) || (actual.dato != null && actual.dato.equals(elemento))){
                remove(i);
                return true;
            }
            actual = actual.sig;
            i++;
        } while (actual != inicio);
        
        return false;
    }

    @Override
    public int indexOf(T elemento) {
       if (empty()) return -1;
       NodoDoble<T> actual = inicio;
       int i = 0;
       do{
           if((actual.dato == null && elemento == null) || (actual.dato != null && actual.dato.equals(elemento))){
               return i;
           }
           actual = actual.sig;
           i++;
       }while (actual != inicio);
        return -1;
    }

    @Override
    public T get(int index) throws ListException {
        if(index < 0 || index >= nElementos){
            throw new ListException("indice fuera de rango: " + index);
        }
        
        NodoDoble<T> actual = inicio;
        for (int i = 0; i < index; i++){
            actual = actual.sig;
        }
        return actual.dato;
    }

    @Override
    public void set(T elemento, int index) throws ListException {
        if ( index < 0 || index >= nElementos){
            throw new ListException("indicie fuera de rango: " + index);
        }
        
        NodoDoble<T> actual = inicio;
        for (int i = 0; i < index; i++){
            actual = actual.sig;
        }
        
        actual.dato = elemento;
    }

    @Override
    public void clear() {
        inicio = null;
        ultimo = null;
        nElementos = 0;
        iteradorActual = null;
    }

    @Override
    public boolean empty() {
        return nElementos == 0;
    }

    @Override
    public int size() {
        return nElementos;
    }
    
    public void invertir(){
      if (empty() || nElementos == 1)return;
      NodoDoble<T> actual = inicio;
      NodoDoble<T> temp = null;
      
      do{
          temp = actual.sig;
          actual.sig = actual.ant;
          actual.ant = temp;
          actual = temp;
      } while (actual != inicio);
      
      temp = inicio;
      inicio = ultimo;
      ultimo = temp;
    }
    
    public void concatenar(ListaEnlazada<T> otraLista){
        if (otraLista == null || otraLista.empty()){
            return;
        }
        
        NodoDoble<T> actualOtra = otraLista.inicio;
        while (actualOtra != null){
            this.append(actualOtra.dato);
            actualOtra = actualOtra.sig;
        }
    }

    public void irInicio(){
        if(!empty()){
            iteradorActual = inicio;
            System.out.println("Iterador posicionado en inicio: " + iteradorActual.dato);
        } else {
            System.out.println("La lista esta vacia");
        }
    }
    
    public void irFInal(){
        if (!empty()){
            iteradorActual = ultimo;
            System.out.println("Iterador posicionado en final (cola): " + iteradorActual.dato);
        } else {
            System.out.println("La lista esta vacia");
        }
    }
    
    public void previous(){
        if (!empty() && iteradorActual != null)
        {
            iteradorActual = iteradorActual.ant;
            System.out.println("Moviendo iterador al anterior. Actual: " + iteradorActual.dato);
        } else {
            System.out.println("No se puede mvoer el iterador");
        }
    }
    
    public void nextIterador(){
        if (!empty() && iteradorActual != null){
            iteradorActual = iteradorActual.sig;
            System.out.println("MOviendo iterador al siguiente. Actual: " + iteradorActual.dato);
        }
    }
    
    @Override
    public java.util.Iterator<T> Iterator() {
        return iterator();
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoDoble<T> actual = inicio;
            private int contador = 0;
            
            @Override
            public boolean hasNext() {
                return contador < nElementos;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                T dato = actual.dato;
                actual = actual.sig;
                contador++;
                return dato;
            }
        };
    }
    
}
