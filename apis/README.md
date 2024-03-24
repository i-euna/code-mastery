# On APIs

- set of protocols for software components to communicate and transfer data
- the work by sharing data through a request and response cycle

## how APIs work
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

## architectural styles
- APIs can be categorized based on their architectural styles as well

#### SOAP

#### REST

#### GraphQL

#### WebHooks

#### gRPC

#### Web Sockets

#### MQTT

#### others

## API Use Cases

## API-first strategy

## Important Differences

### SOAP vs REST

### APIs vs Webhooks

### SOA vs Microservice

##

### References
[1] [Postman](https://www.postman.com/what-is-an-api/)
