# Deployment Strategies, Strategies for Microservices

## Table of Contents
- [Deployment Strategies](#deployment-strategies)
  - [Blue-Green](#blue-green-deployment)
  - [Canary Deployment](#canary-deployment)
  - [Rolling Update](#rolling-update)
  - [Custom Deployment](#custom-deployment)
  - [Bake and Deploy](#bake-and-deploy)
  - [Shadow Deployment](#shadow-deployment)
  - [Feature Toggles](#feature-toggles)
  - [A/B Testing Deployment](#ab-testing-deployment)
- [When To Use What](#-when-to-use-what)
- [Real World Example](#-quick-real-world-examples)
- [Strategy for Microservices](#-strategy-for-microservices)

# Deployment Strategies
## Blue-Green Deployment
- Have two identical environments:
  - Blue = live/serving users
  - Green = new version
- Deploy to Green, test it quietly, then instantly flip traffic from Blue to Green.
- If something is wrong, flip back to Blue.
  
✅ **Pros:**
- Instant rollback
- Minimal downtime
- Easy in cloud infra (AWS Elastic Beanstalk supports this)

❌ **Cons:**
- Double infra cost (need 2 full environments ready)
- Risk of DB schema mismatch if not handled carefully
- Limited feedback during rollout since traffic switches all at once

**Use When:**
- Have high confidence in pre-deployment testing
- can afford two environments
- need super-safe upgrades or have a critical environment
- When success criteria are clear and a gradual rollout is not needed
- want near-zero downtime (e.g., fintechs, e-commerce checkouts)
- Suitable when traffic patterns are predictable, and a full switch won’t overwhelm the new environment.

### Red-Black Deployment
- A variant of Blue-Green where the old environment (Blue) is destroyed immediately after switching traffic to the new environment (Green). Also called **immutable deployment**.
- No rollback option, so issues require a new deployment.
  
## Canary Deployment
- Deploy the new version to a small subset of users (say 1%, 5%, 10%), watch carefully for errors, then slowly roll out to everyone.
- Relies on metrics and automated analysis to decide whether to proceed or roll back.
- Rollback is achieved by redirecting traffic to the baseline and removing the canary.
- Uses fewer resources than Blue-Green initially, as the canary starts small, but scales up over time.

✅ **Pros:**
- Detect issues early with real traffic
- Fine-grained control (percentages)
- Safer than all-at-once

❌ **Cons:**
- Takes more time to fully deploy
- Complicated routing logic needed (feature flags, service mesh, load balancer config)

**Use When:**
- Minimize the blast radius. Common in critical services (banking, ads systems, real-time platforms).
- When deploying significant or risky changes (e.g., major refactors, new features) that need real-world validation with production traffic.
- For applications where performance or user experience varies under load, requiring gradual exposure.
- When you have robust monitoring (e.g., Prometheus, New Relic) and clear success metrics (e.g., error rates < 1%, latency < 200ms).
- Suitable for applications with variable or high traffic, as you can control the rollout pace to avoid overwhelming the new version.

## Rolling Update
- Update servers one batch at a time (e.g., update 10% of instances → next 10% → ...).

✅ **Pros:**
- No need for full double infra (cheaper than Blue-Green)
- Always serving some traffic

❌ **Cons:**
- Partial failures are messy (old + new versions mix during rollout)
- Harder rollback (you need to roll out the old version manually)

**Use When:**
- You can tolerate mixed-version traffic for a short time, e.g., internal systems, APIs with good backward compatibility.

## Custom Deployment
- Engineers push manually:
  git push production → Build → Deploy → Monitor

✅ **Pros:**
- Flexible
- Good for small startups / internal tools

❌ **Cons:**
- Human error
- No rollback safety nets
- No gradual exposure

**Use When:**
- Prototypes, MVPs, internal tools, non-critical apps.

## Bake and Deploy
- Bake = build a machine image (e.g., AMI for AWS) that has the new app baked into it.
- Then deploy the baked image into production.
- Immutable — you don't update the app on live servers — you replace servers.

✅ **Pros:**
- Predictable (what you tested = what you deployed)
- Easy rollback (use old images)
- No "works on my machine" surprises

❌ **Cons:**
- Slower pipeline (building machine images takes time)
- Infra cost (creating new servers)

**Use When:**
High compliance needs, immutable infra culture, e.g., Netflix, banks, critical SaaS services.

## Shadow Deployment
- Deploy new version alongside old version, but don't send real user traffic — only duplicate traffic internally.
- Good for testing without real impact.

✅ No risk to users
❌ Higher infra cost

## Feature Toggles 
- (aka Feature Flags)
- Deploy the code to production but hide new features behind a toggle/flag.
- Turn it on for small groups (internal users, beta testers).

✅ Super gradual rollout
❌ Code complexity if toggles pile up

## A/B Testing Deployment
Like Canary, but intentionally different experiences to measure impact (e.g., marketing experiments).

✅ Data-driven
❌ Needs strong analytics

## ⚡ When To Use What
Situation | Best Strategy |
--- | --- |
Critical app (checkout, payment) |  Blue-Green or Canary
Gradual risk management | Canary or Feature Flags
Internal APIs or low-risk services | Rolling Update
Startups / small apps | Manual/Custom (then improve)
Immutable infra or strong testing | Bake and Deploy

## 🔥 Quick Real-World Examples
- Netflix → Bake and Deploy + Canary
- Amazon → Heavy Canary + Feature Flags
- PayPal → Blue-Green + Canary
- Facebook → Shadow deployments + Feature Flags

## ⚡ Strategy for Microservices

Situation | Best Strategy | Why |
--- | --- | --- |
Small, internal microservice (e.g. logging, metrics) | Rolling Update | Quick, cheap, tolerant to partial failures
Customer-facing service (e.g. user profile) | Canary Deployment | Minimize risk, slowly release
High critical service (e.g. payment, auth) | Blue-Green + Canary (hybrid) | Ultra-safe, minimal downtime
Infra service (e.g. API Gateway, Service Mesh) | Bake and Deploy | Need full immutability, safe rollback
Experimental features | Feature Toggles (behind a flag) | Deploy safely without exposing

### Considerations for Microservices
- **Isolate blast radius**: If one service breaks, it shouldn’t kill the whole system.
- **Fast rollbacks**: If a deployment breaks something, rollback quickly without downtime.
- **Smooth versioning**: Handle API compatibility between different versions carefully.
