package com.codespring.trackinghashtagservice.domain.service

import com.codespring.trackinghashtagservice.domain.model.TrackedHashTag
import com.codespring.trackinghashtagservice.domain.repository.TrackedHashTagRepository
import org.springframework.stereotype.Service

@Service
class TrackedHashTagService(private val repository: TrackedHashTagRepository) {
    fun save(hashTag: TrackedHashTag) = repository.save(hashTag)

    fun all() = repository.findAll()
}