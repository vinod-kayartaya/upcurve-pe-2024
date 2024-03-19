## Common lifecycle phases (goals) of Maven

- clean --> deletes the `target` folder and its content
- compile --> compiles java files in src/main/java folder
- test-compile --> compiles java files in src/test/java folder
- test --> runs the unit tests from src/test/java folder
- package --> creates JAR file from your compiled files
- install --> installs the current maven artifact in local repository
- deploy --> used for publishing this artifact to maven central

## Different types of class you may write:

- program --> class with a `public static void main(String[] args)` method
- entity/model/domain --> a class that represents information (book, person, employee, student, flight, etc)
- service --> class that contain domain (or business) specific logics (`transferFunds` functionality in a banking application)
- dao/repository --> class that contain logic to store/retrieve/udpdate/delete data on a secondary storage (such as file or rdbms or no-sql databases)
- exception --> a class that represents an erroneous situation
- utitlities --> helper methods (usually static) (for example, KeyboardUtil, DbUtil, Math, ...)
