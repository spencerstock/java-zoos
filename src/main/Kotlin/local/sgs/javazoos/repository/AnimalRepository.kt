package local.sgs.javazoos.repository

import local.sgs.javazoos.models.Animal
import org.springframework.data.repository.CrudRepository

interface AnimalRepository: CrudRepository<Animal, Long>