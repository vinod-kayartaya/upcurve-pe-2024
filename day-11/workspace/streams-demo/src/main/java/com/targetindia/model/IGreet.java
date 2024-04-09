package com.targetindia.model;

public interface IGreet {
    void hello();
    static void welcome(){}

    default void hi(){}

}
