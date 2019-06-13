package local.sgs.javazoos.controller

import local.sgs.javazoos.models.Zoo
import local.sgs.javazoos.services.ZooService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("/admin")
class AdminController {

    @Autowired
    private lateinit var zooService: ZooService

    @PutMapping (value = ["/zoos/{zooid}"],
            consumes = ["application/json"],
            produces = ["application/json"])
    fun updateZooById(@Valid @RequestBody updateZoo: Zoo,
                      @PathVariable zooid: Long): ResponseEntity<Any> {
        zooService.updateZoo(updateZoo, zooid)
        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping(value = ["/zoos"],
            consumes = ["application/json"],
            produces = ["application/json"])
    fun addNewZoo(request: HttpServletRequest,
                  @Valid @RequestBody zoo: Zoo): ResponseEntity<Any> {
        val newZoo = zooService.addZoo(zoo)

        val responseHeaders = HttpHeaders()
        val newZooURI = ServletUriComponentsBuilder.fromUriString(request.serverName +
                ":" + request.localPort + "/zoos/zoos/{zooid}").buildAndExpand(newZoo.zooid).toUri()
        responseHeaders.location = newZooURI
        return ResponseEntity(newZoo, responseHeaders, HttpStatus.OK)
    }
}