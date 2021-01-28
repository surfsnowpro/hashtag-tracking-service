package com.codespring.trackinghashtagservice.domain.resources

import com.codespring.trackinghashtagservice.domain.model.TrackedHashTag
import com.codespring.trackinghashtagservice.domain.service.TrackedHashTagService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tracked-hash-tag")
class TrackedHashTagResource(private val service: TrackedHashTagService) {

    @GetMapping
    @ApiOperation(value = "Get Hashtags", notes = "Get a list of all hashtags")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Hashtags found"),
    ])
    fun all() = service.all()

    @PostMapping
    @ApiOperation(value = "Save Hashtag", notes = "Save an individual hashtag")
    @ApiResponses(value = [
        ApiResponse(code = 201, message = "Hashtag saved"),
    ])
    fun save(@RequestBody hashTag: TrackedHashTag) = service.save(hashTag)
}