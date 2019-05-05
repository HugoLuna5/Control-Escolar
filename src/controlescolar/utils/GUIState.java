/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlescolar.utils;

/**
 *
 * @author hugoluna
 */


public class GUIState {

	private static final GUIState manager = new GUIState ();

	
	private GUITheme theme = GUITheme.LIGHT_THEME;

	private GUIState () {}

	public GUITheme getGUITheme () {
		return theme;
	}

	public void setGUITheme (GUITheme theme) {
		this.theme = theme;
		
	}

	public static GUIState getInstance () {
		return manager;
	}

	


	
}
