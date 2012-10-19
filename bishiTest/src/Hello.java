

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import Reflect.Test;

class hello
{
	public static void main(String[] args)
	{
		/*
		 * Class<?> demo = null; try { demo = Class.forName("Reflect.Person"); }
		 * catch (Exception e) { e.printStackTrace(); }
		 * System.out.println("===============本类属性========================"); //
		 * 取得本类的全部属性 Field[] field = demo.getDeclaredFields(); for (int i = 0; i
		 * < field.length; i++) { // 权限修饰符 int mo = field[i].getModifiers();
		 * String priv = Modifier.toString(mo); // 属性类型 Class<?> type =
		 * field[i].getType(); System.out.println(priv + " " + type.getName() +
		 * " " + field[i].getName() + ";"); }
		 * System.out.println("===============实现的接口或者父类的属性========================"
		 * ); // 取得实现的接口或者父类的属性 Field[] filed1 = demo.getFields(); for (int j =
		 * 0; j < filed1.length; j++) { // 权限修饰符 int mo =
		 * filed1[j].getModifiers(); String priv = Modifier.toString(mo); //
		 * 属性类型 Class<?> type = filed1[j].getType(); System.out.println(priv +
		 * " " + type.getName() + " " + filed1[j].getName() + ";"); }
		 * 
		 * Class<?> demo = null; try { demo = Class.forName("Reflect.Person"); }
		 * catch (Exception e) { e.printStackTrace(); } try{
		 * //调用Person类中的sayChina方法 Method method=demo.getMethod("sayChina");
		 * method.invoke(demo.newInstance()); //调用Person的sayHello方法
		 * method=demo.getMethod("sayHello", String.class,int.class);
		 * method.invoke(demo.newInstance(),"Rollen",20);
		 * 
		 * }catch (Exception e) { e.printStackTrace(); }
		 * 
		 * Class<?> demo = null; Object obj=null; try { demo =
		 * Class.forName("Reflect.Person"); } catch (Exception e) {
		 * e.printStackTrace(); } try{ obj=demo.newInstance(); }catch (Exception
		 * e) { e.printStackTrace(); } setter(obj,"Sex","男",String.class);
		 * getter(obj,"Sex");
		
		// System.out.println(obj);
		Class<?> demo = null;
		Object obj = null;
		try
		{
			demo = Class.forName("Reflect.Person");
			obj = demo.newInstance();

			Field field = demo.getDeclaredField("sex");
			field.setAccessible(true);
			field.set(obj, "男");
			System.out.println(field.get(obj));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		 
		Test t=new Test();
        System.out.println("类加载器  "+t.getClass().getClassLoader().getClass().getName());
        */
	}

	/**
	 * @param obj
	 *            操作的对象
	 * @param att
	 *            操作的属性
	 * */
	public static void getter(Object obj, String att)
	{
		try
		{
			Method method = obj.getClass().getMethod("get" + att);
			System.out.println(method.invoke(obj));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @param obj
	 *            操作的对象
	 * @param att
	 *            操作的属性
	 * @param value
	 *            设置的值
	 * @param type
	 *            参数的属性
	 * */
	public static void setter(Object obj, String att, Object value, Class<?> type)
	{
		try
		{
			Method method = obj.getClass().getMethod("set" + att, type);
			method.invoke(obj, value);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}