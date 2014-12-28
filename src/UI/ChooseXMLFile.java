package UI;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ChooseXMLFile extends JFrame {

	JFileChooser chooser;
	File file=null;

	public ChooseXMLFile() {

		super("Choose XML File");



		chooser=new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setFileSelectionMode(JFileChooser.CUSTOM_DIALOG);

		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
			file= chooser.getSelectedFile();
		}
		else {
			JOptionPane.showMessageDialog(null,"No file Selected!");
			file=null;
		}

		setPreferredSize(new Dimension(200, 200));
		getContentPane().add(chooser,"Center");

	}

	public File getFile(){
		return file;
	}


}
