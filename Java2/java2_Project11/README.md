In this project, create a class named PhoneBook that extends Object. This project contains another class, named Main, that will be used as an application to test your PhoneBook class. Your class should work with our Main class. Other than error messages generated within the code of the Main class output statements, no runtime or compile time errors are acceptable.

Objective: The PhoneBook class will be a simple phone book that will manage up to 10 names and phone numbers. This class will be able to be used by any other class, hence, it is neither an applet nor an application, but simply a complex data structure capable of managing its own data. Simply put, it is a class.

PhoneBook class minimum requirements:

No method should use hard numbers to indicate sizes. Use a constant (final) field so that the size of this data structure can be updated easily. (That is, we might want to use more than 10 names and numbers later.)
Two private instance variables that are String arrays. One array represents names and the other array represents phone numbers. The name at index 0 in the names array corresponds to the phone number in index 0 of the phoneNumber array. This is a logical linking of the two arrays that must be maintained by the class (you the programmer).
A constructor for the class. You should fill the arrays with data in this method.
A toString() method that returns a formatted string representation of the entire class. This method cannot use System.out.println() in keeping with the spirit of the toString() method inherited from Object. It is simply a String representation of the class. You should return all valid data in the class in some formatted way, such as name0\t\phonNumber0\nname1\tphoneNumber1\n ...
A setName() method that takes a String as a name and an int as an index number for parameters. Set the name array at index to equal the String parameter. Return true if the index is in bounds of the name array and the data was set. Return false if the index is out of bounds.
A setNumber() method that takes a String as a phone number and an int as an index number for parameters. Set the phoneNumber array at index to equal the String parameter. Return true if the index is in bounds of the phoneNumber array and the data was set. Return false if the index is out of bounds.
A getRecord() method that takes an index number of a record (array slot). Look up the record at that index in the name and phoneNumber arrays. Return a new String array with the record's name in element 0 and the person's phone number in element 1. If the index number is out of bounds or if the record contains no valid data, return null. This method returns either a two element String array or null.
A nextIndex() method returns the next index in the name array that contains null. If no element in the array is null, return -1 as a flag indicating there are no empty slots in the name array. This method can be used by another program to find the nextIndex() in the PhoneBook class where data may be stored without overwriting current data.
A getRecord() method that overloads your other getRecord() method. This method needs to take a String as a parameter that represents the name of a person you want to get the record of. It should return the index number of that record. Your search of the array should be case insensitive. There are methods in the String class that can help with this. Remember to check for a null value before trying to access data in the array element. Return -1 if the record is not found.
Main class minimum requirements:

The Main class has been included in the download of this project.

For extra learning, you can add other arrays to the mix, such as address, city, state, zip, or any other info. The indexes of each array should correspond to one person, though. You would have to modify your setInfo(), toString(), and getRecord methods accordingly.

You might want to also add a removeRecord() method to set a record to null. If you do, remember to overload it like you did the getRecord() method.

Expand the class in any way you see fit. Make it suit your needs. The concept here is that it is a utility class that can be used by any other class. It needs to maintain itself, via its methods. Other classes will tell it to do things for them.

Remember, if you change your PhoneBook class, you will have to adjust your Main class.

Run, debug, run, etc. as needed.