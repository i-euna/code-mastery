# Distributed System: Scalability

# Table of Contents
- [Scalability](#scalability)
  - [Scaling Techniques](#scaling-techniques)
- [Types of Scalability](#types-of-scalability)
- [Direction of Scalability](#direction-of-scalability)
- [Challenges](#challenges-in-scaling)
- [Strategies](#strategies-for-effective-scaling)
- [CAP Theorem](#cap-theorem)
- [Scalability Patterns](#scalability-patterns)
- [Case Studies: Instagram, Twitter, Netflix](#case-studies)
  
## Scalability
- Scalability = How well a system can handle growth.
- Growth can mean more users, more data, or more traffic.
- A scalable system can increase capacity without needing a full redesign.
- Scaling is not just adding servers- it's re-architecting systems to survive growth without chaos.

🧠🧠🧠 More Users → More Load → Need More Resources → Need More Coordination → Need More Resilience → Need More Observability 🧠🧠🧠


### Scalability ≠ Only Performance
- A fast system that crashes under load is not scalable.
- A scalable system maintains performance even when demand grows.

### Scaling Techniques
- **Load Balancing**: Distributing traffic across multiple servers.
- **Caching**: Reducing repeated expensive operations.
- **Partitioning** / Sharding: Splitting data into parts.
- **Asynchronous Processing**: Avoid blocking slow operations.
- **Replication**: Duplicating data/services for redundancy and speed.

## Types of Scalability

Type | Meaning | Example
--- | --- | --- |
Vertical Scaling (Scale Up) | Add more powerful resources to a single server | Add more CPU, memory, and better disk
Horizontal Scaling (Scale Out) | Add more servers/machines | Deploy the same app across many servers
Functional Scaling | Breaking a system into smaller, specialized components | E.g., Microservices
Geographical Scaling | Distributing system components across different locations to reduce latency and improve availability for users in various regions | E.g., using Content Delivery Networks or regional data centers

* Vertical is usually easier short term,
* Horizontal is better for long-term distributed systems.

## Direction of Scalability

Direction | What it Means | Example
--- | --- | --- |
Read | Handling more read operations | Adding caching layers (e.g., Redis)
Write | Handling more write operations | Sharding databases
Storage | Handling larger data sizes | Using distributed storage like S3 or Hadoop
Compute | Handling heavier computation | Spreading computation over multiple nodes (e.g., Spark clusters)
Networking | Handling more network traffic | Load balancing, CDN distribution
Team/Process | Engineering teams growing to handle system growth | Microservices split based on team ownership

## Challenges in Scaling
- **Data Consistency**: In distributed systems, ensuring data remains consistent across nodes (e.g., eventual consistency vs. strong consistency).
- **Load Balancing**: Efficiently distributing workloads across resources to avoid bottlenecks.
- **Fault Tolerance**: Designing systems to handle failures gracefully, ensuring high availability.
- **Cost Management**: Balancing performance improvements with the financial cost of additional resources.

## Strategies for Effective Scaling
- **Modular Design**: Building systems with loosely coupled components to allow independent scaling.
- **Automation**: Using tools for auto-scaling, monitoring, and deployment to adapt to demand dynamically.
- **Caching and Optimization**: Leveraging caching (e.g., Redis, Memcached) and query optimization to reduce resource strain.
- **Asynchronous Processing**: Using message queues (e.g., Kafka, RabbitMQ) to handle tasks that don’t require immediate processing.

## CAP Theorem
In distributed systems, we must trade off between:
- Consistency
- Availability
- Partition Tolerance

🔥 We can't guarantee all three perfectly at the same time.

## Scalability Patterns

Pattern | What it Does |
--- | --- |
CQRS (Command Query Responsibility Segregation) | Separate reads and writes
Event Sourcing | Save system state as a sequence of events
Bulkheads | Isolate parts of the system to prevent failure from spreading
Circuit Breakers | Stop calling failing services automatically


🔥 **Autoscaling** Systems (especially on cloud platforms like AWS, GCP) can automatically scale resources based on demand. Example: More EC2 instances when CPU usage > 70%.

🔥 **Observability**: Monitoring, logging, and tracing become critical at scale. If we can't observe it, we can't scale it reliably.

# Case Studies

## Instagram: From 0 to 100 million users
🔥🔥🔥 **Problem**:
- They grew too fast — overnight success.
- Started as a simple Rails backend with a PostgreSQL database.
- Suddenly needed to handle millions of photo uploads and user actions.

🚀🚀🚀 **Scaling moves**:
- **Database replication**: Read replicas to spread read traffic.
- **Sharding**: Split data into multiple databases when one isn't enough.
- **S3 Storage**: Moved photo storage to AWS S3, because their server disks couldn't keep up.
- **Celery**: Used background queues (Celery workers) for slow tasks like resizing images.
- **Memcached**: Heavy caching for feeds and user info.

🎯🎯🎯 **Key lessons**:
- Start simple, but plan for horizontal scaling.
- Caching and queues are our best friends when scaling fast.
  
## Twitter: The "Fail Whale" Era
🔥🔥🔥 **Problem**:
- Twitter became popular so fast during 2007–2009 that their servers couldn't handle it.

🚀🚀🚀 **Scaling moves**:
- **Monolith to Microservices**: They broke apart the huge Rails app.
- **Message Queues**: Introduced message queues between services to absorb bursts.
- **Database Sharding**: Split user data across multiple databases.
- **Caching timelines**: Instead of regenerating user feeds live, they cached user timelines.

🎯🎯🎯 **Key lessons**:
- When you can't handle real-time generation, precompute and cache.
- Microservices helped them scale parts of the system independently.

## Netflix: Global Scale and Chaos Engineering

🔥🔥🔥 **Problem**:
Netflix went from shipping DVDs to streaming video — a completely different scaling problem. They needed a global scale across millions of devices and ISPs.

🚀🚀🚀 **Scaling moves**:
- **Moved to AWS Cloud**: Full migration off their own data centers to AWS.
- **Microservices architecture**: Hundreds of small services.
- **Global CDN (Open Connect)**: Built their content delivery network.
- **Chaos Monkey**: A tool that randomly kills servers in production to test system resilience.
- **Resilience patterns**: Circuit breakers, bulkheads, retries everywhere.

🎯🎯🎯 **Key lessons**:
- At a global scale, resilience matters more than pure performance.
- Practice failure before real failures happen (chaos engineering).
