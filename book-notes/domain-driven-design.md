# Domain Driven Design

# Table of Contents
- [Crunching Knowledge](#crunching-knowledge)
- [Communication and the Use of Language](#communication-and-the-use-of-language)
- [Binding Model and Implementation](#binding-model-and-implementation)
- [Isolating the Domain]
  
## Crunching Knowledge
**Collaboration is Crucial**

Developers need to work closely with domain experts (people who know the business or problem space deeply) to build meaningful models.

**Learning the Domain**

Understanding the domain is not a one-time task. It’s an iterative process of asking questions, observing, and refining ideas.

**Models Matter**

The domain model (the abstract system that represents real-world concepts) is central. A good model reflects both the domain's logic and the software's structure.

**Language Unification**

Developers and domain experts should use a shared language—known as the Ubiquitous Language—based on the model, in both code and conversation.

**Avoiding Knowledge Gaps**

Software that’s disconnected from the real-world domain leads to confusion, bugs, and inefficiency. Continuous learning bridges that gap.

## Communication and the Use of Language
**Language as a Design Tool**
Words matter. The language used by the team should evolve with the model and be used consistently in code, discussions, and documentation.

**Ubiquitous Language**
- A Ubiquitous Language is a single, consistent vocabulary derived from the domain model.
- It's used by both developers and domain experts, ensuring everyone is aligned.
- It reduces misunderstandings and creates clearer code that reflects real business concepts.

**Refactoring the Language**
- As the model evolves, so should the language. Don’t be afraid to change names or terms if they no longer reflect the current understanding of the domain.

**Code Reflects the Model**
- The model should live in the code, not just in diagrams or conversations.
- Clean, expressive code written in the Ubiquitous Language helps the team communicate and collaborate more effectively.

**Team Collaboration**
- Creating and refining the language is a collaborative effort. Everyone contributes to shaping it through continuous dialogue and shared insights.

## Binding Model and Implementation
**Model ≠ Diagram**

The domain model isn’t just a UML diagram or concept map — it's the backbone of the software design and should be directly reflected in the code.

**Code as an Expression of the Model**
- The structure, classes, and interactions in the code should embody the model’s concepts.
- If a business concept like "Customer Risk Profile" is central to the domain, it should be a first-class citizen in the code, not hidden in utility functions or generic data structures.

**Avoid Anemic Models**

An anemic domain model (one with only data and no behavior) breaks the connection between model and implementation. Instead, behavior should be part of the domain objects — e.g., a Customer object should know how to calculate its own risk level.

**Model Integrity Through Refactoring**

As understanding of the domain evolves, the model and code should be refactored in tandem. The goal is to keep the code expressive and consistent with the domain knowledge.

**Team Discipline**

Maintaining a strong bond between the model and code takes effort and discipline — all team members must be committed to preserving clarity and using the Ubiquitous Language consistently in implementation.

### Domain-Driven Design (DDD) patterns
🔶 1. Entity

An Entity is an object that has a distinct identity that runs through time and different states.

🔷 2. Value Object

- A Value Object has no identity. It’s defined entirely by its attributes and is immutable. If two value objects have the same data, they’re considered equal.
- We  don’t care which one it is, only what it is. e.g- Transaction Amount, Address

🔸 3. Aggregate and Aggregate Root

An Aggregate is a cluster of related objects (Entities + Value Objects) treated as a single unit for data changes. The Aggregate Root is the only entry point for modifying the aggregate.


| Pattern         | Identity? | Mutable? | Role                                |
|----------------|-----------|----------|-------------------------------------|
| Entity          | ✅ Yes    | ✅ Yes   | Tracks state over time              |
| Value Object    | ❌ No     | ❌ No    | Describes attributes, immutable     |
| Aggregate Root  | ✅ Yes    | ✅ Yes   | Controls consistency and access     |


🧠🧠🧠

- If we say"it’s still the same X even if some attributes change", it’s probably an Entity.
- If you say "it’s equal only if all values match", it’s a Value Object.

| Question | Entity | Value Object |
|----------|--------|--------------|
| Is it tracked or referenced elsewhere? | ✔️ | ❌ |
| Can two things have the same values but still be distinct? | ✔️ | ❌ |
| Do I care if it's been updated or changed over time? | ✔️ | ❌ |
| Would it make sense to copy and reuse it? | ❌ | ✔️ |


# Isolating the Domain
Decouple the domain logic from other application parts- user interfaces, databases, and external services. This ensures the domain model remains pure and focused on business rules and logic.

**Layered Architecture**

- **User Interface (UI):** Handles user interactions.
- **Infrastructure Layer:** Deals with technical concerns like database access and messaging.
- **Application Layer:** Coordinates tasks and delegates work to the domain layer.
- **Domain Layer:** Contains the business logic and domain model.

✅ The domain Layer is the core, and everything else should depend on it, not vice versa. We can use Dependency Inversion via Interfaces (the Ports & Adapters pattern) to achieve this.

✅ Instead of the Domain calling infrastructure code directly, it defines abstractions (interfaces) that express what it needs.

Then the infrastructure layer implements those interfaces, injecting the concrete implementations at runtime.

**Dependency Direction**
Dependencies should point inward toward the domain layer. This means the domain layer should not depend on the infrastructure or UI layers.

**Use of Interfaces**

Define interfaces in the domain layer for services that require external implementations. The infrastructure layer then provides concrete implementations, allowing the domain to remain unaware of technical details.

**Persistence Ignorance**

The domain model should not be concerned with how data is persisted. This allows for flexibility and easier testing

🧠 **Benefits**

**Maintainability:** Changes in the UI or infrastructure have minimal impact on the domain logic.

**Testability:** The domain logic can be tested independently of other concerns.

**Flexibility:** Easier to adapt to changes in technology or business requirements.
