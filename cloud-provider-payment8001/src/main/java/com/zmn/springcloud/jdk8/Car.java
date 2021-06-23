package com.zmn.springcloud.jdk8;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car {
    public interface Supplier<T>{
        T get();

    }
    public static Car create(final Supplier<Car> supplier){
        return supplier.get();
    }
    public static void collid(final  Car car){
        System.out.println("Collid"+  car.toString());
    }
    public void follow(final Car another){
        System.out.printf("Following the"+another.toString());


    }
    public void repair(){
        System.out.println("repair"+this.toString());
    }

    public static void main(String[] args) {
            Car car= Car.create(Car::new);//构造器引用
            Car car1=Car.create(Car::new);
            Car car2=Car.create(Car::new);
            Car car3=new Car();
        List<Car> cars= Arrays.asList(car,car1,car3);
        System.out.println("构造器引用=========");
        cars.forEach(Car::collid);
        System.out.println("静态方式引用=========");
        cars.forEach(Car::repair);
        System.out.println("特定类的任意对象的方法引用");
    }
    @Test
    public void test4(){

        List<Employee> lists= Arrays.asList(
                new Employee("张三",18,5555.55f),
                new Employee("李四",20,6666.66f),

                new Employee("王二",5,10000.55f),

                new Employee("麻子",40,50000.55f));

        Collections.sort(lists, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });
        for(Employee employee:lists){
            System.out.println(employee);
        }
    }

    public void  lambda(){
        List<Employee> lists= Arrays.asList(
                new Employee("张三",18,5555.55f),
                new Employee("李四",20,6666.66f),
                new Employee("王二",39,10000.53f),
                new Employee("王二",40,10000.54f),

                new Employee("麻子",41,50000.55f));
        Collections.sort(lists,(x,y)->Integer.compare(x.getAge(),y.getAge()));
        for(Employee employee:lists){
            if (employee.getName().startsWith("张")){  //以张开头
                System.out.println(employee);
            }


        }
        System.out.println("******************************");
        //流的获取Stream<Employee> stream=lists.stream()
        System.out.println("集合通过流过滤转成集合");
        List<Employee> employees=lists.stream().filter(employee -> employee.getAge()<=20).collect(Collectors.toList());//转集合
        System.out.println(employees);
        System.out.println("集合通过流根据name进行分组name作为key，集合或者对象作为值");
        Map<String, List<Employee>> empMap =lists.stream().collect(Collectors.groupingBy(Employee::getName));
        System.out.println(empMap.keySet());//获取key集合
        System.out.println(empMap.values());//获取值集合
        System.out.println(empMap);

        Stream<Employee> stream=lists.stream().filter(employee -> employee.getAge()>20).distinct().skip(2);//年龄大于20,去重，限制为2，跳过2个元素
//        stream.count();  流只能使用一次
        stream.forEach(System.out::println);
        //
        Stream<String> stream1 = Stream.of("张三","李四","王五");
        Stream<Integer> stream2 = Stream.of(1,2,3);
        String[] str = {"张三","李四","王五"};
        Stream<String > stream3 = Stream.of(str);
        Integer[] in = {1,2,3};
        Stream<Integer> stream4 = Stream.of(in);



    }
}
