/*
 * Main.java
 *
 * Created on 21 de abril de 2009, 13:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


import java.io.IOException;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;


/**
 *
 * @author l012g412
 */
public class Main {
        	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
		
       
		try{
			

			/* Esta sentencia se tiene que repetir tantas veces como
			 * nodos nos queramos comunicar. Es decir, cada aut�mata esclavo tendra
			 * uno y el automata maestro tendra cinco.
			 * En ella, el primer parametro es la ip del registro de colas, el segundo
			 * el puerto del registro de colas, el tercero el nombre de la cola por la que se van
			 * a recibir mensajes y el cuarto el nombre de la cola por la que se va a enviar.
			 * En este caso, la cola por la que se recibe es Cola1 y por la que se envia Cola2*/

            // Solo esta sentencia puede lanzar excepcion
            
			MailBox buzon = new MailBox("localhost", 33447, "cola1", "cola2", "cola3", false);
		
        
			System.out.println("Envia mensaje");

			/* Para enviar, hay que crear el mensaje que queremos enviar. Un mensaje es un
			 * objeto de una clase que implementa la interfaz MessageInterface. En este caso
			 * la clase es MessagePrueba con un entero, una cadena y un booleano, pero se le
			 * pueden poner todos los atributos que se necesiten.*/
			MessageInterface messagePrueba = new ConnectionTimedOutMessage();



			/* El metodo enviar devuelve true si se ha enviado correctamente, es decir, si ha
			 * habido conexi�n correcta con el registro de colas y false en caso contrario*/

			boolean dev = buzon.send(messagePrueba);

			if(dev){
				System.out.println("Enviado!");
			}else{
				System.out.println("Error al enviar");
			}	

			}catch(Exception e){
				System.out.println("Problemas al conectar con las colas");
 
			}
	
        // TODO code application logic here
    }
	
    
}