package com.gyw.函数式接口;
/**
 * 接口内有且只有一个抽象方法的接口
 * @author Administrator
 *
 */
@FunctionalInterface//校验：如果有第二个抽象方法，编译不通过
public interface DemoFunctionInterface2 {
	public abstract String[] method(String... s);
}
