package local.sgs.javazoos.services

import local.sgs.javazoos.View.CountZoosForAnimals
import local.sgs.javazoos.models.Zoo

interface ZooService {
    fun findAll(): MutableList<Zoo>

    fun addZoo(zoo: Zoo): Zoo

    fun updateZoo(zoo: Zoo, zooid: Long): Zoo

    fun deleteZoo(zooid: Long)

    fun getCountZoosForAnimals(): MutableList<CountZoosForAnimals>
}