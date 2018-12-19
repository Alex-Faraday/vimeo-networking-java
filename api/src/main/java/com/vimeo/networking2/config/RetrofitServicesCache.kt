package com.vimeo.networking2.config

import retrofit2.Retrofit

/**
 * As Retrofit services are created, they are cached in this class.
 */
class RetrofitServicesCache(var retrofit: Retrofit) {

    /**
     * Cache of Retrofit API Services.  Objects created by calling getService().
     */
    private val cache = mutableMapOf<Class<*>, Any>()

    /**
     * Create and cache instance of the given Retrofit Service interface.
     */
    @Suppress("UNCHECKED_CAST")
    fun <T> getService(serviceClass: Class<T>): T {
        if (cache[serviceClass] == null) {
            cache[serviceClass] = retrofit.create(serviceClass) as Any
        }
        return cache[serviceClass] as T
    }

    /**
     * Empty service endpoint cache.
     */
    fun clear() {
        cache.clear()
    }

}
