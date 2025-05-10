# Distributed System: Scalability

# Table of Contents
- [Scalability](#scalability)
  - [Scaling Techniques](#scaling-techniques)
- [Types of Scalability](#types-of-scalability)
- [Direction of Scalability](#direction-of-scalability)
- [Dimension of Scaling](#dimension-of-scaling)
- [Challenges](#challenges-in-scaling)
- [Strategies](#strategies-for-effective-scaling)
- [CAP Theorem](#cap-theorem)
- [Bottlenecks and Limits](#bottlenecks-and-limits)
- [Scalability Patterns](#scalability-patterns)
- [Elasticity vs Scalability](#elasticity-vs-scalability)
- [Data Models and Scalability](#data-models-and-scalability)
- [Throttling & Backpressure](#throttling--backpressure)
- [Rate Limiting and Quotas](#rate-limiting-and-quotas)
- [Observability](#observability-the-foundation-of-scalable-systems)
- [Feedback Loop](#feedback-loops-in-distributed-systems)
- [Case Studies: Instagram, Twitter, Netflix](#case-studies)
  
## Scalability
- Scalability = How well a system can handle growth.
- Growth can mean more users, more data, or more traffic.
- A scalable system can increase capacity without needing a full redesign.
- Scaling often starts with adding servers, but true scalability usually requires architectural changes to handle coordination, failure, and data distribution.

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

* Vertical is usually easier in the short term,
* Horizontal is better for long-term distributed systems.
* Vertical scaling is constrained by the maximum capacity of a single server and may require downtime for hardware upgrades, unlike horizontal scaling.

## Direction of Scalability

Direction | What it Means | Example
--- | --- | --- |
Read | Handling more read operations | Adding caching layers (e.g., Redis)
Write | Handling more write operations | Sharding databases
Storage | Handling larger data sizes | Using distributed storage like S3 or Hadoop
Compute | Handling heavier computation | Spreading computation over multiple nodes (e.g., Spark clusters)
Networking | Handling more network traffic | Load balancing, CDN distribution
Team/Process | Engineering teams growing to handle system growth | Microservices split based on team ownership

## Dimension of Scaling

| Dimension                   | Meaning                                                  | Example                                   |
| --------------------------- | -------------------------------------------------------- | ----------------------------------------- |
| **Performance Scalability** | Can the system handle more load with acceptable latency? | Faster database queries, async processing |
| **Operational Scalability** | Can we manage the system as it grows?                   | Kubernetes, CI/CD pipelines               |
| **Development Scalability** | Can the team keep developing quickly as the codebase grows?  | Clear ownership, modular architecture     |
| **Cost Scalability**        | Does cost grow linearly or better with traffic?          | Spot instances, serverless functions      |


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

## Bottlenecks and Limits

A bottleneck is the part of a system that limits overall performance or scalability. No matter how optimized the rest of the system is, this "narrowest point" constrains everything, like the neck of a bottle restricts how fast liquid flows out.

Analogy: You might have 10 lanes of highway traffic, but if all cars have to pass through a 1-lane toll booth, traffic jams happen. The toll booth is the bottleneck.

🛑 **Common Bottlenecks in Scalable Systems:**

| Bottleneck Type | Description                             | Example                                 |
| --------------- | --------------------------------------- | --------------------------------------- |
| **Database**    | DB can't handle read/write load         | Too many writes to a single DB instance |
| **Network**     | Bandwidth or latency limits             | High-latency region, saturated network  |
| **Compute**     | CPU-intensive services slow down        | Image/video processing                  |
| **Storage I/O** | Disk read/write speeds limit throughput | Logging or analytics pipeline           |
| **Code-level**  | Inefficient algorithms or sync code     | N+1 queries, blocking I/O               |
| **Team/Org**    | Lack of ownership slows changes         | Monolithic codebase with 1 team         |


📉 **Scaling Limits**

Even with great design, systems hit natural or practical limits:

- **Vertical Scaling Limit:** There's only so much CPU/RAM you can add to a single machine.
- **Cost Limit:** You might be able to scale more, but it becomes too expensive.
- **Complexity Limit:** Scaling further increases failure points and management complexity.
- **Consistency Limit:** Distributed systems must sometimes trade off strong consistency (per CAP theorem).

🛠 **How to Handle Bottlenecks:**

**Measure first:** Use observability tools to identify the real bottleneck.

**Target the constraint:** Optimize or redesign the weakest link — not random parts.

**Design around limits:** 
- Cache to reduce DB load
- Queue to buffer spikes
-Shard to distribute load
- Split services to isolate hot spots

💡 **Real-world Example:**
Twitter in the early days had a single database that became a bottleneck. They moved to sharded DBs and queued processing to allow horizontal scaling.

🔸 **Amdahl’s Law: The Limits of Parallelization**

Amdahl’s Law helps us understand how much a system can benefit from parallelization.
Let's assume a program takes 100 seconds to run.
- 90% of it can be parallelized, 10% cannot
- Even if we use 1000 processors for the parallelizable part, the 10% that must run sequentially will still take 10 seconds.

So,
- Speedup is limited by the part that can’t be parallelized.

📌 Formula:

Speedup ≤ 1 / (S + (1 - S) / N)

Where:

S = fraction that must run sequentially
N = number of processors
** Don’t just add threads or machines — if there's a serial bottleneck (like a DB write), your gains will hit a ceiling.

🔸 **The Slowest Component Bottlenecks Everything**

In a distributed system, everything relies on everything else, and your system is only as fast or reliable as its weakest link.

Examples:

- DB gets overloaded → API response time increases.
- A network with high latency → users experience slow page loads.
- A blocking operation in the backend → the entire service chain slows down.

🔧 This is why identifying and fixing bottlenecks (not just scaling blindly) is critical.

🔸 **Importance of Profiling Before Scaling**

Profiling means measuring system behavior under load to find out:

- Where time is spent (e.g., slow DB queries)
- What component is overloaded
- What traffic patterns cause spikes

**Why it's important:**

- Without profiling, you might scale the wrong thing.

Example: You add more API servers, but the real problem is a slow DB — now you just increased the DB's load.

🧠 Key Idea: Measure first, scale second.

## Scalability Patterns

Pattern | What it Does |
--- | --- |
CQRS (Command Query Responsibility Segregation) | Separate reads and writes
Event Sourcing | Save system state as a sequence of events
Bulkheads | Isolate parts of the system to prevent failure from spreading
Circuit Breakers | Stop calling failing services automatically


🔥 **Autoscaling** Systems (especially on cloud platforms like AWS, GCP) can automatically scale resources based on demand. Example: More EC2 instances when CPU usage > 70%.

🔥 **Observability**: Monitoring, logging, and tracing become critical at scale. If we can't observe it, we can't scale it reliably.

## Elasticity vs Scalability

| Concept         | What it Means   | Example |
| --------------- | --------------- | ------- |
| **Scalability** | A system's **ability to handle increasing load** (by adding resources)  | Add 10 more servers to serve more users                      |
| **Elasticity**  | A system's **ability to automatically scale up AND down** based on load | AWS Auto Scaling: add EC2s when CPU > 70%, remove when < 20% |

** Scalability is about potential capacity — can your system grow?
** Elasticity is about automatic adaptability — can it grow and shrink on its own?

📌 You can have a scalable system that is not elastic (e.g., manually add servers).
📌 You can’t have elasticity without scalability — elasticity builds on top of a scalable design.

## Data Models and Scalability

📦 ** Denormalization in NoSQL (for Read-heavy Systems)**

In traditional SQL databases, data is normalized — stored in multiple tables to avoid redundancy. This improves consistency, but it often requires joins, which are expensive and slow at scale.

In NoSQL systems, we often denormalize the data:

- Duplicate data across documents or tables
- Avoid joins to enable faster reads
- Prioritize read performance over strict normalization

🧠** Example:**

A blog platform might store all user info, posts, and comments in a single document — duplicating data — so it can quickly serve user profiles without joins.

Why? Because in read-heavy apps (like social media), performance matters more than duplication.

⏳ **Using Eventual Consistency to Scale**

In distributed systems, maintaining strong consistency (e.g., every read returns the latest write) is expensive and slow across multiple regions. Many scalable systems adopt eventual consistency:

- All nodes eventually converge to the latest data

- Reads might return slightly stale data

- Enables faster writes, better availability, and resilience

🧠 **Example:**
In Amazon DynamoDB, if you update an item, another user may see the old value briefly, but eventually, they’ll see the latest.

**Trade-off:** You lose immediacy in favor of availability and scale (see also: CAP Theorem).

## Throttling & Backpressure

🛡️**Throttling**
Throttling is when a system intentionally slows down or rejects some requests to protect itself from being overwhelmed.

Think of it like a valve on a pipe: when water flow (traffic) is too much, you tighten the valve.

This is often used in APIs, message queues, or downstream services to avoid crashes or degraded performance.

🧠 **Examples:**

An API limits users to 100 requests per minute.

A web server returns 429 Too Many Requests when overloaded.

🔁 **Backpressure**

Backpressure is a signal sent upstream saying, “Slow down, I can’t keep up.”

Used in streaming systems, messaging queues, or asynchronous pipelines.

Prevents fast producers from flooding slow consumers.

It's like a conveyor belt that tells the machine before it to pause when it's full.

🧠 **Examples:**

Kafka consumer lag — the broker slows delivery or drops messages.

Reactive systems (e.g., RxJava, Project Reactor) support backpressure to avoid memory overflow.

**Difference:**

Throttling is an active policy by the system.

Backpressure is a feedback mechanism from the consumer to the producer.

## Rate Limiting and Quotas
   
🚦 **Rate Limiting**

- Rate limiting restricts how many requests a user/system can make over a specific period.
- Prevents abuse, spamming, or DoS attacks.

Helps maintain fair access to shared resources.

🧠 **Examples:**
- GitHub API: max 5000 requests/hour per user.
- Twitter API: 15 read requests per 15 minutes for basic access.

📊 **Quotas**

- Quotas are long-term usage limits, often per day/month/account.
- More about resource usage budgeting.
- Often implemented at a higher level than rate limiting.

🧠 **Examples**

- Google Cloud allows 20 CPU hours per day for a free-tier project.
- A user can only upload 1GB of video per day to a platform.

🔒 **Why are These Important?**

- Prevent one user from starving others.
- Protect the backend systems from resource exhaustion.
- Encourage fair usage, especially in multi-tenant or public APIs.

## Observability: The Foundation of Scalable Systems
As systems scale, they become more complex, often involving dozens or hundreds of microservices, databases, queues, and APIs spread across different environments. Without observability, you won’t know:
- Where does latency come from
- Why is a service failing
- Which component is under stress
- Whether a scaling change is helping or hurting

Observability means having deep visibility into how your system behaves in real time, especially under load. It involves three main pillars:

| Component   | Description | Tools (Examples)  |
| ----------- | ----------- | ----------------- |
| **Metrics** | Quantitative values over time (e.g., latency, QPS) | Prometheus, CloudWatch, Datadog |
| **Logs**    | Text records of events                             | ELK Stack, Loki, Fluentd        |
| **Traces**  | Tracks the path of a request across services       | Jaeger, Zipkin, OpenTelemetry   |

🧠 **Why is this critical for scalability?**
If you don’t know what’s slow, where errors are happening, or when capacity is exceeded, you’ll scale the wrong parts — wasting money, time, and reliability.

📌 **Example**
A team sees API latency spike and adds more API servers. But with tracing, they realize the slowdown is caused by a downstream database lock — not CPU exhaustion. Without observability, they would have scaled blindly.

## Feedback Loops in Distributed Systems

A feedback loop is a control mechanism where a system responds to its current state. In distributed systems, tight feedback loops enable real-time responsiveness and resilience.

🧩 Think of autoscaling: it measures CPU usage, makes a decision (add/remove servers), and acts. That’s a loop.

**Fast Feedback → Stable Systems**
The faster and more accurate your feedback loop, the more stable and responsive your system will be under varying load.

**System Part	Feedback Use Case**
- **Autoscaling** :	Adjusts server count based on CPU/load
- **Backpressure** :	tells producers to slow down when consumers lag
- **Throttling** :	Limits traffic when the load is high
- **Health Checks**	: Restart or remove unhealthy instances

📌 **Failure Mode**
Slow or absent feedback loops cause oscillations (over-scaling, under-scaling) or meltdowns (e.g., producer floods consumer, memory crashes).

🧠 **Example**
Kafka handles millions of messages. If a consumer lags behind, Kafka uses backpressure — it either slows delivery or alerts the system. Without that, memory could overflow and crash the broker.

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
