package com.review.io_.objectio;


import com.sun.tools.internal.ws.wsdl.document.Output;
import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 对象流ObjectInputStream/ObjectOutputStream
 * 他两本身是字节流，因为继承了InputStream/OutputStream
 * 包装的也是字节流，处理的是实现了Serializable
 * <p>
 * 关于ObjectInputStream和ObjectOutputStream的总结：
 * 1，写入和读取的顺行需要一直，因为写入内容是包含类型的，因此读取的时候需要使用执行的类型来读取
 * 2，要求序列化和反序列化对象，这样才能将对象写入和读取出来。需要实现Serializable
 * 3，序列化类建议添加SerialVersionUID，为了提高版本兼容性
 * 4，序列化对象时，默认将所有的属性都序列化，除了static和transient修饰的成员（类的5大成员：属性+方法+构造器+内部类+代码块）
 * 5，序列化对象时，如果属性也是一个对象类型，那么他也需要实现序列化，否则会报错:NotSerializableException
 * 6,序列化具备可继承性，也就是父类实现了序列化，子类就默认已经实现了序列化。可以参照一下Wrapper类（Integer）
 */
public class ObjectIO {

    String path = "/Users/yuanhaiyang/Document/object.dat";

    /**
     * 需求一：将int num = 10，写入到文件中。不是单纯的100，需要包含这个值的class类型
     */
    @Test
    public void test1() throws IOException {

        // 1.创建该对象的字节输出流
        OutputStream os = new FileOutputStream(path);
        // 2.创建操作对象的处理流
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeInt(100);
        oos.writeUTF("海洋");

        // 写入对象
        oos.writeObject(new Person(new Student(9), "haiyang", "30", "安徽"));

        // 写入对象

        System.out.println("写入完毕");

        oos.close();
    }

    /**
     * 这里有一个小坑：
     * 就是如果我写入的文件是object.txt，那么他会出现EOFException异常，需要使用dat文件来存储，不会出现问题
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        // 因为是通过Unicode编码写入的一种文本文件，因此不可以直接打开
        // 使用ObjectInputStream来读取文件中的内容
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);

        int res = ois.readInt();
        String name = ois.readUTF();
        Object o = ois.readObject();    // 编译类型Object，运行类型是Person

        System.out.println(res);
        System.out.println(name);
        System.out.println(o);

        ois.close();
    }
}

/**
 * 如果想要将一个对象写入到文件中，那么这个对象一定要支持序列化和反序列化，在java中也就是需要实现Serializable
 */
class Person implements Serializable {

    private static String address;

    private Student stu;

    private String name;
    private transient String age;       // 表示age不参与序列化


    public Person(Student stu, String name, String age, String address) {
        this.stu = stu;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "stu=" + stu +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ",address='" + address + '\'' +
                '}';
    }
}

class Student implements Serializable {

//    private SerialVersionUID serialVersionUIDAdder;

    private int level;

    public Student(int level) {
        this.level = level;
    }
}