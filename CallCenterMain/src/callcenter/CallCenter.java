package callcenter;

import java.util.LinkedList;

public class CallCenter {
    private Cola<Llamada> colaLlamadas;
    private double tiempoTotal;
    private LinkedList<Integer> puntuaciones;
    
    public CallCenter(){
        this.colaLlamadas = new Cola<>();
        this.tiempoTotal = 0.0;
        this.puntuaciones = new LinkedList<>();
    }
    
    public void recibirLlamada(Llamada llamada){
        if (llamada.getTipo() == Llamada.Tipo.prioritaria){
            colaLlamadas.enqueuePrioritario(llamada);
        } else {
            colaLlamadas.enqueue(llamada);
        }
    }
    
    public Llamada atenderLlamada(){
        if (colaLlamadas.empty()){
            return null;
        }
        Llamada llamada = colaLlamadas.dequeue();
        tiempoTotal += llamada.getDuracion();
        int puntuacion = llamada.obtenerPuntuacion();
        puntuaciones.add(puntuacion);
        return llamada;
    }
    
    public void cancelarLlamada(){
        if (!colaLlamadas.empty()){
           colaLlamadas.dequeue();
        }
    }
    
    public void mostrarCola(){
        System.out.println("Llamadas Pendientes");
        if(colaLlamadas.empty()){
            System.out.println("No hay llamadas pendientes");
            return;
        }
        var actual = colaLlamadas.getInicio();
        while (actual != null){
            Llamada l = actual.dato;
            System.out.println("ID: " + l.getId() + " | Cliente: " + l.getCliente() +
                                "| Tipo: " + l.getTipo() + " | Duracion: " + l.getDuracion() + " min");
            actual = actual.sig;
        }
    }
    
    public double tiempoTotalPendiente(){
        double suma = 0.0;
        var actual = colaLlamadas.getInicio();
        while (actual != null){
            suma += actual.dato.getDuracion();
            actual = actual.sig;
        }
        return suma;
    }
    
    public int llamadasPendientes(){
        return colaLlamadas.size();
    }
    
    public void atenderTodas(){
        while (!colaLlamadas.empty()){
            Llamada l = colaLlamadas.dequeue();
            tiempoTotal += l.getDuracion();
            int puntuacion = l.obtenerPuntuacion();
            puntuaciones.add(puntuacion);
            System.out.println("Atendido: Cliente "+ l.getCliente() +
                                "| Duracion: " + l.getDuracion() + 
                                " min | Puntuacion: " + puntuacion);
        }
    }
    
    public double obtenerpromedio(){
        if (puntuaciones.isEmpty()){
            return 0.0;
        }
        int suma = 0;
        for(int p : puntuaciones){
            suma += p;
        }
        return (double) suma / puntuaciones.size();
    }
    
    public double getTiempoTotal(){
        return tiempoTotal;
    }
}
