# RESTful Web Services with Spring Boot

## Introduction to RESTful Architecture

REST (Representational State Transfer) is an architectural style for designing networked applications. It relies on a stateless, client-server, cacheable communication protocol -- the HTTP protocol is almost universally used for this purpose. RESTful applications use HTTP requests to perform CRUD (Create, Read, Update, Delete) operations on resources, which are identified by URLs.

### Key Principles of REST:

1. **Stateless**: Each request from a client to server must contain all the information the server needs to fulfill that request. The server should not store any state about the client session on the server side.
2. **Client-Server Architecture**: The client handles the user interface and the server handles the data storage, ensuring a separation of concerns.

3. **Cacheable**: Responses must define themselves as cacheable or non-cacheable. If a response is cacheable, then a client cache is given the right to reuse that response data for later, equivalent requests.

4. **Uniform Interface**: Resources are manipulated via a uniform interface (HTTP). This simplifies the architecture and helps with understanding and managing interactions between the components.

5. **Layered System**: A client cannot ordinarily tell whether it is connected directly to the end server, or to an intermediary along the way.

6. **Code on Demand (optional)**: Servers can extend client functionality by transferring executable code (e.g., JavaScript).

### Example:

Consider a RESTful service for a library system. Resources could include books, authors, and genres.

- **URL for a book resource**: `https://api.library.com/books/{id}`
- **HTTP Methods**:
  - GET `https://api.library.com/books/1` - Retrieves the book with ID 1
  - POST `https://api.library.com/books` - Creates a new book
  - PUT `https://api.library.com/books/1` - Updates the book with ID 1
  - DELETE `https://api.library.com/books/1` - Deletes the book with ID 1

## Creating RESTful Services with Spring Boot

Spring Boot simplifies the creation of production-ready, stand-alone Spring-based applications. It provides a set of tools to create RESTful services quickly and easily.

### Steps to Create RESTful Services:

1. **Set Up Spring Boot Project**:

   - Use Spring Initializr to generate a new project.
   - Include dependencies for Spring Web.

2. **Create the Main Application Class**:

   ```java
   @SpringBootApplication
   public class LibraryApplication {
       public static void main(String[] args) {
           SpringApplication.run(LibraryApplication.class, args);
       }
   }
   ```

3. **Define Entity Classes**:

   ```java
   @Entity
   public class Book {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String title;
       private String author;
       // Getters and setters
   }
   ```

4. **Create a Repository Interface**:

   ```java
   public interface BookRepository extends JpaRepository<Book, Long> {
   }
   ```

5. **Develop REST Controllers**:

   ```java
   @RestController
   @RequestMapping("/books")
   public class BookController {
       @Autowired
       private BookRepository repository;

       @GetMapping
       public List<Book> getAllBooks() {
           return repository.findAll();
       }

       @GetMapping("/{id}")
       public Book getBookById(@PathVariable Long id) {
           return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
       }

       @PostMapping
       public Book createBook(@RequestBody Book book) {
           return repository.save(book);
       }

       @PutMapping("/{id}")
       public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
           Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
           book.setTitle(bookDetails.getTitle());
           book.setAuthor(bookDetails.getAuthor());
           return repository.save(book);
       }

       @DeleteMapping("/{id}")
       public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
           Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
           repository.delete(book);
           return ResponseEntity.noContent().build();
       }
   }
   ```

## Handling HTTP Methods (GET, POST, PUT, DELETE)

### GET:

Used to retrieve information from the server.

```java
@GetMapping("/books")
public List<Book> getAllBooks() {
    return bookRepository.findAll();
}
```

### POST:

Used to create a new resource.

```java
@PostMapping("/books")
public Book createBook(@RequestBody Book book) {
    return bookRepository.save(book);
}
```

### PUT:

Used to update an existing resource.

```java
@PutMapping("/books/{id}")
public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
    Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    book.setTitle(bookDetails.getTitle());
    book.setAuthor(bookDetails.getAuthor());
    return bookRepository.save(book);
}
```

### DELETE:

Used to delete a resource.

```java
@DeleteMapping("/books/{id}")
public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    bookRepository.delete(book);
    return ResponseEntity.noContent().build();
}
```

## Request Mapping and URL Patterns

Spring MVC allows you to map HTTP requests to handler methods of MVC and REST controllers. You can define request mappings using the `@RequestMapping` annotation or its HTTP method-specific variants such as `@GetMapping`, `@PostMapping`, etc.

### Example:

```java
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/books")
    public List<Book> getBooks() {
        // method implementation
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        // method implementation
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        // method implementation
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        // method implementation
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        // method implementation
    }
}
```

- `/api/books` maps to `getBooks()` and `createBook()`.
- `/api/books/{id}` maps to `getBookById()`, `updateBook()`, and `deleteBook()`.

## Consuming RESTful Services Using RestTemplate

RestTemplate is a synchronous client to perform HTTP requests in a Spring application.

### Steps to Use RestTemplate:

1. **Configure RestTemplate Bean**:

   ```java
   @Configuration
   public class AppConfig {

       @Bean
       public RestTemplate restTemplate() {
           return new RestTemplate();
       }
   }
   ```

2. **Consume a RESTful Service**:

   ```java
   @Service
   public class BookService {

       @Autowired
       private RestTemplate restTemplate;

       private static final String BASE_URL = "https://api.library.com/books";

       public List<Book> getAllBooks() {
           ResponseEntity<List<Book>> response = restTemplate.exchange(
               BASE_URL,
               HttpMethod.GET,
               null,
               new ParameterizedTypeReference<List<Book>>() {}
           );
           return response.getBody();
       }

       public Book getBookById(Long id) {
           return restTemplate.getForObject(BASE_URL + "/" + id, Book.class);
       }

       public Book createBook(Book book) {
           return restTemplate.postForObject(BASE_URL, book, Book.class);
       }

       public void updateBook(Long id, Book book) {
           restTemplate.put(BASE_URL + "/" + id, book);
       }

       public void deleteBook(Long id) {
           restTemplate.delete(BASE_URL + "/" + id);
       }
   }
   ```

### Example Usage:

- **Get All Books**:

  ```java
  List<Book> books = bookService.getAllBooks();
  ```

- **Get a Book by ID**:

  ```java
  Book book = bookService.getBookById(1L);
  ```

- **Create a New Book**:

  ```java
  Book newBook = new Book();
  newBook.setTitle("Spring Boot in Action");
  newBook.setAuthor("Craig Walls");
  Book createdBook = bookService.createBook(newBook);
  ```

- **Update a Book**:

  ```java
  Book updatedBook = new Book();
  updatedBook.setTitle("Spring Boot in Action - Updated");
  updatedBook.setAuthor("Craig Walls");
  bookService.updateBook(1L, updatedBook);
  ```

- **Delete a Book**:
  ```java
  bookService.deleteBook(1L);
  ```

These examples provide a comprehensive guide to creating and consuming RESTful services using Spring Boot and handling various HTTP methods effectively.
