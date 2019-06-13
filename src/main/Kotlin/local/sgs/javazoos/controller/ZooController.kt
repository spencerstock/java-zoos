package local.sgs.javazoos.controller

import local.sgs.javazoos.services.ZooService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/zoos")
class ZooController {

    @Autowired
    private lateinit var zooService: ZooService

    @GetMapping(value = ["zoos"], produces = ["application/json"])
    fun findAllZoos(): ResponseEntity<Any> {
        val list = zooService.findAll()
        return ResponseEntity(zooService.findAll(), HttpStatus.OK)
    }

    @GetMapping(value = ["/animals/count"], produces = ["application/json"])
    fun showCountZoosForAnimals(): ResponseEntity<Any> {
        return ResponseEntity(zooService.getCountZoosForAnimals(), HttpStatus.OK)
    }
}