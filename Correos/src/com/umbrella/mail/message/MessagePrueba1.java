/*
 * MessagePrueba1.java
 *
 * Created on 29 de abril de 2009, 18:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.umbrella.mail.message;

import java.util.Vector;

/**
 *
 * @author l012g412
 */
public class MessagePrueba1 implements MessageInterface{
    
    private int varInteger;
    private String varString;
    private boolean varBoolean;
    
    /** Creates a new instance of MessagePrueba1 */
    public MessagePrueba1() {        
    }

	public void setVarInteger(int varInteger) {
		this.varInteger = varInteger;
	}

	public int getVarInteger() {
		return varInteger;
	}

	public void setVarString(String varString) {
		this.varString = varString;
	}

	public String getVarString() {
		return varString;
	}

	public void setVarBoolean(boolean varBoolean) {
		this.varBoolean = varBoolean;
	}

	public boolean isVarBoolean() {
		return varBoolean;
	}

	@Override
	public OntologiaMSG getIdentificador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<String> getParametros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdentificador(OntologiaMSG idetificador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setObject(Object objeto) {
		// TODO Auto-generated method stub
		
	}
    
}
