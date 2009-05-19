package com.umbrella.automaster.comm;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.umbrella.automaster.model.PropertiesFile;
import com.umbrella.mail.mailbox.ClientMailBox;
import com.umbrella.mail.mailbox.ServerMailBox;
import com.umbrella.mail.message.MessageInterface;
import com.umbrella.mail.utils.properties.PropertiesFileHandler;
import com.umbrella.mail.utils.properties.PropertyException;

public class Postmaster{
	
	private final MessageConsulter _SCADAmessageConsulter;
	private final MessageConsulter _RB1messageConsulter;
	private final MessageConsulter _RB2messageConsulter;
	private final MessageConsulter _AU1messageConsulter;
	private final MessageConsulter _AU2messageConsulter;
	private final MessageConsulter _AU3AmessageConsulter;
	private static Postmaster instance = null;
	
	// El constructor privado no permite que se genere un constructor por defecto
	// (con mismo modificador de acceso que la definicion de la clase) 
	private Postmaster() throws PropertyException, RemoteException, MalformedURLException, NotBoundException {
		PropertiesFile pfmodel = PropertiesFile.getInstance();
		PropertiesFileHandler.getInstance().LoadValuesOnModel(pfmodel);
		PropertiesFileHandler.getInstance().writeFile();
		
		ServerMailBox smb = new ServerMailBox(pfmodel.getMasterAutPort());
		
		ClientMailBox clientMailBox;
		clientMailBox = new ClientMailBox(pfmodel.getMasterAutIP(), pfmodel.getMasterAutPort(), ServerMailBox._sendSCADAName, ServerMailBox._reciveSCADAName);
		_SCADAmessageConsulter = new MessageConsulter(clientMailBox);
		_SCADAmessageConsulter.start();
		//new Thread(_SCADAmessageConsulter).run();
		
		clientMailBox = new ClientMailBox(pfmodel.getMasterAutIP(), pfmodel.getMasterAutPort(), ServerMailBox._sendR1Name, ServerMailBox._reciveR1Name);
		_RB1messageConsulter = new MessageConsulter(clientMailBox);
		_RB1messageConsulter.start();
		//new Thread(_RB1messageConsulter).run();
		
		clientMailBox = new ClientMailBox(pfmodel.getMasterAutIP(), pfmodel.getMasterAutPort(), ServerMailBox._sendR2Name, ServerMailBox._reciveR2Name);
		_RB2messageConsulter = new MessageConsulter(clientMailBox);
		_RB2messageConsulter.start();
		//new Thread(_RB2messageConsulter).run();
		
		clientMailBox = new ClientMailBox(pfmodel.getMasterAutIP(), pfmodel.getMasterAutPort(), ServerMailBox._sendAU1Name, ServerMailBox._reciveAU1Name);
		_AU1messageConsulter = new MessageConsulter(clientMailBox);
		_AU1messageConsulter.start();
		//new Thread(_AU1messageConsulter).run();
		
		clientMailBox = new ClientMailBox(pfmodel.getMasterAutIP(), pfmodel.getMasterAutPort(), ServerMailBox._sendAU2Name, ServerMailBox._reciveAU2Name);
		_AU2messageConsulter = new MessageConsulter(clientMailBox);
		_AU2messageConsulter.start();
		//new Thread(_AU2messageConsulter).run();
		
		clientMailBox = new ClientMailBox(pfmodel.getMasterAutIP(), pfmodel.getMasterAutPort(), ServerMailBox._sendAU3Name, ServerMailBox._reciveAU3Name);
		_AU3AmessageConsulter = new MessageConsulter(clientMailBox);
		_AU3AmessageConsulter.start();
		//new Thread(_AU3AmessageConsulter).run();
	}

	/**
	 * Obtiene la instancia única del objeto, la primera invocación
	 * realiza la creación del mismo.
	 * @return la instancia única de Postmaster
	 * @throws PropertyException 
	 */
	public static Postmaster getInstance() throws RemoteException, MalformedURLException, NotBoundException, PropertyException {
		Postmaster ret;
		if(instance == null){
			return getSyncInstance();
		}
		return instance;
	}

	private static synchronized Postmaster getSyncInstance() throws RemoteException, MalformedURLException, NotBoundException, PropertyException{
		if(instance == null)
			instance = new Postmaster();
		return instance;
	}
	
	public boolean sendMessageSCADA(MessageInterface message){
		return _SCADAmessageConsulter.send(message);
	}
	
	public boolean sendMessageAU1(MessageInterface message){
		return _AU1messageConsulter.send(message);
	}
	
	public boolean sendMessageAU2(MessageInterface message){
		return _AU2messageConsulter.send(message);
	}
	
	public boolean sendMessageAU3(MessageInterface message){
		return _AU3AmessageConsulter.send(message);
	}
	
	public boolean sendMessageRB1(MessageInterface message){
		return _RB1messageConsulter.send(message);
	}
	
	public boolean sendMessageRB2(MessageInterface message){
		return _RB2messageConsulter.send(message);
	}
	
	public void shutdown(){
		_SCADAmessageConsulter.shutdown();
		_AU1messageConsulter.shutdown();
		_AU2messageConsulter.shutdown();
		_AU3AmessageConsulter.shutdown();
		_RB1messageConsulter.shutdown();
		_RB2messageConsulter.shutdown();	
	}
	
	private class MessageConsulter extends Thread {
		private boolean no_end = true;
		private Object mutex = new Object();
		private ClientMailBox _clientMailBox;
		
		public MessageConsulter(ClientMailBox clientMailBox) {
			_clientMailBox = clientMailBox;
		}
		
		@Override
		public void run() {
			MessageInterface miInterface;
			while(isNo_end()){
				try {
					System.out.println("Escuchando:");
					miInterface = _clientMailBox.receiveBlocking();
					System.out.println(miInterface);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public boolean isNo_end(){
			boolean ret;
			synchronized (mutex) {
				ret = no_end;
			}
			return ret;
		}
		
		void shutdown(){
			synchronized (mutex) {
				no_end = false;
			}
		}
		
		boolean send(MessageInterface message){
			return _clientMailBox.send(message);
		}
		
	}
	

}