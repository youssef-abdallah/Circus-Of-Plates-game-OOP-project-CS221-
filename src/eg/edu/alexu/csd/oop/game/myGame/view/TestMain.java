package eg.edu.alexu.csd.oop.game.myGame.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.myGame.controller.startegy.Hard;
import eg.edu.alexu.csd.oop.game.myGame.controller.startegy.Easy;
import eg.edu.alexu.csd.oop.game.myGame.controller.startegy.Moderate;
import eg.edu.alexu.csd.oop.game.myGame.model.CircusOfPlates;

public class TestMain {
	private static CircusOfPlates circus;
	private static GameController gameController;

	public static void main(String[] args) {
		circus = new CircusOfPlates(1500, 800);
		new Hard(circus);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		JMenuItem resumeMenuItem = new JMenuItem("Resume");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		JMenuItem loadMenuItem = new JMenuItem("Load");
		JMenu difficultySubmenu = new JMenu("Choose difficulty");
		JMenuItem easy = new JMenuItem("Easy");
		JMenuItem moderate = new JMenuItem("Moderate");
		JMenuItem hard = new JMenuItem("Hard");
		difficultySubmenu.add(easy);
		difficultySubmenu.add(moderate);
		difficultySubmenu.add(hard);
		menu.add(newMenuItem);
		menu.addSeparator();
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menu.add(saveMenuItem);
		menu.add(loadMenuItem);
		menu.add(difficultySubmenu);
		menuBar.add(menu);
		gameController = GameEngine.start("test", circus, menuBar, Color.BLACK);
		newMenuItem.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
				gameController.changeWorld(new CircusOfPlates(1500, 800));
			}
		});
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
				circus = new CircusOfPlates(1500, 800);
				new Easy(circus);
				gameController = GameEngine.start("test", circus, Color.BLACK);
			}
		});
		moderate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				circus = new CircusOfPlates(1500, 800);
				new Moderate(circus);
				System.out.println(circus.getSpeed());
				gameController.changeWorld(circus);
			}
		});
		hard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				circus = new CircusOfPlates(1500, 800);
				new Hard(circus);
				gameController = GameEngine.start("test", circus, Color.BLACK);
			}
		});
	}
	
}
