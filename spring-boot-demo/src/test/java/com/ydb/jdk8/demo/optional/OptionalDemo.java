package com.ydb.jdk8.demo.optional;

import com.ydb.jdk8.demo.Apple;

import java.util.Optional;

/**
 * @Author ligeng
 * @Date 19/8/25
 * @Time 下午3:12
 */
public class OptionalDemo {
    public static void main(String[] args) {
        OptionalDemo demo = new OptionalDemo();
        demo.test1();
        demo.test2();
    }

    // 使用map从Optional对象中提取和转换值
    public void test1() {
        Apple apple = new Apple();
        apple.setColor("red");
        Optional<Apple> optApple = Optional.ofNullable(apple);
        Optional<String> color = optApple.map(Apple::getColor);
        System.out.println(color.get());
    }

    public void test2() {
        Person person = new Person(){{
            setCar(new Car(){{
                setInsurance(new Insurance(){{
                    setName("JAVA");
                }});
            }});
        }};

        Optional<Person> optPerson = Optional.of(person);
        Optional<String> name =
                optPerson.map(Person::getCar)
                        .map(Car::getInsurance)
                        .map(Insurance::getName);
        System.out.println(optPerson.map(Person::getCar));
//        System.out.println(optPerson.flatMap(Person::getCar));
    }

}
