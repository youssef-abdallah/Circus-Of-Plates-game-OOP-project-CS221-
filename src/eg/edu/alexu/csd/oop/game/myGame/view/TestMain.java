package eg.edu.alexu.csd.oop.game.myGame.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.myGame.controller.startegy.Hard;
import eg.edu.alexu.csd.oop.game.myGame.controller.memento.Memento;
import eg.edu.alexu.csd.oop.game.myGame.controller.startegy.Easy;
import eg.edu.alexu.csd.oop.game.myGame.controller.startegy.Moderate;
import eg.edu.alexu.csd.oop.game.myGame.model.CircusOfPlates;

public class TestMain {
	private static CircusOfPlates circus, newCircus;
	private static GameController gameController;
	private static Memento memento;
	private static JMenuBar menuBar;
	
	public static void main(String[] args) {
		circus = new CircusOfPlates(1500, 800);
		new Hard(circus);
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		JMenuItem resumeMenuItem = new JMenuItem("Resume");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		JMenuItem loadMenuItem = new JMenuItem("Load");
		JMenu difficultySubmenu = new JMenu("Choose difficulty");
		JMenuItem easy = new JMenuItem("Easy");
		JMenuItem moderate = new JMenuItem("Moderate");
		JMenuItem hard = new JMenuItem("Hard");
		JMenuItem loadPluginMenuItem = new JMenuItem("Load Plugin");
		difficultySubmenu.add(easy);
		difficultySubmenu.add(moderate);
		difficultySubmenu.add(hard);
		menu.addSeparator();
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menu.add(saveMenuItem);
		menu.add(loadMenuItem);
		menu.add(difficultySubmenu);
		menu.add(loadPluginMenuItem);
		menuBar.add(menu);
		gameController = GameEngine.start("test", circus, menuBar, Color.BLACK);
		pauseMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				gameController.pause();
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
		easy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Easy(circus);
			}
		});
		moderate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Moderate(circus);
				System.out.println(circus.getSpeed());
			}
		});
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Hard(circus);
			}
		});
		saveMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				newCircus = circus.clone();
				circus.setState(newCircus);
				memento = circus.save();
			}
		});
		loadMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				circus.restore(memento);
				circus.setState(newCircus);
				memento = circus.save();
				gameController.changeWorld(circus);
			}
		});
		loadPluginMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setAcceptAllFileFilterUsed(false);
				if (fileChooser.showOpenDialog(menuBar) == JFileChooser.APPROVE_OPTION) {
					
				}
			}
		});
	}
	
}
