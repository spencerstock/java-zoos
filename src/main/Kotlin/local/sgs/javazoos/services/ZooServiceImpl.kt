package local.sgs.javazoos.services

import local.sgs.javazoos.View.CountZoosForAnimals
import local.sgs.javazoos.models.Zoo
import local.sgs.javazoos.repository.ZooRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException
import javax.transaction.Transactional

@Service(value = "zooService")
class ZooServiceImpl: ZooService {
    override fun updateZoo(zoo: Zoo, zooid: Long): Zoo {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteZoo(zooid: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Autowired
    private lateinit var zooRepository: ZooRepository

    override fun findAll(): MutableList<Zoo> {
        val zooList = mutableListOf<Zoo>()
        zooRepository.findAll().iterator().forEachRemaining{zooList.add(it)}
        return zooList
    }

    override fun getCountZoosForAnimals(): MutableList<CountZoosForAnimals> {
        return zooRepository.getCountZoosForAnimals()
    }


    @Transactional
    override fun addZoo(zoo: Zoo): Zoo {
        val newZoo = zoo.copy()
        for (telephone in newZoo.telephones) {
            telephone.zoo = newZoo
        }
        return zooRepository.save(newZoo)
    }

}