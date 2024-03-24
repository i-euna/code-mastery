# On APIs
- set of protocols for software components to communicate and transfer data
- the work by sharing data through a request and response cycle
- an API platform like Postman can help design, develop, test, secure, deploy, and monitor APIs at scale

## Table of Content
- [How APIs work](#how-apis-work)
- [API Request](#api-request)
- [API Response](#api-response)
- [Architectural Styles](#architectural-styles)
- [API Use Cases](#api-use-cases)
- [API-first strategy](#api-first-strategy)
- [Important Differences](#important-differences)

## How APIs Work
- client  sends a request to API server
- a request has the following components: Endpoint, Method, Parameter, Header, Body
- API server handles authentication, validates input and fetches/ manipulates data
- then server sends a response(components of response: status code, response header and body)

### API Request

#### Endpoint
- Point of contact between API client and server/ dedicated url that provides access to specific resource

#### Method
- type of operation client wants to perform on a resource
- rest APIs are accessible through HTTP methods(common actions: CRUD)

#### Parameters
- variables sent to the endpoint 
- can be included in URL query string or parameter

#### Header
- key/value pairs that contains content-type and authentication credentials

#### Body
- main part of the request
- contains actual data for CRUD operation

### API Response

#### Status Code
- 3 digit code indicating outcome of API request
- e.g: 200(OK), 201()created, 404(not found)etc

#### Response Header
- similar to request header

#### Body
- contains actual data or content client wants or error message

## Types of APIs
- depending on who has access to them, there can be: private, public and partner APIs

## Architectural Styles
- APIs can be categorized based on their architectural styles as well

#### SOAP
- simple Object Access Protocol
- uses XML to transfer highly structured messages
- slower than other styles
- has advanced security features
- used in legacy systems/enterprise
  
#### REST
- resources are accessed via endpoints
- operations are performed on the resources with standard HTTP methods

#### GraphQL
- open source query language
- lets the clients fetch the exact data they need via a single endpoint
- does not chain multiple requests together
- reduces the number of round trips between client and server
- useful if the app is running on slow or unreliable networks

#### WebHooks
- used to implement event-driven architecture
- requests are automatically sent in response to event triggers
- for example- when a user completes a payment, the application sends an HTTP request to a pre-configured webhook URL putting the event data in the request payload. The system that receives the webhook can then process the event and take the appropriate action.

#### gRPC
- google Remote Procedure Call
- client calls a server as if it were a local object
- useful for distributed applications

#### Web Sockets

#### MQTT

#### others

## API Use Cases
- integrating internal and external system
- adding/enhancing functionality
- connecting to IoT devices
- connecting scalable systems
- reducing cost
- increasing security and governance

## API-first Strategy
- apps are designed and developed as a collection of internal and external services that are delivered through APIs

## Important Differences

### SOAP vs REST
- SOAP uses XML, and REST uses JSON which is less verbose
- SOAP has built-in features for security and error handling making them well-suited for enterprise development with strict standards
- REST APIs are generally easier to understand, consume and integrate

### APIs vs Webhooks
- Webhooks are lightweight callback functions that allow event-driven communication between APIs.
- In API request-response cycle, a client actively sends a request to an API server
- but a webhook listens for an event and performs a pre-configured action in response
- so there is no need for the API client to poll the server because the server automatically performs the appropriate action or returns the relevant data when the specified event occurs.

### SOA(Service-oriented Architecture) vs Microservice
- both are made of modular services that perform specific functions
- microservices communicate with one another through APIs
- SOA services rely on an enterprise service bus (ESB) for routing, transforming, and managing messages
- SOA services usually use SOAP, whereas microservices usually use lightweight protocols like REST
- SOA services are less granular than microservices, and they may also be dependent on one another
  
### References
[1] [Postman](https://www.postman.com/what-is-an-api/)
