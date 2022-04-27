# Final Project

This is the final project for my CIS-171 Java course at Kirkwood Community College. Below is a journal of all the things I learned throughout the class.

## Introduction

In this week I set up Git, Github, Slack and some other stuff for class.

I also learned how to use Markdown. 
- \# to make a heading.
- \## to make a subheading, add more \# will make subheading smaller.
- Put "\_" or "\*" at beginning and the end to make text italic.
- Use "\__" or "\**" to make text bold.
- Use "\```" at beginning and end to make text look like code.

## Chapter 1

- In this chapter I learned about some simple Java program like how to output and input. 
`System.out.println("Hello, World!");`
- To ask user for input we need to do a little different with Python:
```Java
    Scanner sc = new Scanner(System.in);
    System.out.print("What is your age? ");
    int age = sc.nextInt();
    sc.close;
```
- Round off errors occur because storing decimal values in binary is not exact. In general, to avoid round off errors it is best to use the BigDecimal opens in new window class rather than the double data type. 

- If statement:
```Java
if (a<b) {
    System.out.println(a);
}
```
- For loop:
```Java
for(count = 0; count < 5; count = count+1) {
    System.out.println("This is count: " + count); 
}
```

## Chapter 2

**The math class**

Java provides a built-in Math opens in new window opens in new window class with many helpful methods. Common items include: 
- Math.PI
- Math.abs()
- Math.ceil() and Math.floor() 
- Math.max() and Math.min()
- Math.pow()
- Math.random()
- Math.round() 
- Math.sqrt()
- Math.hypot() 

**The char Data Type**

- A character must have single quotation marks around it to be assigned to the variable.
- Every character is represented by a decimal value between 0 and 127. Any of these int values can be assigned to a char variable and it will automatically be converted without the use of casting.

**Escape Characters**

Some characters are difficult to print because they are reserved for other things. To print them you need to add the backslash escape character. Escape characters in Java are basically the same as those in Python: 

   -  \'   print a single quotation mark
   -  \"   print a double quotation mark
   -  \\   print a single backslash
   -  \r   print a carriage return
   -  \n   print a new line
   -  \t   print a horizontal tab

**Variable Scope**

- Code blocks include if statements, loops, methods, and classes. Their code is enclosed inside opening { and closing } curly brackets.
- Any variable declared outside the curly brackets is considered to have a global scope.
- Any variable declared within the curly brackets is considered to have a local scope.
- Scopes can be nested, meaning an inner scope has access to all variables in its outer scope. 

**Logical Operators**

Logical operators in Java are the same as logical operators in Python.
   - < less than, <= less than or equal to, > greater than, >= greater than or equal to, == equal to, != not equal to.

## Chapter 3

**The if Statement**

Syntax:

```Java
if(ch == answer || ch - 32 == answer) {
    System.out.println("...Yes! It was " + answer + ".");
} else {
    System.out.println("...Sorry, the correct letter was " + answer + ".");
}
```

- To test equality of strings you CANNOT use two equal signs ==. Instead, you must use the `String` opens in new window class equals() method.
- There is also a `equalsIgnoreCase()` method that would allow the user's input to be in uppercase or lowercase. 

**The for Loop**

`for` loops require 3 parts, separated by semicolons: 
- Initialization: a variable declared and assigned a starting value.
- Condition: a boolean expression related to the initialization variable. If true, the loop runs. If false, the loop stops.
- Iteration: an expression that modifies the initialization variable.

```Java
for (int num = 1; num < 10; num++) {
    System.out.println(i);
}
```
- Note that when you declare and initialize a count variable in a for loop, the count variable has a scope local to the loop and cannot be accessed outside the loop. 
- For loops can also write as a infinite loop:
```Java
for (;;) {}
```

**The while Loop**

- A while loop can be written as a count controlled loop or infinite loop. 
- Count controlled while loops need an initializer, condition, and iteration just like a for loop. The initializer must be created before the loop. The condition must be in the parenthesis. The iteration must be inside the curly brackets. Do not use curly brackets inside the parenthesis.
```Java
int n = 1;
while (n < 10)
{
    System.out.println(n);
    n++;
}
```

- Do-while loops are while loops that execute at least once before the condition is tested.
- They can be useful to validate user input before allowing the program to continue.
```Java
System.out.print("Press a key (q to quit): ");
ch = (char) System.in.read();
while (ch != 'q') {
    System.out.print("\nPress a key (q to quit): ");
    ch = (char) System.in.read();
}
System.out.println();
```

**The break Statement and continue Statement**

- A break statement can be used to exit out of a loop before it has finished iterating.
```Java
int t = 0;
while (t < 100) {
    if (t == 10) {
        break; // terminate loop if t is 10
    }
    System.out.print(t + " ");
    t++;
}
```
- The continue statement is similar to the break statement. However, instead of exiting a loop completely, the continue statement will only exit the current iteration. The loop will continue with the next iteration.
```Java
for (int i = 0; i <= 100; i++) {
    if ((i % 2) != 0)
        continue; // iterate
    System.out.println(i);
}
```

## Chapter 4

**Creating Objects**

- Each object must be referenced by different variable names. 
- Both objects have the same attributes. They have different values associated with those attributes.
- The biggest takeaway: Classes are the data type, while objects are variables that have been initiated with that type.

```Java
class Vehicle {  
    int passengers; // number of passengers  
    int fuelcap;    // fuel capacity in gallons 
    double mpg;     // fuel consumption in miles per gallon 
}  
```

**Reference Variables and Assignment**

- Primitive types hold only one piece of data at a time.
- When you assign one primitive-type variable to another, the variable on the left receives a copy of the value of the variable on the right.
- Any change that you make to one primitive-type variable will not affect the value assigned to the other. Both variables are assigned different values.
- Class/Object types can hold more than one piece of data and have methods.
- When you assign one object-type variable to another, the variable on the left receives a reference to the value of the variable on the right.
- Any change that you make to one object-type variable will affect both variables that reference it. Both variables are assigned the same value.

**Methods**

- Anytime you find yourself repeating code, you should move that code to a method. Methods are similar to functions in Python.
- If the class is declared in a different file, methods must be declared with the public or private keyword. 
- In the main method we "call" the object's method by specifying the object name, a period, the method name, and a set of parenthesis.
- If the method required input parameters we would need to include input arguments in the parenthesis.
- Methods can also be added to the same class as the main method. Because the main method is "static", any other method declared in this class will also need to be declared "static".
- When a method returns a value, the data type of the value returned must be specified in the method signature instead of the void keyword.
- The method return type must match the variable type it is assigned to.
- The data types of the arguments must match the data types of the parameters.

**Constructors**

- A constructor is a method that has no return type. Its return type is always void.
- The name of the constructor must be the exact same as the class.
- If the class is created in a separate file, the keyword public must be included in the constructor's header/signature.

```Java
class MyClass { 
    int x; 

    MyClass() { 
        x = 10; 
    }  
    MyClass(int i) {
        this.x = i;
    }
}   
```
- Getter and setter in Java and C# very difference.
- Java:
```java
public int getNumerator() {
        return numerator;
}

public int getDenominator() {
        return denominator;
}
public void setNumerator(int numerator) {
        this.numerator = numerator;
}
public void setDenominator(int denominator) {
        this.denominator = denominator;
}
```
- In C#:
```c
public int Numerator(){get; set}

public int setDenominator() {get; set}
```

## Chapter 5

**Array**

- An array is a fixed-length collection of data. An array can hold many values.  Only data of that type will be allowed to be stored.
- A set of square brackets [] must be placed either after the data type specified or after the variable name.
```java
int[] n;
int n[];
```
- To assign any vaule to an array you can do like this:
```java
int[] n = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//OR
int[] n = new int[10];
```
- The size of the array can be determined by typing the name of the array and adding ".length".
```java
n.length // = 10
```

**Two-Dimensional Arrays**

- A 2-dimensional array is an array of arrays.
- The declaration requires 2 sets of square brackets after the data type or variable name.
```java
int[][] table;
int table [][];
//Both of these declarations will automatically assign 0 to each block.
//In C# you will do like this:
//int[,] table;
```
**Strings**

- The String opens in new window class in Java creates an immutable sequence of characters. Immutable means that it cannot be changed after its constructed/initialized.
```java
String str1 = new String("Java strings are objects.");
String str2 = "They are constructed various ways.";
```
- `str1` is an example of a string that is created with a constructor.
- `str2` is an example of a string that is created and initialized without a constructor.
- Assigning a String variable to another String variable creates two separate copies that are independent of each other.
- There are many useful methods in the String opens in new window class:
    - `length()` - Obtains the number of characters in a string.
    - `charAt(index)` - Finds a single character at a particular index position in a string.
    - `equals(str)` - Compares two strings for equality.
    - `equalsIgnoreCase(str)` - Compares two strings for equality, ignoring capitalization.
    - `compareTo(str)` - Compares two strings alphabetically. If the first comes alphabetically before the second the result is a negative number. If the first comes alphabetically after the second the result is a positive number. If the two are equal the result is 0.
    - `compareToIgnoreCase(str)` - Compares two strings alphabetically, ignoring capitalization.
    - `indexOf(str)` - Finds the starting index position of a sequence of characters in a string starting at the beginning of the string. If the value is not found the result is -1.
    - `lastIndexOf(str)` - Finds the starting index position of a sequence of characters in a string starting at the end of the string. If the value is not found the result is -1.
    - `toCharArray()` - converts the string into an array of characters. For-each loops don't work with strings, but they work with arrays.
    - `concat()` - An alternative to "+" concatenation.
    - `contains(str)` - returns true or false if a sequence of characters is in a string.
    - `replace()`, `replaceAll()` - Find and replace a sequence of characters in a string.
    - `split(str)` - Uses a delimiter to break a string into an array of strings.
    - `trim()` - returns the string with leading and trailing spaces removed.

**String Arrays**

- Arrays can contain objects such as Strings. They work the same as arrays of integers or other primitive data types.
- When looping through an array of Strings, be sure to know that the array uses `.length` and Strings use `.length()`.