# Input-Output (IO) Operations

## Overview of Java IO API

The Java IO (Input/Output) API provides classes and interfaces for reading and writing data in Java. It is a fundamental part of Java programming for handling various types of input and output operations. The API is divided into two main categories: streams-based IO and file-based IO.

1. **Streams-based IO**:

   - Streams are a sequence of data elements accessed sequentially.
   - Java IO provides two types of streams: byte streams and character streams.
   - Byte streams (`InputStream` and `OutputStream`) are used for reading and writing binary data, like images or other non-textual data.
   - Character streams (`Reader` and `Writer`) are used for reading and writing text data, handling character encoding automatically.

2. **File-based IO**:
   - The `File` class represents a file or directory path.
   - Classes like `FileInputStream`, `FileOutputStream`, `FileReader`, and `FileWriter` are used for file-based IO operations.
   - These classes allow reading from and writing to files directly.

Here's a brief overview of commonly used classes and interfaces in the Java IO API:

- **InputStream**: Abstract class representing an input stream of bytes.
- **OutputStream**: Abstract class representing an output stream of bytes.
- **Reader**: Abstract class representing a reader of characters.
- **Writer**: Abstract class representing a writer of characters.
- **FileInputStream**: A subclass of `InputStream` that reads bytes from a file.
- **FileOutputStream**: A subclass of `OutputStream` that writes bytes to a file.
- **FileReader**: A subclass of `Reader` that reads characters from a file.
- **FileWriter**: A subclass of `Writer` that writes characters to a file.
- **BufferedInputStream** and **BufferedOutputStream**: Classes for buffering input and output streams for better performance.
- **BufferedReader** and **BufferedWriter**: Classes for buffering character input and output streams.
- **InputStreamReader** and **OutputStreamWriter**: Classes for converting bytes to characters and vice versa using specified character encodings.

Here's a simple example demonstrating how to use Java IO to read from a file and write to another file:

```java
import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt");
             FileOutputStream out = new FileOutputStream("output.txt")) {

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

In this example, `FileInputStream` is used to read bytes from the file "input.txt", and `FileOutputStream` is used to write bytes to the file "output.txt". The `try-with-resources` statement is used to automatically close the streams after the operation is completed or an exception is thrown.

## Working with streams: InputStream, OutputStream, Reader, Writer

Working with streams in Java involves dealing with various classes and interfaces, including InputStream, OutputStream, Reader, and Writer. These classes and interfaces provide the foundation for reading and writing data in Java applications. Let's delve into each of them:

1. **InputStream**:

   - InputStream is an abstract class representing an input stream of bytes.
   - It serves as the superclass for all classes representing input streams of bytes.
   - Subclasses of InputStream include FileInputStream, ByteArrayInputStream, and PipedInputStream, among others.
   - InputStream provides methods like read(), available(), close(), and mark(), which are commonly used for reading bytes from the input stream.

2. **OutputStream**:

   - OutputStream is an abstract class representing an output stream of bytes.
   - It serves as the superclass for all classes representing output streams of bytes.
   - Subclasses of OutputStream include FileOutputStream, ByteArrayOutputStream, and PipedOutputStream, among others.
   - OutputStream provides methods like write(), flush(), close(), and flush(), which are commonly used for writing bytes to the output stream.

3. **Reader**:

   - Reader is an abstract class representing a reader of characters.
   - It serves as the superclass for all classes representing character streams.
   - Subclasses of Reader include InputStreamReader, FileReader, and StringReader, among others.
   - Reader provides methods like read(), ready(), close(), and mark(), which are commonly used for reading characters from the input stream.

4. **Writer**:
   - Writer is an abstract class representing a writer of characters.
   - It serves as the superclass for all classes representing character streams.
   - Subclasses of Writer include OutputStreamWriter, FileWriter, and StringWriter, among others.
   - Writer provides methods like write(), flush(), close(), and append(), which are commonly used for writing characters to the output stream.

Now, let's see a simple example that demonstrates how to use InputStream and OutputStream to copy the content of one file to another:

```java
import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("input.txt");
             OutputStream outputStream = new FileOutputStream("output.txt")) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

In this example, we use FileInputStream to read bytes from the file "input.txt" and FileOutputStream to write bytes to the file "output.txt". We read data from the input stream into a buffer and then write the data from the buffer to the output stream. Finally, we close both streams using try-with-resources to ensure proper resource management.

## File input and output operations

File input and output operations in Java involve reading data from files and writing data to files. This is typically done using InputStream, OutputStream, Reader, and Writer classes in combination with classes like FileInputStream, FileOutputStream, FileReader, and FileWriter. Let's explore how to perform file input and output operations in Java:

1. **Reading from a File**:
   - Use FileInputStream or FileReader to read bytes or characters from a file.
   - Create an instance of FileInputStream or FileReader with the file path.
   - Read data from the stream using methods like read(byte[]), read(), or readLine().
   - Close the stream after reading is complete to release resources.

Example of reading from a file using FileInputStream:

```java
import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt")) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData); // Assuming input.txt contains text
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

2. **Writing to a File**:
   - Use FileOutputStream or FileWriter to write bytes or characters to a file.
   - Create an instance of FileOutputStream or FileWriter with the file path.
   - Write data to the stream using methods like write(byte[]), write(int), or write(String).
   - Close the stream after writing is complete to ensure data is flushed and resources are released.

Example of writing to a file using FileOutputStream:

```java
import java.io.*;

public class FileWriterExample {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            String data = "Hello, world!";
            fos.write(data.getBytes());
            System.out.println("Data written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

3. **Copying Files**:
   - Use FileInputStream and FileOutputStream together to copy bytes from one file to another.
   - Read bytes from the source file and write them to the destination file until the end of file is reached.

Example of copying a file:

```java
import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("source.txt");
             FileOutputStream fos = new FileOutputStream("destination.txt")) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

These examples demonstrate the basic file input and output operations in Java. It's important to handle exceptions properly and close streams after use to avoid resource leaks.

## Reading and writing text files

Reading and writing text files in Java can be done using classes like FileReader, FileWriter, BufferedReader, and BufferedWriter. Here's how you can perform these operations:

1. **Reading from a Text File**:
   - Use FileReader to read characters from a text file.
   - Wrap FileReader in a BufferedReader for efficient reading.
   - Read lines from the BufferedReader using readLine() method until it returns null, indicating the end of the file.

Example of reading from a text file:

```java
import java.io.*;

public class TextFileReaderExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

2. **Writing to a Text File**:
   - Use FileWriter to write characters to a text file.
   - Wrap FileWriter in a BufferedWriter for efficient writing.
   - Write lines to the BufferedWriter using write() or newLine() methods.

Example of writing to a text file:

```java
import java.io.*;

public class TextFileWriterExample {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Hello, world!");
            writer.newLine(); // Write a new line
            writer.write("This is a text file.");
            System.out.println("Data written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

3. **Copying Text Files**:
   - Use FileReader and FileWriter together to copy characters from one text file to another.
   - Read characters from the source file and write them to the destination file until the end of file is reached.

Example of copying a text file:

```java
import java.io.*;

public class TextFileCopyExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("source.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("destination.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Write a new line
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

These examples demonstrate how to read from and write to text files in Java using FileReader, FileWriter, BufferedReader, and BufferedWriter. Remember to handle exceptions properly and close streams after use to avoid resource leaks.

## Binary file handling in Java

Binary file handling in Java involves reading and writing binary data to files, which is commonly done using DataInputStream and DataOutputStream classes. These classes provide methods to read and write primitive data types and strings in binary format. Here's how you can perform binary file handling using DataInputStream and DataOutputStream:

1. **Writing Binary Data to a File**:
   - Create a FileOutputStream to write binary data to a file.
   - Wrap the FileOutputStream in a DataOutputStream for writing primitive data types and strings in binary format.
   - Use methods like writeInt(), writeDouble(), writeUTF(), etc., to write data to the DataOutputStream.

Example of writing binary data to a file:

```java
import java.io.*;

public class BinaryFileWriterExample {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"))) {
            dos.writeInt(123); // Write an integer
            dos.writeDouble(3.14); // Write a double
            dos.writeUTF("Hello, world!"); // Write a UTF-encoded string
            System.out.println("Binary data written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

2. **Reading Binary Data from a File**:
   - Create a FileInputStream to read binary data from a file.
   - Wrap the FileInputStream in a DataInputStream for reading primitive data types and strings in binary format.
   - Use methods like readInt(), readDouble(), readUTF(), etc., to read data from the DataInputStream.

Example of reading binary data from a file:

```java
import java.io.*;

public class BinaryFileReaderExample {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"))) {
            int intValue = dis.readInt(); // Read an integer
            double doubleValue = dis.readDouble(); // Read a double
            String stringValue = dis.readUTF(); // Read a UTF-encoded string
            System.out.println("Integer: " + intValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("String: " + stringValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

In these examples, we first create FileOutputStream or FileInputStream to handle binary data files. Then, we wrap them in DataOutputStream or DataInputStream, respectively. Finally, we use the methods provided by DataOutputStream and DataInputStream to write or read binary data. Remember to handle exceptions properly and close streams after use to avoid resource leaks.

## Object serialization and deserialization

Object serialization and deserialization in Java involve converting Java objects into byte streams (serialization) and reconstructing objects from byte streams (deserialization). This process is commonly used for data persistence, network communication, and storing objects in files or databases. Java provides built-in mechanisms for serialization and deserialization through the ObjectOutputStream and ObjectInputStream classes. Here's how you can perform object serialization and deserialization:

1. **Serialization**:
   - Implement the Serializable interface in your class to mark it as serializable.
   - Create an ObjectOutputStream to write objects to a file or OutputStream.
   - Use the writeObject() method of ObjectOutputStream to serialize the object.

Example of serialization:

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        Person person = new Person("John", 30);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Object serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

2. **Deserialization**:
   - Create an ObjectInputStream to read objects from a file or InputStream.
   - Use the readObject() method of ObjectInputStream to deserialize the object.
   - Cast the deserialized object to the appropriate class type.

Example of deserialization:

```java
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person person = (Person) ois.readObject();
            System.out.println("Object deserialized successfully!");
            System.out.println("Deserialized Person: " + person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

In both examples, we define a simple Person class that implements the Serializable interface. We then serialize an instance of the Person class into a file named "person.ser" in the serialization example. In the deserialization example, we deserialize the object from the "person.ser" file and print its contents. Make sure that the classes being serialized and deserialized have the serialVersionUID field defined to ensure compatibility between different versions of the class.

## Working with directories and files

Working with directories and files in Java involves creating, deleting, listing, and manipulating directories and files. Java provides classes like File for working with directories and files. Here's how you can perform these operations:

1. **Creating a Directory**:
   - Use the mkdir() method of the File class to create a directory.
   - Use mkdirs() method to create directories recursively if parent directories don't exist.

Example of creating a directory:

```java
import java.io.File;

public class DirectoryCreationExample {
    public static void main(String[] args) {
        File directory = new File("myDirectory");
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory created successfully!");
            } else {
                System.out.println("Failed to create directory!");
            }
        } else {
            System.out.println("Directory already exists!");
        }
    }
}
```

2. **Creating a File**:
   - Use the createNewFile() method of the File class to create a new file.
   - Check if the file already exists before creating it.

Example of creating a file:

```java
import java.io.File;
import java.io.IOException;

public class FileCreationExample {
    public static void main(String[] args) {
        File file = new File("myFile.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

3. **Listing Files in a Directory**:
   - Use the list() method of the File class to get an array of file names in a directory.
   - Use the listFiles() method to get an array of File objects representing files in a directory.

Example of listing files in a directory:

```java
import java.io.File;

public class ListFilesExample {
    public static void main(String[] args) {
        File directory = new File("myDirectory");
        String[] files = directory.list();
        if (files != null) {
            System.out.println("Files in directory:");
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("Directory is empty or doesn't exist!");
        }
    }
}
```

4. **Deleting a File or Directory**:
   - Use the delete() method of the File class to delete a file or directory.

Example of deleting a file:

```java
import java.io.File;

public class FileDeletionExample {
    public static void main(String[] args) {
        File file = new File("myFile.txt");
        if (file.delete()) {
            System.out.println("File deleted successfully!");
        } else {
            System.out.println("Failed to delete file!");
        }
    }
}
```

These examples demonstrate how to work with directories and files in Java using the File class. Ensure proper error handling and permissions when performing these operations.

## File manipulation: creating, deleting, renaming files

File manipulation in Java involves creating, deleting, and renaming files, which can be done using methods provided by the File class. Here's how you can perform these operations:

1. **Creating a File**:
   - Use the createNewFile() method of the File class to create a new file.
   - Check if the file already exists before creating it.

Example of creating a file:

```java
import java.io.File;
import java.io.IOException;

public class FileCreationExample {
    public static void main(String[] args) {
        File file = new File("example.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

2. **Deleting a File**:
   - Use the delete() method of the File class to delete a file.

Example of deleting a file:

```java
import java.io.File;

public class FileDeletionExample {
    public static void main(String[] args) {
        File file = new File("example.txt");
        if (file.delete()) {
            System.out.println("File deleted successfully!");
        } else {
            System.out.println("Failed to delete file!");
        }
    }
}
```

3. **Renaming a File**:
   - Use the renameTo() method of the File class to rename a file.

Example of renaming a file:

```java
import java.io.File;

public class FileRenamingExample {
    public static void main(String[] args) {
        File oldFile = new File("oldName.txt");
        File newFile = new File("newName.txt");
        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully!");
        } else {
            System.out.println("Failed to rename file!");
        }
    }
}
```

These examples demonstrate how to create, delete, and rename files in Java using the File class. Ensure proper error handling and permissions when performing these operations.

## Managing file permissions and attributes

In Java, managing file permissions and attributes involves using the java.nio.file package, specifically the Files and FileAttribute classes. This package provides more flexibility and functionality for managing file permissions and attributes compared to the traditional File class. Here's how you can manage file permissions and attributes:

1. **Setting File Permissions**:
   - Use the setPosixFilePermissions() method of the Files class to set file permissions for a file.
   - File permissions are represented by a set of PosixFilePermission enums (OWNER_READ, OWNER_WRITE, OWNER_EXECUTE, GROUP_READ, GROUP_WRITE, GROUP_EXECUTE, OTHERS_READ, OTHERS_WRITE, OTHERS_EXECUTE).

Example of setting file permissions:

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class FilePermissionExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        Set<PosixFilePermission> permissions = new HashSet<>();
        permissions.add(PosixFilePermission.OWNER_READ);
        permissions.add(PosixFilePermission.OWNER_WRITE);
        permissions.add(PosixFilePermission.OWNER_EXECUTE);
        permissions.add(PosixFilePermission.GROUP_READ);
        permissions.add(PosixFilePermission.OTHERS_READ);
        try {
            Files.setPosixFilePermissions(path, permissions);
            System.out.println("File permissions set successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

2. **Setting File Attributes**:
   - Use the setAttribute() method of the Files class to set file attributes for a file.
   - File attributes are represented as key-value pairs.

Example of setting file attributes:

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class FileAttributeExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-r--r--");
        FileAttribute<Set<PosixFilePermission>> fileAttributes = PosixFilePermissions.asFileAttribute(permissions);
        try {
            Files.setAttribute(path, "posix:permissions", fileAttributes);
            System.out.println("File attributes set successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

3. **Getting File Attributes**:
   - Use the getAttribute() method of the Files class to get file attributes for a file.
   - You can get various file attributes such as creation time, last access time, last modified time, etc.

Example of getting file attributes:

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class GetFileAttributesExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        try {
            BasicFileAttributes basicAttributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("Creation Time: " + basicAttributes.creationTime());
            System.out.println("Last Access Time: " + basicAttributes.lastAccessTime());
            System.out.println("Last Modified Time: " + basicAttributes.lastModifiedTime());

            PosixFileAttributes posixAttributes = Files.readAttributes(path, PosixFileAttributes.class);
            Set<PosixFilePermission> permissions = posixAttributes.permissions();
            System.out.println("File Permissions: " + PosixFilePermissions.toString(permissions));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

These examples demonstrate how to manage file permissions and attributes in Java using the java.nio.file package. Make sure to handle exceptions appropriately when working with file operations.

## Handling file I/O errors and exceptions

Handling file I/O errors and exceptions is crucial to ensure robust and reliable file operations in Java. Various exceptions can occur during file I/O operations, such as FileNotFoundException, IOException, SecurityException, etc. Here's how you can handle file I/O errors and exceptions effectively:

1. **Using Try-Catch Blocks**:
   - Wrap file I/O code within try-catch blocks to handle exceptions gracefully.
   - Catch specific exceptions and handle them accordingly to provide meaningful error messages or take appropriate actions.

Example:

```java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileIOExample {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            FileReader reader = new FileReader(file);
            // Perform file reading operations
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
```

2. **Using Finally Block**:
   - Use a finally block to ensure that resources (like file streams) are properly closed, even if an exception occurs.
   - Close file streams or release resources in the finally block to prevent resource leaks.

Example:

```java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileIOExample {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            File file = new File("example.txt");
            reader = new FileReader(file);
            // Perform file reading operations
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
```

3. **Using Try-With-Resources**:
   - Use try-with-resources statement introduced in Java 7 for automatic resource management.
   - Resources declared within the try-with-resources statement are automatically closed when the try block exits, whether normally or through an exception.

Example:

```java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileIOExample {
    public static void main(String[] args) {
        File file = new File("example.txt");
        try (FileReader reader = new FileReader(file)) {
            // Perform file reading operations
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
```

Using try-with-resources is the preferred way for handling file I/O operations as it reduces boilerplate code and ensures that resources are closed properly. Ensure to catch specific exceptions and handle them appropriately based on your application's requirements.
