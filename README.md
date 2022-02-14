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