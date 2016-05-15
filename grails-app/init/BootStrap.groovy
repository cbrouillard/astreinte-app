import com.dentifrice.astreinte.Personne
import com.dentifrice.astreinte.PersonneRole
import com.dentifrice.astreinte.Role

class BootStrap {

    def init = { servletContext ->

        def admin = new Personne();
        admin.username = 'admin'
        admin.password = 'admin'
        admin.trigramm = 'ADM'
        admin.save(flush: true)

        def role = Role.findByAuthority('ROLE_ADMIN')
        if (!role){
            role = new Role (authority: 'ROLE_ADMIN')
            role.save(flush:true)
        }

        PersonneRole.create(admin, role).save(flush:true)
    }
    def destroy = {
    }
}
