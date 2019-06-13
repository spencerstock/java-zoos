package local.sgs.javazoos.models


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "zoos")
data class Zoo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val zooid: Long,

        var zooname: String,

        @OneToMany(mappedBy = "zoo",
                cascade = [CascadeType.ALL],
                orphanRemoval = true,
                fetch = FetchType.LAZY)
        @JsonIgnoreProperties("zoo")
        var telephones: MutableList<Telephone> = mutableListOf(),

        @ManyToMany
        @JoinTable(name = "zooanimals",
                joinColumns = [JoinColumn(name = "zooid")],
                inverseJoinColumns = [JoinColumn(name = "animalid")])
        var animals: MutableList<Animal> = mutableListOf()
)