package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	 int id = 125715;
            	 String apellido= "Fillottrani";
            	 String nombre= "Tomas";
            	 String mail="tomasfilotrani@gmail.com";
            	 String githubURL="https://github.com/FiloArg";
            	 String pathPhoto = "/images/fotoPer.png";
            	 
            	 Student Alumno =new Student(id,apellido,nombre,mail,githubURL,pathPhoto);
            	 SimplePresentationScreen mostrar= new SimplePresentationScreen(Alumno);
            	 mostrar.setVisible(true);
            	 
            	 
            	 
            }
        });
    }
}