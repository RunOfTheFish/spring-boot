package com.example.three.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;

public interface Clibrary extends Library {

    /**
     * 动态链接库编译时选择的平台。如果通过x86平台编译，那么只能使用32位jdk环境加载，如果要使用64位jdk,必须使用x64平台编译。
     *
     * 接口内部需要一个公共静态常量：INSTANCE，通过这个常量，就可以获得这个接口的实例，从而使用接口的方法，也就是调用外部dll/so的函数。
     *	该常量通过Native.loadLibrary()PI函数获得，该函数有2个参数：
     *
     *	第一个参数是动态链接库dll/so的名称，但不带.dll或.so这样的后缀，这符合JNI的规范，因为带了后缀名就不可以跨操作系统平台了。
     *	搜索动态链接库路径的顺序是：先从当前类的当前文件夹找，如果没有找到，再在工程当前文件夹下面找win32/win64文件夹，
     *	找到后搜索对应的dll文件，如果 找不到再到WINDOWS下面去搜索，再找不到就会抛异常了。
     *	第二个参数是本接口的Class类型。JNA通过这个Class类型，根据指定的.dll/.so文件，动态创建接口的实例。
     *	该实例由JNA通过反射自动生成。
     *
     *	接口中只需要定义你要用到的函数或者公共变量，不需要的可以不定义，注数和返回值的类型，应该和链接库中的函数类型保持一致。
     *	定义好接口后，就可以使用接口中的函数即相应dll/so中的函数了
     */
    //加载链接库
    //如果本地类库不是线程安全的，可用Clibrary INSTANCE2 =  (Clibrary)Native.synchronizedLibrary("VIDEOMP4LIB",Clibrary.class);
    Clibrary INSTANCE = (Clibrary) Native.loadLibrary("AuthEncrypt", Clibrary.class);
    //链接库中对应的方法
    String encrypt(String one, String two);

}
