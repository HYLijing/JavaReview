package com.review.poly_;


public class PolyObject3 {
    public static void main(String[] args) {
        BB bb = new BB();   // 编译类型AA 运行类型BB

        // 我猜测：aa属于BB。instanceof属于运行时期的方法
        System.out.println(bb instanceof AA);
        System.out.println(bb instanceof BB);


        //aa 编译类型 AA, 运行类型是 BB
        // BB 是 AA 子类
        // 此时的aa在运行类型是BB，因此也是AA的类型。因为BB是AA的子类
        AA aa = new BB();
        System.out.println(aa instanceof AA);       // true
        System.out.println(aa instanceof BB);       // true

    }
}


class AA {

}

class BB extends AA {
}