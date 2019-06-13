package local.sgs.javazoos.models;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

//will contain audit fields that are common among all other classes

//@Temporal(TemporalType.TIMESTAMP) //for kotlin
//@EntityListeners(value = [AuditingEntityListener::class]) //for kotlin


@MappedSuperclass //goes along with it being abstract
@EntityListeners(AuditingEntityListener.class)
abstract class Auditable {

    @CreatedBy
    protected String createdBy;
    @CreatedDate
            @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;
    @LastModifiedBy
    protected String lastModifiedBy;
    @LastModifiedDate
            @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;



}
