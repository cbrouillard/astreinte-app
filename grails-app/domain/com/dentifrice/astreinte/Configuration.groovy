package com.dentifrice.astreinte

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString(includeNames=true, includePackage=false)
class Configuration {

    String id

    String name

    enum ConfigurationType {
        STRING,
        INTEGER,
        BOOLEAN
    }

    ConfigurationType type

    String strValue
    Integer intValue
    Boolean boolValue

    static constraints = {
        strValue nullable: true
        intValue nullable: true
        boolValue nullable: true
        name unique: true
    }

    static mapping = {
        id generator: 'uuid'
    }

    static Configuration create(String name, def value) {
        Configuration newOne = new Configuration(name: name)
        newOne.setValue(value)
        return newOne
    }

    def getValue() {
        // donne la valeur en fonction du type
        switch (type) {
            case ConfigurationType.STRING:
                return strValue
            case ConfigurationType.BOOLEAN:
                return boolValue
            case ConfigurationType.INTEGER:
                return intValue
            default:
                throw IllegalArgumentException("Wrong type in Configuration object.")
        }
    }

    def setValue(value) {
        // set en fonction du type
        if (value instanceof Boolean) {
            this.boolValue = value
            this.type = ConfigurationType.BOOLEAN
        } else if (value instanceof Integer) {
            this.intValue = value
            this.type = ConfigurationType.INTEGER
        } else {
            this.strValue = value
            this.type = ConfigurationType.STRING
        }
    }
}
