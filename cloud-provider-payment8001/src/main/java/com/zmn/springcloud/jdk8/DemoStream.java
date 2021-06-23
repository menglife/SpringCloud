package com.zmn.springcloud.jdk8;

import org.apache.el.stream.Stream;

import java.util.Arrays;

public class DemoStream {
    String [] str = new String[10];
    Stream stream= (Stream) Arrays.stream(str);

}
