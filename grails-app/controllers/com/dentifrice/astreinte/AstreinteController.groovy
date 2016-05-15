package com.dentifrice.astreinte

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
@Transactional(readOnly = true)
class AstreinteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    AstreinteService astreinteService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond astreinteService.findAstreintesWithin4Months()
    }

    def show(Astreinte astreinte) {
        respond astreinte
    }

    def create() {
        respond new Astreinte(params)
    }

    @Transactional
    def save(Astreinte astreinte) {
        if (astreinte == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (astreinte.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond astreinte.errors, view:'create'
            return
        }

        astreinte.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'astreinte.label', default: 'Astreinte'), astreinte.id])
                redirect astreinte
            }
            '*' { respond astreinte, [status: CREATED] }
        }
    }

    def edit(Astreinte astreinte) {
        respond astreinte
    }

    @Transactional
    def update(Astreinte astreinte) {
        if (astreinte == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (astreinte.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond astreinte.errors, view:'edit'
            return
        }

        astreinte.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'astreinte.label', default: 'Astreinte'), astreinte.id])
                redirect astreinte
            }
            '*'{ respond astreinte, [status: OK] }
        }
    }

    @Transactional
    def delete(Astreinte astreinte) {

        if (astreinte == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        astreinte.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'astreinte.label', default: 'Astreinte'), astreinte.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'astreinte.label', default: 'Astreinte'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
