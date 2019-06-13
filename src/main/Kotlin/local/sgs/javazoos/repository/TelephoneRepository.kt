package local.sgs.javazoos.repository

import local.sgs.javazoos.models.Telephone
import org.springframework.data.repository.CrudRepository

interface TelephoneRepository: CrudRepository<Telephone, Long>