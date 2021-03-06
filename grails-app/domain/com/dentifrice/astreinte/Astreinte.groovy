package com.dentifrice.astreinte

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString(includeNames=true, includePackage=false)
class Astreinte {

    static belongsTo = [Personne]

    String id

    Date dateCreated
    Date lastUpdated

    Personne owner

    Date startDate
    Date endDate

    Integer level
    Float price

    static constraints = {
    }

    static mapping = {
        id generator:'uuid'
    }
}
