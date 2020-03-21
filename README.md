**This contain a step by step how to build a micro-services system by using Spring Cloud**

*I recommend that you should view in order below.*

---
## Spring Cloud Circuit Breaker ##
Spring Cloud Circuit breaker provides an abstraction across different circuit breaker implementations. 
It provides a consistent API to use in your applications allowing you the developer to choose the circuit breaker implementation that best fits your needs for your app.

In this, I use the *Netflix Hystrix* library to implement the circuit breaker.

## Spring Cloud Config ##
In micro-services environment, I need to have a centralize configuration for all the services. So that I can easy to reuse, view, edit the configuration and also prevent the mistake.

## Spring Cloud Discovery ##
I will set up a *Netflix Eureka* service registry and then build a client that both registers itself with the registry and uses it to resolve its own host. 
A service registry is useful because it enables client-side load-balancing and decouples service providers from consumers without the need for DNS.

## Spring Cloud Gateway ##
In micro-services environment, we have lots of services. And all the services will be deployed on different machines and have different addresses.
We cannot ask client that with the endpoint A you should use the address A1, endpoint B you must use address B1.

So that Spring Cloud Gateway help to centralize all the services. Client just only know about gateway address, they cannot make request to the services directly.
This also help to increase the security and easy to monitor the requests.

This project show how to integrate Spring Cloud Gateway and Spring Cloud Discovery.

## More... ##