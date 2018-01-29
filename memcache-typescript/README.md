# Caching using memcached as Container from Typescript and NodeJS

## Prerequisites
### Tools
* \*nix (Ubuntu 16.04 LTS)
* NodeJS + NPM (8.9.x, 5.6.x)

### Knowledge
* Basics in both Typescript and Javascript.
* Plus
  * Containerisation (Docker-Compose)

The Plus is required to get the Protoype up-and-running, but not for understanding the key parts.

## Motivation
Get along with a common caching mechanism like memcached can lead to serious confusion, since there are 
several Solutions out there. In this prototype I will explain two different Approaches. Both are similar in the underlying memcached-Interface with it's set-/get/-delete-calls, but differ in Configuration and Architecture as well.

### [Memcached][1]
This is currently, according to npmjs.org's Downloads, a quite popular Library. Although it's most recent Release dates back to 2016, it has valid TypeScript Definition Support available that can be installed by ```npm i @types/memcached```. 

### [cache-manager][2] and [cache-manager-memcached-store][3]
The second Approach uses ```cache-manager-memcached-storecache-manager```, which is build on a different Architecture. First, it's an implementation of the [cache-manager][3] API, which tries to unify caching no matter what Backend is used: memcache, redis, file system or even in-memory. Second, it mostly wraps the calls of the [memcache-plus][4] Library in such a way by flattening it's internal Promises.  

## Conclusion
Up to now, if you preffer Typescript and only target for memcached, stay with the first candidate. It has proper TS-Definitions. The second one provides additional Backends and is more up-to-date, but lacks proper Definition Support. Even worse, if you'd ```npm i @types/cache-manager``` and got the definitions @1.2.6 like I did, your project will fail to compile, since there's no Typescript Support for ```cache-manager-memcached-storecache-manager``` and the configuration required by ```memcache-plus``` doesn't comply to the regular ```cache-manager``` configs! See the [online-docs](http://memcache-plus.com/initialization.html#options) for more details.

 
## Start
Call ```docker-compose up``` inside root-Folder and listen to containers output.

[1]: https://github.com/3rd-Eden/memcached
[2]: https://github.com/BryanDonovan/node-cache-manager.git
[3]: https://github.com/theogravity/node-cache-manager-memcached-store.git
[4]: https://github.com/victorquinn/memcache-plus.git