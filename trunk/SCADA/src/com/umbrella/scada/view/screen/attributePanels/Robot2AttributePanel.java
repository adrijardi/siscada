package com.umbrella.scada.view.screen.attributePanels;

import com.umbrella.scada.controller.Action;
import com.umbrella.scada.controller.ActionFactoryProvider;
import com.umbrella.scada.controller.ActionKey;
import com.umbrella.scada.controller.ActionParams;
import com.umbrella.scada.controller.ActionResult;

/**
 * Clase que extiende AttributePanel recogiendo los valores para el robot 2
 * @author Umbrella.Soft
 * @version 1.0
 *
 */
public class Robot2AttributePanel extends RobotAttributePanel {

	/**
	 * serial_id
	 */
	private static final long serialVersionUID = -3682365725960617956L;

	@Override
	public void refreshData() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public ActionParams getNewAttributes() {
		// No tiene sentido llamarlo para esta clase
		return null;
	}
	
	protected void setAcceptAction() {
		_acceptButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ActionParams params = new ActionParams();
				for (AttributePanel panel : _subPanels) {
					params.join(panel.getNewAttributes());
				}
				Action action = ActionFactoryProvider.getInstance().factoryMethod(ActionKey.UPDATE_ROBOT2, params);
				ActionResult result = action.execute();
				if (result != ActionResult.EXECUTE_CORRECT)
					System.out.println("Error al ejecutar la acción");
			}
		});
	}

}
