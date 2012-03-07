<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : DataBaseTitle
    Created on : 2012-02-29, 21:40:53
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
                        <div style="height: 150px; width: 250px; -rave-layout: grid" xmlns:f="http://java.sun.com/jsf/core"
                            xmlns:h="http://java.sun.com/jsf/html" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
                            <f:subview id="FormTitle">
                                <h:panelGrid binding="#{FormTitle.titleapplicationpanel}" columns="2" id="titleapplicationpanel"
                                    style="height: 122px; left: 312px; top: 144px; position: absolute" width="240">
                                    <webuijsf:label for="title" id="title_label" text="Title"/>
                                    <webuijsf:textField binding="#{FormTitle.title}" id="title" required="true"/>
                                    <webuijsf:label for="author" id="author_label" text="Author"/>
                                    <webuijsf:textField binding="#{FormTitle.author}" id="author" required="true"/>
                                    <webuijsf:label for="isbn" id="ISBN_label" text="ISBN"/>
                                    <webuijsf:textField binding="#{FormTitle.isbn}" id="isbn" required="true"/>
                                    <webuijsf:label for="publisher" id="publisher_label" text="Publisher"/>
                                    <webuijsf:textField binding="#{FormTitle.publisher}" id="publisher" required="true"/>
                                    <webuijsf:label id="actor_label" text="Actor"/>
                                    <webuijsf:textField binding="#{FormTitle.actor}" id="actor"/>
                                </h:panelGrid>
                            </f:subview>
                        </div>
                        <webuijsf:button actionExpression="#{DataBaseTitle.addtitle_database_action}" id="addtitle_database"
                            style="left: 575px; top: 144px; position: absolute" text="addtitle_DataBase"/>
                        <webuijsf:messageGroup id="messageGroup1" style="height: 94px; left: 576px; top: 192px; position: absolute; width: 118px"/>
                        <div style="position: absolute; left: 312px; top: 336px">
                            <jsp:directive.include file="Fragment1.jspf"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
