package local.sgs.javazoos.models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "telephones")
data class Telephone (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val phoneid: Long,

        val phoneType: String? = null,
        var phonenumber: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "zooid", nullable = false)
        @JsonIgnore
        var zoo: Zoo? = null
)