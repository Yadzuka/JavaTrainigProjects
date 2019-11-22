package ru.operations;

import java.lang.annotation.*;
import java.util.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Description{
	String descr() default "Hello world!";
}
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface myAnno{
	String str();
	int i();
}

@Description(descr = "Testing Class for annotations")
@myAnno(str = "Test myAnno annotation", i = 5)
class Tst{
	
	@Description(descr = "Method one")
	@myAnno(str = "Hello method one!", i = 1)
	public void getThis() {
		
		String k = "Hello World!";
		
		System.out.println(k);
	}
	
}
@SuppressWarnings("Hello cannot be resolved to a type")
class PrTst extends Tst{
	public void getAnnotation() {
		myAnno ann = super.getClass().getAnnotation(myAnno.class);

		System.out.println(ann.i());
	}
}
class Enums{

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {	
		
		PrTst ts = new PrTst();
		
		ts.getAnnotation();
		
		Tst testingClass = new Tst();
		
		Annotation [] annotations = Tst.class.getAnnotations();
		
		for(Annotation n : annotations) {
			System.out.println(n);
		}
		System.out.println();
		
		Method m = testingClass.getClass().getMethod("getThis");
		annotations = m.getAnnotations();
		
		Annotation newAnn = annotations[0];
		Description annNew = m.getAnnotation(Description.class);
		Annotation [] br = Tst.class.getDeclaredAnnotations();
		for(Annotation an : br)
		System.out.println(an);
		
		System.out.println(annNew.descr());
		
		for(Annotation n : annotations) {
			System.out.println(n);
		}
	}


}
