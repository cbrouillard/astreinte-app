<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'astreinte.label', default: 'Astreinte')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        ${astreinteList}
    </body>
</html>