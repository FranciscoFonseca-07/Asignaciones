package callcenter;
public class CallCenterMain {
    public static void main(String[] args) {
        CallCenter centro = new CallCenter();
        
        System.out.println("Recibiend Llamadas");
        centro.recibirLlamada(new Llamada(1, "Ana Perez", Llamada.Tipo.normal, 5.0));
        centro.recibirLlamada(new Llamada(2, "Carlos Gomez", Llamada.Tipo.prioritaria, 2.5)); // Se encola al inicio
        centro.recibirLlamada(new Llamada(3, "Maria Lopez", Llamada.Tipo.normal, 4.0));
        centro.recibirLlamada(new Llamada(4, "Juan Torres", Llamada.Tipo.prioritaria, 3.0)); // Se encola al inicio (antes de Carlos)
   
        centro.mostrarCola();
        
        System.out.println("\nCantidad de llamadas pendientes: " + centro.llamadasPendientes());
        System.out.println("Tiempo total pendiente:" + centro.tiempoTotalPendiente() + " min");
        
        System.out.println("Atendiendo una llamada individual");
        Llamada atendida = centro.atenderLlamada();
        if (atendida != null){
            System.out.println("Llamada atendida de: " + atendida.getCliente());
        }
        
        System.out.println("\n Cola despues de atender una llamada");
        centro.mostrarCola();
        
        System.out.println("\n Cancelando una llamada");
        centro.cancelarLlamada();
        System.out.println("Se cancelo la siguiente llamada en la cola");
        centro.mostrarCola();
        
        System.out.println("\n Atendiendo todas las llamadas restantes");
        centro.atenderTodas();
        
        System.out.println("Estadisticas Finales");
        System.out.println("Tiempo total acumulado de atencion: " + centro.getTiempoTotal() + " min");
        System.out.println("Promedio de puntuacion de atencion: " + centro.obtenerpromedio());
    }
    
}
