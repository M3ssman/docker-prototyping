import * as Memcached from 'memcached';

// cache this value
const bar = { a: 42, hello: 'world!' };
const foo = 'foo';
const ttl = 30;
const host = 'memcache-server'

// using plain memcached lib
const logPrefixOne = 'example 1: using memcached lib';
const cache = new Memcached( host + ':11211', { retries: 10, retry: 10000, remove: true });
cache.set(foo, bar, ttl, setValue);
setTimeout(() => cache.get(foo, getValue), 2000);
setTimeout(() => cache.del(foo, delValue), 2000);

function setValue(err, result) {
    console.log(logPrefixOne + ' setValue: err=> ' + err + ', success => ' + result);
    return;
}
function getValue(err, data) {
    console.log(logPrefixOne + ' getValue: err=> ' + err + ', data => ' + JSON.stringify(data));
    return;
}
function delValue(err, result): void {
    console.log(logPrefixOne + ' delValue: err=> ' + err + ', success => ' + result);
    return;
}


// using cache-manager with memcache as storage engine
// https://github.com/theogravity/node-cache-manager-memcached-store.git
let logPrefixTwo = 'example 2: using cache-manager API';
// watch out! avoid @types/cache-manager, these definitions dont fit with the cache-manager api
// http://memcache-plus.com/initialization.html - see options
import cacheManager = require('cache-manager');
import memcachedStore = require('cache-manager-memcached-store');
const cache2 = cacheManager.caching({
    store: memcachedStore,
    options: {
        hosts: [host + ':11211']
    }
});

let fooTwo = 'foo2';
cache2.set(fooTwo, bar, ttl, setHandler);
setTimeout(() => cache2.get(fooTwo, getHandler), 2000);

function setHandler(err) {
    console.log(logPrefixTwo + ' stored bar? ' + JSON.stringify(bar));
}
function getHandler(err, result) {
    console.log(logPrefixTwo + ' getHandler result: ' + JSON.stringify(result));
    cache2.del(fooTwo, err => console.log(logPrefixTwo + ' deleted ' + fooTwo + ' from cache err? => ' + err));
}
