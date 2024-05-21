What is a web service?

- service available or offered on the web
  - service is an application that can be remotely invoked from another client application
  - distributed computing

REST ?

- Representational State Transfer
- Transfer (exchange) of state (data) (between client and server) in different representations (formats json/xml/text)

- Concept created by Roy Fielding, co-creator of HTTP
- Allows a client to exchange data in different formats (mostly JSON)
- Server exposes a `resource` which is a collection of `states`
  - Resource -> products, flights, books, items, employees (usually nouns)
  - A `products` resource is a collection of zero or more `product` states
  - http://example.com/api/products
  - http://example.com/api/products/231
  - http://example.com/api/products/231/category
  - http://example.com/api/products/231/pictures
  - http://exampleblog.com/posts/
  - http://exampleblog.com/posts/2024
  - http://exampleblog.com/posts/2024/5
  - http://exampleblog.com/posts/2024/5/14
- Server allows the use of HTTP verbs (a.k.a methods) for performing an action on a resource
  - GET --> get one ore more resource
    - http://example.com/api/products/231
    - http://example.com/api/products
    - http://example.com/api/products?category=fruits
  - POST -> create a new state in the resource
    - http://example.com/api/products
    - the state is sent as request body (aka payload) in a specific format (like JSON)
  - PUT/PATCH -> update exisiting state in the resource by id
    - http://example.com/api/products/231
    - the modified state is sent as request body (aka payload) in a specific format (like JSON)
  - DELETE -> delete a state in the resource
    - http://example.com/api/products/231
- Server and client deal with different representations (content negotiation) using standard HTTP headers
  - HTTP request header by the client:
    - `Accept` -> tells the server that the client is interested in this specific format
      - for example `Accept: application/json`
      - for example `Accept: application/xml`
      - for example `Accept: text/plain`
      - can be used by any of the HTTP verbs
    - `Content-Type` --> telss about the format of data sent via **POST/PUT/PATCH** requests
- Based on 6 constraints
  - Client/Server
  - Stateless
  - Uniform interface (resource is available using this)
  - Layered (nothing to do by the developer, this is mostly infrastructure related)
  - Cacheable (nothing to do by the developer, this is mostly client infrastructure related)
  - Code on demand (optional)
