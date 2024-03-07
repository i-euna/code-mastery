## Table of Contents
- [Virtualization](#virtualization)
  - [Key components of Virtualization](#key-components-of-virtualization)
- [Containerization](#containerization)
- [Virtualization vs Containerization](#virtualization-vs-containerization)
- [Container Orchestration](#container-orchestration)
- [Serverless Computing, Cloud Native](#extra)

## Virtualization
- allows a single physical server to act like multiple computers
- creates virtual version of resources(CPU, memory, storage etc)
- these virtual resources can run separate app/os separately on a single machine

### Key components of Virtualization

#### Hypervisor
- runs on the physical host
- pools the hosts resources and allocates them to virtual machine
- there are 2 types of hypervisors: type 1 and type 2
- type 1/bare metal hypervisors install directly on top of physical server
	- provide better security and lower latency
	- example: VMware ESXI, Microsoft Hyper V, Open source KVM
- type 2 runs on host OS(installed on physical server)
	- mainly used for end user virtualization
	- have higher latency than type 1
	- example: VMWare workstation, virtualbox
#### Virtual Machine
- abstracted from physical hardware by hypervisors
- multiple VMs can run on a physical machine
- physical computer is called the host and virtual ones are guest

## Containerization
- a deployment process, packages an app with all necessary parts
- offers portability, fault tolerance
- container images contain all info to run an app
- (Open Container Image) Specification defines a standard format for creating container image
- are read only, cannot be altered by the system
- has 4 layers: 
	- infrastructure(hardware)
	- OS(linux, AWS EC2 etc)
	- container engine(intermediate image between container and OS)
	- application and dependencies(may also have a guest OS)

## Virtualization vs Containerization
- VM is best when we need to run multiple apps that need their own OS
- containers share the host machines OS Kernel, so the app needs to be compatible with host OS
- containerization is similar but improved concept of VM
- container does not have a full OS like a VM
- containers share the host system's kernel which reduces overhead and improves efficiency compared to VM
- containers provides the app exactly what resource it needs, thus preventing waste
- in container, app run independently from host OS because OS is removed from self-contained environment

## Container Orchestration
- allows automatic management of containers
- useful because manually managing large number of microservices is impossible


### Extra

#### Serverless Computing
- vendor manages server infrastructure powering application
- while container gives complete control of app environment, in serverless org does not need to maintain resouces

#### Cloud Native
- app is born and reside in an cloud computing environment
- offers scalability
- containerization is one of the techs used to build cloud native apps
