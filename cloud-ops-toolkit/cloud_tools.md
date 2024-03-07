## Table of Contents
- [On Docker](#on-docker)
- [On Kubernetes](#on-kubernetes)
  - [Why K8](#why-kubernetes)
  - [Architecture](#architecture)
  - [Kubernetes Resources](#kubernetes-resources)
- [On Terraform](#on-terraform)
- [On Helm](#on-helm)
  - [Helm Chart](#helm-chart)
  - [Config Values](#config-values)
  - [Helm Release](#helm-release)
  - [Helm Templating Engine](#helm-templating-engine)

## On Docker
- with docker container, we can package any application
- a container runtime, build, deploy and test containerized apps on different platforms
- docker image is a set of instructions used to create containers, created using dockerfile
- container is the runtime instance of an image
- docker file contains commands for creating a docker image
- docker hub is the online repo for docker images
- docker engine hosts the containers, it's a client-server based application with 3 main components
	- server(daemon process, creates and manages image, container, network, volume)
	- client(command line interface, we use it to communicate with docker)
	- REST-API(specifies how the app interacts with server)
- [Reference](https://docs.docker.com/get-started/overview/#docker-architecture)

## On Kubernetes
- can manage thousands of containers
- handles everything in the life cycle of containers: starting, managing, stopping
- abstracts the infrastructure details, simplifies deployment
- handles automation/failover/centralized logging/monitoring

### Why Kubernetes
- Scalability: can scale a single container to serve millions of requests
- Automate container deployment: k8 can help manage the automated docker deployment
- Auto Healing: when a container fails, replace it
- Roll-out and Roll back: can monitor unhealthy container and restart

### Architecture 
- deployed as a cluster
- has 2 main parts: master and worker nodes
![Usage](diagrams/Kubernetes.PNG?raw=true "Usage")

### Kubernetes Resources

#### Pods
- multiple containers and volumes grouped within **single execution environment**- pods
- pods can be used for closely related(but seperate) process that need to share resources
- recommendation is to have 1 container per pod, because scaling an application becomes easier that way

#### Services
- when dealing with microservices, 1 microservice per pod is the common recommendation
- provide a stable(does not change on restart/failure) endpoint (IP address/port) that other components within the cluster can use to communicate with Pods
- performs load balancing: distributes incoming traffic among the associated pods

#### Deployment
- With deployment we can manage and scale applications
- when a deployment is created, a replica set is also created
- a replicaset makes sure that a specific number of pod replicas are running

#### Volume
- a component of pod, a kind of storage
- if a container goes down, the file systems is also erased
- but the contents of a volume persists after container restart and it can be accessed by all containers across pod

### Kubernetes Ingress
- ....
- [Reference](https://kubernetes.io/docs/concepts/services-networking/ingress/#what-is-ingress)


## On Terraform
- automation tool for configuring application deployment and their dependencies
- maintains the dependencies between components and create a dependency graph
- uses declarative language(Hashicorp Declarative Language- HCI)
- pluggable by design
- has 3 phases: init , plan, apply

### Terraform Module
- like a function
- a way of grouping together sone automation

#### Terraform Provider
- if terraform wants to 

#### Locals

#### Resource
- Every object TF manages is a resource
- can be a compute instance, database, or on-premise physical server
- TF manages lifecycle of resource from provisioning, configuration, decommissioning

### State
- TF records the state of the infrustructure as it is seen in real world
- based on this, it can determine what actions to take when updating
- TF can ensure that the infrastructure is always at the defined state
- State is a blueprint of infrastructure defined by TF


## On Helm
- like a package manager for k8
- can use it to install, update and rollback k8 applications
- can simplify complicated application deployment into single command
- Key components of helm: helm chart, config values, helm release  

### Why Helm
- Managing a K8 cluster is difficult
- We need a abstract template(Helm) that can sit on top of k8, so we can manage complete k8 cluster with minimam effort

### Helm Chart
- collection of yml files needed to create k8 applications
- the yml files are similar to the ones we use to deploy on k8 cluster
- the ymls also use helm template, which can make the configuration more dynamic

### Config Values
- the dynamic configuration that we can provide that will customize the deployment of the helm chart
- can be set via CLI args or provided in the values.yml

### Helm Release
- the running instance of a chart with a specific configuration(could be dev, test, prod etc)
- with Release, helm manages deployed application
- allows up to install, upgrade and rollback the deployments

### Helm Templating Engine
- allows us to customize helm releases
- suppose, we are running multiple instance of same application(dev, test and prod).
- in stead of managing a custom template for each environment, we can make a common blueprint with helm chart and
override the dynamic values
- default values will go to values.yml file, and have additional values files for other environments