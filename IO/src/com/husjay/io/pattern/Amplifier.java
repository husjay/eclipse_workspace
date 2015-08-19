package com.husjay.io.pattern;
/**
 * 装饰设计模式
 * 扩音器
 * 类于类之间的关系
 * 1 依赖：行参；局部变量
 * 2 关联：属性
 * 		聚合：属性 整体于部分 不一致的生命周期
 * 		组合：属性 整体与部分 一致的生命周期
 * 3 继承：父子关系
 * 4 实现：类与接口的关系
 * @author hsj
 *
 */
public class Amplifier {
	private Voice voice;

	
	public Amplifier() {
		super();
	}

	public Amplifier(Voice voice) {
		super();
		this.voice = voice;
	}
	
	public void say() {
		System.out.println((voice.getVoice() * 1000));
	}
}
