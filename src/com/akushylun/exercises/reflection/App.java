package com.akushylun.exercises.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
	    IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	Car truck = new Truck("mercedes", 8, 350, 1000);
	Class clazz = truck.getClass();

	for (java.lang.reflect.Method method : clazz.getMethods()) {
	    if (method.isAnnotationPresent(CallMe.class)) {
		System.out.println(method.getName() + " " + method.invoke(truck));
	    }
	}

	Class[] interfaces = clazz.getInterfaces();
	for (Class interf : interfaces) {
	    System.out.println("interface name " + interf.getName());
	    Field[] fields = interf.getFields();
	    for (Field field : fields) {
		System.out.println(
			field.getName() + " " + Modifier.toString(field.getModifiers()) + " " + field.getAnnotations());
	    }

	}
    }

}
