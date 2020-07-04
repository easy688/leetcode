package com.easy688.service;

/**
 * 逃逸分析demo
 */
public class ToTestService {
    public static void main(String[] args) {
        ToTestService testService=new ToTestService();
        testService.example();
    }
    public  void example() {
        Foo foo = new Foo();
        Bar bar = new Bar();
        bar.setFoo(foo);
    }
     class Foo {
    }

    class Bar {
        private Foo foo;
        public void setFoo(Foo foo) {
            this.foo = foo;
        }
    }


}