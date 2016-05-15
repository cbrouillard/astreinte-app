package com.dentifrice.astreinte

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Personne implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

    String id

	String username
	String password
    String trigramm

	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false

	Set<Role> getAuthorities() {
		PersonneRole.findAllByPersonne(this)*.role
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		password blank: false, password: true
		username blank: false, unique: true
        trigramm blank: false, unique: true
	}

	static mapping = {
		password column: '`password`'
        id generator:'uuid'
	}
}
