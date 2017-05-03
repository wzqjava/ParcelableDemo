package com.wzq.jiyun.testparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author:Created by WangZhiQiang on 2017/5/3.
 */

public class Student implements Parcelable {


    private String name;
    private int age;

    public Student(String s, int i) {
        name = s;
        age = i;
    }

    protected Student(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 内容描述接口，基本不用管
     * 重写describeContents方法，内容接口描述，默认返回0就可以
     *
     * @return
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 重写writeToParcel方法，将你的对象序列化为一个Parcel对象，即：将类的数据写入外部提供的Parcel中，
     * 打包需要传递的数据到Parcel容器保存，以便从 Parcel容器获取数据
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    /**
     * 实例化静态内部对象CREATOR实现接口Parcelable.Creator
     * 其中public static final一个都不能少，内部对象CREATOR的名称也不能改变，必须全部大写。
     * 需重写本接口中的两个方法：createFromParcel(Parcel in) 实现从Parcel容器中读取传递数据值，
     * 封装成Parcelable对象返回逻辑层，newArray(int size) 创建一个类型为T，长度为size的数组，
     * 仅一句话即可（return new T[size]），供外部类反序列化本类数组使用。
     */
    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
