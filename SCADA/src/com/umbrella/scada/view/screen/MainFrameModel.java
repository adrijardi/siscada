package com.umbrella.scada.view.screen;

import com.umbrella.scada.observer.ObserverProvider;
import com.umbrella.scada.observer.TransferBuffer;
import com.umbrella.scada.observer.TransferBufferKeys;
import com.umbrella.scada.view.Updatable;
import com.umbrella.scada.view.localization.LocalizationResources.LanguageIDs;

public class MainFrameModel implements Updatable {

	enum ElementsGroupModelEnum {
		CINTA1, CINTA2, CINTA3, ROBOT1, ROBOT2;
	}

	// Cerrojo
	private Object[] _cerrojos;
	
	// Estado de los automatas y robot
	private boolean []_statesAutRob;
	// Variables generales
	private LanguageIDs _selectedLanguage;
	private UpdatableInterface _mainFrame;

	// ESTADOS

	private boolean _cintaPasteles;
	private boolean _cintaBlister;
	private boolean _cintaMontaje;
	private int _brazoMontaje;
	private boolean _brazoDesechar;
	private int[] _pasteles = new int[7];
	private int[] _blisters = new int[5];
	private int[] _paquetes = new int[4];

	// ACTIONS

	// El constructor privado no permite que se genere un constructor por
	// defecto
	// (con mismo modificador de acceso que la definicion de la clase)
	private MainFrameModel() {
		System.out.println("Arrancando MainFrameModel");
		_statesAutRob = new boolean[5];
		for (int i = 0; i < _statesAutRob.length; i++) {
			_statesAutRob[i] = false;
		}
		_cerrojos = new Object[TransferBufferKeys.values().length];
		for (int i = 0; i < _cerrojos.length; i++) {
			_cerrojos[i] = new Object();
		}
		_selectedLanguage = LanguageIDs.SPANISHLOCALE;
	}

	/**
	 * Obtiene la instancia única del objeto, la primera invocación realiza la
	 * creación del mismo.
	 * 
	 * @return la instancia única de MainFrameModel
	 */
	public static MainFrameModel getInstance() {
		return SingletonHolder.instance;
	}

	public void initialize() {
		if (_mainFrame == null) {
			_mainFrame = MainFrame.getInstance();
			ObserverProvider.getInstance().registerUpdatable(this);
		}
	}

	private static class SingletonHolder {
		private static MainFrameModel instance = new MainFrameModel();
	}

	public LanguageIDs get_selectedLanguage() {
		return _selectedLanguage;
	}

	public void set_selectedLanguage(LanguageIDs language) {
		_selectedLanguage = language;
		_mainFrame.updateLanguage();
	}

	@Override
	public void update(TransferBuffer buffer) {
		// Se obtienen las claves
		TransferBufferKeys[] tbk = TransferBufferKeys.values();
		Object value;
		// Se recorren las claves
		for (int i = 0; i < tbk.length; i++) {
			// Se obtiene el valor de la clave
			value = buffer.getElement(tbk[i]);
			if (value != null) {
				updateValue(tbk[i], tbk[i].get_class(), value);
			}
		}
		_mainFrame.updateData();
	}

	private void updateValue(TransferBufferKeys key, Class<?> object_class,
			Object o) {
		switch (key) {
		case AU1_CAKE_DEPOT:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CAKE_DEPOT.ordinal()]) {

			}
			break;
		case AU1_CARAMEL_VALVE_DELAY:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CARAMEL_VALVE_DELAY
					.ordinal()]) {

			}
			break;
		case AU1_CHOCOLATE_VALVE_DELAY:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CHOCOLATE_VALVE_DELAY
					.ordinal()]) {

			}
			break;
		case AU1_CONVEYOR_BELT_SIZE:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CONVEYOR_BELT_SIZE
					.ordinal()]) {

			}
			break;
		case AU1_CONVEYOR_BELT_SPEED:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CONVEYOR_BELT_SPEED
					.ordinal()]) {

			}
			break;
		case AU1_CAKES_POS1:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS1.ordinal()]) {
				_pasteles[0] = (Integer) o;
			}
			break;
		case AU1_CAKES_POS2:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS2.ordinal()]) {
				_pasteles[1] = (Integer) o;
			}
			break;
		case AU1_CAKES_POS3:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS3.ordinal()]) {
				_pasteles[2] = (Integer) o;
			}
			break;
		case AU1_CAKES_POS4:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS4.ordinal()]) {
				_pasteles[3] = (Integer) o;
			}
			break;
		case AU1_CAKES_POS5:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS5.ordinal()]) {
				_pasteles[4] = (Integer) o;
			}
			break;
		case AU1_CAKES_POS6:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS6.ordinal()]) {
				_pasteles[5] = (Integer) o;
			}
			break;
		case AU1_CAKES_POS7:
			synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS7.ordinal()]) {
				_pasteles[6] = (Integer) o;
			}
			break;
		case AU1_STATE:
			synchronized (_cerrojos[TransferBufferKeys.AU1_STATE.ordinal()]) {
				_statesAutRob[0] = (Boolean) o;
			}
			break;
		case AU2_CONVEYOR_BELT_SIZE:
			synchronized (_cerrojos[TransferBufferKeys.AU2_CONVEYOR_BELT_SIZE
					.ordinal()]) {

			}
			break;
		case AU2_CONVEYOR_BELT_SPEED:
			synchronized (_cerrojos[TransferBufferKeys.AU2_CONVEYOR_BELT_SPEED
					.ordinal()]) {

			}
			break;
		case AU2_VACUUM_SEALING_MACHINE:
			synchronized (_cerrojos[TransferBufferKeys.AU2_VACUUM_SEALING_MACHINE
					.ordinal()]) {

			}
			break;
		case AU2_STATE:
			synchronized (_cerrojos[TransferBufferKeys.AU2_STATE.ordinal()]) {
				_statesAutRob[1] = (Boolean) o;
			}
			break;
		case AU3_CONVEYOR_BELT_SIZE:
			synchronized (_cerrojos[TransferBufferKeys.AU3_CONVEYOR_BELT_SIZE
					.ordinal()]) {

			}
			break;
		case AU3_CONVEYOR_BELT_SPEED:
			synchronized (_cerrojos[TransferBufferKeys.AU3_CONVEYOR_BELT_SPEED
					.ordinal()]) {

			}
			break;
		case AU3_STATE:
			synchronized (_cerrojos[TransferBufferKeys.AU3_STATE.ordinal()]) {
				_statesAutRob[2] = (Boolean) o;
			}
			break;
		case GEN_BLISTER_SIZE:
			synchronized (_cerrojos[TransferBufferKeys.GEN_BLISTER_SIZE
					.ordinal()]) {

			}
			break;
		case GEN_CAKE_SIZE:
			synchronized (_cerrojos[TransferBufferKeys.GEN_CAKE_SIZE.ordinal()]) {

			}
			break;
		case GEN_CLOCK_TIME:
			synchronized (_cerrojos[TransferBufferKeys.GEN_CLOCK_TIME.ordinal()]) {

			}
			break;
		case GEN_ROBOT_INTERFERENCE:
			synchronized (_cerrojos[TransferBufferKeys.GEN_ROBOT_INTERFERENCE
					.ordinal()]) {

			}
			break;
		case GEN_SENSOR_ERROR:
			synchronized (_cerrojos[TransferBufferKeys.GEN_SENSOR_ERROR
					.ordinal()]) {

			}
			break;
		case RB1_BLISTER_DELAY:
			synchronized (_cerrojos[TransferBufferKeys.RB1_BLISTER_DELAY
					.ordinal()]) {

			}
			break;
		case RB1_CAKE_DELAY:
			synchronized (_cerrojos[TransferBufferKeys.RB1_CAKE_DELAY.ordinal()]) {

			}
			break;
		case RB1_STATE:
			synchronized (_cerrojos[TransferBufferKeys.RB1_STATE.ordinal()]) {
				_statesAutRob[3] = (Boolean) o;
			}
			break;
		case RB2_BLISTER_DELAY:
			synchronized (_cerrojos[TransferBufferKeys.RB2_BLISTER_DELAY
					.ordinal()]) {

			}
			break;
		case RB2_STATE:
			synchronized (_cerrojos[TransferBufferKeys.RB2_STATE.ordinal()]) {
				_statesAutRob[4] = (Boolean) o;
			}
			break;

		default:
			break;
		}

	}

	public boolean is_cintaPasteles() {
		return _cintaPasteles;
	}

	public boolean is_cintaBlister() {
		return _cintaBlister;
	}

	public boolean is_cintaMontaje() {
		return _cintaMontaje;
	}

	public int get_brazoMontaje() {
		return _brazoMontaje;
	}

	public boolean is_brazoDesechar() {
		return _brazoDesechar;
	}

	int[] get_pasteles() {
		int[] ret = new int[_pasteles.length];

		synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS1.ordinal()]) {
			ret[0] = _pasteles[0];
		}
		synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS2.ordinal()]) {
			ret[1] = _pasteles[1];
		}
		synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS3.ordinal()]) {
			ret[2] = _pasteles[2];
		}
		synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS4.ordinal()]) {
			ret[3] = _pasteles[3];
		}
		synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS5.ordinal()]) {
			ret[4] = _pasteles[4];
		}
		synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS6.ordinal()]) {
			ret[5] = _pasteles[5];
		}
		synchronized (_cerrojos[TransferBufferKeys.AU1_CAKES_POS7.ordinal()]) {
			ret[6] = _pasteles[6];
		}

		return ret;
	}

	public int[] get_blisters() {
		_blisters[0] = 4;
		_blisters[1] = 4;
		_blisters[2] = 4;
		_blisters[3] = 4;
		_blisters[4] = 4;
		return _blisters;
	}

	public int[] get_paquetes() {
		_paquetes[0] = 6;
		_paquetes[1] = 6;
		_paquetes[2] = 6;
		_paquetes[3] = 6;
		return _paquetes;
	}

	public boolean isStarted(ElementsGroupModelEnum egme) {
		boolean ret = false;
		switch (egme) {
			case CINTA1:
				synchronized (_cerrojos[TransferBufferKeys.AU1_STATE.ordinal()]) {
					ret = _statesAutRob[0];
				}
				break;
			case CINTA2:
				synchronized (_cerrojos[TransferBufferKeys.AU2_STATE.ordinal()]) {
					ret = _statesAutRob[1];
				}	
				break;
			case CINTA3:
				synchronized (_cerrojos[TransferBufferKeys.AU3_STATE.ordinal()]) {
					ret = _statesAutRob[2];
				}
				break;
			case ROBOT1:
				synchronized (_cerrojos[TransferBufferKeys.RB1_STATE.ordinal()]) {
					ret = _statesAutRob[3];
				}
				break;
			case ROBOT2:
				synchronized (_cerrojos[TransferBufferKeys.RB2_STATE.ordinal()]) {
					ret = _statesAutRob[4];
				}
				break;
		}

		return ret;
	}

}
