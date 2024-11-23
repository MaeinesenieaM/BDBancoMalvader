package br.com.util;

import javax.swing.*;

public class PanelUtils {
	public static int getMiddleWidth(JFrame panel) {
		return panel.getBounds().width / 2;
	}
	
	public static int getMiddleHeight(JFrame panel) {
		return panel.getBounds().height / 2;
	}
	
	public static int getMiddleWidth(JPanel panel) {
		return panel.getBounds().width / 2;
	}
	
	public static int getMiddleHeight(JPanel panel) {
		return panel.getBounds().height / 2;
	}
}
