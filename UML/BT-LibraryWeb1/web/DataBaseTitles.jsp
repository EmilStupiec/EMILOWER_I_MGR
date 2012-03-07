<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DataBaseTitles
    Created on : 2012-02-29, 21:40:31
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
                        <webuijsf:button actionExpression="#{DataBaseTitles.addtitles_database_action1}" binding="#{DataBaseTitles.addtitles_database}"
                            id="addtitles_database" style="left: 335px; top: 144px; position: absolute" text="addtitles_DataBase"/>
                        <webuijsf:messageGroup id="messageGroup1" style="height: 6px; left: 552px; top: 120px; position: absolute"/>
                        <div style="left: 312px; top: 216px; position: absolute">
                            <jsp:directive.include file="Fragment1.jspf"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
