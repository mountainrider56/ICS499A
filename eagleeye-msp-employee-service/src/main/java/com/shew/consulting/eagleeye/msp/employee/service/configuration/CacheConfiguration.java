package com.shew.consulting.eagleeye.msp.employee.service.configuration;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public ConcurrentMapCache concurrentMapCache() {
        return new ConcurrentMapCache("employees");
    }

    @Bean
    public CacheLoader<String, Employee> employeeCacheLoader(ConcurrentMapCache concurrentMapCache) {
        CacheLoader<String, Employee> loader;
        loader = new CacheLoader<String, Employee>() {

            @Override
            public Employee load(@NonNull String key) {
                return concurrentMapCache.get(key, Employee.class);
            }

        };
        return loader;
    }

    @Bean
    public LoadingCache<String, Employee> sessionCache(CacheLoader<String, Employee> employeeCacheLoader) {
        return CacheBuilder.newBuilder()
                           .expireAfterAccess(30, TimeUnit.MINUTES)
                           .maximumSize(1000)
                           .build(employeeCacheLoader);
    }

}
