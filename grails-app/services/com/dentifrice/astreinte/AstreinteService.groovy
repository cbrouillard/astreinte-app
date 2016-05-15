package com.dentifrice.astreinte

import grails.transaction.Transactional

@Transactional
class AstreinteService {


    List<Astreinte> findAstreintesWithin4Months () {
        Calendar calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -1)
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        Date startDate = calendar.getTime()
        log.debug("PreviousMonth date is "+startDate)

        calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, 2)
        calendar.set(Calendar.DAY_OF_MONTH, 0)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.MILLISECOND, -1)

        Date endDate = calendar.getTime()
        log.debug("InTwoMonth date is "+endDate)

        return Astreinte.findAllByStartDateGreaterThanEqualsAndEndDateLessThanEquals (startDate, endDate)
    }

}
