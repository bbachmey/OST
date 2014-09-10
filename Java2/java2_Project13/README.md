Create a new project named java2_Project13 in your Java2_Homework working set.

You may only use while(){ } or do{ }while() loops for any loops in this project.

Create a Java class named Student that extends Object.

The Student class should have instance variables (with getters and setters) for a student's last name (String), first name (String), student id number (int), an array for up to 15 project scores that are represented as double values, named "projects," and an array for up to 10 quiz scores that are represented as double values, named "quizzes."

There should be no getters or setters for the arrays themselves. They should not be accessible from outside of this class without going through the other methods of the class. The getters and setters described in 5 and 6 below indicate getting and setting specific contents of the arrays, not the array objects themselves.

The constructor of the Student class should take the student's last and first name and a student id as parameters and set the instance variables to those values. It should also instantiate the arrays to their size. There should be no console I/O in the Student class unless it is in the main method or a private static method called by the main method. The constructor should initialize all elements of the arrays to -1.0 to indicate there is no score in that element yet.

Create setProjectScore() and setQuizScore() methods for the arrays. These should only take a double as a parameter and an int as a project or quiz number. These methods should return a boolean to indicate success or failure, depending on if the project or quiz number is out of the bounds of the array. The setProjectScore() and setQuizScore() methods will place the double value into the project or quiz number index of its respective array.

Create getProjectScore() and getQuizScore() methods for the arrays. These methods will return a double value. These will take an index parameter, representing the project or quiz number to return. They will return the value stored at that index in the array. This method should return -1.0 if the array index is out of bounds. -1.0 is a common flag to indicate failure in methods that should only return non-negative floats or doubles. If the element in the array is a -1.0, that indicates there is no valid score in that slot and -1.0 should be returned as a failure code.

Create a method named getNextProjectIndex() that returns an int that gets the next index of the projects array that contains a -1.0. Find the next item in the projects array that contains a -1.0 and return that index of the array. This method should return -1 if the array is full. -1 is a common flag to indicate failure in methods that should only return non-negative integers.

Create a method named getNextQuizIndex() that returns an int that gets the next index of the quizzes array that contains a -1.0. Find the next item in the quizzes array that contains a -1.0 and return that index of the array. This method should return -1 if the array is full. 

There should be no getters for the arrays, since we don't want any outside program modifying their contents without going through the setProjectScore() and setQuizScore() methods.

You may add other methods as needed, such as a method to return the size of the projects and quizzes arrays. Keep in mind that any method you add that is not meant to be called from an outside class should be private.

Create a Java class, named Main, that has a main method. The main() method of the class is a tester. We will exercise the methods of the Student class to make sure they are working properly. Any console I/O must be in the main() method or a private static method called by the main method. This Main class is only there to test the functionality of your Student class. The Student class should not do any I/O to the console (debugging output is allowed but should be removed in the final product); only the Main class' main() method should interact with the console.

Instantiate a Student object in the main() method. You should not make local copies of the Student object's arrays in the main() method, but rather only access them via the object's methods. Remember, these requirements state that no getters for the arrays in Student are allowed.

Try to display the student's information to the console. Use a loop to get project and quiz scores from the student object. This will test your code to make sure it handles a student with no project or quiz scores.

Fill the projects and quizzes for this student. Use the getNextProjectIndex() and getNextQuizIndex() methods to find the indexes in which to add the scores.

Try to go out of bounds to add a project and a quiz to the student to test the ability of the Student class's methods to handle full arrays.

Once full, display the student's information to the console. Use a loop to get project and quiz scores from the student object.
Run, debug, run, etc. as needed

Submit the project java2_Project13 when complete.