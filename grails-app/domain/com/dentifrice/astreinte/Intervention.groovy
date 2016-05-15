package com.dentifrice.astreinte

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString(includeNames=true, includePackage=false)
class Intervention {

    static belongsTo = [Astreinte]

    String id

    Date dateCreated
    Date lastUpdated

    Astreinte astreinte
    Personne creator

    Date startDate
    Date endDate
    String description

    static constraints = {
    }

    static mapping = {
        id generator:'uuid'
        description type: 'text'
    }
}
