import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class ControlOK implements ActionListener {
	JButton j;

	public ControlOK(JButton b) {
		j = b;
	}

	public void actionPerformed(ActionEvent e) {
		if(j.getText().equals("OK"))
			j.setText("KO");
		else
			j.setText("OK");
	}

}