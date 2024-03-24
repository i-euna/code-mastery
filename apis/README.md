# On APIs
- set of protocols for software components to communicate and transfer data
- the work by sharing data through a request and response cycle

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
- 

#### gRPC

#### Web Sockets

#### MQTT

#### others

## API Use Cases

## API-first Strategy

## Important Differences

### SOAP vs REST

### APIs vs Webhooks

### SOA vs Microservice

##

### References
[1] [Postman](https://www.postman.com/what-is-an-api/)
