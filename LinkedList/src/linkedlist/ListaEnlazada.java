package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<T> implements IList<T>, Iterable<T>{
protected NodoSimple<T> inicio;
protected int nElementos;
    
    private class NodoSimple<T>{
        private T dato;
        private NodoSimple<T> sig;
        
        public NodoSimple(T dato){
            this.dato = dato;
        }
    }

    public ListaEnlazada() {
        inicio = null;
        nElementos = 0;

    }
    @Override
    public void append(T elemento) throws ListException {
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
        NodoSimple<T> nodo = inicio;
        
        if(nodo == null){
        inicio = nodoNuevo;
    }else{
        while(nodo.sig != null){
            nodo = nodo.sig;
        }
        
        nodo.sig = nodoNuevo;
    }
    nElementos++;
    }
    @Override
    public void insert(T elemento, int index) throws ListException {
        if (index < 0 || index > nElementos){
            throw new ListException("Indice fuera de rango: " + index);
        }
        
        NodoSimple<T> nodoNuevo = new NodoSimple<>(elemento);
        
        if(index == 0){
            nodoNuevo.sig = inicio;
            inicio = nodoNuevo;
        } else {
            NodoSimple<T> actual = inicio;
            for (int i = 0; i < index - 1; i++){
                actual = actual.sig;
            }
            nodoNuevo.sig = actual.sig;
            actual.sig = nodoNuevo;
        }
        nElementos++;
    }

    @Override
    public T remove(int index) throws ListException {
        if (empty() || index < 0 || index >= nElementos){
            throw new ListException("Indice fuera de rango o lista vacia: " + index);
        }
        
        T elementoEliminado;
        
        if (index == 0){
            elementoEliminado = inicio.dato;
            inicio = inicio.sig;
        } else {
            NodoSimple<T> actual = inicio;
            for (int i = 0; i < index - 1; i++){
                actual = actual.sig;
            }
            elementoEliminado = actual.sig.dato;
            actual.sig = actual.sig.sig;
        }
        nElementos--;
        return elementoEliminado;
    }

    @Override
    public boolean removeObj(T elemento) throws ListException {
        if (empty()){
            return false;
        }
        
        if ((inicio.dato == null && elemento == null) || (inicio.dato != null && inicio.dato.equals(elemento))){
            inicio = inicio.sig;
            nElementos--;
            return true;
        }
        
        NodoSimple<T> actual = inicio;
        while (actual.sig != null){
            if((actual.sig.dato == null && elemento == null) ||
                (actual.sig.dato != null && actual.sig.dato.equals(elemento))){
                actual.sig = actual.sig.sig;
                nElementos--;
                return true;
            }
            actual = actual.sig;
        }
        return false;
    }

    @Override
    public int indexOf(T elemento) {
        NodoSimple<T> actual = inicio;
        int i = 0;
        
        while (actual != null){
            if((actual.dato == null && elemento == null) ||
                (actual.dato != null && actual.dato.equals(elemento))){
                return i;
            }
            actual = actual.sig;
            i++;
        }
        return -1;
    }

    @Override
    public T get(int index) throws ListException {
        if(index < 0 || index >= nElementos){
            throw new ListException("indice fuera de rango: " + index);
        }
        
        NodoSimple<T> actual = inicio;
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
        
        NodoSimple<T> actual = inicio;
        for (int i = 0; i < index; i++){
            actual = actual.sig;
        }
        
        actual.dato = elemento;
    }

    @Override
    public void clear() {
        inicio = null;
        nElementos = 0;
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
        NodoSimple<T> previo = null;
        NodoSimple<T> actual = inicio;
        NodoSimple<T> siguiente = null;
        
        while (actual != null){
            siguiente = actual.sig;
            actual.sig = previo;
            previo = actual;
            actual = siguiente;
        }
        inicio = previo;
    }
    
    public void concatenar(ListaEnlazada<T> otraLista){
        if (otraLista == null || otraLista.empty()){
            return;
        }
        
        NodoSimple<T> actualOtra = otraLista.inicio;
        while (actualOtra != null){
            this.append(actualOtra.dato);
            actualOtra = actualOtra.sig;
        }
    }

    @Override
    public java.util.Iterator<T> Iterator() {
        return iterator();
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoSimple<T> actual = inicio;
            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                T dato = actual.dato;
                actual = actual.sig;
                return dato;
            }
        };
    }
    
}
