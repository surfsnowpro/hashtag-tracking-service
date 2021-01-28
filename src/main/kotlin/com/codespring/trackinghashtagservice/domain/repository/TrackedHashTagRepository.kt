package com.codespring.trackinghashtagservice.domain.repository

import com.codespring.trackinghashtagservice.domain.model.TrackedHashTag
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TrackedHashTagRepository(private val redisTemplate: ReactiveRedisTemplate<String, String>) {
    fun save(trackedHashTag: TrackedHashTag): Mono<TrackedHashTag> =
            redisTemplate.opsForSet()
                    .add("hash-tags", "${trackedHashTag.hashTag}:${trackedHashTag.queue}")
                    .flatMap { Mono.just(trackedHashTag) }

    fun findAll(): Flux<TrackedHashTag> =
            redisTemplate.opsForSet()
                    .members("hash-tags")
                    .flatMap { element ->
                        val data = element.split(":")
                        Flux.just(TrackedHashTag(hashTag = data[0], queue = data[1]))
                    }
}