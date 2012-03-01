<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DataBaseBooks
    Created on : 2012-02-29, 21:41:19
    Author     : wera
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <webuijsf:form id="form1">
                        <div style="height: 94px; left: 0px; top: 0px; position: absolute; width: 382px">
                            <jsp:directive.include file="Logo.jspf"/>
                        </div>
                        <div style="left: 0px; top: 144px; position: absolute">
                            <jsp:directive.include file="Menu.jspf"/>
                        </div>
                        <webuijsf:button binding="#{DataBaseBooks.addbooks_database}" id="addbooks_database"
                            style="position: absolute; left: 360px; top: 144px; width: 168px; height: 24px" text="addbooks_DataBase"/>
                        <webuijsf:messageGroup id="messageGroup1" style="left: 600px; top: 96px; position: absolute"/>
                        <div style="position: absolute; left: 336px; top: 216px">
                            <jsp:directive.include file="BooksApplicationfragment.jspf"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
