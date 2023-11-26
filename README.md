# CodeHunter [Java 8] 蓝队工具

**基于污点分析和模拟栈帧技术的自动化代码审计**   ，  `仅做学习记录`

**测试环境：8.5.81**

# 特性

- PassthroughDiscovery 类性能比gadgetinspector的高 
- 将 FindEvilDiscovery 中的 visitMethodInsn 抽离出来,方便于扩展
- 增强检测能力
- 将污点源黑名单导出到一个文件中,使用fileUtils去读取,方便于扩展
- -info参数.会输出内容，能帮助人工辅助分析

# 使用方法

```md
基础用法:
-d "要扫描的tomcat路径"
-cp "tomcat依赖"
-del // 加此参数会自动删除恶意shell,不会删除可疑文件,可疑文件需要人工分析
-debug // 开启用户debug选项,会输出污点流方向
-info // 获取shell的各种信息,可以用于尝试获取shell的连接密码.建议单个分析shell

如：
java -cp JSPHunter.jar org.sec.Main -d D:\phpstudy_pro\Extensions\apache-tomcat-8.5.81\webapps\ROOT -cp D:\phpstudy_pro\Extensions\apache-tomcat-8.5.81\lib -del 

高级用法:
stainSource.txt为污点源文件,如果你发现新的污点源,可以手动添加到stainSource.txt,进而增强检测能力.

文件内容格式:
类 方法 方法参数和返回值 方法参数中能影响返回值的索引(0代表this,从1开始为方法参数)
如:
javax/servlet/http/HttpServletRequest	getParameter	(Ljava/lang/String;)Ljava/lang/String;	0,
```

# TODO

- 解决继承,实现接口能导致绕过的问题
- 增加检测能力:   检测bypass文件夹下的jsp webshell
- 设置导出结果名单 -o 参数
- 将Evil方法导出为文件,便于修改和扩展

# 源码编译可能遇到的问题

```md
1.编译后的jar包过大的问题:
	使用7-zip打开jar,进入com文件夹,然后将sum文件夹全部删除
	
2.反编译class文件:
	javap -c 	
```



# Refence

[code-inspector](https://github.com/4ra1n/code-inspector)

[Tomcat 6 --- 使用Jasper引擎解析JSP](https://www.cnblogs.com/xing901022/p/4592159.html)

[JSPKiller](https://github.com/changheluor007/JSPKiller)

[JSPFinder](https://github.com/flowerwind/JspFinder)

[使用ASM框架创建ClassVisitor时遇到IllegalArgumentException的一种可能解决办法](https://blog.csdn.net/fwhdzh/article/details/128694172)

[IDEA 错误 找不到或无法加载主类（完美解决）](https://blog.csdn.net/l_mloveforever/article/details/112725753)
