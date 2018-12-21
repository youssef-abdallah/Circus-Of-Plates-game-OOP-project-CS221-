package eg.edu.alexu.csd.oop.game.myGame.controller.dynamicloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import eg.edu.alexu.csd.oop.game.myGame.model.shapes.Plate;

public class PlatesLoader implements Loader {
	private Loadable loadable;
	public PlatesLoader(Loadable loadable) {
		this.loadable = loadable;
	}

	@Override
	public void loadPlugin(String path) {
		try(JarFile jarFile = new JarFile(path);) {
			Enumeration<JarEntry> e = jarFile.entries();
			URL[] urls = { new URL("jar:file:" + path +"!/") };
			URLClassLoader cl = URLClassLoader.newInstance(urls);

			while (e.hasMoreElements()) {
			    JarEntry je = e.nextElement();
			    if(je.isDirectory() || !je.getName().endsWith(".class")){
			        continue;
			    }
			    // -6 because of .class
			    String className = je.getName().substring(0,je.getName().length() - 6);
			    className = className.replace('/', '.');
			    Class<?> c = cl.loadClass(className);
			    if (c.newInstance() instanceof Plate) {
			    	loadable.addSupportedClasses(c);
			    	loadable.setCurrentClass(c);
			    }

				}
			} catch(Exception e) {
				e.printStackTrace();
			}
	}

}
