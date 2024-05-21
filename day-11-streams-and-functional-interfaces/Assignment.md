### Assignment 1: Word Frequency Counter

**Problem Statement:**
Write a Java program that reads a text file and counts the frequency of each word in the file. The program should then display the top N most frequent words along with their frequencies.

**Requirements:**

1. Read the contents of a text file (`input.txt`) and tokenize it into words.
2. Count the frequency of each word using Java Streams.
3. Display the top N most frequent words along with their frequencies, where N is provided by the user as input.
4. Ignore case sensitivity while counting words (i.e., treat "Hello" and "hello" as the same word).

**Sample Input:**

```
Enter the value of N: 5
```

**Sample Output:**

```
Top 5 most frequent words:
1. the - 10 occurrences
2. java - 8 occurrences
3. programming - 7 occurrences
4. is - 6 occurrences
5. in - 6 occurrences
```

### Assignment 2: Student Grade Analyzer

**Problem Statement:**
Write a Java program that reads a CSV file containing student grades and calculates various statistics. The program should display the average grade, highest grade, lowest grade, and the number of students who passed (grade >= 60) and failed (grade < 60).

**Requirements:**

1. Read the contents of a CSV file (`grades.csv`) containing student grades in the format: `studentName, grade`.
2. Parse the CSV file using Java Streams and calculate the following statistics:
   - Average grade
   - Highest grade
   - Lowest grade
   - Number of students who passed
   - Number of students who failed
3. Display the calculated statistics.

**Sample Input (grades.csv):**

```
John,85
Alice,72
Bob,60
Emma,55
```

**Sample Output:**

```
Statistics:
- Average grade: 68.0
- Highest grade: 85
- Lowest grade: 55
- Number of students passed: 3
- Number of students failed: 1
```
