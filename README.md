

# 0. 写在前面

代码仓库：[个人项目-论文查重](https://github.com/xpt030610/3121005314)

| 这个作业属于哪个课程 | [计科21级34班](https://edu.cnblogs.com/campus/gdgy/CSGrade21-34) |
| -------------------- | ------------------------------------------------------------ |
| 这个作业要求在哪里   | [个人项目-论文查重](https://edu.cnblogs.com/campus/gdgy/CSGrade21-34/homework/13023) |
| 这个作业的目标       | 设计一个论文查重算法，给出一个原文文件和一个抄袭版论文的文件，在答案文件中输出其重复率并进行测试 |

# 1. 需求

## 1.1 编码要求

1. 在Github仓库中新建一个**学号为名**的文件夹。
2. 在开始实现程序之前，在PSP表格[附录2]记录下你估计在程序开发各个步骤上耗费的时间，在你实现程序之后，在PSP表格记录下你在程序的各个模块上实际花费的时间。
3. 使用C++ 、Java语言或者python3实现，提交python代码时请附带上requirements.txt。C++请使用Visual Studio Community 2017进行开发，运行环境为64-bit Windows 10。对于C++/Java，还需将编译好的程序发布到Github仓库中的releases中
4. 提交的代码要求经过Code Quality Analysis工具的分析并消除所有的警告。
5. 完成项目的首个版本之后，请使用性能分析工具Studio Profiling Tools来找出代码中的性能瓶颈并进行改进。
6. 使用Github[附录3]来管理源代码和测试用例，**代码有进展即签入Github**。签入记录不合理的项目会被助教抽查询问项目细节。
7. 使用单元测试[附录4]对项目进行测试，并使用插件查看测试分支覆盖率等指标；写出至少10个测试用例确保你的程序能够正确处理各种情况。

## 1.2 需求

1. 题目：**论文查重**

2. 描述如下：

- 设计一个论文查重算法，给出一个**原文文件**和一个在这份原文上经过了**增删改的抄袭版论文的文件**，在答案文件中输出其**重复率**。
  - 原文示例：今天是星期天，天气晴，今天晚上我要去看电影。
  - 抄袭版示例：今天是周天，天气晴朗，我晚上要去看电影。

- 要求输入输出采用文件输入输出，规范如下：
  - 从**命令行参数**给出：论文原文的文件的**绝对路径**。
  - 从**命令行参数**给出：抄袭版论文的文件的**绝对路径**。
  - 从**命令行参数**给出：输出的答案文件的**绝对路径**。

- 我们提供一份样例，课堂上下发，上传到班级群，使用方法是：orig.txt是原文，其他orig_add.txt等均为抄袭版论文。

3. 注意：答案文件中输出的答案为浮点型，精确到小数点后两位

## 1.3 开发环境

- 编译语言：Java 17
- IDE：Intellij IDEA 2021
- 单元测试：JUnit 4.12
- 性能分析工具：JProfiler 9.2

## 1.4 PSP表格（开发前）

| PSP2.1                                | Personal Software Process Stages      | 预估耗时(分钟) |
| :------------------------------------ | :------------------------------------ | :------------- |
| **Planning**                          | **计划**                              | 40             |
| Estimate                              | 估计这个任务需要多少时间              | 40             |
| **Development**                       | **开发**                              | 770            |
| Analysis                              | 需求分析 (包括学习新技术)             | 200            |
| Design Spec                           | 生成设计文档                          | 30             |
| Design Review                         | 设计复审                              | 40             |
| Coding Standard                       | 代码规范 (为目前的开发制定合适的规范) | 50             |
| Design                                | 具体设计                              | 120            |
| Coding                                | 具体编码                              | 240            |
| Code Review                           | 代码复审                              | 30             |
| Test                                  | 测试（自我测试，修改代码，提交修改）  | 40             |
| **Reporting**                         | **报告**                              | 240            |
| Test Repor                            | 测试报告                              | 60             |
| Size Measurement                      | 计算工作量                            | 60             |
| Postmortem & Process Improvement Plan | 测试报告                              | 60             |
| Test Repor                            | 事后总结, 并提出过程改进计划          | 60             |
|                                       | **合计**                              | 1050           |

# 2.模块设计

## 2.1设计流程图示

![image-20230915150837878](https://raw.githubusercontent.com/xpt030610/myImage/main/image-20230915150837878.png)

## 2.2 代码结构

![image-20230915152118479](https://raw.githubusercontent.com/xpt030610/myImage/main/image-20230915152118479.png)

- 本项目主要依靠**simHash**实现查重功能（[simHash介绍](https://blog.csdn.net/qq_37857921/article/details/108875990)）

## 2.3 关键代码举例

main关键代码：

```java
String article1=null;
String article2=null;
char[] chs=new char[1024];
int len;
BufferedReader br = new BufferedReader(new FileReader(s1));
while ((len= br.read(chs))!=-1){
    article1= new String(chs,0,len);
}
br = new BufferedReader(new FileReader(s2));
while ((len= br.read(chs))!=-1){
    article2= new String(chs,0,len);
}
br.close();
long l3 = System.currentTimeMillis();
SimHash hash1 = new SimHash(article1, 64);
SimHash hash2 = new SimHash(article2, 64);
```

simHash关键代码：

```java
String article1=null;
char[] chs=new char[1024];
int len;
BufferedReader br = new BufferedReader(new FileReader(s1));
while ((len= br.read(chs))!=-1){
    article1= new String(chs,0,len);
}
br.close();
SimHash simHash=new SimHash(article1);
System.out.println("结果为："+simHash.getSemblance(simHash));
```

## 2.4 性能分析

### 2.4.1 概览

![image-20230915154047303](https://raw.githubusercontent.com/xpt030610/myImage/main/image-20230915154047303.png)

### 2.4.2 实时内存

![image-20230915154122831](D:/Typora/Typora/upload/image-20230915154122831.png)

### 2.4.3 线程历史

![image-20230915154200801](https://raw.githubusercontent.com/xpt030610/myImage/main/image-20230915154200801.png)

### 2.4.4 总结

从这里可以看出，首先最频繁调用的是**int数组**。这是因为**SimHash算法**的底层需要大量调用int数组作为容器来**封装文章的句子**。其次，调用频率较高的是**hankcs包中的工具类**，这些工具类主要用于SimHash算法的分词和计算操作。

可以通过以下方面来优化：

1. **优化数据结构和算法**：检查SimHash算法的实现是否可以使用其他数据结构或算法来减少对int数组的调用次数，从而提高效率。
2. **内存管理和优化**：确保在使用大量int数组时进行有效的内存管理，避免内存泄漏或不必要的内存占用。
3. **代码优化和缓存**：检查SimHash算法的代码是否可以进行优化，减少对int数组的重复调用。另外，你可以考虑使用缓存技术来存储已经计算过的结果，避免重复计算。
4. **并行计**算：如果可能的话，考虑将SimHash算法中的一些计算任务并行化，以提高整体的执行效率。
5. **使用更高效的工具类**：评估hankcs包中的工具类的性能和效率，如果有更高效的替代方案，可以考虑切换到其他更适合的工具类。

# 3. 测试

## 3.1 simHash测试

![](https://raw.githubusercontent.com/xpt030610/myImage/main/image-20230915154943727.png)

## 3.2 main测试

![image-20230915155002973](https://raw.githubusercontent.com/xpt030610/myImage/main/image-20230915155002973.png)

## 3.3 测试结果

程序能够正确处理各种情况，测试结果均与预期相同，且代码覆盖率均为100%

# 4. 写在最后

## 4.1 PSP表格（开发后）

| PSP2.1                                | Personal Software Process Stages      | 预估耗时(分钟) | 实际耗时(分钟) |
| ------------------------------------- | ------------------------------------- | -------------- | -------------- |
| **Planning**                          | **计划**                              | 40             | 30             |
| Estimate                              | 估计这个任务需要多少时间              | 40             | 30             |
| **Development**                       | **开发**                              | 770            | 730            |
| Analysis                              | 需求分析 (包括学习新技术)             | 200            | 160            |
| Design Spec                           | 生成设计文档                          | 30             | 60             |
| Design Review                         | 设计复审                              | 40             | 60             |
| Coding Standard                       | 代码规范 (为目前的开发制定合适的规范) | 50             | 30             |
| Design                                | 具体设计                              | 120            | 60             |
| Coding                                | 具体编码                              | 240            | 260            |
| Code Review                           | 代码复审                              | 30             | 60             |
| Test                                  | 测试（自我测试，修改代码，提交修改）  | 40             | 40             |
| **Reporting**                         | **报告**                              | 240            | 200            |
| Test Repor                            | 测试报告                              | 60             | 30             |
| Size Measurement                      | 计算工作量                            | 60             | 50             |
| Postmortem & Process Improvement Plan | 测试报告                              | 60             | 60             |
| Test Repor                            | 事后总结, 并提出过程改进计划          | 60             | 60             |
|                                       | **合计**                              | 1050           | 960            |

## 4.2 项目总结

- 在本项目中，我们设计了一个论文查重算法，该算法能够检测给定的原文文件和经过增删改的抄袭版论文文件之间的重复率，并将结果输出到指定的答案文件中。
- 我们的算法采用了文件输入输出的方式进行操作。通过命令行参数，我们接收了原文文件路径、抄袭版论文文件路径以及答案文件路径作为输入。这种设计使得算法的使用更加灵活和方便。
- 算法的核心思想是对原文和抄袭版论文进行文本分词，并计算它们之间的相似度。我们使用了基于文本相似度的算法，通过比较原文和抄袭版论文中的词语、句子等元素，来判断它们之间的重复程度。
- 在我们提供的样例中，我们使用了原文文件（orig.txt）以及多个抄袭版论文文件（orig_add.txt等）。通过运行算法，我们得到了每个抄袭版论文文件与原文之间的重复率，并将结果精确到小数点后两位的浮点型数据保存在答案文件中。
- 总的来说，我们的论文查重算法能够准确地评估抄袭版论文与原文之间的重复率。通过这个项目，我们不仅提供了一种实用的工具，还深入了解了文本相似度计算的原理和方法。这个算法具有一定的实际应用价值，可以帮助人们发现论文抄袭行为，保护学术诚信。