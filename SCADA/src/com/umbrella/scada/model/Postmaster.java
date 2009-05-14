package com.umbrella.scada.model;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;

import com.umbrella.mail.message.MessageInterface;
import com.umbrella.mail.modulocomunicacion.MailBox;
import com.umbrella.scada.controller.ActionFactory;
import com.umbrella.scada.controller.ActionFactoryProvider;
import com.umbrella.scada.controller.ActionKey;
import com.umbrella.scada.controller.ActionParams;
import com.umbrella.scada.controller.ActionParamsEnum;

public class Postmaster extends Thread {
	
	private final MailBox _mailBox;
	private final LinkedList<MessageInterface> llmi;
	private static Postmaster instance = null;
	private boolean _no_end;
	
	// El constructor privado no permite que se genere un constructor por defecto
	// (con mismo modificador de acceso que la definicion de la clase) 
	private Postmaster() throws RemoteException, MalformedURLException, NotBoundException {
		Model model = Model.getInstance();
		_mailBox = new MailBox(model.get_genIP(), model.get_genPort(), "reciveBox", "sendBox");
		llmi = new LinkedList<MessageInterface>();
		_no_end = true;
	}

	/**
	 * Obtiene la instancia única del objeto, la primera invocación
	 * realiza la creación del mismo.
	 * @return la instancia única de Postmaster
	 */
	public static Postmaster getInstance() throws RemoteException, MalformedURLException, NotBoundException {
		Postmaster ret;
		if(instance == null){
			return getSyncInstance();
		}
		return instance;
	}

	private static synchronized Postmaster getSyncInstance() throws RemoteException, MalformedURLException, NotBoundException{
		if(instance == null)
			instance = new Postmaster();
		return instance;
	}
	
	@Override
	public void run() {
		ActionFactory af = ActionFactoryProvider.getInstance();
		ActionParams params;
		ActionParamsEnum ape;
		
		while(_no_end){
			try {
				params = null;
				MessageInterface msg = _mailBox.receiveBlocking();
				switch (msg.getIdentificador()) {
				case AU1ARRANCADO:
					params = new ActionParams();
					ape = ActionParamsEnum.STATE;
					params.setParam(ape, ape.getEnclosedClass(), true);
					ape = ActionParamsEnum.MACHINE;
					params.setParam(ape, ape.getEnclosedClass(), "AU1");
					af.executeAction(ActionKey.UPDATE_STATE, params);
					break;
				case AU2ARRANCADO:
					params = new ActionParams();
					ape = ActionParamsEnum.STATE;
					params.setParam(ape, ape.getEnclosedClass(), true);
					ape = ActionParamsEnum.MACHINE;
					params.setParam(ape, ape.getEnclosedClass(), "AU2");
					af.executeAction(ActionKey.UPDATE_STATE, params);				
					break;
				case AU3ARRANCADO:
					params = new ActionParams();
					ape = ActionParamsEnum.STATE;
					params.setParam(ape, ape.getEnclosedClass(), true);
					ape = ActionParamsEnum.MACHINE;
					params.setParam(ape, ape.getEnclosedClass(), "AU3");
					af.executeAction(ActionKey.UPDATE_STATE, params);
					break;
				case RB1ARRANCADO:
					params = new ActionParams();
					ape = ActionParamsEnum.STATE;
					params.setParam(ape, ape.getEnclosedClass(), true);
					ape = ActionParamsEnum.MACHINE;
					params.setParam(ape, ape.getEnclosedClass(), "RB1");
					af.executeAction(ActionKey.UPDATE_STATE, params);
					break;
				case RB2ARRANCADO:
					params = new ActionParams();
					ape = ActionParamsEnum.STATE;
					params.setParam(ape, ape.getEnclosedClass(), true);
					ape = ActionParamsEnum.MACHINE;
					params.setParam(ape, ape.getEnclosedClass(), "RB2");
					af.executeAction(ActionKey.UPDATE_STATE, params);
					break;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}