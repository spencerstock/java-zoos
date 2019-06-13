package local.sgs.javazoos.models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "animals")
data class Animal (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val animalid: Long,
        var animaltype: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "zooid", nullable = false)
        @JsonIgnore
        var zoo: Zoo? = null
)