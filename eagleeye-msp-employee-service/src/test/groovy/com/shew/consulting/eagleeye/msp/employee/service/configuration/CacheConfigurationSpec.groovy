package com.shew.consulting.eagleeye.msp.employee.service.configuration

import com.google.common.base.Ticker
import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.shew.consulting.eagleeye.msp.employee.service.model.Employee
import org.springframework.cache.concurrent.ConcurrentMapCache
import spock.lang.Specification

class CacheConfigurationSpec extends Specification {

    CacheConfiguration cacheConfiguration

    def setup() {
        cacheConfiguration = new CacheConfiguration()
    }

    def 'concurrentMapCache'() {
        when:
        ConcurrentMapCache concurrentMapCache = cacheConfiguration.concurrentMapCache()

        then:
        concurrentMapCache // not null
        concurrentMapCache.getName() == 'employees'
        !concurrentMapCache.isStoreByValue()
        concurrentMapCache.getNativeCache().isEmpty()
    }

    def 'employeeCacheLoader'() {
        setup:
        ConcurrentMapCache concurrentMapCache = cacheConfiguration.concurrentMapCache()
        Employee employee = new Employee()
        concurrentMapCache.put('test', employee)

        when:
        CacheLoader<String, Employee> employeeCacheLoader = cacheConfiguration.employeeCacheLoader(concurrentMapCache)

        then:
        employeeCacheLoader // not null
        employeeCacheLoader.load('test') == employee
    }

    def 'sessionCache'() {
        setup:
        ConcurrentMapCache concurrentMapCache = cacheConfiguration.concurrentMapCache()
        CacheLoader<String, Employee> employeeCacheLoader = cacheConfiguration.employeeCacheLoader(concurrentMapCache)

        when:
        LoadingCache<String, Employee> loadingCache = cacheConfiguration.sessionCache(employeeCacheLoader)
        loadingCache.getMetaPropertyValues()
        int count = 0
        while (count < 2000) {
            loadingCache.put(count.toString(), new Employee(username: "${count}"))
            count++
        }

        then:
        loadingCache.size() == 1000
    }

//        setup:
//        ConcurrentMapCache concurrentMapCache = cacheConfiguration.concurrentMapCache()
//        Employee employee = new Employee()
//        CacheLoader<String, Employee> employeeCacheLoader = cacheConfiguration.employeeCacheLoader(concurrentMapCache)
//
//        when:
//        LoadingCache<String, Employee> loadingCache = cacheConfiguration.sessionCache(employeeCacheLoader)
//        LocalCache.LocalLoadingCache localLoadingCache = loadingCache as LocalCache.LocalLoadingCache
////        sessionCache.put('test', employee)
////        int count = 0
////        while (count < 930) {
////            String string = new Random()
////            System.out.println(string)
////            sessionCache.put(string, new Employee(username: '${count}'))
////            count++
////        }
//
//        then:
////        Thread.sleep(2000)
//        loadingCache // not null
////        sessionCache.
////        sessionCache.getMetaPropertyValues()
////        sessionCache.size() == 1000
//
//
//    }

    /*

    @Bean
    public LoadingCache<String, Employee> sessionCache(CacheLoader<String, Employee> employeeCacheLoader) {
        return CacheBuilder.newBuilder()
                           .expireAfterAccess(30, TimeUnit.MINUTES)
                           .maximumSize(1000)
                           .build(employeeCacheLoader);
    }
     */

}
