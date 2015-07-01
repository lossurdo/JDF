package com.jdf.swing.iface;

/**
 * Enum utilizada para fornecer atalhos de teclas para menu e traybar
 * @author lossurdo
 * @since 24/03/2009
 */
public enum Shortcut {
	F1("F1"),
	F2("F2"),
	F3("F3"),
	F4("F4"),
	F5("F5"), 
	F6("F6"), 
	F7("F7"), 
	F8("F8"), 
	F9("F9"), 
	F10("F10"), 
	F11("F11"), 
	F12("F12"), 
	DEFAULT("");
	
	private String value;

	private Shortcut(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
}
