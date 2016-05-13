package com.dentifrice.astreinte

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class PersonneRole implements Serializable {

	private static final long serialVersionUID = 1

	Personne personne
	Role role

	@Override
	boolean equals(other) {
		if (other instanceof PersonneRole) {
			other.personneId == personne?.id && other.roleId == role?.id
		}
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (personne) builder.append(personne.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static PersonneRole get(String personneId, long roleId) {
		criteriaFor(personneId, roleId).get()
	}

	static boolean exists(String personneId, long roleId) {
		criteriaFor(personneId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(String personneId, long roleId) {
		PersonneRole.where {
			personne == Personne.load(personneId) &&
			role == Role.load(roleId)
		}
	}

	static PersonneRole create(Personne personne, Role role) {
		def instance = new PersonneRole(personne: personne, role: role)
		instance.save()
		instance
	}

	static boolean remove(Personne u, Role r) {
		if (u != null && r != null) {
			PersonneRole.where { personne == u && role == r }.deleteAll()
		}
	}

	static int removeAll(Personne u) {
		u == null ? 0 : PersonneRole.where { personne == u }.deleteAll()
	}

	static int removeAll(Role r) {
		r == null ? 0 : PersonneRole.where { role == r }.deleteAll()
	}

	static constraints = {
		role validator: { Role r, PersonneRole ur ->
			if (ur.personne?.id) {
				PersonneRole.withNewSession {
					if (PersonneRole.exists(ur.personne.id, r.id)) {
						return ['userRole.exists']
					}
				}
			}
		}
	}

	static mapping = {
		id composite: ['personne', 'role']
		version false
	}
}
