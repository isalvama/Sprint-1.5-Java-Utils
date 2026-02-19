# Tasca S1 05

## Description

This project was created for academic purposes as part of the IT ACADEMY Java & Spring specialization. The focus of this task is to master **Java Utils**, specifically handling the File System (java.io), recursion, object serialization, and the use of configuration properties files.


## Techonologies

- Java 17+
- Gradle


## Project Structure
```
TascaS1.05/
src/
└── main/
    └── java/
        └── first_level/
            └── exercise1_2_3_4/
                ├── Ex1_2_3_4Main.java
                └── Listator.java
            └── exercise5/
                ├── Main.java
                └── User.java
        └── second_level/
            └── Main.java/
```

## Installation

1. Clone the repository: `git clone https://github.com/isalvama/tascaS1.05.git`
2. Navigate to the project directory: `cd TascaS1.05`
3. Build the project using Gradle: `./gradlew build`
4. Run the main exercises using: `./gradlew run`


## 💻 Terminal Command Guide

> **Note:** All commands must be executed from the source code root directory:  
> `cd /your/project/path/src/main/java`

### 📂 Exercises 1, 2, 3, and 4: Directory Management & TXT Files
This set of exercises allows you to list directories recursively, save the output to a `.txt` file, and read it back to the console.

*   **Compile the package:**
    ```bash
    javac first_level/exercise1_2_3_4/*.java
    ```

*   **Run (List + Write to TXT + Read):**
    ```bash
    # Syntax: java <package.MainClass> <directory_to_read> <output_file_path.txt>
    java first_level.exercise1_2_3.Ex1_2_3_4Main /Users/ines/Documents /Users/ines/output.txt
    ```

---

### 💾 Exercise 5: Object Serialization
This exercise saves a `User` object into a binary file (`.ser`) and then retrieves it to display the data in the console.

*   **Compile the package:**
    ```bash
    javac first_level/exercise5/*.java
    ```

*   **Run (Serialize and Deserialize):**
    ```bash
    # Syntax: java <package.MainClass> <directory_to_store_file/>
    java first_level.exercise5.Main /Users/ines/Documents/
    ```

---

## 💡 Terminal Tips for Mac Users

1.  **Automatic Paths:** You don't need to type long paths manually. Type the beginning of the command (e.g., `java first_level.exercise5.Main `) and then **drag and drop the folder** from Finder directly into the terminal. macOS will automatically paste the full path for you.
2.  **Handling Spaces:** If a folder name contains spaces, you must wrap the path in double quotes:
    `java first_level.exercise5.Main "/Users/ines/My Projects/"`
3.  **Verify Created Files:** You can check if the file was created successfully without leaving the terminal by using the `ls` command:
    ```bash
    ls -l /Users/ines/Documents/user.ser
    ```
4.  **Clean Up Old Classes:** If you want to delete all compiled `.class` files to start fresh:
    ```bash
    find . -name "*.class" -delete
    ```


## Concepts covered

- **File System Management**: Iterating, sorting, and identifying files and directories using the `java.io.File` class.
- **Recursion**: Implementing recursive algorithms to traverse deep directory structures.
- **I/O Streams**: Efficient reading and writing of text files using `BufferedReader` and `BufferedWriter`.
- **Date Formatting**: Displaying metadata like the last modification date using `SimpleDateFormat`.
- **Object Serialization**: Converting Java objects into byte streams (`Serializable`) to store them in `.ser` files and reconstructing them.
- **Resource Management**: Loading external configuration via `Properties` files and handling classpaths.


## First Level

### Ex 1, 2, 3 & 4: Directory Listing and File Persistence

#### Listator class
This is the core utility class for managing directory content. It includes three main functionalities:
- **getPathContentSorted**: A recursive method that explores a directory tree. It sorts all elements alphabetically and identifies them as either `(Directory)` or `(File)`, appending the last modification timestamp. For every directory found, it calls itself recursively to list its internal content, creating a hierarchical view.
- **writePathsInTxtFile**: Captures the output of the recursive listing and saves it into a specified `.txt` file using `BufferedWriter`.
- **readPathsInTxtFile**: Reads and prints the content of a generated text file to the console using `BufferedReader`.

#### Ex1_2_3_4Main class
The entry point to test the recursive listing. It triggers the `Listator` methods to display, save, and read the directory structure.

### Ex 5: Object Serialization

#### User class
A model class that implements the `Serializable` interface. This allows instances of `User` (containing `id`, `userName`, `isPremium`, and `points`) to be converted into a format that can be saved to disk.

#### Main (Serialization) class
Demonstrates the serialization process:
1. **Serialization**: Uses `ObjectOutputStream` to save a `User` object into a file named `user.ser`.
2. **Deserialization**: Uses `ObjectInputStream` to read the `.ser` file and reconstruct the original `User` object, verifying the data integrity by printing the result to the console.
3. **Dynamic Pathing**: Utilizes the ClassLoader to determine the execution path dynamically, ensuring the serialized file is created in the correct build directory.


## Second Level

### Ex 1: External Configuration via Properties

#### Main (Properties) class
This level enhances the `Listator` utility by removing "hardcoded" paths.
- **app.properties**: An external file located in the resources folder that defines the `input.directory` (the folder to scan) and the `output.file` (where the list will be saved).
- **Properties Logic**: The program loads this file using the `Properties` class, allowing the user to change the program's behavior without modifying or recompiling the Java code. It integrates the `Listator` logic to execute the directory scan based on these external settings.