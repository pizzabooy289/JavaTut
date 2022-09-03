# JavaTut

<p style="color:green; font-size:60px;">Cheat Sheet</p>


## Concurrency

## Interface Class
An interface is a special kind of class that cannot be instantiated.The main idea of an interface is declaring functionality. Interfaces help to abstract from specific classes and emphasize the functionality. It makes software design more reusable and clean. Opposite to a class, an interface can extend several interfaces. A class can implement multiple interfaces.    

### Interface
```Java
interface Animal {
  public void animalSound(); // interface method (does not have a body)
}
```
### Implementation
Pig "implements" the Animal interface.            
```Java
class Pig implements Animal {
  public void animalSound() {
    // The body of animalSound() is provided here
    System.out.println("The pig says: wee wee");
  }
}
```

## ModifierTypes   

Access modifiers are those elements in code that determine the scope for that variable. As we know there are three access modifiers available namely public, protected, and private. Let us see the differences between Protected and Private access modifiers.        

Protected

The methods or variables declared as protected are accessible within the same package or different packages. By using protected keywords, we can declare the methods/variables protected.

## Thread
Java is a multi-threaded programming language which means we can develop multi-threaded program using Java. A multi-threaded program contains two or more parts that can run concurrently and each part can handle a different task at the same time making optimal use of the available resources specially when your computer has multiple CPUs.      

Following are the stages of the life cycle −

* **New** − A new thread begins its life cycle in the new state. It remains in this state until the program starts the thread. It is also referred to as a born thread.

* **Runnable** − After a newly born thread is started, the thread becomes runnable. A thread in this state is considered to be executing its task.

* **Waiting** − Sometimes, a thread transitions to the waiting state while the thread waits for another thread to perform a task. A thread transitions back to the runnable state only when another thread signals the waiting thread to continue executing.

* **Timed Waiting** − A runnable thread can enter the timed waiting state for a specified interval of time. A thread in this state transitions back to the runnable state when that time interval expires or when the event it is waiting for occurs.

* **Terminated (Dead)** − A runnable thread enters the terminated state when it completes its task or otherwise terminates.

## Serialization    
Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. This mechanism is used to persist the object.

# Abstract Methods and Classes
An abstract method can declared implementation or not. An abstract class cannot be instantiated.   

```Java
public abstract class Shape {

    public Shape() {}

    private String color;

   abstract public double area();

       public boolean isBlue(){
        return this.color.toUpperCase() == "BLUE";
    }

}
```
Square class extends the Shape class.

```Java
public class Square extends Shape {

     private double width = 0;
    private double length = 0;

    @Override
    public double area() {
        return this.width * this.length;
    }
}
```

# Collection Iterator

### Populate the collection

```Java
ArrayList<String> bandMembers = new ArrayList<String>();

bandMembers.add("Kurt Cobain");
bandMembers.add("Dave Grohl");  
bandMembers.add("Krist Novoselic");  
bandMembers.add("Pat Smear");
```

### Getting the iterator

```Java
Iterator<String> itr = bandMembers.iterator();
```
### Iterate the collection

```Java
while(itr.hasNext()){  
     System.out.println(itr.next());  
 }
```
### Remove element from collection
```Java
itr.remove();
```
# Default

Before Java 8, interfaces could have only abstract methods. The implementation of these methods has to be provided in a separate class. So, if a new method is to be added in an interface, then its implementation code has to be provided in the class implementing the same interface. To overcome this issue, Java 8 has introduced the concept of default methods which allow the interfaces to have methods with implementation without affecting the classes that implement the interface.   

```java
interface TestInterface
{
    // abstract method
    public void square(int a);

    // default method
    default void show()
    {
      System.out.println("Default Method Executed");
    }
}
```

# Enumerations    

```Java
public enum CarSize{
  SMALL(1), MEDIUM(2), LARGE(3), EXTRALARGE(4);

  private int size;

  CarSize(int size) {
    this.size = size;
  }

  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
```
### Methods

* <b>ordinal()</b> - returns the position of an enum constant
* <b>compareTo()</b> -  compares the enum constants based on their ordinal value.
* <b>toString()</b> - returns the string representation of the enum constants.
* <b>name()</b> - returns the defined name of an enum constant in string form. The returned value from the name() method is final.
* <b>valueOf()</b> - takes a string and returns an enum constant having the same string name.
* <b>values() </b> -  returns an array of enum type containing all the enum constants.

# Exception Handling

Java Exception Handling is a mechanism to handle runtime errors such as ClassNotFoundException, IOException, SQLException, RemoteException, etc.     

Exception is an unwanted or unexpected event, which occurs during the execution of a program, i.e. at run time, that disrupts the normal flow of the program's instructions.

# Functional Interfaces  

Java has forever remained an Object-Oriented Programming language. By object-oriented programming language, we can declare that everything present in the Java programming language rotates throughout the Objects, except for some of the primitive data types and primitive methods for integrity and simplicity. There are no solely functions present in a programming language called Java. Functions in the Java programming language are part of a class, and if someone wants to use them, they have to use the class or object of the class to call any function.     

A **functional interface** is an interface that contains only one abstract method. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods. **Runnable, ActionListener, Comparable** are some of the examples of functional interfaces.     

Functional Interface is additionally recognized as **Single Abstract Method Interfaces**. In short, they are also known as **SAM interfaces**. Functional interfaces in Java are the new feature that provides users with the approach of fundamental programming.     

Functional interfaces are included in Java SE 8 with Lambda expressions and Method references in order to make code more readable, clean, and straightforward. Functional interfaces are interfaces that ensure that they include precisely only one abstract method. Functional interfaces are used and executed by representing the interface with an **annotation called @FunctionalInterface**. As described earlier, functional interfaces can contain only one abstract method. However, they can include any quantity of default and static methods.      

In Functional interfaces, there is no need to use the abstract keyword as it is optional to use the abstract keyword because, by default, the method defined inside the interface is abstract only. We can also call Lambda expressions as the instance of functional interface.    

# Generic

Java Generic methods and generic classes enable programmers to specify, with a single method declaration, a set of related methods, or with a single class declaration, a set of related types, respectively.    

Generics also provide compile-time type safety that allows programmers to catch invalid types at compile time.

Using Java Generic concept, we might write a generic method for sorting an array of objects, then invoke the generic method with Integer arrays, Double arrays, String arrays and so on, to sort the array elements  

# Inner Classes
As with instance methods and variables, an inner class is associated with an instance of its enclosing class and has direct access to that object's methods and fields. Also, because an inner class is associated with an instance, it cannot define any static members itself.

Objects that are instances of an inner class exist within an instance of the outer class. Consider the following classes:

```Java
class OuterClass {
    ...
    class InnerClass {
        ...
    }
}
```

# Joda Time

The standard date and time classes prior to Java SE 8 are poor. By tackling this problem head-on, Joda-Time became the de facto standard date and time library for Java prior to Java SE 8. Note that from Java SE 8 onwards, users are asked to migrate to java.time (JSR-310) - a core part of the JDK which replaces this project.     

The design allows for multiple calendar systems, while still providing a simple API. The “default” calendar is the ISO8601 standard which is used by many other standards. The Gregorian, Julian, Buddhist, Coptic, Ethiopic and Islamic calendar systems are also included. Supporting classes include time zone, duration, format and parsing.   

## Here are some of our reasons for developing and using Joda-Time:

* Easy to Use. Calendar makes accessing ‘normal’ dates difficult, due to the lack of simple methods. Joda-Time has straightforward field accessors such as getYear() or getDayOfWeek().   

* Easy to Extend. The JDK supports multiple calendar systems via subclasses of Calendar. This is clunky, and in practice it is very difficult to write another calendar system. Joda-Time supports multiple calendar systems via a pluggable system based on the Chronology class.    

* Comprehensive Feature Set. The library is intended to provide all the functionality that is required for date-time calculations. It already provides out-of-the-box features, such as support for oddball date formats, which are difficult to replicate with the JDK.

* Up-to-date Time Zone calculations. The time zone implementation is based on global-tz, which is a fork of the original data provided by IANA. It is updated several times a year. New Joda-Time releases incorporate all changes made to this database. Should the changes be needed earlier, manually updating the zone data is easy.   

* Calendar support. The library provides 8 calendar systems.    

* Easy interoperability. The library internally uses a millisecond instant which is identical to the JDK and similar to other common time representations. This makes interoperability easy, and Joda-Time comes with out-of-the-box JDK interoperability.    

* Better Performance Characteristics. Calendar has strange performance characteristics as it recalculates fields at unexpected moments. Joda-Time does only the minimal calculation for the field that is being accessed.    

* Good Test Coverage. Joda-Time has a comprehensive set of developer tests, providing assurance of the library's quality.
Complete Documentation. There is a full User Guide which provides an overview and covers common usage scenarios. The javadoc is extremely detailed and covers the rest of the API.    

*  Maturity. The library has been under active development since 2002. It is a mature and reliable code base. A number of related projects are now available.    

* Open Source. Joda-Time is licenced under the business friendly Apache License Version 2.0.     

# Lambda
Lambda expressions are introduced in Java 8 and are touted to be the biggest feature of Java 8. Lambda expression facilitates functional programming, and simplifies the development a lot.

Syntax       
A lambda expression is characterized by the following syntax.
```
parameter -> expression body
```

## Example
```
MyMath.MathOperation addition = (int a, int b) -> a + b;
```

## Overriding   

In any object-oriented programming language, Overriding is a feature that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its super-classes or parent classes. When a method in a subclass has the same name, same parameters or signature, and same return type(or sub-type) as a method in its super-class, then the method in the subclass is said to override the method in the super-class.   

## Polymorphism
Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.

Like we specified in the previous chapter; Inheritance lets us inherit attributes and methods from another class. Polymorphism uses those methods to perform different tasks. This allows us to perform a single action in different ways.

For example, think of a superclass called Animal that has a method called animalSound(). Subclasses of Animals could be Pigs, Cats, Dogs, Birds - And they also have their own implementation of an animal sound (the pig oinks, and the cat meows, etc.):   

# Runnable Interface

### Why use Runnable
Although you have the ability to create new threads by using just the Thread class, which by itself implements the Runnable interface, the suggested and much more accepted approach is to use Runnable for all the logic that we want to provide for our threads. There are certain reasons for that:

* <b>Modularity:</b> When you run a thread and it finishes running, there is no way to restart it. This could lead to a lot of code duplication in case of multithreading, where you need a certain task to run a number of times. Fortunately, you can create a Runnable instance which can be reused in any number of threads.    


* <b>Ease of use:</b> Runnable only has one method, public void run(). It accepts no arguments and is as simple as possible. Thread has many methods that need to be taken into account making it very cumbersome to work with, and the extra overhead is always an issue.                 


* <b>Inheritance:</b> More often than not, you will have to use additional classes (through inheritance) to extend the functionality of your Runnable object. Java does not support multiple inheritance, so it is much more convenient to create a new class which just implements Runnable (and allows to extend another class) than creating a new class that extends Thread and prevents you from inheriting anything else.

## Stream   
 **Stream map(Function mapper)** returns a stream consisting of the results of applying the given function to the elements of this stream.   

Stream map(Function mapper) is an  **intermediate operation**. These operations are always lazy. Intermediate operations are invoked on a Stream instance and after they finish their processing, they give a Stream instance as output.

# References

## Concurrency

## Interface Class
* [Java Interface - w3schools](https://www.w3schools.com/java/java_interface.asp)

## ModifierTypes  
* [Protected vs Private Access Modifiers in Java- GeeksforGeeks](https://www.geeksforgeeks.org/protected-vs-private-access-modifiers-in-java/)

## Thread
* [Java - Multithreading - tutorialspoint](https://www.tutorialspoint.com/java/java_multithreading.htm)

## Serialization
* [Serialization and Deserialization in Java with Example - GeeksforGeeks](https://www.geeksforgeeks.org/serialization-in-java/)

## Abstract Methods and Classes
* [Java Abstraction - w3schools](https://www.w3schools.com/java/java_abstract.asp)

## Collection Iterator
* [A Guide to Iterator in Java - Baeldung](https://www.baeldung.com/java-iterator)

## Default   
* [Default Methods In Java 8 - GeeksforGeeks](https://www.geeksforgeeks.org/default-methods-java/)

## Enumerations
* [enum in Java - GeeksforGeeks](https://www.geeksforgeeks.org/enum-in-java/)
* [A Guide to Java Enums - Baeldung](https://www.baeldung.com/a-guide-to-java-enums)

## Exception Handling
* [Exceptions in Java](https://www.geeksforgeeks.org/exceptions-in-java)

## Functional Interfaces

* [Package java.util.function - Oracle Docs](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)  
* [Functional Interfaces in Java 8 - By Baeldung](https://www.baeldung.com/java-8-functional-interfaces)
* [Java Functional Interfaces - By Jenkov](https://jenkov.com/tutorials/java-functional-programming/functional-interfaces.html)
* [Java 8 Function Examples - Mkyong](https://mkyong.com/java8/java-8-function-examples/)


## Generic
* [Java - Generics - tutorialspoint](https://www.tutorialspoint.com/java/java_generics.htm)

## Inner Classes
* [Nested Classes - Oracle Docs](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#:~:text=it%20is%20used.-,Inner%20Classes,define%20any%20static%20members%20itself.)  

## Joda Time   
* [Joda Time - Joda Org ](https://www.joda.org/joda-time/)
    * [Available Time Zones - Joda Org ](https://www.joda.org/joda-time/timezones.html)
* [Introduction to Joda-Time - Baeldung](https://www.baeldung.com/joda-time)
* [JODA-Time - GeeksforGeeks](https://www.geeksforgeeks.org/joda-time/)

## Lambda  
* [Java 8 - Lambda Expressions - tutorialspoint](https://www.tutorialspoint.com/java8/java8_lambda_expressions.htm)
* [Java Lambda Expressions - Java T Point](https://www.javatpoint.com/java-lambda-expressions)
* [Java Lambda Expressions - Programiz ](https://www.programiz.com/java-programming/lambda-expression)

## Overriding
* [Overriding in Java - GeeksforGeeks](https://www.geeksforgeeks.org/overriding-in-java/)

## Polymorphism
* [Java Polymorphism - w3schools](https://www.w3schools.com/java/java_polymorphism.asp)

## Runnable Interface
* [Runnable interface in Java - GeeksforGeeks ](https://www.geeksforgeeks.org/runnable-interface-in-java/)

## Stream   
* [Stream map() in Java with examples - GeeksforGeeks ](https://www.geeksforgeeks.org/stream-map-java-examples/)

# Logs

## Concurrency

### assignmentTest
```
2022-07-31 17:31:04,836 INFO o.c.ConnectionPoolTest [main]
 ConnectionPool [myConn=[
 MyConnection [inUse=false, idNumber=1fc58ea1-2c97-4ea4-a59f-22371106014d],  
 MyConnection [inUse=false, idNumber=5d295db7-f4a9-44ff-9b17-c555397ac224],  
 MyConnection [inUse=false, idNumber=4ae4f096-2d8c-42e9-a5f3-fd953a899601]]]
2022-07-31 17:31:04,883 INFO o.c.ConnectionPoolTest [main]  *** START ***
2022-07-31 17:31:04,928 INFO o.c.ConnectionPoolTest [main]  *** END ***
```

### checkInConnectionTest
```
2022-07-31 17:33:54,198 INFO o.c.ConnectionPoolTest [main]
 ConnectionPool [myConn=[
 MyConnection [inUse=false, idNumber=d2a24ad8-f60f-404b-afaf-5080211ffcc0],  
 MyConnection [inUse=false, idNumber=a5d409a5-4cb2-41e0-b4e8-5baa0119aff3],  
 MyConnection [inUse=false, idNumber=552d2ff6-af66-4c48-ac71-f2a472b19ebb]]]
2022-07-31 17:33:54,211 INFO o.c.ConnectionPoolTest [main]  *** START ***
2022-07-31 17:33:54,215 INFO o.c.ConnectionPoolTest [main] New check out connection:  
 MyConnection [inUse=true, idNumber=d2a24ad8-f60f-404b-afaf-5080211ffcc0]
2022-07-31 17:33:54,216 INFO o.c.ConnectionPoolTest [main] Check back into the pool:  
 MyConnection [inUse=false, idNumber=d2a24ad8-f60f-404b-afaf-5080211ffcc0]
2022-07-31 17:33:54,216 INFO o.c.ConnectionPoolTest [main]  *** END ***
```

### checkOutConnectionTest

```
2022-08-01 10:53:22,672 INFO o.c.ConnectionPoolTest [main]
 ConnectionPool [myConn=[
 MyConnection [inUse=false, idNumber=6e669bc3-fbee-496f-b361-30a3b4f4f292],  
 MyConnection [inUse=false, idNumber=8841b3d8-54b6-4029-a469-48bf699fa234],  
 MyConnection [inUse=false, idNumber=4921a3ac-f4a7-45d5-bbfb-96195153c2ba]]]
2022-08-01 10:53:22,680 INFO o.c.ConnectionPoolTest [main]  *** START ***
2022-08-01 10:53:22,688 INFO o.c.ConnectionPool [main] checkOutConnection:  
 MyConnection [inUse=true, idNumber=6e669bc3-fbee-496f-b361-30a3b4f4f292]
2022-08-01 10:53:22,689 INFO o.c.ConnectionPoolTest [main] New check out connection:  
 MyConnection [inUse=true, idNumber=6e669bc3-fbee-496f-b361-30a3b4f4f292]
2022-08-01 10:53:22,689 INFO o.c.ConnectionPool [main] checkInConnection:  
 MyConnection [inUse=false, idNumber=6e669bc3-fbee-496f-b361-30a3b4f4f292]
2022-08-01 10:53:22,690 INFO o.c.ConnectionPoolTest [main] Check back into the pool:  
 MyConnection [inUse=false, idNumber=6e669bc3-fbee-496f-b361-30a3b4f4f292]
2022-08-01 10:53:22,690 INFO o.c.ConnectionPoolTest [main]  *** END ***
```

#### MainConcurrency

```
2022-08-01 10:51:46,861 INFO o.c.MainConcurrency [main]  *** START ***
2022-08-01 10:51:47,177 INFO o.c.MainConcurrency [main] Connection Pool: [Lorg.cusey.MyConnection;@18ece7f4
2022-08-01 10:51:47,177 INFO o.c.MainConcurrency [main]
 ConnectionPool [myConn=[
 MyConnection [inUse=false, idNumber=0d6800c6-12e6-43a6-9b91-ecc45889875b],  
 MyConnection [inUse=false, idNumber=80ba7ca9-6670-4a45-9175-943472a737b3],  
 MyConnection [inUse=false, idNumber=92f22309-1735-4620-8b77-ba75b2fd1112]]]
2022-08-01 10:51:47,178 INFO o.c.MainConcurrency [main]

2022-08-01 10:51:47,179 INFO o.c.MainConcurrency [main]  *** END ***
2022-08-01 10:51:47,179 INFO o.c.ConnectionPool [Thread-0] checkOutConnection:  
 MyConnection [inUse=true, idNumber=0d6800c6-12e6-43a6-9b91-ecc45889875b]
2022-08-01 10:51:47,180 INFO o.c.ConnectionPool [Thread-0] checkInConnection:  
 MyConnection [inUse=false, idNumber=0d6800c6-12e6-43a6-9b91-ecc45889875b]
2022-08-01 10:51:47,181 INFO o.c.ConnectionPool [Thread-1] checkOutConnection:  
 MyConnection [inUse=true, idNumber=0d6800c6-12e6-43a6-9b91-ecc45889875b]
2022-08-01 10:51:47,181 INFO o.c.ConnectionPool [Thread-1] checkInConnection:  
 MyConnection [inUse=false, idNumber=0d6800c6-12e6-43a6-9b91-ecc45889875b]
 ```

## Serialization

```
2022-07-31 23:56:30,457 INFO o.c.MainSerialization [main] *** SERIALIZATION ***
2022-07-31 23:56:30,478 INFO o.c.MainSerialization [main] Object Persisted
2022-07-31 23:56:30,478 INFO o.c.MainSerialization [main] *** Deserialization ***
2022-07-31 23:56:30,525 INFO o.c.MainSerialization [main] PersonDetails [name=hemanth, age=10, sex=Male]
2022-07-31 23:56:30,525 INFO o.c.MainSerialization [main] PersonDetails [name=bob, age=12, sex=Male]
2022-07-31 23:56:30,525 INFO o.c.MainSerialization [main] PersonDetails [name=Richa, age=10, sex=Female]
```

## ModifierTypes    

```
2022-07-31 22:47:31,419 INFO o.c.M.MainModifierTypes [main] *** MODIFIER TYPES ***
2022-07-31 22:47:31,422 INFO o.c.M.MainModifierTypes [main] --- Java Access Modifiers (Default) ---
2022-07-31 22:47:31,429 INFO o.c.M.D.Car [main] Truck Name: Minivan
2022-07-31 22:47:31,429 INFO o.c.M.MainModifierTypes [main] --- Java Access Modifiers (Protected) ---
2022-07-31 22:47:31,432 INFO o.c.M.P.Van [main] Truck Name: Sienna
```

## Thread
```
2022-07-31 17:13:02,757 INFO o.c.MainThread [main]  *** START ***
2022-07-31 17:13:02,767 INFO o.c.MainThread [main]  *** END ***
2022-07-31 17:13:02,767 INFO o.c.MainThread [Thread-0] Thread Name: Thread One
2022-07-31 17:13:02,769 INFO o.c.MainThread [Thread-0] Item add to the list: JOHN
2022-07-31 17:13:02,769 INFO o.c.MainThread [Thread-0] Element JOHN does not exist in list so added it to the list.
2022-07-31 17:13:02,769 INFO o.c.MainThread [Thread-0]

2022-07-31 17:13:02,770 INFO o.c.MainThread [Thread-3] Thread Name: Thread Four
2022-07-31 17:13:02,770 INFO o.c.MainThread [Thread-3] Item add to the list: TOM
2022-07-31 17:13:02,770 INFO o.c.MainThread [Thread-3] Element TOM does not exist in list so added it to the list.
2022-07-31 17:13:02,770 INFO o.c.MainThread [Thread-3]

2022-07-31 17:13:02,770 INFO o.c.MainThread [Thread-4] Thread Name: Thread Five
2022-07-31 17:13:02,771 INFO o.c.MainThread [Thread-4] Item add to the list: TOM
2022-07-31 17:13:02,771 INFO o.c.MainThread [Thread-4]

2022-07-31 17:13:02,772 INFO o.c.MainThread [Thread-2] Thread Name: Thread Three
2022-07-31 17:13:02,773 INFO o.c.MainThread [Thread-2] Item add to the list: JOHN
2022-07-31 17:13:02,773 INFO o.c.MainThread [Thread-2]

2022-07-31 17:13:02,774 INFO o.c.MainThread [Thread-1] Thread Name: Thread Two
2022-07-31 17:13:02,774 INFO o.c.MainThread [Thread-1] Item add to the list: JOHN
2022-07-31 17:13:02,774 INFO o.c.MainThread [Thread-1]
```
