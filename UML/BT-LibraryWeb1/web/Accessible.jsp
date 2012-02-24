<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Accessible
    Created on : 2012-02-22, 10:00:49
    Author     : lab05
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
                        <div style="left: 528px; top: 264px; position: absolute">
                            <jsp:directive.include file="BooksApplication.jspf"/>
                        </div>
                        <jsp:directive.include file="TitlesApplication.jspf" style="left: 192px; top: 360px; position: absolute"/>
                        <webuijsf:button id="search1" style="position: absolute; left: 312px; top: 312px" text="Search"/>
                        <div style="position: absolute; left: 312px; top: 144px">
                            <jsp:directive.include file="FormPeriod.jspf"/>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
